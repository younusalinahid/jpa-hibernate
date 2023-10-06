package info.nahid.repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CourseRepositoryTest {

    @Autowired
    CourseRepository repository;

    @Test
    public void findById_basic() {
        repository.findById(10001L).ifPresent(course -> assertEquals("JPA in 500 Steps", course.getName()));
    }
}