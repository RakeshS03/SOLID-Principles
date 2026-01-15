public class SRPGood {

    public static void main(String[] args) {

    
        UserRepository userRepository = new UserRepository();
        EmailService emailService = new EmailService();
        AuditLogger auditLogger = new AuditLogger();

        UserService userService =
                new UserService(userRepository, emailService, auditLogger);

    
        userService.registerUser("Rakesh", "rakesh@gmail.com");
    }
}


   //BUSINESS LOGIC RESPONSIBILITY
   
class UserService {

    private final UserRepository userRepository;
    private final EmailService emailService;
    private final AuditLogger auditLogger;

    public UserService(UserRepository userRepository,
                       EmailService emailService,
                       AuditLogger auditLogger) {

        this.userRepository = userRepository;
        this.emailService = emailService;
        this.auditLogger = auditLogger;
    }

    public void registerUser(String name, String email) {

        User user = new User(name, email);

        System.out.println("UserService: User created");

        userRepository.save(user);
        emailService.sendWelcomeMail(user);
        auditLogger.log("User registered: " + user.getEmail());
    }
}


   //DATA / DOMAIN RESPONSIBILITY
   
class User {

    private final String name;
    private final String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}


   //PERSISTENCE RESPONSIBILITY
  
class UserRepository {

    public void save(User user) {
        System.out.println("UserRepository: Saving user"+ user.getEmail());
    }
}


   //COMMUNICATION RESPONSIBILITY
   
class EmailService {

    public void sendWelcomeMail(User user) {
        System.out.println("EmailService: Sending welcome"+ user.getEmail());
    }
}


   //LOGGING / AUDIT RESPONSIBILITY
   
class AuditLogger {

    public void log(String message) {
        System.out.println("AuditLogger: " + message);
    }
}
