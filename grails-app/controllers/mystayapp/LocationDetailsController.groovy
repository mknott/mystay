package mystayapp

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class LocationDetailsController {



     def index() {
         
        def visitData = new Visit(params);
        //System.out.println("reached here 1");
        int time = 0;
        System.out.println(visitData.checkin+"     "+visitData.checkout + "    "+visitData.isCrtUserProf);
        if(visitData.isCrtUserProf==null)
        {
            visitData.isCrtUserProf = 'N';
        }
        else
        {
            visitData.isCrtUserProf = 'Y';
        }
        if(visitData!=null)
        {
            time = 1 * 60 * 60 * 24;
                  
            def firstN = new Cookie("firstName", visitData.firstName);
            firstN.maxAge = time;
            firstN.setPath("/");
            response.addCookie(firstN);
            
            def lastN = new Cookie("lastName", visitData.lastName);
            lastN.maxAge = time;
            lastN.setPath("/");
            response.addCookie(lastN);
            
            def roomN = new Cookie("roomNo", visitData.roomNo);
            roomN.maxAge = time;
            roomN.setPath("/");
            response.addCookie(roomN);
            
            def checkN = new Cookie("checkin", visitData.checkin);
            checkN.maxAge = time;
            checkN.setPath("/");
            response.addCookie(checkN);
            
            def checkOT = new Cookie("checkout", visitData.checkout);
            checkOT.maxAge = time;
            checkOT.setPath("/");
            response.addCookie(checkOT);
            
            visitData.save(flush: true)
        }

        println "params.isCrtUserProf : " + params.isCrtUserProf

        if( params.isCrtUserProf)
        {
            redirect(controller:"newProfile", action:"index")
             
        }
        else
        {            
            if(request.getCookie("firstName")!=null){
                redirect(controller:"roomService", action:"index")
            }else{

                render(view: 'index')
            }
           
        }
    }

     def home() {
            //redirect(controller:"roomService", action:"index")
             render(view: 'index')
     }
}
