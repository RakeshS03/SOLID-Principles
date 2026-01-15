class ContentRenderer {
  render(type: string) {
    if (type === "VIDEO") {
      console.log("Rendering video content");
    } else if (type === "PDF") {
      console.log("Rendering PDF content");
    }
  }
}

// Execution
const renderer = new ContentRenderer();
renderer.render("VIDEO");
