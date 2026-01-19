class UserRepository {
    public void saveUser(String name) {
        System.out.println("User saved");
    }
}

class LoggingOnlyUserRepository extends UserRepository {
    
    public void saveUser(String name) {
        System.out.println("saving user");
        // No actual save
    }
}

class UserService {
    public static void register(UserRepository repo) {
        repo.saveUser("Rakesh");
        System.out.println("Registered");
    }

    public static void main(String[] args) {
        register(new UserRepository());
        register(new LoggingOnlyUserRepository()); // Silent LSP violation
    }
}
