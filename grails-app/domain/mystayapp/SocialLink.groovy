package mystayapp

class SocialLink {

    //Integer guestId
    String name
    String type
    String loginId
    String password
    
    static constraints = {
    // guestId
     name(blank: false, size:5..30)
     type(blank: false, size:3..30)
     loginId(blank: false, size:5..30)
     password(password:true)
    }
    
    static belongsTo = [guest:Guest]
}