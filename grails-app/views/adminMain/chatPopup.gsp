<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sample title</title>
  </head>
  <body>

    <g:form method="post">

      <table id="chattable">
        <tr>
          <td>

          </td>
        </tr>
       </table>
            <div align="center">

                    <input type="hidden" name="sendto" id="sendto" value=<%=request.getParameter('chatWith') %>  readonly />
                    <textarea id="chat_input" name="chat_input" placeholder="Write a reply..."></textarea>

                    <INPUT type="button" id="replytochat" value="reply to chat" onclick="sendMsgs();"/>

            </div>

       <script language="javascript">
     var messageDisplayed = 0;

     function sendMsgs() {
         var xmlhttp=false;
              var sendXmlhttp=false;
              //alert("I m in Send message");
               var sendto = document.getElementById("sendto").value;

               var chat_input = document.getElementById("chat_input").value;
               //alert(chat_input);
               var table = document.getElementById('chattable');
               var rowCount = table.rows.length;
               var row = table.insertRow(rowCount);
               var cell = row.insertCell(0);
               cell.innerHTML="<b>Me: </b> " + chat_input;

            try{
                  // Opera 8.0+, Firefox, Safari
                  sendXmlhttp = new XMLHttpRequest();
               } catch (e){
                  // Internet Explorer Browsers
                  try{
                     sendXmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
                  } catch (e) {
                     try{
                        sendXmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                     } catch (e){
                        // Something went wrong
                        alert("Your browser broke!");
                        return false;
                     }
                  }
               }
               sendXmlhttp.open("GET",'/MyStayApp/adminMain/sendMessages?chat_input='+chat_input+'&send_to='+sendto , true);
               sendXmlhttp.send(null);
               document.getElementById("chat_input").value="";
               messageDisplayed = messageDisplayed + 1;
            return false;
        }


function getMessage(){
        var getXmlhttp=false;
        var sendto = document.getElementById("sendto").value;
          try{
                // Opera 8.0+, Firefox, Safari
                getXmlhttp = new XMLHttpRequest();
             } catch (e){
                // Internet Explorer Browsers
                try{
                   getXmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e) {
                   try{
                      getXmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                   } catch (e){
                      // Something went wrong
                      alert("Your browser broke!");
                      return false;
                   }
                }
             }
             getXmlhttp.open("GET",'/MyStayApp/adminMain/getMyChatMsgs?userfrom='+sendto , true);

             getXmlhttp.onreadystatechange= function() {
                if (getXmlhttp.readyState==4) {

                    var status = getXmlhttp.responseText;
                    var user_array = JSON.parse(status);
                    //alert(ststus);
                    if(status==null || status=='' || status=='null'){
                    }else{
                      

                      for(var i = messageDisplayed; i <user_array.length;i++ ){
                        var table = document.getElementById('chattable');
                        var rowCount = table.rows.length;
                        var row = table.insertRow(rowCount);
                        var cell = row.insertCell(0);
                        cell.innerHTML=user_array[i];
                        }
                      messageDisplayed = user_array.length;
                    }

                }
             }

         getXmlhttp.send(null);

        return false;
      }

      window.setInterval("getMessage()",10000);

       </script>

    </g:form>
  </body>
</html>
