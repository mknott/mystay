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
    
    static constraints = {
     hotelName blank: false, unique:true, size:5..30, nullable: true
     chain blank: false, size:5..30, nullable: true
     subChain size:5..30, nullable: true
     location size:5..30, nullable: true
     latLng size:5..15, nullable: true
     status blank: false, inList: ["ACTIVE","INACTIVE"], nullable: true
     activeDate blank: false, nullable: true
     inactiveDate blank: true, nullable: true
    }
    
    //static hasMany = [visit:Visit]
    static hasMany = [modules:Module,visits:Visit,adminUsers:AdminUser]
}
