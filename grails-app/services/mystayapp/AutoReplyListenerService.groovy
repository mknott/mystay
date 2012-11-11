package mystayapp

import com.utility.*;

class AutoReplyListenerService {

    static expose = [ 'jabber' ]

     def onJabberMessage = { msg ->
            //log.debug "Received jabber message [from: $msg.from, subject: $msg.subject, body: $msg.body]"
            //println "Received jabber message [from: $msg.from, subject: $msg.subject, body: $msg.body]"
            //println msg.from
            String msgBody = msg.body
            String msgfrom =  msg.from.substring(0,msg.from.indexOf("@"))
            String replyMsg = null;
            try{
            //=============Autoreply==================
           
            def autoMsgLst = AutoReply.list();

            for(AutoReply autoMsg: autoMsgLst) {
                if(msgBody.equalsIgnoreCase(autoMsg.question))
                    {
                        replyMsg = autoMsg.answer;
                        break;
                    }
                }
           
            //String replyMsg = MyStayConstants.autoReplyMsgLst.get(msgBody.toLowerCase());

            println "msgfrom= "+ msgfrom+ " msgBody= " + msgBody +" replyMsg= "+ replyMsg;
            
            if(replyMsg!=null)
                {
                    sendJabberMessage(msgfrom + MyStayConstants.CHAT_DOMAIN, replyMsg)
                }
           //=========================================
            

            }catch(all){
                println all.message
            }

        }
   
}
