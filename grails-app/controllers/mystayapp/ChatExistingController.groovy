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

class ChatExistingController {

    ConnectionConfiguration config = new ConnectionConfiguration(MyStayConstants.CHAT_SERVER, MyStayConstants.CHAT_PORT, MyStayConstants.CHAT_SERVICE);
    def dataSource

    def index() {

      def session = RequestContextHolder.currentRequestAttributes().getSession()
      println session.id;
      def firstmsg = params.chat_input;
      def msgto = params.chat_topic + MyStayConstants.CHAT_DOMAIN;
      println msgto
      println firstmsg

      XMPPConnection connection = new XMPPConnection(config);
      connection.connect();

      def firstName = request.getCookie("firstName");
      def lastName = request.getCookie("lastName");
      def roomNo = request.getCookie("roomNo");

      def userProfileInstance = UserProfile.find("from UserProfile as b where b.firstName=?",firstName);

      if(userProfileInstance!=null)
      {
        def username = userProfileInstance.emailAddress;
        def password = userProfileInstance.password;
        connection.login(username,password);
      }
      else{
          AccountManager accmanager = connection.getAccountManager();
          def username = "rm"+roomNo+"_"+lastName;
          println username;
          def password = lastName;
          def temp_name = "";
                    
          Sql db = new Sql(dataSource)
          //def result = db.rows("SELECT username FROM ofuser");
          db.eachRow("select * from ofuser where username='"+username+"'",{ row ->

                temp_name=row.username;
           })
           println "username" + temp_name;

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

      Chat chat = connection.getChatManager().createChat(msgto, new XmppMessageListener(session));
      chat.sendMessage(firstmsg);

      JSONArray msgLst =null;
      try{

        msgLst = (JSONArray)session.getAttribute(MyStayConstants.MY_MESSAGE_LIST);
        if(msgLst == null){
           msgLst = new JSONArray();
        }
        msgLst.put("<b>Me :</b>"+firstmsg);

      }catch(Exception e){
          println "Error is: " + e.getMessage();
      }
      session.setAttribute(MyStayConstants.MY_MESSAGE_LIST,msgLst);

      session.setAttribute(MyStayConstants.XMPP_CONN,connection);
      session.setAttribute(MyStayConstants.CHAT_OBJ,chat);

      render(view: 'index')

    }

    def index_old() {

      def session = RequestContextHolder.currentRequestAttributes().getSession()
      println session.id;
      def firstmsg = params.chat_input;
      def msgto = params.chat_topic + MyStayConstants.CHAT_DOMAIN;
      println msgto
      println firstmsg

      XMPPConnection connection = new XMPPConnection(config);
      connection.connect();
      connection.loginAnonymously();

      Chat chat = connection.getChatManager().createChat(msgto, new XmppMessageListener(session));
      chat.sendMessage(firstmsg);

      JSONArray msgLst =null;
      try{

        msgLst = (JSONArray)session.getAttribute(MyStayConstants.MY_MESSAGE_LIST);
        if(msgLst == null){
           msgLst = new JSONArray();
        }
        msgLst.put("<b>Me :</b>"+firstmsg);

      }catch(Exception e){
          println "Error is: " + e.getMessage();
      }
      session.setAttribute(MyStayConstants.MY_MESSAGE_LIST,msgLst);
      
      session.setAttribute(MyStayConstants.XMPP_CONN,connection);
      session.setAttribute(MyStayConstants.CHAT_OBJ,chat);

      //flash.message = message(code: params.chat_input)

      render(view: 'index')

    }

    def loagMessagesFromSession(){
      //new
      def session = RequestContextHolder.currentRequestAttributes().getSession()
      JSONArray msgLst = (JSONArray)session.getAttribute(MyStayConstants.MY_MESSAGE_LIST);

      //println "loagMessagesFromSession: msgLst : " + msgLst;
      render(msgLst);
    }

    def sendMessages(){
       String msgs = params.chat_input;
        // chat_input
        //new
       def session = RequestContextHolder.currentRequestAttributes().getSession()
       XMPPConnection connection =  session.getAttribute(MyStayConstants.XMPP_CONN);
       Chat chat =  session.getAttribute(MyStayConstants.CHAT_OBJ);
       chat.sendMessage(msgs);

          JSONArray msgLst =null;
          try{

            msgLst = (JSONArray)session.getAttribute(MyStayConstants.MY_MESSAGE_LIST);
            if(msgLst == null){
               msgLst = new JSONArray();
            }
            msgLst.put("<b>Me :</b>"+msgs);

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



}
