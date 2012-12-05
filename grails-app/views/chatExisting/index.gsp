<!doctype html> 
<!-- Conditional comment for mobile ie7 blogs.msdn.com/b/iemobile/ -->
<!--[if IEMobile 7 ]>    <html class="no-js iem7" lang="en"> <![endif]-->
<!--[if (gt IEMobile 7)|!(IEMobile)]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->

  <head>
  <meta charset="utf-8">

  <title>Chat with us</title>

  <g:include controller="pageInclude" action="headinclude" />

</head>

<body>
  <div id="container" data-role="page" data-template="chat">
    <!-- Header Include -->
    <g:include controller="pageInclude" action="headerinclude" />
    <div id="main" role="main" data-role="content">

      <section class="content gradient clearfix">
          <h1 class="pagetitle">Chat With Room Service</h1>
          <p>
            <g:link  url="[action:'index',controller:'chatManager']" class="cta-blue ui-link modal-close"> Back to chat list </g:link>
            <g:link  url="[action:'index',controller:'roomService']" class="cta-blue ui-link modal-close"> Back to room service </g:link>
          </p>
      </section> 

      <!-- /.content -->

      <section class="chat content gradient clearfix">
        <div class="container">
          <ul class="rows alternating">
            <li class="clearfix">
  <!-- BEGIN temp placeholder of content style -->
            <table id="chattable">
                  <tr>
                    <td>                                               
                    <div class="avatar">
                            <img src="/assets/img/fpo_100x100.gif" class="scalable">
                    </div>
                    <div class="username">
                            @customer_name
                    </div>
                    <div class="timestamp">
                            Monday at 7:32am in room
                    </div>
                    <div class="message" id="message">
                            Belgian Waffles blandit tempus porttitor. Nulla vitae elit libero
                            retra augue. Lorem ipsum dolor sit amet, consectetur adipiscing elit
                    </div>
                    </td>
                  </tr>
              </table>
  <!-- END temp placeholder of content style -->

            </li>
            <li class="clearfix">
              <g:form method="post">
                  <div align="center">
                      <textarea id="chat_input" name="chat_input" placeholder="Write a reply..."></textarea>
                      <INPUT type="hidden" id="chatwith" name="chatwwith" value="${chatwith}"/>
                      <INPUT type="button" id="replytochat" value="reply to chat" onclick="javascript:sendMsgs();"/>
                  </div>

                  <script language="javascript">
                    var messageDisplayed = 0;
                    function sendMsgs() {
                      //alert("I m in Send message");
                      var sendXmlhttp=false;
                      var chat_input = document.getElementById("chat_input").value;
                      var chat_with = document.getElementById("chatwith").value;
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

                      sendXmlhttp.open("GET",'/MyStayApp/chatExisting/sendMessages?chat_input='+chat_input+"&chatwith="+chat_with , true);
                      sendXmlhttp.send(null);
                      document.getElementById("chat_input").value="";
                      messageDisplayed = messageDisplayed + 1;

                      return false;
                    }

                    //retrieves messages from server running as often as window.setInterval settings
                    function getMessage() {
                      var getXmlhttp=false;

                      try {
                        // Opera 8.0+, Firefox, Safari
                        getXmlhttp = new XMLHttpRequest();
                      } catch (e){
                        // Internet Explorer Browsers
                        try {
                          getXmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
                        } catch (e) {
                          try {
                            getXmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                          } catch (e){
                            // Something went wrong
                            alert("Your browser broke!");
                            return false;
                          }
                        }
                      }

                      getXmlhttp.open("GET",'/MyStayApp/chatExisting/loadMessagesFromSession' , true);
                      getXmlhttp.onreadystatechange= function() {
                        if (getXmlhttp.readyState==4) {
                          var status = getXmlhttp.responseText;
                          var user_array = JSON.parse(status);

                          if(status==null || status=='' || status=='null') {
                          }
                          else {
                            for(var i = messageDisplayed; i <user_array.length;i++ )
                            {
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

                    window.setInterval("getMessage()",4000);
                  </script>

              </g:form>
            </li>
          </ul>
        </div>
      </section>
    </div>

    <g:include controller="pageInclude" action="footerinclude" />

</body>
</html>