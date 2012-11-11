package mystayapp

class WorkerAssign {

    String name
    String type
    //Integer propertyId
    //Integer moduleId
    //Integer workerId
    String status
    Date activeDate
    Date inactiveDate 
    String alert
    String alertFrequency
    String alertMethod
    Boolean admin
    String role
    
    static constraints = {
     name(blank: false,size: 5..30)
     type(size: 3..30)
    // propertyId
    // moduleId
    // workerId
     status(blank: false, inList: ["ACTIVE","INACTIVE"] )
    // activeDate(blank: false)
    // inactiveDate(blank: false)
     alert(blank: true,size: 1..10)
     alertFrequency(blank: true,size: 1..10)
     alertMethod(blank: true,size: 1..10)
     admin(blank: true,inList: ["Y","N"] )
     role(blank: true,size: 1..30)
    }
    
    static belongsTo = [guest:Guest]
}
