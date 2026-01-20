/*
interface FileHandler {
  read(): void;
  write(): void;
  compress(): void;
}

class ReadOnlyFile implements FileHandler {
  read(): void {
    console.log("Reading the file");
  }

  write(): void {}
  compress(): void {}
}

*/

interface Readable {
    read(): void;
}

interface Writable {
    write(): void;
}

class ReadOnlyFile implements Readable {
    read(): void {
        console.log("Reading the file");
    }
}
