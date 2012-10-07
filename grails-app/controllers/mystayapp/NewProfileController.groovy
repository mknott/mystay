package mystayapp

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



class NewProfileController {

    def index() {
        render(view: 'index')
    }

    def createProfile(){
       
            def guestInstance = new UserProfile(params)
            guestInstance.save(flush: true)
            println("Name: " + guestInstance.firstName);
            flash.message = message(code: 'default.mtstay.message', args: [guestInstance.firstName])
            println("MSG: " + flash.message);

            //render(view: 'tell-us',model: [guestInstance: guestInstance])

            redirect(controller:"locationDetails", action:"home")
    }
    
    def tellus()
    { 
        if(request.getCookie("firstName")!=null && request.getCookie("lastName")!=null){
                def fName = request.getCookie("firstName");
                def lName = request.getCookie("lastName");
                println(fName + " " +lName);
                def visit = new Visit();
                visit = Visit.find("from Visit as b where b.firstName=? and b.lastName=?",fName,lName);
                if(visit!=null)
                {
                    //allow to redirect to home page
                    redirect(controller:"locationDetails", action:"home")
                }
                else{
                    render(view: 'tell-us')
                }
                
        }
        else{
            println("cookie not found");
            render(view: 'tell-us')
            
        }   
    }

}
