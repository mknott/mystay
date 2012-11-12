<!doctype html>
<!-- Conditional comment for mobile ie7 blogs.msdn.com/b/iemobile/ -->
<!--[if IEMobile 7 ]>    <html class="no-js iem7" lang="en"> <![endif]-->
<!--[if (gt IEMobile 7)|!(IEMobile)]><!--> <html class="no-js" lang="en"> <!--<![endif]-->

<head>
  <meta charset="utf-8">

  <title></title>
  <meta name="description" content="">

  <!-- Mobile viewport optimization h5bp.com/ad -->
  <meta name="HandheldFriendly" content="True">
  <meta name="MobileOptimized" content="320">
  <meta name="viewport" content="width=device-width">

  <!-- Home screen icon  Mathias Bynens mathiasbynens.be/notes/touch-icons -->
  <!-- For iPhone 4 with high-resolution Retina display: -->
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/img/h/apple-touch-icon.png">
  <!-- For first-generation iPad: -->
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/img/m/apple-touch-icon.png">
  <!-- For non-Retina iPhone, iPod Touch, and Android 2.1+ devices: -->
  <link rel="apple-touch-icon-precomposed" href="../assets/img/l/apple-touch-icon-precomposed.png">
  <!-- For nokia devices: -->
  <link rel="shortcut icon" href="../assets/img/l/apple-touch-icon.png">

  <!-- iOS web app, delete if not needed. https://github.com/h5bp/mobile-boilerplate/issues/94 -->
  <!-- <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="apple-mobile-web-app-status-bar-style" content="black"> -->
  <!-- <script>(function(){var a;if(navigator.platform==="iPad"){a=window.orientation!==90||window.orientation===-90?"img/startup-tablet-landscape.png":"img/startup-tablet-portrait.png"}else{a=window.devicePixelRatio===2?"img/startup-retina.png":"img/startup.png"}document.write('<link rel="apple-touch-startup-image" href="'+a+'"/>')})()</script> -->

  <!-- The script prevents links from opening in mobile safari. https://gist.github.com/1042026 -->
  <!-- <script>(function(a,b,c){if(c in b&&b[c]){var d,e=a.location,f=/^(a|html)$/i;a.addEventListener("click",function(a){d=a.target;while(!f.test(d.nodeName))d=d.parentNode;"href"in d&&(d.href.indexOf("http")||~d.href.indexOf(e.host))&&(a.preventDefault(),e.href=d.href)},!1)}})(document,window.navigator,"standalone")</script> -->

  <!-- Mobile IE allows us to activate ClearType technology for smoothing fonts for easy reading -->
  <meta http-equiv="cleartype" content="on">

  <!-- more tags for your 'head' to consider h5bp.com/d/head-Tips -->

  <!-- Main Stylesheet -->
  <link rel="stylesheet" href="../assets/css/base.css">

  <!-- All JavaScript at the bottom, except for Modernizr which enables HTML5 elements & feature detects -->
  <script src="../assets/js/libs/modernizr-2.0.6.min.js"></script>

<!--  <link rel="stylesheet" href="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.css" />-->
  <link rel="stylesheet" href="assets/css/jquery.mobile-1.1.0.min.css" />
<!--  <script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>-->
  <script src="assets/js/jquery-1.7.1.min.js"></script>
<!--  <script src="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.js"></script>-->
  <script src="assets/js/jquery.mobile-1.1.0.min.js"></script>

  <link rel="stylesheet" href="assets/css/jquery-mobile-datebox.css">
  <script src="assets/js/jquery-mobile-datebox.js"></script>

  <link rel="stylesheet" href="../assets/css/main.css">
</head>

<body>
  <div id="container" data-role="page" data-template="chat">

	<!-- Header Include<?php include "../components/header-condensed.html" ?> -->
    
    <g:include controller="pageInclude" action="headerinclude" />
    <div class="modal_content">
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>

      <div class="modal-title">Tell Us About Your Stay</div>
                               
      <g:form url="[action:'index',controller:'newProfile']" method="post">
        <div align="center" style="padding: 0px 20px 0px 10px">
         <!-- Hello <g:cookie name="visitId" /> and ${visit.hotelName}-->
          <label for="hotelNameDisplay">Hotel Name</label>
          <g:if test="${visit.hotelName}">
              <g:textField name="hotelNameDisplay" value="${visit.hotelName}" disabled="true"/>
          </g:if>
          <g:else>
                <g:textField name="hotelNameDisplay" value="" disabled="true"/>
          </g:else>
          <input type="hidden" name="hotelName" id="hotelName" value="${visit.hotelName}" />

          <label for="firstName">First Name</label>
          <g:if test="${visit.firstName}">
              <g:textField name="firstName" value="${visit.firstName}" />
          </g:if>
          <g:else>
                <g:textField name="firstName" value="" />
          </g:else>

          <label for="lastName">Last Name</label>
          <g:if test="${visit.lastName}">
            <g:textField name="lastName" value="${visit.lastName}" />
          </g:if>
          <g:else>
                <g:textField name="lastName" value="" />
          </g:else>

          <label for="roomNumber">Room Number</label>
          <input type="text" name="roomNumber" id="roomNumber" value="${visit.roomNumber}" placeholder="">

          <label for="checkInDate">Check-In Date</label>
          <input name="checkInDate" id="checkInDate" type="date" data-role="datebox" data-options='{"mode": "calbox"}' value="${visit.checkInDate}" placeholder="MM-DD-YYYY">
                 <!--<input name="checkInDate" id="checkInDate" type="text" value="${visit.checkInDate}">-->

          <label for="checkOutDate">Check-Out Date</label>
          <input name="checkOutDate" id="checkOutDate" type="date" data-role="datebox" data-options='{"mode": "calbox"}' value="${visit.checkOutDate}" placeholder="MM-DD-YYYY">
          <!--<input name="checkOutDate" id="checkOutDate" type="text" value="${visit.checkOutDate}">-->

          <label for="confirmationId">Reservation Confirmation</label>
          <input type="text" name="confirmationId" id="confirmationId" value="${visit.confirmationId}" placeholder="">

          <label for="isCrtUserProf">Click to Create a User Profile</label>
          <input type="checkbox" name="isCrtUserProf" id="isCrtUserProf" value="1" placeholder="" data-theme="q">

          <input type="hidden" name="chatType" id="chatType" value="${params.chatType}" />
          <input type="hidden" name="userId" id="userId" value="${params.userId}" />
          <input type="hidden" name="propertyId" id="propertyId" value="${property.id}" />
          <!--button>Register My Stay</button-->
          <g:submitButton name="submitPage" value="Register My Stay" />
        </div>
      </g:form>
      <g:link url="[action:'home',controller:'locationDetails']" class="cta-blue modal-close">Don't want to register?  Sign in as guest </g:link>
    </div>
  <!-- Footer Include <?php include "../components/footer.html" ?>-->
    <g:include controller="pageInclude" action="footerinclude" />

  </div> <!--! end of #container -->


  <!-- JavaScript at the bottom for fast page loading -->

  <!-- Grab Google CDN's jQuery, with a protocol relative URL; fall back to local if necessary -->
  <!--script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script-->
  <script>window.jQuery || document.write('<script src="../assets/js/libs/jquery-1.7.1.min.js"><\/script>')</script>

  <!-- scripts concatenated and minified via ant build script-->
  <script src="../assets/js/helper.js"></script>
  <script src="../assets/js/plugins.js"></script>
  <script src="../assets/js/script.js"></script>
  
 
  <!-- end scripts-->

  <!-- Debugger - remove for production -->
  <!-- <script src="https://getfirebug.com/firebug-lite.js"></script> -->

  <!-- Asynchronous Google Analytics snippet. Change UA-XXXXX-X to be your site's ID.
       mathiasbynens.be/notes/async-analytics-snippet -->
  <script>
    var _gaq=[["_setAccount","UA-XXXXX-X"],["_trackPageview"]];
    (function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];g.async=1;
    g.src=("https:"==location.protocol?"//ssl":"//www")+".google-analytics.com/ga.js";
    s.parentNode.insertBefore(g,s)}(document,"script"));
  </script>


</body>
</html>
