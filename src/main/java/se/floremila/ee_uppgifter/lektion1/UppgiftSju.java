package se.floremila.ee_uppgifter.lektion1;

public class UppgiftSju {
    public static void main(String[] args) {

        int day = 3;
        String result;


        switch (day) {
            case 1:
                result = "Monday";
                break;
            case 2:
                result = "Tuesday";
                break;
            case 3:
                result = "Wednesday";
                break;
            default:
                result = "Unknown";
                break;
        }

        System.out.println("Classic switch says: " + result);
    }
}

