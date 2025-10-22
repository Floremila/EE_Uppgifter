package se.floremila.ee_uppgifter.lektion1.student.service;

import org.springframework.stereotype.Service;

@Service("jpaStudentService")
public class JpaStudentService implements StudentService {

    @Override
    public String getStudentInfo(Long id) {
        return "Hello from JPA service (stub), id=" + id;
    }
}
