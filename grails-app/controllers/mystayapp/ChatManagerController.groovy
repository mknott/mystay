package mystayapp

import groovy.sql.Sql;
import org.json.JSONObject;
import org.json.JSONArray;
import groovy.json.JsonSlurper;
import com.utility.*;

class ChatManagerController {

    def dataSource


    def index() {
        
      def firstName = request.getCookie(MyStayConstants.FIRST_NAME);
      def lastName = request.getCookie(MyStayConstants.LAST_NAME);
      def roomNumber = request.getCookie(MyStayConstants.ROOM_NUMBER);
      def visitId = request.getCookie(MyStayConstants.VISIT_ID);
      def username = request.getCookie(MyStayConstants.USER_ID);

      println "====="+username;

      if((username==null || username.trim().equals("")) && session.getAttribute(MyStayConstants.USER_ID)!=null)
      {
            
        username = session.getAttribute(MyStayConstants.USER_ID);
           
      }

     println "====="+username;

      JSONArray chatlist = new JSONArray();

      Sql sql = new Sql(dataSource);

      sql.eachRow("select distinct(ofm.conversationid) from ofmessagearchive ofm "+
                  "where (ofm.fromjid like '"+username+"@%' "+
                  "or ofm.tojid like '"+username+"@%') and ofm.conversationid not in (select distinct(ofms.conversationid) from ofmessagearchive ofms  where ofms.fromjid like 'autoreply@%' or ofms.tojid like 'autoreply@%')", { convrow ->

                //println "----------->" + convrow.conversationid;

                sql.eachRow("select ofmsg.fromjid,ofmsg.tojid,ofmsg.sentdate,ofmsg.body from ofmessagearchive ofmsg "+
                            "where ofmsg.conversationid='"+convrow.conversationid+"' order by ofmsg.sentdate desc limit 1 offset 0", { row ->

                JSONObject chatInfo = new JSONObject();
                    String frmUsr = row.fromjid.substring(0,row.fromjid.indexOf('@'));
                    if(frmUsr.equals(username)){
                        chatInfo.put("fromUser","Me");
                    }else{
                        chatInfo.put("fromUser",frmUsr);
                    }
                    
                    chatInfo.put("toUser",row.tojid.substring(0,row.tojid.indexOf('@')));
                    chatInfo.put("sentDate",new Date(row.sentdate));
                    chatInfo.put("msgBody",row.body);
                    chatInfo.put("convID",convrow.conversationid);

                    chatlist.put(chatInfo);

                })
            })

       def list = new JsonSlurper().parseText( chatlist.toString() )

       [msglist:list]

       //render(view: 'index')
    }
}
