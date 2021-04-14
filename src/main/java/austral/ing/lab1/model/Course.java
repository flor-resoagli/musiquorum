package austral.ing.lab1.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Course {

    @Id
    @GeneratedValue
    private Long courseID;

    @Column(name = "COURSE_NAME")
    private String name;

    @Column(name = "TAGS")
    private String tags;
    //private List<String> tags;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;


  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  private List<User> users = new ArrayList<>();


    public Long getCourseID() {
        return courseID;
    }

    public String getName() {
        return name;
    }

    public String getTags() {
        return tags;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getActive() {
        return isActive;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setCourseID(Long courseID) {
        this.courseID = courseID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
