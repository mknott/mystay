package mystayapp

class AdminUser {

    String userName
    String password
    String servicetype
    /*static constraints = {
    }*/
    static belongsTo = [property:Property ]
    
}
