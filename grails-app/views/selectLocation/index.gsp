<!doctype html>
<!-- Conditional comment for mobile ie7 blogs.msdn.com/b/iemobile/ -->
<!--[if IEMobile 7 ]>    <html class="no-js iem7" lang="en"> <![endif]-->
<!--[if (gt IEMobile 7)|!(IEMobile)]><!--> <html class="no-js" lang="en"> <!--<![endif]-->

<head>
  <meta charset="utf-8">

  <title>select your location</title>
  <meta name="description" content="">

  <!-- Mobile viewport optimization h5bp.com/ad -->
  <meta name="HandheldFriendly" content="True">
  <meta name="MobileOptimized" content="320">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0"/>

  <!-- Home screen icon  Mathias Bynens mathiasbynens.be/notes/touch-icons -->
  <!-- For iPhone 4 with high-resolution Retina display: -->
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/img/h/apple-touch-icon.png">
  <!-- For first-generation iPad: -->
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/img/m/apple-touch-icon.png">
  <!-- For non-Retina iPhone, iPod Touch, and Android 2.1+ devices: -->
  <link rel="apple-touch-icon-precomposed" href="assets/img/l/apple-touch-icon-precomposed.png">
  <!-- For nokia devices: -->
  <link rel="shortcut icon" href="assets/img/l/apple-touch-icon.png">

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
  <script src="/assets/js/libs/modernizr-2.0.6.min.js"></script>

  <!--link rel="stylesheet" href="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.css" />-->
  <link rel="stylesheet" href="../assets/css/jquery.mobile-1.1.0.min.css" />
  <link rel="stylesheet" href="../assets/css/main.css">

</head>

<body>
  <div id="homepage" data-template="homepage" data-role="page">
    <header data-role="header">

    </header>
    <div id="main" role="main" data-role="content">
      <section class="hero">
          <div class="mainlogo">
              <li><g:link controller="locationDetails" action="index" class="modal modal-close"><g:img uri="/assets/img/logo_standard.png"/></g:link></li>
          </div>
          <div id="myScroll" class="imagecarousel clearfix">
              <section>
                  <div class="carousel">
                      <div id="wrapper" class="wrapper">
                          <div id="scroller" class="scroller">
                              <ul class="scrollItems hidden">
                                  <li class="current">
                                      <img src="/assets/img/myStay_iPhone_mobileweb_homepage_02.jpg" alt="" />
                                      <div class="content">
                                          <g:link  class="bubble" controller="locationDetails" action="index">
                                            <div class="bubble-icon">
                                               <img src="/assets/img/icon_mobile.png">
                                            </div>
                                            <div class="bubble-title">relax@</div>
                                            <div class="bubble-content">Order a drinkwhile you're relaxing by the pool</div>
                                          </g:link>
                                      </div>
                                  </li>
                                  <li>
                                      <img src="/assets/img/myStay_iPhone_mobileweb_homepage_03_02.jpg" alt="" />
                                      <div class="content">
                                          <g:link class="bubble" controller="locationDetails" action="index">
                                            <div class="bubble-icon">
                                              <img src="/assets/img/icon_service.png">
                                            </div>
                                            <div class="bubble-title">quick@</div>
                                            <div class="bubble-content">Order a quick bite to eat before my next meeting</div>
                                          </g:link>
                                      </div>
                                  </li>
                                  <li>
                                      <img src="/assets/img/myStay_iPhone_mobileweb_homepage_05_02.jpg" alt="" />
                                      <div class="content">
                                          <g:link  class="bubble" controller="locationDetails" action="index">
                                            <div class="bubble-icon">
                                              <img src="/assets/img/icon_relax.png">
                                            </div>
                                            <div class="bubble-title">unwind@</div>
                                            <div class="bubble-content">Schedule a spa appointment from the comfort of your room</div>
                                          </g:link>
                                      </div>
                                  </li>
                                  <li>
                                      <img src="/assets/img/myStay_iPhone_mobileweb_homepage_06_02.jpg" alt="" />
                                      <div class="content">
                                          <g:link  class="bubble" controller="locationDetails" action="index">
                                            <div class="bubble-icon">
                                              <img src="/assets/img/icon_dine.png">
                                            </div>
                                            <div class="bubble-title">dine@</div>
                                            <div class="bubble-content">Make dinner reservations while you are on the slopes</div>
                                          </g:link>
                                      </div>
                                  </li>
                              </ul>
                          </div>
                          <div class="prev ir" onclick="myScroll.scrollToPage('prev', 0);return false;"><a href="#">prev</a></div>
                          <div class="next ir" onclick="myScroll.scrollToPage('next', 0);return false;"><a href="#">next</a></div>
                          <div class="carouselNav hidden">
                          <ul class="indicator"></ul>
                          </div>
                      </div>
                  </div>
              </section>
          </div>
      </section>

      <section class="content gradient">
          <p>Take full advantage of all the services during your stay right from your wireless device.</p>

          <!--<a class="getgeo ui-link" href="#">Get Location</a>-->

          <p>Select from these participating properties</p>

          <g:form url="[action:'index',controller:'newProfile']" method="post">
              <div align="center">
              <div class="ui-select">
              <div class="ui-btn ui-btn-corner-all ui-fullsize ui-btn-block ui-btn-icon-right ui-btn-up-q" data-corners="true" data-shadow="false" data-iconshadow="true" data-wrapperels="span" data-icon="arrow-d" data-iconpos="right" data-theme="q" data-inline="false" data-mini="false">
              <!--<span class="ui-btn-inner ui-btn-corner-all">-->
              <span class="ui-icon ui-icon-arrow-d ui-icon-shadow"> </span>
              </span>

              <select id="propertyId" data-inline="false" data-shadow="false" data-theme="q" name="propertyId">
              <g:each in="${selectLocationList}" var="property">
              <option value="${property.id}">${property.hotelName}</option>
              </g:each>      

              </select>

              </div>
              </div>
                <input type='submit' id="submit" value='start mystay'/>
              </div>
          </g:form>
      </section>
    </div>

    <footer>
        <section class="social">
                share this @ <img src="/assets/img/fpo_social.png" width="98">
        </section>
        <section class="links centered clearfix">
            <ul>
                <li>&copy; CueMobile</li>
                <li><g:link controller="locationDetails" action="index">Privacy Policy</g:link></li>
                <li><g:link controller="locationDetails" action="index">Trademark</g:link></li>
                <li><g:link controller="locationDetails" action="index">Terms</g:link></li>
            </ul>
        </section>
    </footer>
  </div> <!--! end of #container -->
<div id="modal_content" class="reveal-modal" style="visibility: hidden;"> Content was not loaded properly. </div>

  <!-- JavaScript at the bottom for fast page loading -->

  <!-- Grab Google CDN's jQuery, with a protocol relative URL; fall back to local if necessary -->
  <!--script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script-->
  <script>window.jQuery || document.write('<script src="../assets/js/libs/jquery-1.7.1.min.js"><\/script>')</script>
  <!--script src="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.js"></script>-->
  <script src="../assets/js/jquery.mobile-1.1.0.min.js"></script>
  <!--script src="/assets/js/jquery-mobile-custom.js"></script-->
  
  <!-- scripts concatenated and minified via ant build script-->
  <script src="../assets/js/libs/jquery.iscroll.js"></script>
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