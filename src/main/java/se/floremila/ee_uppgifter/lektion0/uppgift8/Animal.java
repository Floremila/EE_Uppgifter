package se.floremila.ee_uppgifter.lektion0.uppgift8;

sealed interface Animal permits Dog, Cat {
    String sound();
}
