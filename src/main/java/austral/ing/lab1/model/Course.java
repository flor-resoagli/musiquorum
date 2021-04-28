package austral.ing.lab1.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COURSE")
public class Course {

    @Id
    @GeneratedValue
    private int courseID;

    @Column(name = "COURSE_NAME")
    private String name;


    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "TAGS")
    private String tag;

    @Column(name = "PROFESSOR")
    private String professor;



    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

//
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Tag> tags = new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    private List<User> users = new ArrayList<>();
//
//      @OneToMany
//      private List<Class> classes = new ArrayList<>();


    public int getCourseID() {
        return courseID;
    }

    public String getName() {
        return name;
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

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    //    public List<Tag> getTags() {
//        return tags;
//    }
//
//    public void addTag(Tag tag) {
//        this.tags.add(tag);
//    }
//
//    public void removeTag(Tag tag) {
//        this.tags.remove(tag);
//    }
}
