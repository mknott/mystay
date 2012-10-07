package mystayapp

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class MyDetailsController {

    def index() {
    
        System.out.println("IN MyDetailsController..");
        
        //def email = request.getCookie("email");
        def firstName = request.getCookie("firstName");
        def lastName = request.getCookie("lastName");
        def checkin = request.getCookie("checkin");
        def checkout = request.getCookie("checkout");
        def roomNo = request.getCookie("roomNo");
        
        def myDetails = new MyDetails();             
        
        myDetails.firstName = firstName;
        myDetails.lastName = lastName;
        myDetails.roomNo = roomNo;
        myDetails.checkin = checkin;
        myDetails.checkout = checkout;
        
        render(view: 'mydetails', model: [myDetails: myDetails])
    }
}
