package mystayapp

class Visit {

    String firstName
    String lastName
    String roomNumber
    String chatType
    String checkInDate
    String checkOutDate
    String confirmationId
    String userId //guestId
    String emailAddress
    String hotelName
    String mobileNumber
    String rewardsProgramId
    String myChats = "0"
    String hasUserProf 
   // Boolean hasUserProf = false
  //  String status = null;
  //  String locale = null;
  //  String latLng = null;
  //  String browserAgent = null;
  //  String referrer = null;
  //  String clientIP = null;
  //  Date initialVisitDate = null;
    
    static constraints = {
    // userId //guestId
    // guestId(blank: false)
     firstName(blank: false, size: 1..30, nullable:false)
     lastName(blank: false, size: 1..30, nullable:false)
     roomNumber(blank: false, size: 1..30, nullable:false)
     checkInDate(blank: true, nullable:true)
     checkOutDate(blank: true, nullable:true)
     hasUserProf(blank: true, nullable:true)
     chatType(blank: true, nullable:true)
     confirmationId(blank: true, nullable:true)
     myChats(blank: true, nullable:true)
     emailAddress(email:true,blank: true, nullable:true)
     mobileNumber(size:10..20,blank: true, nullable:true)
     rewardsProgramId(blank:true, nullable:true)
    // status(blank: false, inList: ["ACTIVE","INACTIVE"] )
    // locale(display: false)
    // latLng(display: false)
    // browserAgent(display: false)
    // referrer(display: false)
    // clientIP(display: false)
    // initialVisitDate(display: false)
    }
    
    static belongsTo = [property:Property ] //,guest:Guest]
}
