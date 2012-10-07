package admin

import mystayapp.*;
import com.utility.*;
import org.json.JSONArray;
import org.jivesoftware.smack.*;
import org.json.JSONObject;
import org.springframework.web.context.request.RequestContextHolder;
import groovy.sql.Sql;

class AdminMainController {

     def dataSource

    def getChatDetails(){
        //http://localhost:8080/MyStayApp/adminMain/getChatDetails?username=rm442_da&adminUname=admin
        def uname = params.username;
        def adminUname = params.adminUname;

        JSONObject userdetails = new JSONObject();
            userdetails.put("userId",uname);
            userdetails.put("emailId","subhadeep@gmail.com");
            userdetails.put("roomNo","201");
            userdetails.put("confirmationID","4678123");
            userdetails.put("checkIn","Tues, Apr 3,2012");
            userdetails.put("checkOut","Sun, Apr 8,2012");
            userdetails.put("chatType","RoomSvc");
            userdetails.put("conversationId","1");
        JSONArray chatmsgarr = new JSONArray();

        Sql sql = new Sql(dataSource);
        
        //the id should be used to retrieve name from the same table.
        sql.eachRow("select mdg.fromjid , mdg.tojid , mdg.sentdate, mdg.body from ofmessagearchive mdg where mdg.fromjid like ('"+uname+"@%') or mdg.fromjid like ('"+adminUname+"@%') and mdg.tojid like ('"+uname+"@%') or mdg.tojid like ('"+adminUname+"@%')", { row ->
                JSONObject chatmsg = new JSONObject();
                    chatmsg.put("fromUser",row.fromjid);
                    chatmsg.put("toUser",row.tojid);
                    chatmsg.put("sentDate",new Date(row.sentdate));
                    chatmsg.put("msgBody",row.body);
                    
                chatmsgarr.put(chatmsg);

            })

        userdetails.put("chatmsg",chatmsgarr)

        render(userdetails)
    }

    def getAllUserList(){
    //http://localhost:8080/MyStayApp/adminMain/getAllUserList
    JSONArray activeusers = new JSONArray();
    Sql sql = new Sql(dataSource)
    sql.eachRow("select username from ofuser ofu where ofu.username not in (select username from ofpresence ofp)", { row ->
            JSONObject activeuser = new JSONObject();
                activeuser.put("userId",row.username);
                activeuser.put("chatType","RoomSvc");
                activeuser.put("pendingMsg","3");
                activeuser.put("roomNo","201");
                activeuser.put("lastName","Vail");
                activeuser.put("imgLocation","../assets/img/restaurant.png");
                activeuser.put("conversationId","1");

            activeusers.put(activeuser);
            })

    render(activeusers);
    }



    def index() {
        //new
        def session = RequestContextHolder.currentRequestAttributes().getSession()
        session.invalidate()
        println "AdminMainController: I m in index page";
    }

    def openPopup() {
        render(view: 'chatPopup');
    }

    def adminUserLogin(){

            def inputAdminuser = new AdminUser(params)
            def session = RequestContextHolder.currentRequestAttributes().getSession()
            println session.id;

            if(inputAdminuser){
                def admiUserInstance = AdminUser.find("from AdminUser as a where a.userName=?",[inputAdminuser.userName]);
                if((inputAdminuser.userName == admiUserInstance.userName) && (inputAdminuser.password == admiUserInstance.password))
                {
                           MyStayUtility mystayutility = new MyStayUtility();
                           if(mystayutility.isChatServerLoginSucc(inputAdminuser.userName,inputAdminuser.password,session)){
                                render(view: 'admin_home')
                           }else{
                               render(view: 'index')
                           }

                }
                else{
                            render(view: 'index')
                }
            }
        println "AdminMainController: adminUserLogin = complete"
    }

    def getAllUsersChat(){
        //new
        def session = RequestContextHolder.currentRequestAttributes().getSession()
      JSONArray msgLst = null;
       if (session != null){
           msgLst = (JSONArray)session.getAttribute(MyStayConstants.MSG_LIST);
       }

       println "AdminMainController: getAllUsersChat = " + msgLst

       render(msgLst);
    }

    def getActiveUserList(){
        //new
        def session = RequestContextHolder.currentRequestAttributes().getSession()
      JSONArray userLst = null;
       if (session != null){
           userLst = (JSONArray)session.getAttribute(MyStayConstants.ACTIVE_USERS);
       }

       render(userLst)
    }

    def getMyChatMsgs(){
        //new
        def session = RequestContextHolder.currentRequestAttributes().getSession()
        String myname = params.userfrom;
        JSONObject userfrmchat = null;

        JSONArray msgLst = null;
           if (session != null){
               msgLst = (JSONArray)session.getAttribute(MyStayConstants.MSG_LIST);
           }

        if(msgLst!=null){
            for(int i=0;i<msgLst.length() ; i++){
                    JSONObject chatobj = (JSONObject)msgLst.get(i);
                    try{
                      if(chatobj.getJSONArray(myname)!=null){
                            userfrmchat = chatobj;
                            break;
                        }
                    }catch(Exception ex){
                        System.out.println("AdminMainController: User JSONObject="  + ex.getMessage());
                    }

                }

            //println "getMyChatMsgs: " + userfrmchat.getJSONArray(myname);
            render(userfrmchat.getJSONArray(myname));
        }else{
            render("[]");
        }



    }

    def sendMessages(){
        //new
        def session = RequestContextHolder.currentRequestAttributes().getSession()
       // chat_input
       String send_msg = params.chat_input;
       String send_to = params.send_to;

       //println send_msg +"------"+send_to;

       JSONObject usertochat = null;

       XMPPConnection connection =  (XMPPConnection)session.getAttribute(MyStayConstants.XMPP_CONN);

       //Chat chat =  session.getAttribute("chat");
       try{

           if(connection==null){
               render('error')
           }else{
               Chat chat = connection.getChatManager().createChat(send_to + MyStayConstants.CHAT_DOMAIN,null);
               chat.sendMessage(send_msg);

               JSONArray msgLst = (JSONArray)session.getAttribute(MyStayConstants.MSG_LIST);

                if(msgLst!=null){
                    int position = 0;
			for(int i=0;i<msgLst.length() ; i++){

                            JSONObject chatobj = (JSONObject)msgLst.get(i);
                            try{
                              if(chatobj.getJSONArray(send_to)!=null){
                                    usertochat = chatobj;
                                    position = i;
                                    break;
                                }
                            }catch(Exception ex){
                                System.out.println("User JSONObject : "  + ex.getMessage());
                            }

                        }

                  JSONArray chatlst = (JSONArray)usertochat.getJSONArray(send_to);
                  chatlst.put("Me : " + send_msg);
                  usertochat.put(send_to,chatlst);

                  msgLst.put(position,usertochat);

                  session.setAttribute(MyStayConstants.MSG_LIST,msgLst);

                  println "AdminMainController: sendMessages=" + usertochat;
                  println "AdminMainController: msgLst=" + msgLst;
                  }



               render('success')
           }

       }catch(Exception ex){
           println "Message From Session: " + ex.getMessage();
           render('error')
       }


    }


    def adminLogout(){
        //new
        def session = RequestContextHolder.currentRequestAttributes().getSession()
        MyStayUtility mystayutility = new MyStayUtility();
        mystayutility.clearMySession(session);
        render(view: 'index');
    }

}
