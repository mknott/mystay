package mystayapp

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.utility.*;

class NewProfileController {

    static defaultAction = "index"
    
    def index() {
        println("NewProfileController.index newProfile index")        
        if (params.(MyStayConstants.PROPERTY_ID))
        {
            println("NewProfileController.index look up propertyid for session: "+params.(MyStayConstants.PROPERTY_ID))
            session["propertyId"] = params.propertyId
        }

        println("NewProfileController.index params.propertyId: -" + params.(MyStayConstants.PROPERTY_ID) +"-")
        
        def propertyId = params.(MyStayConstants.PROPERTY_ID)? params.(MyStayConstants.PROPERTY_ID) : request.getCookie(MyStayConstants.PROPERTY_ID)
      //  println("index params.propertyId: "+ params.propertyId+ " session.propertyId: "+ session.getAttribute("propertyId"))
        println("NewProfileController.index calculated propertyId: " + propertyId)
        if(!propertyId)
        {
            //start over
            println("NewProfileController.index send to selectLocation")      
            
            def propId = new Cookie(MyStayConstants.PROPERTY_ID, propertyId);
            propId.maxAge = (0);
            propId.setPath("/");
            response.addCookie(propId);
            
            redirect(controller: "selectLocation", action:"index")
        }
        else
        { 
            println("NewProfileController.index find property with propertyId: "+propertyId)
            def propertyResult = new Property();
            propertyResult = Property.findById(propertyId.toInteger() );
            def hotelName = propertyResult.hotelName.toString();
            println("NewProfileController.hotelName retrieve "+hotelName)
            
            def visitId = session.getAttribute(MyStayConstants.VISIT_ID) ? session.getAttribute(MyStayConstants.VISIT_ID) : request.getCookie(MyStayConstants.VISIT_ID)
            println("NewProfileController.index params.visitId: "+ params.visitId+ " session.visitId: "+ request.getCookie(MyStayConstants.VISIT_ID))
            def visit = new Visit()
            if (visitId)
            {
                visit = Visit.findById(visitId) 
            }
            println("NewProfileController.index params.visitId: "+ params.visitId+ " cookie.visitId: "+ request.getCookie(MyStayConstants.VISIT_ID))
            visit.hotelName = hotelName
            
            render(view: 'tellus',model: [visit: visit, params: params] ) 
        }
    }       
    

    def dataSource
    
    //post from tellus.gsp
    def tellus()
    {
        println("NewProfileController.tellus-"+params.(MyStayConstants.PROPERTY_ID)+"-"+session.getAttribute("propertyID")+"-"+request.getCookie(MyStayConstants.PROPERTY_ID)+"-")  
        def propertyId = params.(MyStayConstants.PROPERTY_ID) ? params.(MyStayConstants.PROPERTY_ID) : session.getAttribute(MyStayConstants.PROPERTY_ID)? session.getAttribute(MyStayConstants.PROPERTY_ID):request.getCookie(MyStayConstants.PROPERTY_ID)
        println("NewProfileController.propertyId "+propertyId)
        if (!propertyId?.trim())
        {   //start over
            println("NewProfileController.tellus no property")      
            redirect(controller: "selectLocation", action:"index")
        }
        else 
        {
            println("NewProfileController.tellus with propertId: "+propertyId)
            def visitId = session.getAttribute(MyStayConstants.VISIT_ID) ? session.getAttribute(MyStayConstants.VISIT_ID) : params.(MyStayConstants.VISIT_ID) ? params.(MyStayConstants.VISIT_ID):request.getCookie(MyStayConstants.VISIT_ID)
            if (visitId)
            {
                println("NewProfileController.tellus params.visitId: "+ params.visitId+ " session.visitId: "+ session.getAttribute("visitId"))
                if (!session.getAttribute("propertyId"))
                {
                    session["visitId"] = visitId
                    println("NewProfileController.tellus set session visitId")  
                }
//                def visit = Visit.findById(visitId)
                //visitId already exists in session - update (or send to locationDetails)
                println("NewProfileController.tellus update-bef "+visitId) 
                params.(MyStayConstants.VISIT_ID) = visitId
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
                println("NewProfileController.tellus all new1 "+params.visitId + " - "+params.propertyId)
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
        println("NewProfileController.createVisit "+params)
 
        def propertyId = params.(MyStayConstants.PROPERTY_ID);
println ("NewProfileController.createVisit propertyId1: " + propertyId)                
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

        //visit.validate()
        //if (visit.hasErrors()) {
        //    visit.errors.each {
        //        println it
        //    }
            //return [ params: params]
            //render(view: 'tellus',model: [visit: visit, params: params] ) 
        //}
        
        int time = 0;
        time = 1 * 60 * 60 * 24;

        println("NewProfileController.createVisit propertyId2: "+propertyId)

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
/*
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
*/
        println("NewProfileController.createVisit before save")
        def property = Property.findById(propertyId.toInteger() )
            property.addToVisits(visit)
            property.save(flush:true)
        
            if (!visit.save()) {
                visit.errors.each {
                println it
                }
            }
        println("NewProfileController.createVisit after save" +visit.id)
        
        def visitId = new Cookie(MyStayConstants.VISIT_ID, visit.id.toString());
        println("NewProfileController.createVisit new visitid:" + visitId)
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

        //visit.validate()
        //if (visit.hasErrors()) {
        //    visit.errors.each {
        //        println it
        //    }
        //}
        
        println("NewProfileController.createVisit before 2nd save: ")
        visit.save(flush: true)
            if (!visit.save()) {
                visit.errors.each {
                println it
                }
            }
        println("NewProfileController.createVisit after 2nd save visitId: "+ visit.id + " new userId:- " + useridStr)

        if( (params.hasUserProf) && (params.hasUserProf = "Y"))
        {
            println("NewProfileController.createVisit new userProfile")
   //         def userProfile = new UserProfile();
    //        userProfile.firstName = params.(MyStayConstants.FIRST_NAME);
    //        userProfile.lastName = params.(MyStayConstants.LAST_NAME);
    //        userProfile.emailAddress = params.(MyStayConstants.EMAIL_ADDRESS);
    //        userProfile.mobileNumber = params.(MyStayConstants.MOBILE_NUMBER);
            //userProfile.userId = params.userId;
          
            println("NewProfileController.createVisit redirect to newProfile")
         //   redirect(controller:"newProfile", action:"createProfile", )
            render(view: 'createProfile',model: [visit: visit, params: params] ) 
        }else{
            params.hasUserProf = "N";
            
            println("NewProfileController.createVisit no userProfile")
            redirect(controller:"locationDetails", action:"index")
        }
     }
        
    def updateVisit() {
        println("NewProfileController.updateVisit")
        
        def propertyId = params.(MyStayConstants.PROPERTY_ID) ? params.(MyStayConstants.PROPERTY_ID) : session.getAttribute(MyStayConstants.PROPERTY_ID)? session.getAttribute(MyStayConstants.PROPERTY_ID):request.getCookie(MyStayConstants.PROPERTY_ID)
        if(!propertyId)
        {
            println("NewProfileController.updateVisit no propertyId")
            redirect(controller:"selectLocation")
        }
    
        def visitId = session.getAttribute(MyStayConstants.VISIT_ID) ? session.getAttribute(MyStayConstants.VISIT_ID) : params.(MyStayConstants.VISIT_ID) 
        println("NewProfileController.updateVisit next "+propertyId+" "+visitId)
        def visit = Visit.findById(visitId.toInteger() )
        
        visit.firstName = params.(MyStayConstants.FIRST_NAME);
        visit.lastName = params.(MyStayConstants.LAST_NAME);
        visit.confirmationId = params.(MyStayConstants.CONFIRMATION_ID);
        visit.roomNumber = params.(MyStayConstants.ROOM_NUMBER);
        visit.checkInDate = params.(MyStayConstants.CHECKINDATE);
        visit.checkOutDate = params.(MyStayConstants.CHECKOUTDATE);
        visit.hotelName = params.(MyStayConstants.HOTEL_NAME);
        visit.myChats = 0;
        visit.emailAddress = params.(MyStayConstants.EMAIL_ADDRESS);
        visit.mobileNumber = params.(MyStayConstants.MOBILE_NUMBER);
        visit.rewardsProgramId = params.(MyStayConstants.REWARDS_PROGRAM_ID);        
        //visit.chatType = params.chatType;

        //visit.validate()
        //if (visit.hasErrors()) {
        //    visit.errors.each {
        //        println it
        //    }
        //}
        
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

        def email = new Cookie(MyStayConstants.EMAIL_ADDRESS, visit.emailAddress);
        email.maxAge = time;
        email.setPath("/");
        response.addCookie(email);

        def mobile = new Cookie(MyStayConstants.MOBILE_NUMBER, visit.mobileNumber);
        mobile.maxAge = time;
        mobile.setPath("/");
        response.addCookie(mobile);
/*
        def chats = new Cookie(MyStayConstants.MY_CHATS, visit.myChats);
        chats.maxAge = time;
        chats.setPath("/");
        response.addCookie(chats);

        def reward = new Cookie(MyStayConstants.REWARDS_PROGRAM_ID, visit.rewardsProgramId);
        reward.maxAge = time;
        reward.setPath("/");
        response.addCookie(reward);
  */      

        //visit.validate()
        //if (visit.hasErrors()) {
        //    visit.errors.each {
        //        println it
        //    }
        //}

        println("NewProfileController.updateVisit before save"+visit.id)

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
        println("NewProfileController.updateVisit after save, hasUserProf " +params.hasUserProf)
        if( (params.hasUserProf) && (params.hasUserProf = "Y"))
        {
            println("NewProfileController.updateVisit hasUserProf: "+params.hasUserProf)
            def userProfileId = params.(MyStayConstants.USER_PROFILE_ID) ? params.(MyStayConstants.USER_PROFILE_ID) : request.getCookie(MyStayConstants.USER_PROFILE_ID)
            println("NewProfileController.updateVisit userProfileId: "+userProfileId)
  
            if (userProfileId)
            {
                println("NewProfileController.userProfile update lookup ")
                def userProfile = UserProfile.findById(userProfileId )
                render(view: 'updateProfile',model: [visit: visit, params: params, userProfile: userProfile] ) 
            }
            else
            {
                println("NewProfileController.userProfile create new")
                render(view: 'createProfile',model: [visit: visit, params: params] ) 
            }
        }else{
            println("NewProfileController.updateVisit no updateProfile")
            params.hasUserProf = "N";
            redirect(controller:"locationDetails", action:"index")
            } 
     }


    def createProfile()
    {
        println("NewProfileController.createProfile a new User Profile"+params);
        def userProfile = new UserProfile()
        userProfile.firstName = params.(MyStayConstants.FIRST_NAME);
        userProfile.lastName = params.(MyStayConstants.LAST_NAME);
        userProfile.emailAddress = params.(MyStayConstants.EMAIL_ADDRESS);
        userProfile.mobileNumber = params.(MyStayConstants.MOBILE_NUMBER);
        userProfile.address1 = params.address1;
        userProfile.address2 = params.address2;
        userProfile.city = params.city;
        userProfile.postalCode = params.postalCode;
        userProfile.state = params.state;
        userProfile.country = params.country;
        userProfile.password = params.(MyStayConstants.PASSWORD);

        //userProfile.validate()
        //if (userProfile.hasErrors()) {
        //    userProfile.errors.each {
        //        println it
        //    }
        //}

        userProfile.save(flush: true)
        if (!userProfile.save()) {
            userProfile.errors.each {
            println it }
        }

        flash.message = message(code: 'default.mystay.message', args: [userProfile.firstName])

        int time = 0;
        time = 1 * 60 * 60 * 24;

        def userProfId = new Cookie(MyStayConstants.USER_PROFILE_ID, userProfile.id.toString() );
        userProfId.maxAge = time;
        userProfId.setPath("/");
        response.addCookie(userProfId);

        def email = new Cookie(MyStayConstants.EMAIL_ADDRESS, userProfile.emailAddress);
        email.maxAge = time;
        email.setPath("/");
        response.addCookie(email);

        def mobile = new Cookie(MyStayConstants.MOBILE_NUMBER, userProfile.mobileNumber);
        mobile.maxAge = time;
        mobile.setPath("/");
        response.addCookie(mobile);

        redirect(controller:"locationDetails", action:"home")
    }

    def updateProfile()
    {
        println("NewProfileController.updateProfile User Profile");
        def userProfileId = session.getAttribute(MyStayConstants.USER_PROFILE_ID) ? session.getAttribute(MyStayConstants.USER_PROFILE_ID) : params.(MyStayConstants.USER_PROFILE_ID) 
        if(!userProfileId)
        {
            redirect(controller:"selectLocation")
        }
        println("NewProfileController.updateProfile for: "+userProfileId)

        def userProfile = UserProfile.findById(userProfileId.toInteger() )
        userProfile.firstName = params.(MyStayConstants.FIRST_NAME);
        userProfile.lastName = params.(MyStayConstants.LAST_NAME);
        userProfile.emailAddress = params.(MyStayConstants.EMAIL_ADDRESS);
        userProfile.mobileNumber = params.(MyStayConstants.MOBILE_NUMBER);
        userProfile.address1 = params.address1;
        userProfile.address2 = params.address2;
        userProfile.city = params.city;
        userProfile.postalCode = params.postalCode;
        userProfile.state = params.state;
        userProfile.country = params.country;
        userProfile.password = params.(MyStayConstants.PASSWORD);
 
        //userProfile.validate()
        //if (userProfile.hasErrors()) {
        //    userProfile.errors.each {
        //        println it
        //    }
        //}
        
        userProfile.save(flush: true)
        if (!userProfile.save()) {
            userProfile.errors.each {
            println it
            }
        }                               

        println("NewProfileController.updateProfile after save userProfileId: " + userProfile.id);
        flash.message = message(code: 'default.mtstay.message', args: [userProfile.firstName])

        int time = 0;
        time = 1 * 60 * 60 * 24;

        def userProfId = new Cookie(MyStayConstants.USER_PROFILE_ID, userProfile.id.toString() );
        userProfId.maxAge = time;
        userProfId.setPath("/");
        response.addCookie(userProfId);

        def email = new Cookie(MyStayConstants.EMAIL_ADDRESS, userProfile.emailAddress);
        email.maxAge = time;
        email.setPath("/");
        response.addCookie(email);

        def mobile = new Cookie(MyStayConstants.MOBILE_NUMBER, userProfile.mobileNumber);
        mobile.maxAge = time;
        mobile.setPath("/");
        response.addCookie(mobile);

        redirect(controller:"locationDetails", action:"home")
    }
}

        ///======================================================
        //Sql sql = new Sql(dataSource)
        //sql.eachRow("select u.name,u.email,u.username from ofuser u where u.username='palash'", { row ->
            //println "Found: " << row.name
                //})
        ///======================================================