// abstractions
interface patientrepository {
    void savepatient(String name);
}
interface notificationservice {
    void notifypatient(String message);
}
interface billingservice {
    void generatebill(String patientname, double amount);
}

// low level implementations
class mysqlpatientrepository implements patientrepository {
    public void savepatient(String name) {
        System.out.println("patient saved:"+name);
    }
}
class smsnotificationservice implements notificationservice {
    public void notifypatient(String message) {
        System.out.println("sms sent:"+message);
    }
}
class insurancebillingservice implements billingservice {
    public void generatebill(String patientname, double amount) {
        System.out.println("bill generated for"+patientname+": ₹" + amount);
    }
}

// high level business logic
class hospitalservice {
    private patientrepository patientrepo;
    private notificationservice notifier;
    private billingservice billing;

    public hospitalservice(patientrepository patientrepo,notificationservice notifier,billingservice billing){
        this.patientrepo = patientrepo;
        this.notifier = notifier;
        this.billing = billing;
    }

    public void admitpatient(String name) {
        patientrepo.savepatient(name);
        notifier.notifypatient("welcome" + name);
        billing.generatebill(name, 5000);
    }
}
public class smarthospital{
    public static void main(String[] args) {
        hospitalservice service = new hospitalservice(new mysqlpatientrepository(),new smsnotificationservice(),new insurancebillingservice());

        service.admitpatient("rakesh");
    }
}
