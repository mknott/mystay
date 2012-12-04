<!doctype html> 
<!-- Conditional comment for mobile ie7 blogs.msdn.com/b/iemobile/ -->
<!--[if IEMobile 7 ]>    <html class="no-js iem7" lang="en"> <![endif]-->
<!--[if (gt IEMobile 7)|!(IEMobile)]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->

<head>
  <meta charset="utf-8">

  <title>Tell us about yourself</title>

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

        <section class="content gradient clearfix">
          <g:form action="createProfile" >
          <div align="center" style="padding: 0px 20px 0px 10px">      
              <label for="lastName">First Name *</label>
              <g:textField name="firstName" value="${visit?.firstName}" />

              <label for="lastName">Last Name *</label>
              <g:textField name="lastName" value="${visit?.lastName}" />

              <label for="emailAddress">Email Address *</label>
              <g:textField name="emailAddress" value="${userProfile?.emailAddress}" />

              <label for="mobileNumber">Mobile Number</label>
              <g:textField name="mobileNumber" value="${userProfile?.mobileNumber}" />

              <label for="address1">Address Line 1</label>
              <g:textField name="address1" value="${userProfile?.address1}" />

              <label for="address2">Address Line 2</label>
              <g:textField name="address2" value="${userProfile?.address2}" />

              <label for="city">City</label>
              <g:textField name="city" value="${userProfile?.city}" />

              <label for="state" class="ui-input-text">State</label>
              <select name="state" id="state" data-theme="q" data-shadow="false">
              <option value="">Select</option>
              <option value="ILLINOIS">ILLINOIS</option>
              <option value="NEW YORK">NEW YORK</option>
              </select>

              <label for="country" class="ui-input-text">Country</label>
              <select name="country" id="country" data-theme="q" data-shadow="false">
              <option value="">Select</option>
              <option value="USA">USA</option>
              <option value="CANADA">Canada</option>
              <option value="MEXICO">Mexico</option>
              </select>

              <label for="postalCode" class="ui-input-text">Postal Code</label>
              <g:textField name="postalCode" value="${userProfile?.postalCode}" />

              <label for="password" class="ui-input-text">Password</label>
              <g:textField type="password" name="password" id="password" value="${userProfile?.password}" />

              <!--button>submit</button-->
              <g:submitButton value="submit" name="create"/>
          </div>
          </g:form>
        </section>
    </div>

    <g:include controller="pageInclude" action="footerinclude" />

</body>
</html>