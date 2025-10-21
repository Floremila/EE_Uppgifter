/* package se.floremila.ee_uppgifter.lektion1;

import java.util.List;

public class Uppgiftfyra {
    public static void main(String[] args) {

        int day = 3;
        String result = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            default -> "Unknown";
        };
        System.out.println("Enhanced switch says: " + result);


        List<String> names = List.of("Alice", "Bob", "Charlie");


        PersonRecord p = new PersonRecord("Florencia");
        System.out.println(p.name());
    }
}


record PersonRecord(String name) {}

*/