<html class="no-js" lang="en">
 <head>

</head>

  <body>
    <div id="container" data-role="page" data-template="chat">
      
      <div class="modal_content">
        
        <div class="modal-title">Admin User Login</div>

          <g:form url="[action:'adminUserLogin',controller:'adminMain']"  method="post">

            <div align="left" style="padding: 0px 20px 0px 10px">
              <label for="userName">User ID</label>
              <input type="text" name="userName" /><br/>

              <label for="userName">Password</label>
              <input type="password" name="password" /><br/>

               <input type="submit" value="Sign In"/>
            </div>

          </g:form>
      </div>
  </div>
  </body>
</html>
