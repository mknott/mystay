package admin

import mystayapp.*;
import com.utility.*;
import org.json.JSONArray;
import org.jivesoftware.smack.*;
import org.json.JSONObject;
import org.springframework.web.context.request.RequestContextHolder;

class AdminMainController {

    def index() {
        session.invalidate()
        println "AdminMainController: I m in index page";
    }

    def openPopup() {
        //String chatWith = params.chatWith + MyStayConstants.CHAT_DOMAIN;
        //println 'chatWith : ' + params.chatWith;
        //render(view: 'chatPopup?chatWith='+chatWith);
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
      JSONArray msgLst = null;
       if (session != null){
           msgLst = (JSONArray)session.getAttribute(MyStayConstants.MSG_LIST);
       }

       println "AdminMainController: getAllUsersChat = " + msgLst

       render(msgLst);
    }

    def getActiveUserList(){
      JSONArray userLst = null;
       if (session != null){
           userLst = (JSONArray)session.getAttribute(MyStayConstants.ACTIVE_USERS);
       }

       //println "AdminMainController: getActiveUserList = " + userLst
       //PrintWriter writer = response.getWriter();
       //writer.print(userLst.toString());
       //writer.flush();
       //writer.close();
       render(userLst)
       //byte[] bytes = userLst.toString().getBytes();
       //response.outputStream << bytes
    }

    def getMyChatMsgs(){
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


}
