package info.nahid.seeder;

import info.nahid.entity.Course;
import info.nahid.repository.CourseRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
@Component
public class DatabaseSeeder {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseSeeder.class);

    @Autowired
    CourseRepository repository;

    @EventListener
    public void seed(ContextClosedEvent event) {
        logger.info("insert course data");
        seedCourseData();
        logger.info("finish insert course data");
    }

    public void seedCourseData() {
        Course course = new Course();
        course.setId(10001);
        course.setName("JPA in 50 Steps");
        repository.save(course);
    }
}
