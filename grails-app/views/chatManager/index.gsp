<!doctype html> <!-- Conditional comment for mobile ie7 blogs.msdn.com/b/iemobile/ -->
<!--[if IEMobile 7 ]>    <html class="no-js iem7" lang="en"> <![endif]-->
<!--[if (gt IEMobile 7)|!(IEMobile)]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->

  <head>
  <meta charset="utf-8">

  <title>select your location</title>
  <!-- Mobile viewport optimization h5bp.com/ad -->
  <meta name="HandheldFriendly" content="True">
  <meta name="MobileOptimized" content="320">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0"/>

  <!-- Home screen icon  Mathias Bynens mathiasbynens.be/notes/touch-icons -->
  <!-- For iPhone 4 with high-resolution Retina display: -->
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/assets/img/h/apple-touch-icon.png">
  <!-- For first-generation iPad: -->
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/assets/img/m/apple-touch-icon.png">
  <!-- For non-Retina iPhone, iPod Touch, and Android 2.1+ devices: -->
  <link rel="apple-touch-icon-precomposed" href="/assets/img/l/apple-touch-icon-precomposed.png">
  <!-- For nokia devices: -->
  <link rel="shortcut icon" href="/assets/img/l/apple-touch-icon.png">

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
  <link rel="stylesheet" href="/assets/css/reset.css">

  <!-- All JavaScript at the bottom, except for Modernizr which enables HTML5 elements & feature detects -->
  <script src="/assets/js/libs/modernizr-2.0.6.min.js"></script>

  <link rel="stylesheet" href="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.css" />
  <!--link rel="stylesheet" href="../assets/css/jquery.mobile-1.1.0.min.css" /> -->

  <link rel="stylesheet" href="/assets/css/main.css">

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

  </div> <!--! end of #container -->
  <div id="modal_content" class="reveal-modal" style="visibility: hidden;">
	Content was not loaded properly.
  </div>

  <!-- JavaScript at the bottom for fast page loading -->

  <!-- Grab Google CDN's jQuery, with a protocol relative URL; fall back to local if necessary -->
  <!-- Libraries --->
  <!--script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script-->
  <script>window.jQuery || document.write('<script src="../assets/js/libs/jquery-1.7.1.min.js"><\/script>')</script>
  <script src="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.js"></script>
  <!--script src="../assets/js/jquery.mobile-1.1.0.min.js"></script-->
  <!--script src="/assets/js/jquery-mobile-custom.js"></script-->
  
  <!-- scripts concatenated and minified via ant build script-->
  <script src="../assets/js/libs/jquery.iscroll.js"></script>
  <script src="../assets/js/helper.js"></script>
  <script src="../assets/js/plugins.js"></script>
  <script src="../assets/js/script.js"></script>
  <!-- end scripts-->

  <!-- Asynchronous Google Analytics snippet. Change UA-XXXXX-X to be your site's ID.
       mathiasbynens.be/notes/async-analytics-snippet -->
  <script>
	var _gaq = [["_setAccount", "UA-XXXXX-X"], ["_trackPageview"]]; ( function(d, t) {
			var g = d.createElement(t), s = d.getElementsByTagName(t)[0];
			g.async = 1;
			g.src = ("https:" == location.protocol ? "//ssl" : "//www") + ".google-analytics.com/ga.js";
			s.parentNode.insertBefore(g, s)
		}(document, "script")); 
  </script>
</body>
</html>