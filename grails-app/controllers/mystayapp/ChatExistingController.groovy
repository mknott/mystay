package mystayapp

import com.utility.*;
import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import com.chat.XmppMessageListener;
import org.json.*;
import org.springframework.web.context.request.RequestContextHolder;
import groovy.sql.Sql;
import org.jivesoftware.smack.AccountManager;
import com.utility.*;
import org.jivesoftware.smack.packet.Message;


class ChatExistingController {

    ConnectionConfiguration config = new ConnectionConfiguration(MyStayConstants.CHAT_SERVER, MyStayConstants.CHAT_PORT, MyStayConstants.CHAT_SERVICE);
    def dataSource

    def index() {
      XMPPConnection connection= null;
      Chat chat=null;
      Sql db = new Sql(dataSource)
      def session = RequestContextHolder.currentRequestAttributes().getSession()
      println session.id;
      JSONArray msgLst=null;
      String firstmsg = params.chat_input;
      String chatTopic = params.chat_topic;
      String msgto = "";
      boolean isAnonymus = false;
        //println chatTopic
      def firstName = request.getCookie(MyStayConstants.FIRST_NAME);
      def lastName = request.getCookie(MyStayConstants.LAST_NAME);
      def roomNumber = request.getCookie(MyStayConstants.ROOM_NUMBER);
      def visitId = request.getCookie(MyStayConstants.VISIT_ID);
      def username = request.getCookie(MyStayConstants.USER_ID);
      
      boolean isUserOnline = false;
      int numberOfActiveUser = 0;

      // XMPP server Login - Start =============================================
      connection = new XMPPConnection(config);
      connection.connect();
      
      def userProfileInstance =null;
      if(firstName != null){
         userProfileInstance = UserProfile.find("from UserProfile as b where b.firstName=?",firstName);
       }
      

      if(userProfileInstance!=null)
      {
        username = userProfileInstance.emailAddress;
        def password = userProfileInstance.password;
        connection.login(username,password);
        
      } else{

            if(firstName == null || firstName.trim().equals("")){
                connection.loginAnonymously();
                //println "Anonymous ID: " + connection.getUser(); bbab86bf@
                String anonUserName = connection.getUser();
                session.setAttribute(MyStayConstants.USER_ID, anonUserName.substring(0,anonUserName.indexOf('@')));
                isAnonymus = true;
            }else{
              AccountManager accmanager = connection.getAccountManager();
              println username;
              def password = lastName;
              def temp_name = "";
              //Sql db = new Sql(dataSource)
              //def result = db.rows("SELECT username FROM ofuser");
              db.eachRow("select * from ofuser where username='"+username+"'",{ row ->
                    temp_name=row.username;
               })
               println "username: " + temp_name;

                if(temp_name.equalsIgnoreCase(""))
                {
                    try{
                        accmanager.createAccount(username,password);
                    }catch(Exception e){
                        println "User Already Exists.."
                    }
                }
              connection.login(username,password);
            }

      }
      session.setAttribute(MyStayConstants.XMPP_CONN,connection);
      // XMPP server Login - End ===============================================
    try{
        msgLst = (JSONArray)session.getAttribute(MyStayConstants.MY_MESSAGE_LIST);
        if(msgLst == null){
           msgLst = new JSONArray();
        }

        msgLst.put("<b>"+MyStayConstants.MY_SELF+" :</b>"+firstmsg);

        session.setAttribute(MyStayConstants.MY_MESSAGE_LIST,msgLst);

      }catch(Exception e){
          println "Error is: " + e.getMessage();
      }
      //AutoReply ===============Start
      if(isAutoReplyExists(firstmsg)){
        Chat autoreplychat = connection.getChatManager().createChat(MyStayConstants.AUTO_RLY_USR + MyStayConstants.CHAT_DOMAIN, new XmppMessageListener(session));
        autoreplychat.sendMessage(firstmsg);
        def adminuserlist = AdminUser.findAll { servicetype == chatTopic }
        for(AdminUser auser: adminuserlist) {
                  db.eachRow("select username from ofpresence where username='"+auser.userName+"'",{ row ->
                            isUserOnline = true;
                       })
                  if(isUserOnline){
                      isUserOnline = false;
                      continue;
                  }

                  msgto= auser.userName;
                  println msgto
            }

      }else{
          //AutoReply ===============End
          def adminuserlist = AdminUser.findAll { servicetype == chatTopic }
          for(AdminUser auser: adminuserlist) {
                  db.eachRow("select username from ofpresence where username='"+auser.userName+"'",{ row ->
                            isUserOnline = true;
                       })

                  if(isUserOnline){
                      isUserOnline = false;
                      continue;
                  }

                  msgto= auser.userName;
                  println msgto

                 chat = connection.getChatManager().createChat(msgto + MyStayConstants.CHAT_DOMAIN, new XmppMessageListener(session));
                 chat.sendMessage(firstmsg);

                 numberOfActiveUser ++ ;
                }
      }

        if(isAnonymus==false){
            ///Save Visit Id Again - Start
            def visitData = Visit.get(visitId);
            visitData.chatType = chatTopic;
            visitData.save(flush: true)
            ///Save Visit Id Again - End
        }
      

        println "Last AdminUser: " + msgto;

        render(view: 'index',model:[chatwith:msgto])
    }



    def loadMessagesFromSession(){
      //new
      def session = RequestContextHolder.currentRequestAttributes().getSession()
      JSONArray msgLst = (JSONArray)session.getAttribute(MyStayConstants.MY_MESSAGE_LIST);
      //println "loadMessagesFromSession: msgLst : " + msgLst;
      render(msgLst);
    }

    def sendMessages(){
       String userId = request.getCookie(MyStayConstants.USER_ID);
       String msgs = params.chat_input.trim();
       String msgTo = params.chatwith + MyStayConstants.CHAT_DOMAIN;
       
       //new
       def session = RequestContextHolder.currentRequestAttributes().getSession()
       XMPPConnection connection =  session.getAttribute(MyStayConstants.XMPP_CONN);

         if(isAutoReplyExists(msgs)){
           msgTo = MyStayConstants.AUTO_RLY_USR + MyStayConstants.CHAT_DOMAIN;
         }

       println msgTo

       Chat chat = connection.getChatManager().createChat(msgTo, new XmppMessageListener(session));
       chat.sendMessage(msgs);
        

          JSONArray msgLst =null;
          try{

            msgLst = (JSONArray)session.getAttribute(MyStayConstants.MY_MESSAGE_LIST);
            if(msgLst == null){
               msgLst = new JSONArray();
            }
            msgLst.put("<b>"+MyStayConstants.MY_SELF+" :</b>"+msgs);

          }catch(Exception e){
              println "Error is: " + e.getMessage();
          }
       session.setAttribute(MyStayConstants.MY_MESSAGE_LIST,msgLst);

       println "sendMessages: msgLst : " + msgLst;        

       render('success')
    }

    def userLogout(){
       //added
      def session = RequestContextHolder.currentRequestAttributes().getSession()

       MyStayUtility mystayutility = new MyStayUtility();
       mystayutility.clearMySession(session);

       redirect(controller:"locationDetails", action:"index")
   }


    def chatExistingIndex(){

        String convid = params.conv_id;
        String msgto = params.frmUsr;
        String toUser = params.toUsr;

        Sql db = new Sql(dataSource)
        JSONArray msgLst = new JSONArray();
        //println convid
       // println msgto
        String compareWith = msgto;

        db.eachRow("select ofmsg.fromjid,ofmsg.tojid,ofmsg.body from ofmessagearchive ofmsg "+
                    "where ofmsg.conversationid='"+convid+"' order by ofmsg.sentdate",{ row ->
                        String frmUser = row.fromjid.substring(0,row.fromjid.indexOf('@'));
                        

                       if(MyStayConstants.MY_SELF.equals(compareWith)){
                          compareWith = toUser;
                        }
                        println "1."+frmUser
                        println "2."+compareWith
                        //println "3."+toUser
                        
                            if(frmUser.equals(compareWith)){
                                msgLst.put("<b>"+msgto+" :</b>"+row.body);
                               }else{
                                msgLst.put("<b>"+MyStayConstants.MY_SELF+" :</b>"+row.body);
                               }
                       

              })
          
        session.setAttribute(MyStayConstants.MY_MESSAGE_LIST,msgLst);

        
        if(MyStayConstants.MY_SELF.equals(msgto)){
            render(view: 'index',model:[chatwith:toUser])
        }else{
           render(view: 'index',model:[chatwith:msgto])
        }
       
    }

     private boolean isAutoReplyExists(String msgBody){
         boolean isExists=false;
         def autoMsgLst = AutoReply.list();

                for(AutoReply autoMsg: autoMsgLst) {
                    if(msgBody.equalsIgnoreCase(autoMsg.question))
                        {
                            isExists=true;
                            break;
                        }
                    }
          return isExists;
     }
}
