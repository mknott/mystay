/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utility;

import javax.servlet.http.HttpSession;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author palashb
 */
public class MyStayUtility {

    public boolean isChatServerLoginSucc(final String userName, String password,
            final HttpSession session) throws XMPPException {

		boolean isSuccess = false;
		try{
		XMPPConnection connection = null;

		ConnectionConfiguration config = new ConnectionConfiguration(MyStayConstants.CHAT_SERVER, MyStayConstants.CHAT_PORT, MyStayConstants.CHAT_SERVICE);

		connection = new XMPPConnection(config);

		connection.connect();

		connection.login(userName, password);

		PacketListener myListener = new PacketListener() {
	        public void processPacket(Packet packet) {
	            // Do something with the incoming packet here.
	        	System.out.println("AdminListener : Packet Listener for= "  + userName);
	        	System.out.println("AdminListener : From= "  + packet.getFrom());
	        	//System.out.println("AdminListener : Message: "  + ((Message)packet).getBody());
                        JSONObject userfrmchat = null;
	        	try{

					String userfrom = packet.getFrom();
					if(userfrom!=null){
						userfrom = userfrom.substring(0,userfrom.indexOf('@'));

						JSONArray msgLst = (JSONArray)session.getAttribute(MyStayConstants.MSG_LIST);

						//System.out.println("JSONObject msgLst 1: "  + msgLst);

						if(msgLst==null){
							 msgLst =  new JSONArray();
						}else{

                                                    for(int i=0;i<msgLst.length() ; i++){

                                                        JSONObject chatobj = (JSONObject)msgLst.get(i);
                                                        try{
                                                          if(chatobj.getJSONArray(userfrom)!=null){
                                                                userfrmchat = chatobj;
                                                                break;
                                                            }
                                                        }catch(Exception ex){
                                                            System.out.println("AdminListener : User JSONObject= "  + ex.getMessage());
                                                        }

                                                    }
                                                }
                                                if(userfrmchat==null){
                                                    userfrmchat =  new JSONObject();
                                                    msgLst.put(userfrmchat);
                                                }

						JSONArray chatlst = null;
						try{
							chatlst = (JSONArray)userfrmchat.get(userfrom);
						}catch(Exception e){
							System.out.println("AdminListener :" +e.getMessage());
						}
						if(chatlst==null){
							chatlst = new JSONArray();
						}

                                                chatlst.put(userfrom+" :" + ((Message)packet).getBody());

                                                userfrmchat.put(userfrom, chatlst);

                                                //msgLst.put(userfrmchat);
						//System.out.println("JSONArray chatlst 2: "  + chatlst);
                                                session.setAttribute(MyStayConstants.MSG_LIST,msgLst);

						try{
						boolean isExists = false;
                                                JSONArray userLst = (JSONArray)session.getAttribute(MyStayConstants.ACTIVE_USERS);
                                                if(userLst==null){
                                                        userLst =  new JSONArray();
                                                }else{
                                                    for(int i=0;i<userLst.length() ; i++){

                                                        String obj = (String)userLst.get(i);
                                                        try{
                                                          if(obj.indexOf(userfrom)>=0){
                                                               isExists = true;
                                                                break;
                                                            }else{
                                                              isExists = false;
                                                            }
                                                        }catch(Exception ex){
                                                            System.out.println("AdminListener : User JSONObject="  + ex.getMessage());
                                                        }

                                                    }
                                                }
                                                if(isExists == false){
                                                    //userLst.put(userfrom + MyStayConstants.CHAT_DOMAIN);
                                                    userLst.put(userfrom);
                                                    session.setAttribute(MyStayConstants.ACTIVE_USERS,userLst);
                                                }

                                                System.out.println(" AdminListener: User JSONObject= "  + userLst);
						}catch(Exception e){
							System.out.println(e.getMessage());
						}

                                        System.out.println("AdminListener : Tolat Chat JSONObject="  + msgLst);

                                        }

					}catch(Exception exx){
						System.out.println("AdminListener :Error is=" + exx.getMessage());
						//e.printStackTrace();
					}

	        }
	    };

	    connection.addPacketListener(myListener, null);

            session.setAttribute(MyStayConstants.XMPP_CONN, connection);

            System.out.println("Connection is Successful........");

            isSuccess = true;

		}catch(Exception e){
			e.printStackTrace();
			isSuccess = false;
		}
		return isSuccess;
	}


}
