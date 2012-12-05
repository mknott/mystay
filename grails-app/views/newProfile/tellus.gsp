<!doctype html> 
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
  <div id="container" data-role="page" data-template="chat">

	<!-- Header Include<?php include "../components/header-condensed.html" ?> -->
    
    <g:include controller="pageInclude" action="headerinclude" />
    <div id="main" class="ui-content" data-role="content" role="main">
      <section class="content gradient clearfix">
      <h1 class="pagetitle">Create a profile</h1>
      </section>
                               
      <g:form url="[action:'tellus',controller:'newProfile']" method="post" >
        <div align="center" style="padding: 0px 20px 0px 10px">
        
          <label for="hotelNameDisplay">Hotel Name 
<!--            <g:link controller="selectLocation" action="index" params="[editLocation='Y']" class="cta-blue">Change</g:link>-->
              <a href="/selectLocation/index?editLocation=Y" class="cta-blue">Change</a>
          </label>
          <g:textField name="hotelNameDisplay" value="${visit?.hotelName}" disabled="true"/>
          <input type="hidden" name="hotelName" id="hotelName" value="${visit?.hotelName}" />

          <label for="firstName">First Name *</label>
          </label>
          <g:textField name="firstName" value="${visit?.firstName}" />

          <label for="lastName">Last Name *</label>
          <g:textField name="lastName" value="${visit?.lastName}" />

          <label for="roomNumber">Room Number *</label>
          <input type="text" name="roomNumber" id="roomNumber" value="${visit?.roomNumber}" placeholder="">

          <label for="checkInDate">Check-In Date</label>
          <input name="checkInDate" id="checkInDate" type="date" data-role="datebox" data-options='{"mode": "calbox"}' value="${visit?.checkInDate}" placeholder="MM-DD-YYYY">
                 <!--<input name="checkInDate" id="checkInDate" type="text" value="${visit?.checkInDate}">-->

          <label for="checkOutDate">Check-Out Date</label>
          <input name="checkOutDate" id="checkOutDate" type="date" data-role="datebox" data-options='{"mode": "calbox"}' value="${visit?.checkOutDate}" placeholder="MM-DD-YYYY">
          <!--<input name="checkOutDate" id="checkOutDate" type="text" value="${visit?.checkOutDate}">-->

          <label for="confirmationId">Reservation Confirmation</label>
          <input type="text" name="confirmationId" id="confirmationId" value="${visit?.confirmationId}" placeholder="">

          <label for="hasUserProf">Click to Create a User Profile</label>
          <input type="checkbox" name="hasUserProf" id="hasUserProf" value="1" placeholder="" data-theme="q"> 
          <input type="hidden" name="emailAddress" id="emailAddress" value="${params?.emailAddress}" />
          <input type="hidden" name="mobileNumber" id="mobileNumber" value="${params?.mobileNumber}" />
          <input type="hidden" name="rewardsProgramId" id="rewardsProgramId" value="${params?.rewardsProgramId}" />
          <input type="hidden" name="chatType" id="chatType" value="${params?.chatType}" />
          <input type="hidden" name="userId" id="userId" value="${params?.userId}" />
          <input type="hidden" name="propertyId" id="propertyId" value="${params?.propertyId}" />
          <!--button>Register My Stay</button-->
          <g:submitButton name="submitPage" value="Register My Stay" />
          <br>
          <a class="cta-blue formfooter" href="/locationDetails/home">Don't want to register?  Sign in as guest </a>
          <br><br>
        </div>
      </g:form>
    </div>
  
    <g:include controller="pageInclude" action="footerinclude" />

</body>
</html>
