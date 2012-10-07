<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sample title</title>
  </head>
  <body>
    <h1>Sample line</h1>
    
    <g:form url="[action:'adminUserLogin',controller:'adminMain']"  method="post">

      <input type="text" name="userName" /><br/>

      <input type="password" name="password" /><br/>

      <input type="submit" />

    </g:form>

  </body>
</html>
