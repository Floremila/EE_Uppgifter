package se.floremila.ee_uppgifter.lektion1.uppgift8;

public class AnimalSealedDemo {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();

        System.out.println(a1.getClass().getSimpleName() + " -> " + a1.sound());
        System.out.println(a2.getClass().getSimpleName() + " -> " + a2.sound());
    }
}