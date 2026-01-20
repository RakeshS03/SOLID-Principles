/* violated code
interface Notification {
    void sendEmail(String message);
    void sendSMS(String message);
    void sendPush(String message);
}
class EmailNotifier implements Notification {
    public void sendEmail(String message) {
        System.out.println("Email sent" + message);
    }

    public void sendSMS(String message) {
        // Not supported
    }

    public void sendPush(String message) {
        // Not supported
    }
} */

interface EmailNotification {
    void sendEmail(String message);
}

interface SMSNotification {
    void sendSMS(String message);
}

class EmailNotifier implements EmailNotification {
    public void sendEmail(String message) {
        System.out.println("Email sent: " + message);
    }
}
