package se.floremila.ee_uppgifter.lektion1.student.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service("jpaStudentService")
public class JpaStudentService implements StudentService {

    @Override
    public String getStudentInfo(Long id) {
        return "Hello from JPA Student Service, id=" + id;
    }
}