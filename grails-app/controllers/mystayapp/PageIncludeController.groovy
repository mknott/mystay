package mystayapp

import javax.servlet.http.Cookie;
import com.utility.*;

class PageIncludeController {

    def headerinclude()
    {
        render(view: 'header')
    }
    
    
    def headerbar()
    {
        def visit = new Visit(); 
        render(view: 'headerbar')
    }
    
    def footerbar()
    {
        render(view: 'footerbar')
    }

    def footerinclude()
    {
        render(view: 'footer')
    }
}
