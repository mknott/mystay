<!doctype html>
<!-- Conditional comment for mobile ie7 blogs.msdn.com/b/iemobile/ -->
<!--[if IEMobile 7 ]>    <html class="no-js iem7" lang="en"> <![endif]-->
<!--[if (gt IEMobile 7)|!(IEMobile)]><!--> <html class="no-js" lang="en"> <!--<![endif]-->

<head>
  <meta charset="utf-8">

  <title></title>
 
  <g:include controller="pageInclude" action="header" />

</head>

<body>
  <div id="container" data-role="page" data-template="chat">
    
    <g:include controller="pageInclude" action="headerbar" />

    <div class="modal_content">     
      
            <div class="modal-title">Login</div>
            <g:form url="[action:'authenticate',controller:'login']"  method="post">
                    <div align="center" style="padding: 0px 10px 0px 10px">
                            <label for="username">Email Address</label>
                            <input type="text" name="emailAddress" id="emailAddress" value="" placeholder="">

                            <label for="password">Password</label>
                            <input type="password" name="password" id="password" value="" placeholder="">

                            <button>myStay Account</button>
                    </div>
            </g:form>
            <!--p>
            Don't have an account? <g:link url="[action:'tellus',controller:'newProfile']" class="cta-blue modal-close">sign in as guest</g:link><br>
            You want to create an account? <g:link  url="[action:'index',controller:'newProfile']" class="cta-blue modal-close">register now</g:link>
            </p -->
    </div>
    
    <g:include controller="pageInclude" action="footerbar" />
    
  </div> <!-- end of #container -->

  <g:include controller="pageInclude" action="footer" />

</body>
</html>
