package se.floremila.ee_uppgifter.lektion1.uppgift9;


public class UppgiftNio {

    public static void checkType(IAnimal animal) {
        if (animal instanceof IMammal) {
            System.out.println("This animal is a mammal!");
        } else if (animal instanceof IReptile) {
            System.out.println("This animal is a reptile!");
        } else {
            System.out.println("Unknown animal type.");
        }
    }

    public static void main(String[] args) {
        IAnimal puppy = new Puppy();
        IAnimal snake = new Snake();

        checkType(puppy);
        checkType(snake);
    }
}
