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
  <div id="container" data-role="page" data-template="chat">
    <g:include controller="pageInclude" action="headerbar" />
    
    <div id="main" role="main" data-role="content">
    	<section class="content gradient clearfix">
            <h1 class="modal-title">Create a profile</h1>
            <p>
              <g:if test="${flash.message}">
                    <div class="message">${flash.message}</div>
              </g:if>
            </p>
    	</section> <!-- /.content -->

        <section class="content gradient clearfix">
                <g:form action="createProfile" >
                    <div align="center" style="padding: 0px 20px 0px 10px">
                      <label for="firstname" class="ui-input-text">* First Name</label>
                      <input type="text" name="firstName" id="firstname" value="" placeholder="" class="ui-input-text ui-body-c ui-corner-all ui-shadow-inset">

                      <label for="lastName" class="ui-input-text">* Last Name</label>
                      <input type="text" name="lastName" id="lastname" value="" placeholder="" class="ui-input-text ui-body-c ui-corner-all ui-shadow-inset">

                      <label for="emailAddress" class="ui-input-text">* Email Address</label>
                      <input type="email" name="emailAddress" id="email" value="" placeholder="">
<!--
                      <label for="confirmEmailAddress" class="ui-input-text">* Confirm Email Address</label>
                      <input type="email" name="confirmEmailAddress" id="email-confirm" value="" placeholder="">
-->
                      <label for="password" class="ui-input-text">* Password</label>
                      <input type="password" name="password" id="password" value="" placeholder="">
<!--
                      <label for="confirmPassword" class="ui-input-text">* Confirm Password</label>
                      <input type="password" name="confirmPassword" id="password-confirm" value="" placeholder="">
-->
                      <label for="address1" class="ui-input-text">Address Line 1</label>
                      <input type="text" name="address1" id="address1" value="" placeholder="">

                      <label for="address2" class="ui-input-text">Address Line 2</label>
                      <input type="text" name="address2" id="address2" value="" placeholder="">

                      <label for="city" class="ui-input-text">City</label>
                      <input type="text" name="city" id="city" value="" placeholder="">

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
                      <option value="CANADA">CANADA</option>
                      </select>

                      <label for="postalCode" class="ui-input-text">Postal Code</label>
                      <input type="text" name="postalCode" id="postalCode" value="" placeholder="">

                      <label for="mobileNo" class="ui-input-text">Mobile Number</label>
                      <input type="text" name="mobileNo" id="mobileNo" value="" placeholder="">

                      <!--button>submit</button-->
                        <g:submitButton value="submit" name="create"/>
                    </div>
                    </g:form>
        </section>
    </div>

    <g:include controller="pageInclude" action="footerbar" />
    
  </div> <!-- end of #container -->

  <g:include controller="pageInclude" action="footerinclude" />

</body>
</html>
