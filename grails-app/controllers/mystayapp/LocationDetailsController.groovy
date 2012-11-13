package mystayapp

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.utility.*;

class LocationDetailsController {

     def index() {
        System.out.println("reached here loc"+params);
        
        println("visitId cookie: "+request.getCookie(MyStayConstants.VISIT_ID))        
        println("propertyId cookie: "+request.getCookie(MyStayConstants.PROPERTY_ID))

        //if cookies are set and match previous id and hotel, then update visit
        if (!params.propertyId && !request.getCookie(MyStayConstants.PROPERTY_ID)) 
        { 
            println("all new loc "+params.visitId+" - "+params.propertyId)
            redirect(controller:"selectLocation")
        }
            
        //check for new visit
        //visit cookie set but doesn't match, then create new visit 
        if (!request.getCookie(MyStayConstants.VISIT_ID))
            { 
                println("match loc1 - createNew")
                redirect(controller:"newProfile", action:"createVisit", params: params)
            }
        
        def propertyId = request.getCookie(MyStayConstants.PROPERTY_ID)
        def visitId =  request.getCookie(MyStayConstants.VISIT_ID)
        
        println("all loc2b "+visitId + " - "+propertyId)
        
        def modules = Module.withCriteria {
        isNotNull("controller")
        eq("status","ACTIVE")
        createAlias("property","p")
        eq("p.id", propertyId.toLong() )
        }
        
        render( view:"index", model:[menuItemLst:modules])

     }
 

     def home() {
        println("7")
        def propertyId = session.getAttribute("propertyId") //params.(MyStayConstants.PROPERTY_ID);
        
        def modules = Module.withCriteria {
            isNotNull("controller")
            eq("status","ACTIVE")
            createAlias("property","p")
            eq("p.id", propertyId.toLong() )
        }

        render(view: 'index',model:[menuItemLst:modules])
     }
}
