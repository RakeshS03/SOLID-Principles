//ISP
interface Course {
    void start();
}

interface Notification {
    void send(String message);
}

// LSP + OCP
class RecordedCourse implements Course {
    public void start() {
        System.out.println("Playing videos");
    }
}

class LiveCourse implements Course {
    public void start() {
        System.out.println("Joining class");
    }
}

// SRP
class EmailNotification implements Notification {
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}

//  DIP 
class Student {
    private Course course;
    private Notification notification;

    public Student(Course course, Notification notification) {
        this.course = course;
        this.notification = notification;
    }

    public void learn() {
        course.start();
        notification.send("Learning started");
    }
}


public class LearningManagement{
    public static void main(String[] args) {
        Student student =
            new Student(
                new LiveCourse(),
                new EmailNotification()
            );

        student.learn();
    }
}
