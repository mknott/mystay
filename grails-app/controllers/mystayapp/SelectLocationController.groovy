package mystayapp

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.utility.*;

class SelectLocationController {

    static defaultAction = "index"
    
    def index() 
    { 
        println("selectLocation.home")
        //if cookies are set and then redirect to locationDetails unless edit flag sent
        if (!request.getCookie(MyStayConstants.PROPERTY_ID) ||
             (params.editLocation && params.editLocation=="Y")
        )
        {
            println("selectLocation.no cookie set or edit "+ request.getCookie(MyStayConstants.PROPERTY_ID) + " params " + params)
            //retrieve all properties who are active
            def SelectLocations = Property.withCriteria {
                eq("status","ACTIVE")
                }
            render(view: 'index',model:[selectLocationList:SelectLocations])
        }
        else
        { 
            println("selectLocation. cookie set "+request.getCookie(MyStayConstants.PROPERTY_ID) + " - "+params.editLocation)
            redirect(controller:"locationDetails")
        }
    }
}
