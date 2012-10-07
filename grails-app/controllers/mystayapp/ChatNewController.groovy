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

class ChatNewController {

    def index() {
     session.invalidate()
     render(view: 'index')
    }


    def startChat(){
      //redirect(controller: "chatExisting", action: "index")
      //forward controller: "chatExisting", action: "index"
    }

}
