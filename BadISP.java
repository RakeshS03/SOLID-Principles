interface OfficeMachine {
    void print();
    void scan();
    void fax();
}

class OldPrinter implements OfficeMachine {
    public void print() {
        System.out.println("Printing");
    }

    public void scan() {
        throw new UnsupportedOperationException("Scan not supported");
    }

    public void fax() {
        throw new UnsupportedOperationException("Fax not supported");
    }
}

public class BadISP {
    public static void main(String[] args) {
        OfficeMachine printer = new OldPrinter();
        printer.print();
        
    }
}
