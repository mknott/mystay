<!doctype html> 
<!-- Conditional comment for mobile ie7 blogs.msdn.com/b/iemobile/ -->
<!--[if IEMobile 7 ]>    <html class="no-js iem7" lang="en"> <![endif]-->
<!--[if (gt IEMobile 7)|!(IEMobile)]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->

  <head>
  <meta charset="utf-8">

  <title>Room Service</title>

  <g:include controller="pageInclude" action="headinclude" />

</head>

<body>
  <div id="container" data-role="page" data-template="service">

  	<!-- Header Include -->
    <g:include controller="pageInclude" action="headerinclude" />

    <div id="main" role="main" data-role="content">
<!--
    	<section id="breadcrumb" class="links">
    		<ul>
    			<li><a href="../">Home</a></li>
    			<li>Level2</li>
    			<li>Level3</li>
    		</ul>
    	</section>
	<section class="hero">
    		<img class="scalable" src="/assets/img/fpo_640x288.gif">
    	</section>
-->
      <g:if test="${params.propertyImage}">
        <section class="brand" style="background-color: ${params.propertyBGColor};">
            <div class="img" ><img src="/assets/img/${params.propertyImage}"></div>
      </g:if>
      <g:else>
        <section class="brand">
            <div class="img" ><img src="/assets/img/fpo_640x288.gif"></div>
      </g:else>
        </section>

    	<section class="content gradient clearfix">
                <div class="chat-icon">
                          <g:link controller="chatNew" action="index">
                                <img class="scalable" src="/assets/img/icon_chatnow.png">
                          </g:link>
                </div>

                <h1 class="pagetitle">Room Service</h1>

                <p>
                Enjoy a bite to eat from our award-winning kitchen.
    		</p>
    	</section> <!-- /.content -->

            <div data-role="collapsible-set">
                <div data-role="collapsible" data-mini="true" data-iconpos="right" data-theme="q" data-collapsed="false">
                    <h3>
                            Breakfast Menu
                            <div class="h3-sub">Hours 6:00am - 11:00am</div>
                    </h3>
                    <ul class="rows alternating">
                            <li class="modal clearfix" href="/staticpages/modal-additem.html">
                                    <div class="label menu-item">Waffles</div>
                                    <div class="info menu-item-price">$9.99</div>
                            </li>
                            <li class="modal clearfix" href="/staticpages/modal-additem.html">
                                    <div class="label menu-item">Eggs Benedict</div>
                                    <div class="info menu-item-price">$10.99</div>
                            </li>
                            <li class="modal clearfix" href="/staticpages/modal-additem.html">
                                    <div class="label menu-item">Coffee</div>
                                    <div class="info menu-item-price">$3.99</div>
                            </li>
                            <li class="modal clearfix" href="/staticpages/modal-additem.html">
                                    <div class="label menu-item">Hot Oatmeal</div>
                                    <div class="info menu-item-price">$5.99</div>
                            </li>
                    </ul>
                </div>
                <div data-role="collapsible" data-mini="true" data-iconpos="right" data-theme="q">
                    <h3>
                            Lunch Menu
                            <div class="h3-sub">Hours 11:00am - 4:00pm</div>
                    </h3>
                    <ul class="rows alternating">
                            <li class="modal clearfix" href="/staticpages/modal-additem.html">
                                    <div class="label menu-item">Pizza</div>
                                    <div class="info menu-item-price">$13.99</div>
                            </li>
                            <li class="modal clearfix" href="/staticpages/modal-additem.html">
                                    <div class="label menu-item">Hamburger</div>
                                    <div class="info menu-item-price">$9.99</div>
                            </li>
                            <li class="modal clearfix" href="/staticpages/modal-additem.html">
                                    <div class="label menu-item">Coke Products</div>
                                    <div class="info menu-item-price">$3.99</div>
                            </li>
                    </ul>
                </div>
                <div data-role="collapsible" data-mini="true" data-iconpos="right" data-theme="q">
                    <h3>
                            Dinner Menu
                            <div class="h3-sub">Hours 4:00pm - 11:00pm</div>
                    </h3>
                    <ul class="rows alternating">
                            <li class="modal clearfix" href="/staticpages/modal-additem.html">
                                    <div class="label menu-item">Steak</div>
                                    <div class="info menu-item-price">$20.99</div>
                            </li>
                            <li class="modal clearfix" href="/staticpages/modal-additem.html">
                                    <div class="label menu-item">Sushi</div>
                                    <div class="info menu-item-price">$19.99</div>
                            </li>
                            <li class="modal clearfix" href="/staticpages/modal-additem.html">
                                    <div class="label menu-item">Bottle of Red Wine</div>
                                    <div class="info menu-item-price">$35.99</div>
                            </li>
                    </ul>
                </div>
                <div data-role="collapsible" data-mini="true" data-iconpos="right" data-theme="q">
                    <h3>
                            Snack Menu
                            <div class="h3-sub">Available 24 Hours</div>
                    </h3>
                    <ul class="rows alternating">
                            <li class="modal clearfix" href="/staticpages/modal-additem.html">
                                    <div class="label menu-item">Ice Cream</div>
                                    <div class="info menu-item-price">$5.99</div>
                            </li>
                            <li class="modal clearfix" href="/staticpages/modal-additem.html">
                                    <div class="label menu-item">Pizza</div>
                                    <div class="info menu-item-price">$12.99</div>
                            </li>
                            <li class="modal clearfix" href="/staticpages/modal-additem.html">
                                    <div class="label menu-item">Cookies</div>
                                    <div class="info menu-item-price">$4.99</div>
                            </li>
                    </ul>
                </div>
            </div>
    </div>

    <g:include controller="pageInclude" action="footerinclude" />

</body>
</html>