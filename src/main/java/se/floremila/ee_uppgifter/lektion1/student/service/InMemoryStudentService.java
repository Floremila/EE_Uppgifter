package se.floremila.ee_uppgifter.lektion1.student.service;

import org.springframework.stereotype.Service;

@Service("inMemoryStudentService")
public class InMemoryStudentService implements StudentService {

    @Override
    public String getStudentInfo(Long id) {
        return "Hello from InMemory service (stub), id=" + id;
    }
}

