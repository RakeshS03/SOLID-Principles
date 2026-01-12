public class Main {
    public static void main(String[] args) {
        UserManager manager = new UserManager();
        manager.registerUser("Rakesh");
    }
}

class UserWrongSRP {

    public void registerUser(String name) {
        createUser(name);
        saveToDatabase(name);
        sendEmail(name);
        logAction("User registered:" + name);
    }

    private void createUser(String name) {
        System.out.println("User created: " + name);
    }

    private void saveToDatabase(String name) {
        System.out.println("User saved to database: " + name);
    }

    private void sendEmail(String name) {
        System.out.println("Welcome email sent to: " + name);
    }

    private void logAction(String message) {
        System.out.println("LOG: " + message);
    }
}
