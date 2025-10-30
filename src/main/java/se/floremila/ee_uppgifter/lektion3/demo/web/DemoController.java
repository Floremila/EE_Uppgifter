package se.floremila.ee_uppgifter.lektion3.demo.web;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.floremila.ee_uppgifter.lektion3.demo.model.DemoInput;
import se.floremila.ee_uppgifter.lektion3.demo.service.DemoService;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private final DemoService service;

    public DemoController(DemoService service) {
        this.service = service;
    }


    @GetMapping("/resource/{id}")
    public ResponseEntity<String> getResource(@PathVariable long id) {
        String msg = service.getResource(id);
        return ResponseEntity.ok(msg);
    }


    @PostMapping("/create")
    public ResponseEntity<String> create(@Valid @RequestBody DemoInput input) {
        String msg = service.createSomething(input);
        return ResponseEntity.ok(msg);
    }
}
