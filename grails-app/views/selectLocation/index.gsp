<!doctype html> 
<!-- Conditional comment for mobile ie7 blogs.msdn.com/b/iemobile/ -->
<!--[if IEMobile 7 ]>    <html class="no-js iem7" lang="en"> <![endif]-->
<!--[if (gt IEMobile 7)|!(IEMobile)]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->

  <head>
  <meta charset="utf-8">

  <title>select your location</title>

  <g:include controller="pageInclude" action="headinclude" />

</head>

<body>
  <div id="homepage" data-template="homepage" data-role="page">
    <header data-role="header">

    </header>
    
    <div id="main" role="main" data-role="content">
      <section class="hero">
          <div class="mainlogo">
            <g:img uri="/assets/img/logo_standard.png"/>
               <!-- <g:link controller="locationDetails" action="index" class="modal">
                  <g:img uri="/assets/img/logo_standard.png"/>
                </g:link>-->
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
                                            <div class="bubble-content">Order a drink while you're relaxing by the pool</div>
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
                                            <div class="bubble-content">Order a quick bite to eat before my next meeting</div>
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
                                            <div class="bubble-content">Schedule a spa appointment from the comfort of your room</div>
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
                                            <div class="bubble-content">Make dinner reservations while you are on the slopes</div>
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
          <p>
          	Take full advantage of all the services during your stay right from your wireless device.
		<br>
		<a href="#" class="getgeo">Get Location</a>
		<br>
		Select from these participating properties
	  </p>

          <g:form url="[action:'index',controller:'newProfile']" method="post">
              <div align="center">
		   <select name="propertyId" id="propertyId" data-theme="q" data-shadow="false" data-inline="false">
		   <g:each in="${selectLocationList}" var="property">
	  	   <option value="${property.id}">${property.hotelName}</option>
		   </g:each>      
		   </select>
                 <input type='submit' id="submit" value='start mystay'/>
              </div>
          </g:form>
      </section>
    </div>

    <g:include controller="pageInclude" action="footerinclude" />

  </body>
</html>