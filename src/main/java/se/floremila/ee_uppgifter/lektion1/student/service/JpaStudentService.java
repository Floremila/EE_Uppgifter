package se.floremila.ee_uppgifter.lektion1.student.service;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("prod")
@Service("jpaStudentService")
public class JpaStudentService implements StudentService {

    @Override
    public String getStudentInfo(Long id) {
        return "Hello from JPA Student Service, id=" + id;
    }
}