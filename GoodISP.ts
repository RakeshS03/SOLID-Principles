interface VideoContent {
  watchVideo(): void;
}

interface Downloadable {
  downloadMaterials(): void;
}

interface LiveSession {
  attendLiveClass(): void;
}

class RecordedCourse implements VideoContent, Downloadable {
  watchVideo(): void {
    console.log("Watching recorded video");
  }

  downloadMaterials(): void {
    console.log("Downloading materials");
  }
}

class LiveCourse implements VideoContent, LiveSession {
  watchVideo(): void {
    console.log("Watching live session recording");
  }

  attendLiveClass(): void {
    console.log("Attending live class");
  }
}

const recorded = new RecordedCourse();
recorded.watchVideo();

const live = new LiveCourse();
live.attendLiveClass();
