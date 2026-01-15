public class Smarthospital {

    public static void main(String[] args) {

        PatientRepository repository = new PatientRepository();
        HospitalLogger logger = new HospitalLogger();

        NotificationService emailNotification = new EmailNotification();
        NotificationService smsNotification = new SmsNotification();

        PatientService patientService =new PatientService(repository, emailNotification, logger);
        patientService.registerPatient("Rakesh", "rakesh@gmail.com");

        // Switching notification
        PatientService patientService2 =new PatientService(repository, smsNotification, logger);

        patientService2.registerPatient("Kumar", "kumar@gmail.com");
    }
}

   //BUSINESS RESPONSIBILITY
class PatientService {

    private final PatientRepository repository;
    private final NotificationService notificationService;
    private final HospitalLogger logger;

    public PatientService(PatientRepository repository,NotificationService notificationService,HospitalLogger logger) {
        this.repository = repository;
        this.notificationService = notificationService;
        this.logger = logger;
    }

    public void registerPatient(String name, String email) {

        Patient patient = new Patient(name, email);

        System.out.println("Patient registered");

        repository.save(patient);
        notificationService.notify(patient);
        logger.log("Patient registration completed");
    }
}

   //DOMAIN RESPONSIBILITY
class Patient {

    private final String name;
    private final String email;

    public Patient(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}

   //PERSISTENCE RESPONSIBILITY
class PatientRepository {

    public void save(Patient patient) {
        System.out.println("Saving patient "+ patient.getEmail());
    }
}

   //ABSTRACTION (OCP)
interface NotificationService {
    void notify(Patient patient);
}

   //EXTENSIONS (OCP)
class EmailNotification implements NotificationService {
    public void notify(Patient patient) {
        System.out.println("Email sent "+ patient.getEmail());
    }
}

class SmsNotification implements NotificationService {
    public void notify(Patient patient) {
        System.out.println("SMS sent to"+ patient.getEmail());
    }
}

   //LOGGING RESPONSIBILITY
class HospitalLogger {
public void log(String message) {
        System.out.println("HospitalLogger: " + message);
    }
}
