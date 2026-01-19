class Bird {
    void fly() {
        System.out.println("Bird is flying");
    }
}

class Penguin extends Bird {
    
    void fly() {
        throw new UnsupportedOperationException("Penguin cannot fly");
    }
}

class Crow extends Bird{
    void fly(){
        System.out.println("crow can fly");
    }
}
