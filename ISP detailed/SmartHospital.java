interface Treatable {
    void treatPatient(String patientName);
}
interface Monitorable {
    void monitorVitals(String patientName);
}
interface Billable {
    void generateBill(String patientName);
}
interface Prescribable {
    void prescribeMedicine(String patientName);
}
class doctor implements Treatable, Prescribable {
    public void treatPatient(String patientName) {
        System.out.println("Doctor" + patientName);
    }

    public void prescribeMedicine(String patientName) {
        System.out.println("Doctor medicine" + patientName);
    }
}
// Nurse
class nurse implements Monitorable {
    public void monitorVitals(String patientName) {
        System.out.println("Nurse monitoring" + patientName);
    }
}
// Billing
class billingdepartment implements Billable {
    public void generateBill(String patientName) {
        System.out.println("Generating bill" + patientName);
    }
}
public class SmartHospital {
    public static void main(String[] args) {
        Treatable doctor1 = new doctor();
        Prescribable prescriber1 = new doctor();
        Monitorable nurse1 = new nurse();
        Billable billing1 = new billingdepartment();

        doctor1.treatPatient("RAKESH");
        prescriber1.prescribeMedicine("RAKESH");
        nurse1.monitorVitals("RAKESH");
        billing1.generateBill("RAKESH");
    }
}
