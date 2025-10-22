package se.floremila.ee_uppgifter.lektion1.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.floremila.ee_uppgifter.lektion1.student.service.StudentService;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public String getStudent() {
        return studentService.getStudentInfo(1L);
    }
}

