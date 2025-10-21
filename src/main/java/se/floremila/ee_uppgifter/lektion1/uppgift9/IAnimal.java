package se.floremila.ee_uppgifter.lektion1.uppgift9;

import se.floremila.ee_uppgifter.lektion1.uppgift9.IMammal;
import se.floremila.ee_uppgifter.lektion1.uppgift9.IReptile;

sealed interface IAnimal permits IMammal, IReptile {}
