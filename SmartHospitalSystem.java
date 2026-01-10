// SRP + ISP
interface PatientRepository {
    void save(String patientName);
}

interface NotificationService {
    void notifyPatient(String message);
}

//OCP + LSP 
class DatabasePatientRepository implements PatientRepository {
    public void save(String patientName) {
        System.out.println("Patient saved to DB: " + patientName);
    }
}

class EmailNotification implements NotificationService {
    public void notifyPatient(String message) {
        System.out.println("Email sent: " + message);
    }
}

//  DIP 
class HospitalService {
    private PatientRepository repository;
    private NotificationService notifier;

    public HospitalService(PatientRepository repository,
                           NotificationService notifier) {
        this.repository = repository;
        this.notifier = notifier;
    }

    public void registerPatient(String name) {
        repository.save(name);
        notifier.notifyPatient("Welcome " + name);
    }
}
public class SmartHospitalSystem {
    public static void main(String[] args) {
        HospitalService service =
            new HospitalService(
                new DatabasePatientRepository(),
                new EmailNotification()
            );

        service.registerPatient("Rakesh");
    }
}
