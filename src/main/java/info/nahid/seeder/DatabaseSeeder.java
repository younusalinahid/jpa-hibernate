package info.nahid.seeder;

import info.nahid.entity.Course;
import info.nahid.repository.CourseRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseSeeder.class);

    @Autowired
    CourseRepository repository;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        logger.info("insert course data");
        seedCourseData();
        logger.info("finish insert course data");
    }

    public void seedCourseData() {
        List<Course> courses = new ArrayList<>();

        Course course1 = new Course();
        course1.setId(10001);
        course1.setName("JPA in 50 Steps");
        courses.add(course1);

        Course course2 = new Course();
        course2.setId(10002);
        course2.setName("Spring boot basics");
        courses.add(course2);

        Course course3 = new Course();
        course3.setId(10003);
        course3.setName("Hibernate Fundamentals");
        courses.add(course3);

        repository.saveAll(courses);
    }

}
