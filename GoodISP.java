interface Printable {
    void print();
}

interface Scannable {
    void scan();
}

interface Faxable {
    void fax();
}

class OldPrinter implements Printable {
    public void print() {
        System.out.println("Printing document");
    }
}

class ModernPrinter implements Printable, Scannable, Faxable {
    public void print() {
        System.out.println("Printing document");
    }

    public void scan() {
        System.out.println("Scanning document");
    }

    public void fax() {
        System.out.println("Sending fax");
    }
}

public class GoodISP {
    public static void main(String[] args) {
        Printable printer = new OldPrinter();
        printer.print();

        ModernPrinter allInOne = new ModernPrinter();
        allInOne.scan();
        allInOne.fax();
    }
}
