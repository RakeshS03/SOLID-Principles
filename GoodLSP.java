abstract class Notification {
    abstract void send(String message);
}

class EmailNotification extends Notification {
    void send(String message) {
        System.out.println("Email sent: " + message);
    }
}

class SmsNotification extends Notification {
    void send(String message) {
        System.out.println("SMS sent: " + message);
    }
}

public class GoodLSP {
    public static void notifyUser(Notification notification) {
        notification.send("Welcome!");
    }

    public static void main(String[] args) {
        notifyUser(new EmailNotification());
        notifyUser(new SmsNotification());
    }
}
