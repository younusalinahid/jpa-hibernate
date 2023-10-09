package info.nahid.repository;

import info.nahid.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CourseRepositoryTest {

    @Autowired
    CourseRepository repository;

    @Test
    public void findById_basic() {
        repository.findById(10001L).ifPresent(course -> assertEquals("MicroService in 50 steps", course.getName()));
    }

    @Test
    public void testUpdateCourse() {
        Optional<Course> course = repository.findById(10002L);
        assertTrue(course.isPresent());

        Course courseToUpdate = course.get();
        courseToUpdate.setName("MicroService in 50 steps");
        repository.save(courseToUpdate);

        Optional<Course> updatedCourseOptional = repository.findById(10002L);
        assertTrue(updatedCourseOptional.isPresent());

        assertEquals("MicroService in 50 steps", updatedCourseOptional.get().getName());
    }
        @Test
        public void deleteById_basic () {
            repository.deleteById(10004L);
            assertFalse(repository.findById(10004L).isPresent());
        }
    }