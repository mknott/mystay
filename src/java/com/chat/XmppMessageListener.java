/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.chat;

import javax.servlet.http.HttpSession;
import com.utility.*;
import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.packet.Message;
import org.json.*;
/**
 *
 * @author palashb
 */
public class XmppMessageListener implements MessageListener {

        HttpSession session=null;

	public XmppMessageListener(HttpSession session){
		this.session=session;
	}

      public void processMessage(Chat chat, Message message) {
		
            try{
                System.out.print( "ClientListener: XmppMessageListener=" + message.getBody());
                if(message.getBody()!=null){
                    String userfrom = chat.getParticipant();

                    userfrom = userfrom.substring(0,userfrom.indexOf('@'));

                      JSONArray msgLst =null;
                      try{

                        msgLst = (JSONArray)session.getAttribute(MyStayConstants.MY_MESSAGE_LIST);
                        if(msgLst == null){
                           msgLst = new JSONArray();
                        }
                        msgLst.put("<b>"+userfrom+" :</b>"+message.getBody());

                      }catch(Exception e){
                           System.out.print( "ClientListener: Error is=" + e.getMessage());
                      }
                     session.setAttribute(MyStayConstants.MY_MESSAGE_LIST,msgLst);

                    System.out.print("ClientListener: Message.getBody=" + message.getBody());

                    }
                    
                }catch(Exception ex){
                    System.out.print( "ClientListener: Error is=" + ex.getMessage());
                        
                }
	}
}
