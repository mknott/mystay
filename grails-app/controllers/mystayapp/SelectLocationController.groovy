package mystayapp

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.utility.*;

class SelectLocationController {

    static defaultAction = "index"
    
    def index() 
    { 
        println("home")
        //if cookies are set and then redirect to locationDetails unless edit flag sent
        if (!request.getCookie(MyStayConstants.PROPERTY_ID) ||
        (params.editLocation && params.editLocation=="Y")
        )
        {
            println("no cookie set or edit "+ request.getCookie(MyStayConstants.PROPERTY_ID) + " params " + params)
            def SelectLocations = Property.withCriteria {
            eq("status","ACTIVE")
            }
            render(view: 'index',model:[selectLocationList:SelectLocations])
        }
        else
        { 
            println("cookie set "+request.getCookie(MyStayConstants.PROPERTY_ID) + " - "+params.editLocation)
            redirect(controller:"locationDetails")
        }
    }
}
