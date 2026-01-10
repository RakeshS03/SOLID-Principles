
interface CourseActions {
  watchVideo(): void;
  downloadMaterials(): void;
  attendLiveClass(): void;
}

class RecordedCourse implements CourseActions {
  watchVideo(): void {
    console.log("Watching video");
  }

  downloadMaterials(): void {
    console.log("Downloading materials");
  }

  attendLiveClass(): void {
    throw new Error("Live class not available");
  }
}

const course: CourseActions = new RecordedCourse();
course.watchVideo();
// course.attendLiveClass(); // Runtime error
