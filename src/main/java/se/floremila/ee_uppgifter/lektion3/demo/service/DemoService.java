package se.floremila.ee_uppgifter.lektion3.demo.service;

import se.floremila.ee_uppgifter.lektion3.demo.model.DemoInput;

public interface DemoService {
    String getResource(long id);
    String createSomething(DemoInput in);
}


