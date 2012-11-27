package mystayapp

class Module {

    String action
    String caption
    String controller
    String description
    String imageSrc
    String type
    String status
    Date activeDate
    Date inactiveDate 
    String deviceId
    String deviceType
    Boolean smsEnabled
    Boolean emailEnabled
    Boolean chatEnabled
    String message
    String name
    Integer displayOrder

    
    static constraints = {
        action blank: true, nullable: true
        caption blank: true, nullable: false
        controller blank: true, nullable: true
        description blank: true,size: 0..255,nullable: true
        imageSrc blank: true, nullable: true
        type size: 3..30,nullable: true
        status blank: false, inList: ["ACTIVE","INACTIVE"],nullable: true
        activeDate blank: true, nullable: true
        inactiveDate blank: true, nullable: true
        deviceId blank: true,size: 1..10,nullable: true
        deviceType blank: true,size: 1..10,nullable: true
        smsEnabled blank: true,inList: ["Y","N"],nullable: true
        emailEnabled blank: true,inList: ["Y","N"],nullable: true
        chatEnabled blank: true,inList: ["Y","N"],nullable: true
        message blank: true, nullable: true
        name blank: true, nullable: true

    }
    
    static belongsTo = [property:Property]
}
