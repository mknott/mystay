package mystayapp

class Menu {
    String name //title
    String caption //one liner
    String message //detailed
    String params
    String image_src
    
//    String module_id
//    String property_id
    
    static belongsTo = [property:Property, module:Module]
    static hasMany = [menuItem:MenuItem]

    static constraints = {
        name blank: false, nullable: false
        caption blank: true, nullable: true
        message blank: true, nullable: true
        params blank: true, nullable: true
        image_src blank: true, nullable: true
    }
}
