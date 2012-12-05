package mystayapp

import javax.servlet.http.Cookie;
import com.utility.*;

class PageIncludeController {

    def headinclude()
    {
        println("headinclude...")
        render(view: 'head')
    }
    
    
    def headerinclude()
    {
        println("headerinclude...")
        def visit = new Visit(); 
        render(view: 'header')
    }
    
    def footerinclude()
    {
        println("footerinclude...")
        render(view: 'footer')
    }
}
