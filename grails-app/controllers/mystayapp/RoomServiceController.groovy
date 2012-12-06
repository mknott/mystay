package mystayapp

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.utility.*;

class RoomServiceController {

    def index() {
        println("rs index params: "+params)

        def menuList = Menu.withCriteria {
            createAlias("module","m")
            eq("m.id", params.module_id.toLong() )
            order("name")
        }
println("render room service")
        render(view: 'index',model: [ params: params, Menu: menuList ])
    }
    
         
    def menuItemInfo() {
        System.out.println("RoomServiceController.."+params.module_id);
        def menuItemId = params.menu_item_id;
        System.out.println("RoomServiceController.menuItemId.."+menuItemId);
        def menuItemResult = MenuItem.findById(menuItemId.toInteger() );
        System.out.println("RoomService2.."+menuItemResult+ " "+params);

        render(view: 'menuItemInfo', model: [ params: params, menuItem: menuItemResult])
    }
}
