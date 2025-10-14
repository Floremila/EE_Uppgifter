package se.floremila.ee_uppgifter.lektion1;
import javax.validation.constraints.NotBlank;

public class Uppgiftfem {

    static class User {
        @NotBlank
        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        User u1 = new User(""); // intentionally blank
        System.out.println("Name: '" + u1.getName() + "'");
    }
}

