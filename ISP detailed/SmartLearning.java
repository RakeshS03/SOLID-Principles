interface Enrollable {
    void enroll(String studentName);
}
interface Gradable {
    void gradeStudent(String studentName);
}
interface Certifiable {
    void generateCertificate(String studentName);
}
interface ContentPublishable {
    void uploadContent(String contentTitle);
}

// Student
class student implements Enrollable {
    public void enroll(String studentName) {
        System.out.println(studentName+"enrolled ");
    }
}

// Teacher
class teacher implements Gradable, ContentPublishable {
    public void gradeStudent(String studentName) {
        System.out.println("Grading"+studentName);
    }

    public void uploadContent(String contentTitle) {
        System.out.println("Uploaded"+contentTitle);
    }
}

// Admin
class admin implements Certifiable {
    public void generateCertificate(String studentName) {
        System.out.println("Certificate generated"+studentName);
    }
}
public class SmartLearning{
    public static void main(String[] args) {
        Enrollable student = new student();
        Gradable teacher = new teacher();
        ContentPublishable creator = new teacher();
        Certifiable admin = new admin();

        student.enroll("Rakesh");
        teacher.gradeStudent("Rakesh");
        creator.uploadContent("COMPLETED ISP");
        admin.generateCertificate("Rakesh");
    }
}
