package mystayapp

class UserProfile {

    String firstName
    String lastName
    String emailAddress
    String password  
    String address1
    String address2
    String city
    String state
    String country
    String postalCode
    String mobileNumber
    
    static constraints = {
        firstName(blank: false, size: 1..30)
        lastName(blank: false, size: 1..30)
        emailAddress(email:true,blank: true,nullable: true)
        mobileNumber(size:10..20,blank: true,nullable: true)  
        password(blank: true,nullable: true)
        address1(blank: true,nullable: true)
        address2(blank: true,nullable: true)
        city(blank: true,nullable: true)
        state(blank: true,nullable: true)
        country(blank: true,nullable: true)
        postalCode(blank: true,nullable: true)
    }
}
