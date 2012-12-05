package mystayapp

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.utility.*;

class MyDetailsController {

    def index() {   
        System.out.println("MyDetailsController..");
        
        def propertyId = request.getCookie(MyStayConstants.PROPERTY_ID);
        def visitId = request.getCookie(MyStayConstants.VISIT_ID);
        def firstName = request.getCookie(MyStayConstants.FIRST_NAME);
        def lastName = request.getCookie(MyStayConstants.LAST_NAME);
        def checkInDate = request.getCookie(MyStayConstants.CHECKINDATE);
        def checkOutDate = request.getCookie(MyStayConstants.CHECKOUTDATE);
        def roomNumber = request.getCookie(MyStayConstants.ROOM_NUMBER);
        def hotelName = request.getCookie(MyStayConstants.HOTEL_NAME);
        def confirmationId = request.getCookie(MyStayConstants.CONFIRMATION_ID);
        def myChats = request.getCookie(MyStayConstants.MY_CHATS);
        def emailAddress = request.getCookie(MyStayConstants.EMAIL_ADDRESS);
        def mobileNumber = request.getCookie(MyStayConstants.MOBILE_NUMBER);
        def rewardsProgramId = request.getCookie(MyStayConstants.REWARDS_PROGRAM_ID);
        def myDetails = new Visit();             
        
        myDetails.firstName = firstName;
        myDetails.lastName = lastName;
        myDetails.roomNumber = roomNumber;
        myDetails.checkInDate = checkInDate;
        myDetails.checkOutDate = checkOutDate;
        myDetails.hotelName = hotelName;
        myDetails.confirmationId = confirmationId;
        myDetails.myChats = myChats;
        myDetails.emailAddress = emailAddress;
        myDetails.mobileNumber = mobileNumber;
        
        render(view: 'mydetails', model: [myDetails: myDetails])
    }
}