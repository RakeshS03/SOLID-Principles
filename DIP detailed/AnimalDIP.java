interface Animal {
    void makeSound();
}
class Dog implements Animal {
    public void makeSound() {
        System.out.println("Dog barks");
    }
}
class Cat implements Animal {
    public void makeSound() {
        System.out.println("Cat meows");
    }
}
class AnimalSound{
    private Animal animal;

    public AnimalSound(Animal animal) {
        this.animal = animal;
    }

    public void playSound() {
        animal.makeSound();
    }
}
public class AnimalDIP{
    public static void main(String[] args) {
        AnimalSoundSystem system = new AnimalSound(new Dog());
        system.playSound();
    }
}
