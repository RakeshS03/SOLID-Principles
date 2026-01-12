public class SmartHospital {

    public static void main(String[] args) {

        PatientRepository repository = new PatientRepository();
        NotificationService notificationService = new NotificationService();
        HospitalLogger logger = new HospitalLogger();

        PatientService patientService =
                new PatientService(repository, notificationService, logger);

        patientService.registerPatient("RAKESH", "rakesh@gmail.com");
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

        System.out.println("PatientService:Patient registered");

        repository.save(patient);
        notificationService.sendNotification(patient);
        logger.log("Patient registered");
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
        System.out.println("PatientRepository: Saving patient record"+ patient.getEmail());
    }
}


   //COMMUNICATION RESPONSIBILITY
   
class NotificationService {

    public void sendNotification(Patient patient) {
        System.out.println("NotificationService: Appointment confirmation"+ patient.getEmail());
    }
}


   //LOGGING RESPONSIBILITY
  
class HospitalLogger {

    public void log(String message) {
        System.out.println("HospitalLogger:"+ message);
    }
}
