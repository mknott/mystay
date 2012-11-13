package mystayapp

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class LoginController {

    //def scaffold = UserProfile
    //def cookieService

     def index() {
         if(request.getCookie("firstName")!=null)
        {
             redirect(controller:"locationDetails", action:"index")
        }
        else
        {
            //redirect(controller:"newProfile", action:"tellus")
            render(view: 'modal-login')
        }

    }
    
    def authenticate = {
        println request.getCookie("firstName");
        //println cookieService.get("firstName")
        if(request.getCookie("firstName")!=null)
        {
                 redirect(controller:"roomService", action:"index")
        }
        else
        {
            def userProfile = new UserProfile(params)
                int time = 1 * 60 * 60 * 24;
                System.out.println("userNm: "+userProfile.emailAddress);
            if(userProfile){
                def userProfileInstance = UserProfile.find("from UserProfile as b where b.emailAddress=?",[userProfile.emailAddress]);
                if((userProfile.emailAddress == userProfileInstance.emailAddress) && (userProfile.password == userProfileInstance.password))
                {
                            //System.out.println("userNm: "+userProfileInstance.emailAddress);
                            //render(view: 'tellus')
                            def email = new Cookie("email", userProfile.emailAddress);
                            email.maxAge = time;
                            email.setPath("/");
                            response.addCookie(email);
                            redirect(controller:"roomService", action:"index")
                }
                else{
                            render(view: 'modal-login')
                }  
            }
        }
    }
}
