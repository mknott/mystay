package mystayapp

class ContactMech {

    //Integer guestId
    String contactType
    String address1
    String address2
    String city
    String stateCode
    String postalCode
    String countryCode
    String phoneCountryCode
    String phoneNumber
    String deviceId
    String deviceType
    String locale
    Boolean smsAdEnabled
    Boolean emailAdEnabled
    
    static constraints = {
    // Integer guestId
     contactType(blank: false, inList: ["HOME","WORK"] )
     address1(blank: false,size: 5..30)
     address2(blank: true,size: 1..30)
     city(size: 3..30)
     stateCode(size: 5..30)
     postalCode(blank: false,size: 5..20)
     countryCode(blank: false,size: 1..3)
     phoneCountryCode(blank: false,size: 1..3)
     phoneNumber(blank: false,size: 10..20)
     deviceId(blank: true,size: 1..10)
     deviceType(blank: true,size: 1..10)
     locale(blank: true,size: 1..10)
     smsAdEnabled(blank: true,inList: ["Y","N"] )
     emailAdEnabled(blank: true,inList: ["Y","N"] )
    }
    
    static belongsTo = [guest:Guest]
}
