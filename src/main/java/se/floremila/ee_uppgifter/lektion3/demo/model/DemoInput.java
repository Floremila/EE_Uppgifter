package se.floremila.ee_uppgifter.lektion3.demo.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class DemoInput {

    @NotBlank(message = "name must not be blank")
    private String name;

    @Min(value = 1, message = "age must be >= 1")
    private int age;

    public DemoInput() { }

    public DemoInput(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}

