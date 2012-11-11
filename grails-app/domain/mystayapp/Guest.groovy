package mystayapp

class Guest {

    String email
    String type
    String firstName
    String middleName
    String lastName
    String title
    String suffix
    String gender
    Date dateOfBirth
    String status
    Date activeDate
    Date inactiveDate
    String password
    String passwordHint
    String previousPasswords
    Boolean passwordEnabled
    Date passwordDisabledDate
    Integer successiveFailedLogins
    String homeLocale
    String tsaRedress
    String passportCountry
    String passportNumber
    Date passportExpDate
    Boolean solicitation
    
    static constraints = {
     email(email:true)
     type(blank: false,size: 5..30)
     firstName(blank: false,size: 5..30)
     middleName(blank: true,size: 1..30)
     lastName(blank: false,size: 5..30)
     title(size: 2..10)
     suffix(size: 2..10)
     gender(blank: false, inList: ["MALE","FEMALE"] )
     dateOfBirth(blank: false, max: new Date())
     status(blank: false, inList: ["ACTIVE","INACTIVE"] )
    // activeDate(blank: false)
    // inactiveDate(blank: false)
     password(password:true)
     passwordHint(size: 1..30) 
    // previousPasswords(display: false)
    // passwordEnabled(display: false, inList: ["Y","N"] )
    // passwordDisabledDate(display: false)
     successiveFailedLogins(min:0)
    // homeLocale(display: false)
    // tsaRedress(display: false)
    // passportCountry(display: false)
    // passportNumber(display: false)
    // passportExpDate(display: false)
    // solicitation(display: false)
    }
    
 //   static hasMany = [visit:Visit,loyaltyProgram:LoyaltyProgram,socialLink:SocialLink,contactMech:ContactMech]
}

