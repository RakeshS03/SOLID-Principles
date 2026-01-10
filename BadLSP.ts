class FileReader {
  read(): string {
    return "Reading file content";
  }
}

class SecureFileReader extends FileReader {
  read(): string {
    throw new Error("Access denied");
  }
}

function display(reader: FileReader) {
  console.log(reader.read());
}

display(new SecureFileReader()); //break LSP
