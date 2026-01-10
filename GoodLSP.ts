abstract class DocumentReader {
  abstract read(): string;
}

class PublicDocumentReader extends DocumentReader {
  read(): string {
    return "Public document";
  }
}

class PrivateDocumentReader extends DocumentReader {
  read(): string {
    return "Private document";
  }
}

function print(doc: DocumentReader) {
  console.log(doc.read());
}

print(new PublicDocumentReader());
print(new PrivateDocumentReader());
