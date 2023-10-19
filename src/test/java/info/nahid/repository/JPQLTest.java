package info.nahid.repository;

import info.nahid.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

@DataJpaTest
public class JPQLTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository repository;

    @Test
    public void jpql_basic() {
        List<Course> courses = repository.getAllCourse();
        logger.info("Select c From Course c -> {}", courses);
    }

    @Test
    public void jpql_where() {
        List<Course> courses = repository.getCourse("%100 Steps");
        logger.info("Select c From Course c where name like '%100 Steps' -> {}", courses);
    }
}
