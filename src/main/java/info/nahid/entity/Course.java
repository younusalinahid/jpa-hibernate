package info.nahid.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "courses")
@NamedQueries(value = {
        @NamedQuery(name = "query_get_all_courses", query = "Select c From Course c"),
        @NamedQuery(name = "query_get_100_Step_courses", query = "Select c From Course c where name like '%100 Steps'")
})

public class Course {
    @Id
    private Long id;
    private String name;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Timestamp createdData;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp lastUpdateData;

    public Course() {

    }

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Course[%s]",name);
    }
}
