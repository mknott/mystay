<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin Home</title>
   <script language="javascript" type="text/javascript">
function chatWindow(usertochat){
	var url = "/MyStayApp/adminMain/openPopup?chatWith="+usertochat;
        //alert(url);
        if (!window[usertochat] || window[usertochat].closed){
		window[usertochat] = window.open(url,usertochat,'height=350,width=350');
	}
	window[usertochat].focus();
	return false;
}

var xmlhttp=false;

	function checkUserList(){

			try{
			      // Opera 8.0+, Firefox, Safari
			      xmlhttp = new XMLHttpRequest();
			   } catch (e){
			      // Internet Explorer Browsers
			      try{
			         xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
			      } catch (e) {
			         try{
			            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			         } catch (e){
			            // Something went wrong
			            alert("Your browser broke!");
			            return false;
			         }
			      }
			   }
			   xmlhttp.open("GET",'getActiveUserList' , true);

			   xmlhttp.onreadystatechange= function() {
			      if (xmlhttp.readyState==4) {

			    	  var status = xmlhttp.responseText;
                                  var user_array = JSON.parse(status);
                                  if(user_array==null || user_array =='null'){
                                  }else{
                                     for(var i = 0;i <user_array.length;i++ ){
                                           if(user_array[i] != ''){
                                                 chatWindow(user_array[i]);
                                           }
                                    }
                                  }
                                  //alert(user_array);
			      }
			   }
			   xmlhttp.send(null);
		return false;
	}

 window.setInterval("checkUserList()",10000);
</script>
    
  </head>
  <body>
    <h1>Admin Home</h1>
  </body>
</html>
