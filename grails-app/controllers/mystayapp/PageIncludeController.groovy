package mystayapp

import javax.servlet.http.Cookie;
import com.utility.*;

class PageIncludeController {

    def headinclude()
    {
        render(view: 'head')
    }
    
    
    def headerinclude()
    {
        def visit = new Visit(); 
       // visit.firstName = request.getCookie(MyStayConstants.FIRST_NAME); 
       // visit.lastName = request.getCookie(MyStayConstants.LAST_NAME);
       // visit.confirmationId = request.getCookie(MyStayConstants.CONFIRMATION_ID);
       // visit.roomNumber = request.getCookie(MyStayConstants.ROOM_NUMBER);
       // visit.checkInDate = request.getCookie(MyStayConstants.CHECKINDATE);
       // visit.checkOutDate = request.getCookie(MyStayConstants.CHECKOUTDATE);
       //println("headervisit0 "+request.getCookie("visitId"));
//
  //     if (request.getCookie(MyStayConstants.VISIT_ID))
    //   {
      //  visit.id = Long.parseLong(request.getCookie(MyStayConstants.VISIT_ID));
      // println("headervisit0b "+visit.id);
      // }
       // visit.id = request.getCookie(MyStayConstants.VISIT_ID);
       // visit.hotelName = request.getCookie(MyStayConstants.HOTEL_NAME);
       // visit.propertyId = request.getCookie(MyStayConstants.PROPERTY_ID);
      // println("headervisit1 "+visit.id);
        
      //  def visitId = request.getCookie(MyStayConstants.VISIT_ID);
        
       // render(view: 'header',model: [visit: visitId] )
        render(view: 'header')
    }
    
    def footerinclude()
    {
        render(view: 'footer')
    }
}
