package mystayapp

class MenuItem {

    String menuType
    String message
    String name
    String params
    String pendingMsg    
    String price
//    String moduleId
//    String propertyId
    
    static belongsTo = [property:Property, module:Module]

    static constraints = {
        menuType blank: true, nullable: true
        message blank: true, nullable: true
        name blank: true, nullable: true
        params blank: true, nullable: true
        pendingMsg blank: true, nullable: true
        price blank: true, nullable: true
    }
}
