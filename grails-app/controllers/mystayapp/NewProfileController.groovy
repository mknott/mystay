package mystayapp

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.utility.*;

class NewProfileController {

    static defaultAction = "index"
    
    def index() {
        println("newProfile")
        
        def propertyId = params.(MyStayConstants.PROPERTY_ID) ? params.(MyStayConstants.PROPERTY_ID) : request.getCookie(MyStayConstants.PROPERTY_ID)

        //if cookies are set and match previous id and hotel, then update visit
        if (!propertyId)
        { 
            println("no propertyId bef")
            redirect(controller:"selectLocation", permanent:"true")
            println("no propertyId aft")
        }
        //check for new visit
        //visit cookie set but doesn't match, then create new visit 
        else if (request.getCookie(MyStayConstants.VISIT_ID))
            {
            println("update "+request.getCookie(MyStayConstants.VISIT_ID))
            redirect(action:"updateVisit")
            }    
        //cookies not set then create new
        else
        { 
            println("all new1 "+params.visitId + " - "+params.propertyId)
            redirect(action:"createVisit", params: params)
        }
     }
    
    
    def createProfile()
    {
       
            def guestInstance = new UserProfile(params)
            guestInstance.save(flush: true)
            println("Name: " + guestInstance.firstName);
            flash.message = message(code: 'default.mtstay.message', args: [guestInstance.firstName])
            println("MSG: " + flash.message);

            //render(view: 'tell-us',model: [guestInstance: guestInstance])

            redirect(controller:"locationDetails", action:"home")
    }

    def dataSource

    
    def tellus()
    {
        //if(request.getCookie(MyStayConstants.FIRST_NAME)!=null && request.getCookie(MyStayConstants.LAST_NAME)!=null){
          //  def fName = request.getCookie(MyStayConstants.FIRST_NAME);
           // def lName = request.getCookie(MyStayConstants.LAST_NAME);
            //println(fName + " " +lName);
            
            
            //def visit = new Visit();
            //visit = Visit.find("from Visit as b where b.firstName=? and b.lastName=?",fName,lName);
            //disabling redirect
            //if(visit!=null)
            //{
                //allow to redirect to home page
            //    redirect(controller:"locationDetails", action:"home")
            //}
            //else{
            //    render(view: 'tell-us')
            //} 
        //}
        //else{
        
        def propertyId = params.(MyStayConstants.PROPERTY_ID) ? params.(MyStayConstants.PROPERTY_ID) : request.getCookie(MyStayConstants.PROPERTY_ID)
println("prop "+propertyId)      
        
        if(!propertyId || propertyId == null)
        {
println("prop2 "+propertyId)      
            redirect(controller: "selectLocation", action:"index")
println("prop2aft "+propertyId)      
        }
        else
{println("prop2 "+propertyId)      
}       
 
        def hotelName = request.getCookie(MyStayConstants.HOTEL_NAME);
        if(( !hotelName || hotelName.isEmpty()) && propertyId != null) 
        {
            def propertyResult = new Property();
            propertyResult = Property.findById(propertyId.toInteger() );
            hotelName = propertyResult.hotelName.toString();
        }
           
        println("data: "+ propertyId + "|" + hotelName);

        //def visit = new Visit(params); 
        def visit = new Visit()
        visit.firstName = request.getCookie(MyStayConstants.FIRST_NAME); 
        visit.lastName = request.getCookie(MyStayConstants.LAST_NAME);
        visit.confirmationId = request.getCookie(MyStayConstants.CONFIRMATION_ID);
        visit.roomNumber = request.getCookie(MyStayConstants.ROOM_NUMBER);
        visit.checkInDate = request.getCookie(MyStayConstants.CHECKINDATE);
        visit.checkOutDate = request.getCookie(MyStayConstants.CHECKOUTDATE);
        visit.hotelName = hotelName;
        
        def property = Property.findById(propertyId.toInteger() );
        
        render(view: 'tell-us',model: [visit: visit, property: property] ) 
    }   
    
        //--------- create Visit ---------//
    // - no visitId present
    // - clear any cookies
    // - retrieve propertyId from params
    // - create new Visit model object
    // - set cookies
    // - save visit
    // - retrieve with cisit and create new userId 
    // - update visit with userId
    // - 
    //--------------------------------//
         
    def createVisit() {
        println("createVisit")
        response.deleteCookie(MyStayConstants.FIRST_NAME)
        response.deleteCookie(MyStayConstants.LAST_NAME)
        response.deleteCookie(MyStayConstants.CONFIRMATION_ID)
        response.deleteCookie(MyStayConstants.ROOM_NUMBER)
        response.deleteCookie(MyStayConstants.CHECKINDATE)
        response.deleteCookie(MyStayConstants.CHECKOUTDATE)
        response.deleteCookie(MyStayConstants.HOTEL_NAME)
        response.deleteCookie(MyStayConstants.VISIT_ID)
    
        def propertyId = params.(MyStayConstants.PROPERTY_ID);
                
        def visit = new Visit();
        visit.firstName = params.(MyStayConstants.FIRST_NAME);
        visit.lastName = params.(MyStayConstants.LAST_NAME);
        visit.confirmationId = params.(MyStayConstants.CONFIRMATION_ID);
        visit.roomNumber = params.(MyStayConstants.ROOM_NUMBER);
        visit.checkInDate = params.(MyStayConstants.CHECKINDATE);
        visit.checkOutDate = params.(MyStayConstants.CHECKOUTDATE);
        visit.hotelName = params.(MyStayConstants.HOTEL_NAME);
        visit.id = params.(MyStayConstants.VISIT_ID);
        visit.chatType = params.chatType;
        visit.userId = params.userId;
        //visit.myChats = 0;
        //visit.emailAddress = params.(MyStayConstants.EMAIL_ADDRESS);
        //visit.mobileNumber = params.(MyStayConstants.MOBILE_NUMBER);
        //visit.rewardsProgramId = params.(MyStayConstants.REWARDS_PROGRAM_ID);        

        println("3 ")

        int time = 0;
        time = 1 * 60 * 60 * 24;

        def propId = new Cookie(MyStayConstants.PROPERTY_ID, propertyId);
        propId.maxAge = time;
        propId.setPath("/");
        response.addCookie(propId);
        println("propId: "+propertyId)

        def firstN = new Cookie(MyStayConstants.FIRST_NAME, visit.firstName);
        firstN.maxAge = time;
        firstN.setPath("/");
        response.addCookie(firstN);
        println("firstN: "+visit.firstName)

        def lastN = new Cookie(MyStayConstants.LAST_NAME, visit.lastName);
        lastN.maxAge = time;
        lastN.setPath("/");
        response.addCookie(lastN);
        println("lastN: "+visit.lastName)

        def roomN = new Cookie(MyStayConstants.ROOM_NUMBER, visit.roomNumber);
        roomN.maxAge = time;
        roomN.setPath("/");
        response.addCookie(roomN);

        def checkN = new Cookie(MyStayConstants.CHECKINDATE, visit.checkInDate);
        checkN.maxAge = time;
        checkN.setPath("/");
        response.addCookie(checkN);

        def checkOT = new Cookie(MyStayConstants.CHECKOUTDATE, visit.checkOutDate);
        checkOT.maxAge = time;
        checkOT.setPath("/");
        response.addCookie(checkOT);

        def confirmId = new Cookie(MyStayConstants.CONFIRMATION_ID, visit.confirmationId);
        confirmId.maxAge = time;
        confirmId.setPath("/");
        response.addCookie(confirmId);

        def hotelNm = new Cookie(MyStayConstants.HOTEL_NAME, visit.hotelName);
        hotelNm.maxAge = time;
        hotelNm.setPath("/");
        response.addCookie(hotelNm);
        println("hotelName "+ visit.hotelName)
        
//        def myChats = new Cookie(MyStayConstants.MY_CHATS, visit.myChats);
//        confirmationId.maxAge = time;
//        confirmationId.setPath("/");
//        response.addCookie(myChats);

        println("2before save")
        def property = Property.findById(propertyId.toInteger() )
            property.addToVisits(visit)
            property.save(flush:true)
        
            if (!visit.save()) {
                visit.errors.each {
                println it
                }
            }
        println("2after save" +visit.id)
        
        def visitId = new Cookie(MyStayConstants.VISIT_ID, visit.id.toString());
        println("visitid:" + visitId)
        visitId.maxAge = time;
        visitId.setPath("/");
        if (visit.id.toString())
        {
            response.addCookie(visitId);
        }
        
        String useridStr = "rm"+visit.roomNumber+"_"+visit.lastName+"_"+visit.id;
        def userId = new Cookie(MyStayConstants.USER_ID, useridStr);
        userId.maxAge = time;
        userId.setPath("/");
        response.addCookie(userId);

        visit.userId = useridStr;
        
        println("2before 2nd save: ")
        visit.save(flush: true)
            if (!visit.save()) {
                visit.errors.each {
                println it
                }
            }
        println("2after 2nd save visitId: "+ visit.id + " userId:- " + useridStr)

        if( (params.isCrtUserProf) && (params.isCrtUserProf = "Y"))
        {
            println("redirect to newProfile")
            redirect(controller:"newProfile", action:"index")
             
        }else{
            params.isCrtUserProf = "N";
            
            println("6 Done with create visit")
            redirect(controller:"locationDetails", action:"index" )
        }
     }
    
    def updateVisit() {
        println("19")
        
        def propertyId = params.(MyStayConstants.PROPERTY_ID) ? params.(MyStayConstants.PROPERTY_ID) : request.getCookie(MyStayConstants.PROPERTY_ID)
        if(!propertyId)
        {
            redirect(controller:"selectLocation")
        }
        
        def visit = new Visit();
//instead of cookies, retrieve from db        
        visit.firstName = getCookie(MyStayConstants.FIRST_NAME);
        visit.lastName = getCookie(MyStayConstants.LAST_NAME);
        visit.confirmationId = getCookie(MyStayConstants.CONFIRMATION_ID);
        visit.roomNumber = getCookie(MyStayConstants.ROOM_NUMBER);
        visit.checkInDate = getCookie(MyStayConstants.CHECKINDATE);
        visit.checkOutDate = getCookie(MyStayConstants.CHECKOUTDATE);
        visit.hotelName = getCookie(MyStayConstants.HOTEL_NAME);
        visit.id = getCookie(MyStayConstants.VISIT_ID).toLong();
        
        println("visitid: " + visit.id)
        visit.userId = getCookie(MyStayConstants.USER_ID);
        //visit.chatType = getCookie(MyStayConstants.CHAT_TYPE);
        //visit.myChats = 0;
        //visit.emailAddress = getCookie(MyStayConstants.EMAIL_ADDRESS);
        //visit.mobileNumber = getCookie(MyStayConstants.MOBILE_NUMBER);
        //visit.rewardsProgramId = getCookie(MyStayConstants.REWARDS_PROGRAM_ID);        

        println("13")

        int time = 0;
        time = 1 * 60 * 60 * 24;

        response.deleteCookie(MyStayConstants.PROPERTY_ID)
        def propId = new Cookie(MyStayConstants.PROPERTY_ID, propertyId);
        propId.maxAge = time;
        propId.setPath("/");
        response.addCookie(propId);
        println("propId: "+propertyId)

        response.deleteCookie(MyStayConstants.FIRST_NAME)
        def firstN = new Cookie(MyStayConstants.FIRST_NAME, visit.firstName);
        firstN.maxAge = time;
        firstN.setPath("/");
        response.addCookie(firstN);
        println("1firstN: "+visit.firstName)

        response.deleteCookie(MyStayConstants.LAST_NAME)
        def lastN = new Cookie(MyStayConstants.LAST_NAME, visit.lastName);
        lastN.maxAge = time;
        lastN.setPath("/");
        response.addCookie(lastN);
        println("1lastN: "+visit.lastName)

        response.deleteCookie(MyStayConstants.ROOM_NUMBER)
        def roomN = new Cookie(MyStayConstants.ROOM_NUMBER, visit.roomNumber);
        roomN.maxAge = time;
        roomN.setPath("/");
        response.addCookie(roomN);

        response.deleteCookie(MyStayConstants.CHECKINDATE)
        def checkN = new Cookie(MyStayConstants.CHECKINDATE, visit.checkInDate);
        checkN.maxAge = time;
        checkN.setPath("/");
        response.addCookie(checkN);

        response.deleteCookie(MyStayConstants.CHECKOUTDATE)
        def checkOT = new Cookie(MyStayConstants.CHECKOUTDATE, visit.checkOutDate);
        checkOT.maxAge = time;
        checkOT.setPath("/");
        response.addCookie(checkOT);

        response.deleteCookie(MyStayConstants.CONFIRMATION_ID)
        def confirmId = new Cookie(MyStayConstants.CONFIRMATION_ID, visit.confirmationId);
        confirmId.maxAge = time;
        confirmId.setPath("/");
        response.addCookie(confirmId);

        response.deleteCookie(MyStayConstants.HOTEL_NAME)
        def hotelNm = new Cookie(MyStayConstants.HOTEL_NAME, visit.hotelName);
        hotelNm.maxAge = time;
        hotelNm.setPath("/");
        response.addCookie(hotelNm);

        //response.deleteCookie(MyStayConstants.MY_CHATS)
        //def myChats = new Cookie(MyStayConstants.MY_CHATS, visit.myChats);
        //confirmationId.maxAge = time;
        //confirmationId.setPath("/");
        //response.addCookie(myChats);

        
        println("1before save")
        def property = Property.findById(propertyId.toInteger() )
        property.addToVisits(visit)
        property.save(flush:true)

        //visit.save(flush: true)

        if (!visit.save()) {
            visit.errors.each {
            println it
            }
        }
        println("1after save")
        
        if( (params.isCrtUserProf) && (params.isCrtUserProf = "Y"))
        {
            println("redirect to new profile")
            redirect(controller:"newProfile", action:"index")
             
        }else{
            println("12")
            params.isCrtUserProf = "N";
            
            println("12-locationDetails")
            redirect(controller:"locationDetails", action:"index")
            }     
        
     }

}

        ///======================================================
        //Sql sql = new Sql(dataSource)
        //sql.eachRow("select u.name,u.email,u.username from ofuser u where u.username='palash'", { row ->
            //println "Found: " << row.name
                //})
        ///======================================================