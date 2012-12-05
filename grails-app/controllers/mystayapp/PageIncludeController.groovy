package mystayapp

import javax.servlet.http.Cookie;
import com.utility.*;

class PageIncludeController {

    def headinclude()
    {
        render(view: 'head')
    }
    
    
    def headerinclude()
    {
        def visit = new Visit(); 
        render(view: 'header')
    }
    
    def footerinclude()
    {
        render(view: 'footer')
    }
}
