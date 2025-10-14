package se.floremila.ee_uppgifter.lektion1.uppgift8;

sealed interface Animal permits Dog, Cat {
    String sound();
}
