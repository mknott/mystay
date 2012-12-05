package mystayapp

class MenuItem {
    Menu menu
    String name //title
    String caption //one liner
    String message //detailed
    String params
    String controller
    String action
    String image_src
    String price
    String menuType
    
//    static belongsTo = [menu:Menu]

    static constraints = {
        name blank: false, nullable: false
        caption blank: true, nullable: true
        message blank: true, nullable: true
        params blank: true, nullable: true
        controller blank: true, nullable: true
        action blank: true, nullable: true
        image_src blank: true, nullable: true
        price blank: false, nullable: false
        menuType blank: true, nullable: true
    }
}
