<!doctype html> 
<!-- Conditional comment for mobile ie7 blogs.msdn.com/b/iemobile/ -->
<!--[if IEMobile 7 ]>    <html class="no-js iem7" lang="en"> <![endif]-->
<!--[if (gt IEMobile 7)|!(IEMobile)]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->

<head>
  <meta charset="utf-8">

  <title>Tell us about your stay</title>

  <g:include controller="pageInclude" action="headerinclude" />

</head>

<body>
  <!--
  	The ID below has a value which needs to be unique within the entire site.
  	LDP_id should be replaced with "LDP_{location_id}" to ensure uniqueness
  -->
  <div id="[unique_id]" data-template="ldp" data-role="page">

    <g:include controller="pageInclude" action="headerbar" />

    <div id="main" role="main" data-role="content">
      <g:if test="${property.propertyImage}">
        <section class="brand" style="background-color: ${property.propertyBGColor};">
            <div class="img" ><img src="/assets/img/${property.propertyImage}"></div>
      </g:if>
      <g:else>
        <section class="brand" style="background-color: #999999">
            <div class="img" ><img src="/assets/img/fpo_640x288.gif"></div>
      </g:else>
        </section>

    	<section class="content gradient clearfix">
          <h1 class="pagetitle center">Available Services</h1>
            <section class="grid4 clearfix">
                    <!-- Tile Template -->
                <g:each in="${moduleList}" var="module">
                  <g:link class="tile" controller="${module.controller}" action="${module.action}" 
                      params="[chat_input:module.message, chat_topic:module.name, module_id:module.id ]">
                      <img class="scalable" src="${module.imageSrc}">
                      <div class="caption">${module.caption}</div>
<!--TO-DO: replace with dynamic chat-message indicator from module to visit-->                    
                      <g:if test="${module.name=='Room Service'}">
                        <div class="badge orange">1</div>
                      </g:if>
                  </g:link>
                </g:each> 
            </section>
    	</section>
    </div>

    <g:include controller="pageInclude" action="footerbar" />
    
  </div> <!-- end of #container -->

  <g:include controller="pageInclude" action="footerinclude" />

</body>
</html>
