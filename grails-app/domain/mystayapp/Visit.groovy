package mystayapp

class Visit {

    //Integer propertyId
    //Boolean isCrtUserProf = false
    String firstName
    String lastName
    String roomNumber
    String chatType
    String checkInDate
    String checkOutDate
    String confirmationId
    String hotelName
    String myChats = "0"
    String userId //guestId
  //  String rewardsProgramId
 //   String emailAddress
 //   String mobileNumber
  //  String status = null;
  //  String locale = null;
  //  String latLng = null;
  //  String browserAgent = null;
  //  String referrer = null;
  //  String clientIP = null;
  //  Date initialVisitDate = null;
    
    static constraints = {
//     propertyId(blank: false)
    // guestId(blank: false)
     roomNumber(blank: false, size: 1..30)
     checkInDate(blank: true)
     checkOutDate(blank: true)
     firstName(blank: false, size: 1..30)
     lastName(blank: false, size: 1..30)
    // isCrtUserProf(blank: true)
     chatType(blank: true)
     confirmationId(blank: true)
     myChats(blank: true)
    // userId //guestId
    // emailAddress(email:true)
    // phoneCountryCode(size: 1..3)
    // phoneNumber(size: 10..20)
    // status(blank: false, inList: ["ACTIVE","INACTIVE"] )
    // locale(display: false)
    // latLng(display: false)
    // browserAgent(display: false)
    // referrer(display: false)
    // clientIP(display: false)
    // initialVisitDate(display: false)
    // isCrtUserProf blank: true
    }
    
    static belongsTo = [property:Property ] //,guest:Guest]
}
