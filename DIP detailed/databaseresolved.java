
//this acts a the abstraction
interface db {
    void save(String data);
}

//low level module
class MySQLdb implements db {
    public void save(String data) {
        System.out.println("Saved");
    }
}

//high level module
class Service {
    private db database;

    public Service(Database database) {
        this.database = database;
    }

    public void registerUser(String user) {
        database.save(user);
    }
}
public class databaseresolved {
    public static void main(String[] args) {
        db mysql = new MySQLdb();   // low-level object
        Service service = new Service(mysql); // injected
        service.registerUser("Rakesh");
    }
}