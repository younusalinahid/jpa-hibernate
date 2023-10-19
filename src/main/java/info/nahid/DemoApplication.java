package info.nahid;

import info.nahid.entity.Course;
import info.nahid.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository repository;
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {
        List<Course> courses = repository.findAll();
        for (Course course : courses) {
            logger.info("Course -> {}", course);
        }

        Optional<Course> course1 = repository.findById(10001L);
        logger.info("Course 10001 -> {}", course1.orElse(null));

        course1.ifPresent(course -> {
            course.setName("MicroService in 50 steps");
            repository.save(course);
            logger.info("Course 10001 updated -> {}", course);
        });

        repository.deleteById(10003L);


    }

}