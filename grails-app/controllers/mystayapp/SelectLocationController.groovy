package mystayapp

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.utility.*;

class SelectLocationController {

    static defaultAction = "index"
    
    def index() 
    { 
        println("hi")
        def SelectLocations = Property.list();
        //def propertyId = request.getCookie(MyStayConstants.PROPERTY_ID)
        //def propertyId = params.(MyStayConstants.PROPERTY_ID) ? params.(MyStayConstants.PROPERTY_ID) : session.getAttribute(MyStayConstants.PROPERTY_ID)

        render(view: 'index',model:[selectLocationList:SelectLocations])
    }
}
