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

class ChatExistingController {

    //private ConnectionConfiguration config = new ConnectionConfiguration("palash-vaio", 5222, "conference");
    ConnectionConfiguration config = new ConnectionConfiguration(MyStayConstants.LCHAT_SERVER, MyStayConstants.CHAT_PORT, MyStayConstants.CHAT_SERVICE);
    private String msgto = "admin" + MyStayConstants.CHAT_DOMAIN;

    def index() {

      def session = RequestContextHolder.currentRequestAttributes().getSession()
      println session.id;
      String firstmsg = params.chat_input;
      println params.chat_topic
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
        msgLst.put("<b>Me: </b>"+firstmsg);

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

      JSONArray msgLst = (JSONArray)session.getAttribute(MyStayConstants.MY_MESSAGE_LIST);

      //println "loagMessagesFromSession: msgLst : " + msgLst;
      render(msgLst);
    }

    def sendMessages(){
       String msgs = params.chat_input;
        // chat_input
       XMPPConnection connection =  session.getAttribute(MyStayConstants.XMPP_CONN);
       Chat chat =  session.getAttribute(MyStayConstants.CHAT_OBJ);
       chat.sendMessage(msgs);

          JSONArray msgLst =null;
          try{

            msgLst = (JSONArray)session.getAttribute(MyStayConstants.MY_MESSAGE_LIST);
            if(msgLst == null){
               msgLst = new JSONArray();
            }
            msgLst.put("<b>Me: </b>"+msgs);

          }catch(Exception e){
              println "Error is: " + e.getMessage();
          }
       session.setAttribute(MyStayConstants.MY_MESSAGE_LIST,msgLst);

       println "sendMessages: msgLst : " + msgLst;
       
       render('success')
    }

}
