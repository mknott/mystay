package mystayapp

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import com.chat.XmppMessageListener;
import org.springframework.web.context.request.RequestContextHolder;
class ChatNewController {

    def index() {
        println("chatnew params"+ params);
        def session = RequestContextHolder.currentRequestAttributes().getSession()
        session.invalidate()
        render(view: "index", model:[params:params])
    }


    def startChat(){
        //redirect(controller: "chatExisting", action: "index")
        //forward controller: "chatExisting", action: "index"
    }

}
