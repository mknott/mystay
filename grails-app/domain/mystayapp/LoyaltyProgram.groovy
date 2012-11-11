package mystayapp

class LoyaltyProgram {

    //Integer guestId
    String name
    String type
    String programId
    String level
    
    static constraints = {
    // guestId
     name(blank: false, size:5..30)
     type(blank: false, size:3..30)
     programId(blank: false, inList: ["AIRLINE","CAR","HOTEL"] )
     level(size:2..30)
    }
    
    static belongsTo = [guest:Guest]
}
