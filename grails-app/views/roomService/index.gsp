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

  <div id="container" data-role="page" data-template="service">
    <!-- Header Include -->
    <g:include controller="pageInclude" action="headerinclude" />

    <div id="main" role="main" data-role="content">  
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
        <g:each var="menu" in="${Menu}">
           <div data-role="collapsible" data-mini="true" data-iconpos="right" data-theme="q" data-collapsed="true">
              <!-- Menu Item Template -->
              <h3>
                ${menu.name}          
                <div class="h3-sub">${menu.caption}</div>
              </h3>
              <ul class="rows alternating ">
              <g:each var="item" in="${menu.menuItem}">
                <li class="modal clearfix">

                <g:link controller="${item.controller}" action="${item.action}" class="modal"params="[menu_item_id:item.id ]">
                    <div class="label menu-item">${item.name}</div>
                    <div class="info menu-item-price">${item.price} </div>
                </g:link>
              </li>
              </g:each> 
              </ul>
           </div>
        </g:each>
        </div>
    </div>

    <g:include controller="pageInclude" action="footerinclude" />

</body>
</html>