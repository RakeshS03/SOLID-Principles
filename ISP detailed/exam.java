/* 
interface ExamActions {
    void takeExam();
    void evaluateExam();
    void publishResults();
}

class Student implements ExamActions {
    public void takeExam() {
        System.out.println("Exam taken");
    }

    public void evaluateExam() {}
    public void publishResults() {}
}
*/
interface ExamTaker {
    void takeExam();
}

interface Examiner {
    void evaluateExam();
}

interface ResultPublisher {
    void publishResults();
}

class Student implements ExamTaker {
    public void takeExam() {
        System.out.println("Exam taken");
    }
}
