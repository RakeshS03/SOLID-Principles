class LMSApp {
  static main() {
    const video = new VideoContent();
    const pdf = new PdfContent();

    const player = new ContentPlayer();

    player.play(video);
    player.play(pdf);
  }
}
interface LearningContent {
  render(): void;
}
class VideoContent implements LearningContent {
  render() {
    console.log("video content");
  }
}
class PdfContent implements LearningContent {
  render() {
    console.log("PDF content");
  }
}
class ContentPlayer {
  play(content: LearningContent) {
    content.render();
  }
}

LMSApp.main();
