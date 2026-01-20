interface CourseOperations {
    enroll(): void;
    gradeStudent(): void;
    generateCertificate(): void;
}
class AuditCourse implements CourseOperations {
    enroll(): void {
        console.log("Enrolled");
    }

    gradeStudent(): void {
        // Silent no-op
    }

    generateCertificate(): void {
        // Not applicable
    }
}
