package mystayapp

class TempGuest {
    String j_name;
    String j_roomnumber;
    String j_email;
    String j_lstay;
    
    
    static constraints = {
        
         j_email(email:true)
         j_roomnumber(blank: false,size: 1..5)
         j_name(blank: false,size: 3..30)
         j_lstay(blank: true,size: 1..30)
   
    }
}
