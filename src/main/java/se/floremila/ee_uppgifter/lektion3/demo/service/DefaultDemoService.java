package se.floremila.ee_uppgifter.lektion3.demo.service;

import org.springframework.stereotype.Service;
import se.floremila.ee_uppgifter.lektion3.demo.model.DemoInput;
import se.floremila.ee_uppgifter.lektion3.error.exception.BadRequestException;
import se.floremila.ee_uppgifter.lektion3.error.exception.ResourceNotFoundException;

@Service
public class DefaultDemoService implements DemoService {

    @Override
    public String getResource(long id) {

        if (id == 404L) {
            throw new ResourceNotFoundException("Resource with id=" + id + " was not found");
        }
        return "Resource " + id + " fetched successfully";
    }

    @Override
    public String createSomething(DemoInput in) {

        if ("forbidden".equalsIgnoreCase(in.getName())) {
            throw new BadRequestException("Provided name is not allowed");
        }
        return "Created entity for name=" + in.getName() + ", age=" + in.getAge();
    }
}

