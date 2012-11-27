package mystayapp

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.utility.*;

class NewProfileController {

    static defaultAction = "index"
    
    def index() {
        println("newProfile index")        
        if (params.(MyStayConstants.PROPERTY_ID))
        {
            println("look up session")
            session["propertyId"] = params.propertyId
        }
        
        def propertyId = params.(MyStayConstants.PROPERTY_ID) ? params.(MyStayConstants.PROPERTY_ID) : session.getAttribute(MyStayConstants.PROPERTY_ID)
        println("index params.propertyId: "+ params.propertyId+ " session.propertyId: "+ session.getAttribute("propertyId"))

        if(!propertyId)
        {
            //start over
            println("send to selectLocation")      
            redirect(controller: "selectLocation", action:"index")
        }
        else
        { 
            println("newProfile index with propertyId, params.propertyId: "+ params.propertyId+ " session.propertyId: "+ session.getAttribute("propertyId"))
            def propertyResult = new Property();
            propertyResult = Property.findById(propertyId.toInteger() );
            def hotelName = propertyResult.hotelName.toString();
            println("hotelName retrieve "+hotelName)
            
            def visitId = session.getAttribute(MyStayConstants.VISIT_ID) ? session.getAttribute(MyStayConstants.VISIT_ID) : params.(MyStayConstants.VISIT_ID)
            println("index params.visitId: "+ params.visitId+ " session.visitId: "+ session.getAttribute("visitId"))
            def visit = new Visit()
            if (visitId)
            {
                visit = Visit.findById(visitId)
            }
            println("params.visitId: "+ params.visitId+ " session.visitId: "+ session.getAttribute("visitId"))
            visit.hotelName = hotelName
            
            render(view: 'tellus',model: [visit: visit, params: params] ) 
        }
    }       
    

    def dataSource

    
    def tellus()
    {
        println("in tellus "+params.(MyStayConstants.PROPERTY_ID)+" - "+session.getAttribute("propertyID")+" - "+request.getCookie("propertyId"))  
        def propertyId = params.(MyStayConstants.PROPERTY_ID) ? params.(MyStayConstants.PROPERTY_ID) : (session.getAttribute(MyStayConstants.PROPERTY_ID)? session.getAttribute(MyStayConstants.PROPERTY_ID):request.getCookie("propertyId"))
        if (!propertyId)
        {   //start over
            println("no prop2-bef"+request.getCookie("propertyId"))      
            redirect(controller: "selectLocation", action:"index")
        }
        else 
        {
            if (!session.getAttribute("propertyId"))
            {
                session["propertyId"] = propertyId
                println("in tellus set session propertyId")  
            }

            def visitId = session.getAttribute(MyStayConstants.VISIT_ID) ? session.getAttribute(MyStayConstants.VISIT_ID) : params.(MyStayConstants.VISIT_ID) 
            if (visitId)
            {
                println("params.visitId: "+ params.visitId+ " session.visitId: "+ session.getAttribute("visitId"))
                if (!session.getAttribute("propertyId"))
                {
                    session["visitId"] = visitId
                    println("in tellus set session visitId")  
                }
//                def visit = Visit.findById(visitId)
                //visitId already exists in session - update (or send to locationDetails)
                println("update-bef "+visitId)
                redirect(action:"updateVisit", params: params)
            }    
            else
            { 
                //create new visit
//                def propertyResult = new Property();
//                propertyResult = Property.findById(propertyId.toInteger() );
//                def hotelName = propertyResult.hotelName.toString();
//                println("hotelName retrieve "+hotelName)
//                
//                def visit = new Visit()
//                visit.hotelName = hotelName
                println("all new1 "+params.visitId + " - "+params.propertyId)
                redirect(action:"createVisit", params: params)
            }
//                render(view: 'tellus',model: [visit: visit, params: params] )   
        }
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
        visit.myChats = 0;
        visit.emailAddress = params.(MyStayConstants.EMAIL_ADDRESS);
        visit.mobileNumber = params.(MyStayConstants.MOBILE_NUMBER);
        visit.rewardsProgramId = params.(MyStayConstants.REWARDS_PROGRAM_ID);        

        int time = 0;
        time = 1 * 60 * 60 * 24;

        println("3propId: "+propertyId)

        def propId = new Cookie(MyStayConstants.PROPERTY_ID, propertyId);
        propId.maxAge = time;
        propId.setPath("/");
        response.addCookie(propId);

        def firstN = new Cookie(MyStayConstants.FIRST_NAME, visit.firstName);
        firstN.maxAge = time;
        firstN.setPath("/");
        response.addCookie(firstN);

        def lastN = new Cookie(MyStayConstants.LAST_NAME, visit.lastName);
        lastN.maxAge = time;
        lastN.setPath("/");
        response.addCookie(lastN);

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
        
        def chats = new Cookie(MyStayConstants.MY_CHATS, visit.myChats);
        chats.maxAge = time;
        chats.setPath("/");
        response.addCookie(chats);

        def email = new Cookie(MyStayConstants.EMAIL_ADDRESS, visit.emailAddress);
        email.maxAge = time;
        email.setPath("/");
        response.addCookie(email);

        def mobile = new Cookie(MyStayConstants.MOBILE_NUMBER, visit.mobileNumber);
        mobile.maxAge = time;
        mobile.setPath("/");
        response.addCookie(mobile);

        def reward = new Cookie(MyStayConstants.REWARDS_PROGRAM_ID, visit.rewardsProgramId);
        reward.maxAge = time;
        reward.setPath("/");
        response.addCookie(reward);

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
        println("new visitid:" + visitId)
        visitId.maxAge = time;
        visitId.setPath("/");
        if (visit.id.toString())
        {
            response.addCookie(visitId);
            session["visitId"] = visit.id
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
        println("2after 2nd save visitId: "+ visit.id + " new userId:- " + useridStr)

        if( (params.isCrtUserProf) && (params.isCrtUserProf = "Y"))
        {
            println("create new userProfile")
            def userProfile = new UserProfile();
            userProfile.firstName = params.(MyStayConstants.FIRST_NAME);
            userProfile.lastName = params.(MyStayConstants.LAST_NAME);
            userProfile.emailAddress = params.(MyStayConstants.EMAIL_ADDRESS);
            userProfile.mobileNumber = params.(MyStayConstants.MOBILE_NUMBER);
            //userProfile.userId = params.userId;
          
            println("redirect to newProfile")
         //   redirect(controller:"newProfile", action:"createProfile", )
            render(view: 'createProfile',model: [visit: visit, params: params, userProfile: userProfile] ) 
        }else{
            params.isCrtUserProf = "N";
            
            println("6 Done with create visit")
            redirect(controller:"locationDetails", action:"index")
        }
     }
    
    
    
    def updateVisit() {
        println("19")
        
        def propertyId = params.(MyStayConstants.PROPERTY_ID) ? params.(MyStayConstants.PROPERTY_ID) : session.getAttribute(MyStayConstants.PROPERTY_ID)
        if(!propertyId)
        {
            redirect(controller:"selectLocation")
        }
    
        def visitId = session.getAttribute(MyStayConstants.VISIT_ID) ? session.getAttribute(MyStayConstants.VISIT_ID) : params.(MyStayConstants.VISIT_ID) 
        println("19-next "+propertyId+" "+visitId)
        def visit = Visit.findById(visitId)
        println("visit "+visit)
       // def visit = new Visit();
       // visit = Visit.find("from Visit as b where b.firstName=? and b.lastName=?",fName,lName);
        //visit.myChats = 0;
        //visit.emailAddress = getCookie(MyStayConstants.EMAIL_ADDRESS);
        //visit.mobileNumber = getCookie(MyStayConstants.MOBILE_NUMBER);
        //visit.rewardsProgramId = getCookie(MyStayConstants.REWARDS_PROGRAM_ID);        

        visit.firstName = params.(MyStayConstants.FIRST_NAME);
        println(visit.firstName)
        visit.lastName = params.(MyStayConstants.LAST_NAME);
        visit.confirmationId = params.(MyStayConstants.CONFIRMATION_ID);
        visit.roomNumber = params.(MyStayConstants.ROOM_NUMBER);
        visit.checkInDate = params.(MyStayConstants.CHECKINDATE);
        visit.checkOutDate = params.(MyStayConstants.CHECKOUTDATE);
        visit.hotelName = params.(MyStayConstants.HOTEL_NAME);
        visit.id = visitId; //params.(MyStayConstants.VISIT_ID);
        visit.myChats = 0;
        visit.emailAddress = params.(MyStayConstants.EMAIL_ADDRESS);
        visit.mobileNumber = params.(MyStayConstants.MOBILE_NUMBER);
        visit.rewardsProgramId = params.(MyStayConstants.REWARDS_PROGRAM_ID);        
        //visit.chatType = params.chatType;
        //visit.userId = request.getCookie(MyStayConstants.USER_ID);

        int time = 0;
        time = 1 * 60 * 60 * 24;

        def propId = new Cookie(MyStayConstants.PROPERTY_ID, propertyId);
        propId.maxAge = time;
        propId.setPath("/");
        response.addCookie(propId);

        def firstN = new Cookie(MyStayConstants.FIRST_NAME, visit.firstName);
        firstN.maxAge = time;
        firstN.setPath("/");
        response.addCookie(firstN);

        def lastN = new Cookie(MyStayConstants.LAST_NAME, visit.lastName);
        lastN.maxAge = time;
        lastN.setPath("/");
        response.addCookie(lastN);

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

        def chats = new Cookie(MyStayConstants.MY_CHATS, visit.myChats);
        chats.maxAge = time;
        chats.setPath("/");
        response.addCookie(chats);

        def email = new Cookie(MyStayConstants.EMAIL_ADDRESS, visit.emailAddress);
        email.maxAge = time;
        email.setPath("/");
        response.addCookie(email);

        def mobile = new Cookie(MyStayConstants.MOBILE_NUMBER, visit.mobileNumber);
        mobile.maxAge = time;
        mobile.setPath("/");
        response.addCookie(mobile);

        def reward = new Cookie(MyStayConstants.REWARDS_PROGRAM_ID, visit.rewardsProgramId);
        reward.maxAge = time;
        reward.setPath("/");
        response.addCookie(reward);
        
        println("1before save"+visit.id)

        //        def widgetInstance = Widget.findByName('firstWidget') ?: new Widget(name: 'firstWidget').save(failOnError: true)
        def property = Property.findById(propertyId.toInteger() )
        property.addToVisits(visit)
        property.save(flush:true)
        visit.save(flush: true)

        if (!visit.save()) {
            visit.errors.each {
            println it
            }
        }
        println("1after save")
        if( (params.isCrtUserProf) && (params.isCrtUserProf = "Y"))
        {
            println("create new userProfile")
            def userProfile = new UserProfile();
            userProfile.firstName = params.(MyStayConstants.FIRST_NAME);
            userProfile.lastName = params.(MyStayConstants.LAST_NAME);
            userProfile.emailAddress = params.(MyStayConstants.EMAIL_ADDRESS);
            userProfile.mobileNumber = params.(MyStayConstants.MOBILE_NUMBER);
            //userProfile.userId = params.userId;
          
            println("redirect to new profile")
//            redirect(controller:"newProfile", action:"index")
            render(view: 'createProfile',model: [visit: visit, params: params, userProfile: userProfile] ) 
             
        }else{
            println("12-locationDetails")
            params.isCrtUserProf = "N";
            redirect(controller:"locationDetails", action:"index")
            } 
     }


    def createProfile()
    {
            println("Create a new User Profile"+params);
       
            def userProfile = new UserProfile()
            userProfile.firstName = params.(MyStayConstants.FIRST_NAME);
            userProfile.lastName = params.(MyStayConstants.LAST_NAME);
            userProfile.emailAddress = params.(MyStayConstants.EMAIL_ADDRESS);
            userProfile.mobileNumber = params.(MyStayConstants.MOBILE_NUMBER);
            userProfile.password = params.(MyStayConstants.PASSWORD);

            userProfile.save(flush: true)

            if (!userProfile.save()) {
                userProfile.errors.each {
                println it
                }
            }
        
            println("Name: " + userProfile.firstName);
            println("Email: " + userProfile.emailAddress);
            flash.message = message(code: 'default.mtstay.message', args: [userProfile.firstName])
            println("MSG: " + flash.message);

            int time = 0;
            time = 1 * 60 * 60 * 24;

            def email = new Cookie(MyStayConstants.EMAIL_ADDRESS, userProfile.emailAddress);
            email.maxAge = time;
            email.setPath("/");
            response.addCookie(email);
        
            def mobile = new Cookie(MyStayConstants.MOBILE_NUMBER, userProfile.mobileNumber);
            mobile.maxAge = time;
            mobile.setPath("/");
            response.addCookie(mobile);
     
            //render(view: 'tellus',model: [guestInstance: guestInstance])
            redirect(controller:"locationDetails", action:"home")
    }

}

        ///======================================================
        //Sql sql = new Sql(dataSource)
        //sql.eachRow("select u.name,u.email,u.username from ofuser u where u.username='palash'", { row ->
            //println "Found: " << row.name
                //})
        ///======================================================