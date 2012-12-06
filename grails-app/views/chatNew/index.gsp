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
            <h1 class="pagetitle">Chat With Us</h1>

            <p>
            Use the Concierge to help you with any of your questions before,
            during and after your stay.
            <br/>
              <g:link url="[action:'index',controller:'chatManager']" class="cta-blue ui-link modal-close"> Back to chat list </g:link>
              <g:link class="cta-blue ui-link modal-close" controller="roomService" action="index" params="[module_id:params.module_id]"> Back to room service </g:link>
             
            </p>
    	</section> <!-- /.content -->

        <section class="content gradient clearfix">
          <h2>Start a new chat</h2>
          <g:form url="[action:'index',controller:'chatExisting']" method="post">
            <div align="center">
              <select name="chat_topic" id="chat_topic" data-theme="q"  data-shadow="false">
                  <option value="">Select a topic</option>
                  <option value="RoomSvc">Room Service</option>
                  <option value="HelpDsk">Help Desk</option>
                  <option value="FoodSvc">Food Service</option>
              </select>
              <textarea name="chat_input" placeholder="Chat with Room Service" id="chat_input"></textarea>
              <button>start chat</button>
            </div>
            
            <script>
                var keys = new Array();
                keys[0] = "RoomSvc";
                keys[1] = "HelpDsk";
                keys[2] = "FoodSvc";

                var values = new Array();
                values[0] = "Room Service, I need yor help";
                values[1] = "I need Help";
                values[2] = "I want Food now";

                var topicSelectBox=document.getElementById("chat_topic");
                topicSelectBox.onchange = function (){
                    //alert(topicSelectBox.value)
                    var selectedOption = topicSelectBox.value;
                    for(var i=0;i<keys.length;i++){
                      if(keys[i]==selectedOption){
                        document.getElementById("chat_input").value = values[i];
                        break;
                      }
                    }
                }
            </script>
        </g:form>
        </section>
    </div>

    <g:include controller="pageInclude" action="footerinclude" />

</body>
</html>