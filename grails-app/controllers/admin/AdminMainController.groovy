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
        //http://localhost:8080/MyStayApp/adminMain/getChatDetails?username=rm111_bbb_13&conversationId=11
        String uname = params.username;
        //def adminUname = params.adminUname;
        String conversationId = params.conversationId;

        JSONArray chatmsgarr = new JSONArray();
        JSONObject userdetails = new JSONObject();
        
      try{
        def visitData = Visit.find("from Visit v where v.userId = ?",uname);

        if(visitData==null){
            userdetails("msg",uname + " Does not found.")
        }else{
            userdetails.put("userId",uname);
            userdetails.put("confirmationID",visitData.confirmationId);
            userdetails.put("checkInDate",visitData.checkInDate);
            userdetails.put("checkOutDate",visitData.checkOutDate);
            userdetails.put("chatType",visitData.chatType);
            userdetails.put("roomNumber",visitData.roomNumber);

            userdetails.put("emailId","");
            userdetails.put("conversationId",conversationId);
            
            Sql sql = new Sql(dataSource);
            //the id should be used to retrieve name from the same table.
            /*sql.eachRow("select mdg.fromjid , mdg.tojid , mdg.sentdate, mdg.body"+
                " from ofmessagearchive mdg where mdg.fromjid like ('"+uname+"@%')"+
                " or mdg.fromjid like ('"+adminUname+"@%') and mdg.tojid like ('"+uname+"@%')"+
                " or mdg.tojid like ('"+adminUname+"@%')", { row ->*/
                
            sql.eachRow("select mdg.fromjid , mdg.tojid , mdg.sentdate, mdg.body"+
                " from ofmessagearchive mdg where mdg.conversationid='"+conversationId+"'", { row ->

                    JSONObject chatmsg = new JSONObject();
                        chatmsg.put("fromUser",row.fromjid);
                        chatmsg.put("toUser",row.tojid);
                        chatmsg.put("sentDate",new Date(row.sentdate));
                        chatmsg.put("msgBody",row.body);

                    chatmsgarr.put(chatmsg);

                })
         }
            
        }catch(Exception ex){
            userdetails.put("msg",ex.getMessage())
        }
        userdetails.put("chatmsg",chatmsgarr)
        render(userdetails)
    }
    

  def getAllUserList(){
    //http://localhost:8080/MyStayApp/adminMain/getAllUserList
    JSONArray activeusers = new JSONArray();
    try{            
        Sql sql = new Sql(dataSource)
        sql.eachRow("select ofu.username from ofuser ofu where ofu.username"+
            " not in (select ofp.username from ofpresence ofp)", { row ->
            def userName = row.username;
            def visitData = Visit.find("from Visit as v where v.userId='"+userName+"'")

            if(visitData != null){
                
              JSONObject activeuser = new JSONObject();
                activeuser.put("userId",userName);
                activeuser.put("chatType",visitData.chatType);
                activeuser.put("roomNumber",visitData.roomNumber);
                activeuser.put("lastName",visitData.lastName);

                def chatProperties = ChatProperties.find("from ChatProperties as cp where cp.chatType='"+visitData.chatType+"'")
                activeuser.put("imgLocation",chatProperties.chatIcon);

                //GroovyRowResult
                Object chatfirstrow = sql.firstRow("select mdg.conversationid, mdg.fromjid , mdg.tojid , mdg.sentdate, mdg.body"+
                                                   " from ofmessagearchive mdg where mdg.fromjid like ('"+userName+"@%') or"+
                                                   " mdg.tojid like ('"+userName+"@%') order by mdg.conversationid desc");
                //println "Last Message:" + chatfirstrow.body
                if(chatfirstrow.fromjid.indexOf(userName+"@") >= 0){
                    activeuser.put("pendingMsg","true");
                    int count = 0;
                    boolean flag = true;
                    sql.eachRow("select mdg.fromjid"+
                                " from ofmessagearchive mdg where mdg.fromjid like ('"+userName+"@%') or"+
                                " mdg.tojid like ('"+userName+"@%') order by mdg.sentdate desc", {chatrow ->                                
                        if(chatrow.fromjid.indexOf(userName+"@")>=0 && flag){
                             count++;
                        }else{
                           flag = false;
                        }
                    })
                    activeuser.put("pendingMsgCount",count);
                }else{
                    activeuser.put("pendingMsg","false");
                }

                activeuser.put("conversationId",chatfirstrow.conversationid);

                activeusers.put(activeuser);
            }
        })

         if(activeusers.length()==0){
             activeusers.put("Data Not Found");
         }

      }catch(Exception ex){
        activeusers.put(ex.getMessage());
      }
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
