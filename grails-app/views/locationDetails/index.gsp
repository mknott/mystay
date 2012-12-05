<!doctype html> <!-- Conditional comment for mobile ie7 blogs.msdn.com/b/iemobile/ -->
<!--[if<!doctype html> 
<!-- Conditional comment for mobile ie7 blogs.msdn.com/b/iemobile/ -->
<!--[if IEMobile 7 ]>    <html class="no-js iem7" lang="en"> <![endif]-->
<!--[if (gt IEMobile 7)|!(IEMobile)]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->

<head>
  <meta charset="utf-8">

  <title>Tell us about your stay</title>

  <g:include controller="pageInclude" action="headinclude" />

</head>

<body>

  <!--
  	The ID below has a value which needs to be unique within the entire site.
  	LDP_id should be replaced with "LDP_{location_id}" to ensure uniqueness
  -->
  <div id="[unique_id]" data-template="ldp" data-role="page">

    <!-- Header Include -->
    <g:include controller="pageInclude" action="headerinclude" />

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
                <g:each in="${moduleList}" var="item">
                  <g:link class="tile" controller="${item.controller}" action="${item.action}" 
                          params="[chat_input:item.message, chat_topic:item.name, module_id:item.id ]">
                          <img class="scalable" src="${item.imageSrc}">
                          <div class="caption">${item.caption}</div>
                  	  <div class="badge orange">1</div>

                  </g:link>
                </g:each> 
            </section>
    	</section>
    </div>

    <g:include controller="pageInclude" action="footerinclude" />

</body>
</html>