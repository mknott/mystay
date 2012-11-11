package mystayapp

class Worker {

    //Integer propertyId
    String type
    String firstName
    String middleName
    String lastName
    String title
    String suffix
    String externalId
    String status
    Date activeDate
    Date inactiveDate
    String password
    String passwordHint
    String previousPasswords
    String passwordEnabled
    Date passwordDisabledDate
    Integer successiveFailedLogins
    String deviceId
    String deviceType
    String locale
    Boolean smsEnabled
    Boolean emailEnabled
    Boolean chatEnabled
    
    static constraints = {
    // propertyId
     type(size: 3..30)
     firstName(blank: false,size: 5..30)
     middleName(blank: true,size: 1..30)
     lastName(blank: false,size: 5..30)
     title(size: 2..10)
     suffix(size: 2..10)
     externalId(size: 3..30)
     status(blank: false, inList: ["ACTIVE","INACTIVE"] )
    // activeDate(blank: false)
    // inactiveDate(blank: false)
     password(password:true)
     passwordHint(size: 1..30) 
    // previousPasswords(display: false)
    // passwordEnabled(display: false, inList: ["Y","N"] )
    // passwordDisabledDate(display: false)
     successiveFailedLogins(min:0)
     deviceId(blank: true,size: 1..10)
     deviceType(blank: true,size: 1..10)
     locale(blank: true,size: 1..10)
     smsEnabled(blank: true,inList: ["Y","N"] )
     emailEnabled(blank: true,inList: ["Y","N"] )
     chatEnabled(blank: true,inList: ["Y","N"] )
     }
    
    static belongsTo = [property:Property]
}
