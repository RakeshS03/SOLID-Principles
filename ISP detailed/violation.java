interface Printer {
    void print();
    void scan();
    void fax();
}

class BasicPrinter implements Printer {
    public void print() {
        System.out.println("Printing...");
    }

    public void scan() {
        // Not supported
    }

    public void fax() {
        // Not supported
    }
}
