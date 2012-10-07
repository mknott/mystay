package mystayapp

class UserProfile {

    String firstName
    String lastName
    String emailAddress
    String confirmEmailAddress    
    String password
    String confirmPassword    
    String address1
    String address2
    String city
    String state
    String country
    String postalCode
    String mobileNo
    
    static constraints = {
        firstName blank: false
        lastName blank: false
        emailAddress blank: false, unique: true
        confirmEmailAddress blank: false
        address1 blank: false
        address2 blank: true
        city blank: false
        state blank: false
        country blank: false
        postalCode blank: false
        mobileNo blank: false        
    }
    
}
