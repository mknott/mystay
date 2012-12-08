package mystayapp

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.utility.*;

class LocationDetailsController {

     def index() {
        System.out.println("locationDetails.reached here loc"+params);
        
        println("locationDetails.visitId cookie: "+request.getCookie(MyStayConstants.VISIT_ID))        

        //if cookies are set and match previous id and hotel, then update visit
        if (!params.propertyId && !request.getCookie(MyStayConstants.PROPERTY_ID)) 
        { 
            println("locationDetails.all new loc "+params.visitId+" - "+params.propertyId)
            redirect(controller:"selectLocation")
        }
            
        //check for new visit
        //visit cookie set but doesn't match, then create new visit 
        if (!request.getCookie(MyStayConstants.VISIT_ID))
            { 
                println("locationDetails. haspropertyId but no visitId "+params)
                redirect(controller:"newProfile", action:"createVisit", params: params)
            }
        println("locationDetails.before all loc2b ")

        def propertyId = request.getCookie(MyStayConstants.PROPERTY_ID)
        def visitId =  request.getCookie(MyStayConstants.VISIT_ID)
        println("locationDetails.all loc2b "+visitId + " - "+propertyId)

        def propertyResult = new Property();
        propertyResult = Property.findById(propertyId.toInteger() );
           
        println("locationDetails.propertid" + propertyId);
        
        def propertyImage = propertyResult.propertyImage.toString();
        def hotelName = propertyResult.hotelName.toString();
        
        def modules = Module.withCriteria {
            isNotNull("controller")
            eq("status","ACTIVE")
            createAlias("property","p")
            eq("p.id", propertyId.toLong() )
            order("displayOrder")
        } 
        
        render( view:"index", model:[moduleList:modules, property:propertyResult])

     }
 

     def home() {
        println("locationDetails.locationdetails.home")

        def propertyId = session.getAttribute("propertyId") //params.(MyStayConstants.PROPERTY_ID);
        println("locationDetails.prop: "+propertyId)
        
        //def propertyResult = new Property();
        def propertyResult = Property.findById(propertyId.toInteger() );
           
        println("locationDetails.propertyid" + propertyId);
        
        def propertyImage = propertyResult.propertyImage.toString();
        def hotelName = propertyResult.hotelName.toString();

        def modules = Module.withCriteria {
            isNotNull("controller")
            eq("status","ACTIVE")
            createAlias("property","p")
            eq("p.id", propertyId.toLong() )
            order("displayOrder","asc")
        }

        render(view: 'index',model:[moduleList:modules, property:propertyResult])
     }
     
     def propertyInfo() {
        System.out.println("LocationDetailsController..");
        def propertyId = request.getCookie(MyStayConstants.PROPERTY_ID);
        def visitId = request.getCookie(MyStayConstants.VISIT_ID);
        
        def propertyResult = Property.findById(propertyId.toInteger() );
        render(view: 'propertyInfo', model: [propertyResult: propertyResult])
    }
}

        