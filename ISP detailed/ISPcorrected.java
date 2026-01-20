interface Printable {
    void print();
}
interface Scannable {
    void scan();
}
interface Faxable {
    void fax();
}
class basicmodelimplements Printable {
    public void print() {
        System.out.println("Printing");
    }
}
class advancemodel implements Printable, Scannable, Faxable {
    public void print() {
        System.out.println("Printing");
    }

    public void scan() {
        System.out.println("Scanning");
    }

    public void fax() {
        System.out.println("Faxing");
    }
}
