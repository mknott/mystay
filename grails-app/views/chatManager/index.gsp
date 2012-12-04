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

    <div id="unique_9467239359459" data-role="page" data-template="chat">

    <!-- Header Include -->
    <g:include controller="pageInclude" action="headerinclude" />

    <div id="main" role="main" data-role="content">

        <section class="content gradient clearfix">
        <h1 class="pagetitle">Chat With Us</h1>
              <p>
                Use the Concierge to help you with any of your questions before,
                during and after your stay.
        <br>
              <g:link  url="[action:'index',controller:'chatNew']" class="cta-blue">Start a new chat </g:link>
              </p>
        </section> 
        <!-- /.content -->

        <section class="chat content gradient clearfix">
        <!-- COMPONENT: Single Chat Session -->
          <g:each in="${msglist}" var="item">
              <g:link class="tile" controller="chatExisting" action="chatExistingIndex" params="[conv_id:item.convID, frmUsr:item.fromUser,toUsr:item.toUser]">
                  <div class="container">
                    <ul>
                      <li class="clearfix">
                          <!-- Badge div should be left out if no new messages -->
                          <div class="badge orange">
                                  5
                          </div>
                          <div class="avatar">
                                  <img src="/assets/img/fpo_100x100.gif" class="scalable">
                          </div>
                          <div class="username">
                                  ${item.fromUser}
                          </div>
                          <div class="timestamp">
                                  ${item.sentDate} in room
                          </div>
                          <div class="message">
                                  ${item.msgBody}
                          </div>
                      </li>
                    </ul>
                  </div>
                </g:link>
              <!-- /Single Chat Session -->
        </g:each>		
        </section>
      </div> <!-- /#main -->
	
    <g:include controller="pageInclude" action="footerinclude" />

</body>
</html>