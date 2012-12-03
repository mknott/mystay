package mystayapp

class Property {

    String hotelName
    String chain
    String subChain
    String location
    String latLng
    String status
    Date activeDate
    Date inactiveDate
    String propertyImage
    String propertyBGColor
    String address1
    String address2
    String city
    String state
    String country
    String postalCode
    String phoneNumber
    String reservationsNumber
    String faxNumber
    String email
    
    static constraints = {
     hotelName blank: false, unique:true, size:5..30, nullable: true
     chain blank: false, size:5..30, nullable: true
     subChain size:5..30, nullable: true
     location size:5..30, nullable: true
     latLng size:5..15, nullable: true
     status blank: false, inList: ["ACTIVE","INACTIVE"], nullable: true
     activeDate blank: false, nullable: true
     inactiveDate blank: true, nullable: true
     propertyImage blank: true, nullable: true
     propertyBGColor blank: true, nullable: true
     address1 blank: true, nullable: true
     address2 blank: true, nullable: true
     city blank: true, nullable: true
     state blank: true, nullable: true
     country blank: true, nullable: true
     postalCode blank: true, nullable: true
     phoneNumber blank: true, nullable: true
     faxNumber blank: true, nullable: true
     reservationsNumber blank: true, nullable: true
     email blank: true, nullable: true
    }
    
    //static hasMany = [visit:Visit]
    static hasMany = [modules:Module,visits:Visit,adminUsers:AdminUser]
}
