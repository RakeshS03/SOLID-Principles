// Abstractions
interface CourseRepository {
    void enrollStudent(String student);
}
interface ContentDelivery {
    void deliverCourse(String student);
}
interface EvaluationService {
    void evaluate(String student);
}

// low level modules
class MongoCourseRepository implements CourseRepository {
    public void enrollStudent(String student) {
        System.out.println("Student enrolled"+student);
    }
}

class VideoContentDelivery implements ContentDelivery {
    public void deliverCourse(String student) {
        System.out.println("Video course:"+student);
    }
}

class OnlineEvaluationService implements EvaluationService {
    public void evaluate(String student) {
        System.out.println("evaluation completed"+student);
    }
}

// High level modules
class LearningService {
    private CourseRepository repository;
    private ContentDelivery delivery;
    private EvaluationService evaluation;

    public LearningService(CourseRepository repository,ContentDelivery delivery,EvaluationService evaluation) {
        this.repository = repository;
        this.delivery = delivery;
        this.evaluation = evaluation;
    }

    public void startLearning(String student) {
        repository.enrollStudent(student);
        delivery.deliverCourse(student);
        evaluation.evaluate(student);
    }
}
public class SmartLearning {
    public static void main(String[] args) {
        LearningService service = new LearningService(new MongoCourseRepository(),new VideoContentDelivery(),new OnlineEvaluationService());

        service.startLearning("rakesh");
    }
}
