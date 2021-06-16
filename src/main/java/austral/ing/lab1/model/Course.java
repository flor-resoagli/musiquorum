package austral.ing.lab1.model;

import austral.ing.lab1.entity.Tags;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Blob;
import java.util.*;

import static sun.awt.image.PixelConverter.UshortGray.instance;

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

    @Column(name = "PROFESSOR")
    private String professor;


    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    private List<Tag> tags = new ArrayList<>();

    @ManyToMany(mappedBy = "courses", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Set<Tag> tags = new HashSet<>();
//
//    @ManyToMany(mappedBy = "courses")
//    private List<User> users = new ArrayList<>();
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "USER_COURSE",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private Set<User> users = new HashSet<>();



      @OneToMany(orphanRemoval=true)
      @JoinColumn(name="COURSE_ID")
      private Set<Class> classes = new HashSet<>();




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

    public Set<User> getUsers() {
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

//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public Set<Tag> getTags() {
        return tags;
    }



    //cada vez que se crea una nueva assignment en un curso, todos los inscriptos en el curso van a tener un homework que entregar en estado inicial: pending
    public void giveHomework(Assignment assignment){
        for (User user: getUsers()) {
            user.addHomework(new Homework(assignment, user));
        }
    }

    //cada vez que un nuevo usuario se inscribe a un curso
    public void giveHomeworktoNewStudent(User user){
        for (Class myClass: getClasses()) {
            for (Assignment assignment: myClass.getAssignments()) {
                user.addHomework(new Homework(assignment, user));
            }
        }
    }


    public void addTag(String tagName) {
        Tag tag = retrieveTag(tagName);
        tags.add(tag);
        tag.getCourses().add(this);
    }

    //probablemente no deberia estar en esta clase este metodo
    public static Tag retrieveTag(String string){
        Tags tags = new Tags();
        List<Tag> exisitngTags = tags.listAll();
        //busca si la tag ya existe
        //si no existe, la crea, la persiste en la tabla tags y la devuelve
        if(!exisitngTags.contains(string)) {
            return Tags.persist(new Tag(string));
        }
        //si existe, solo la busca y la devuelve
        return Tags.find(string).get() ;
    }

    public void addClass(Class myClass){
        getClasses().add(myClass);
        myClass.persist();

    }

    public void removeTag(String tagName){
        Tag tag = retrieveTag(tagName);
        tags.remove(tag);
        tag.getCourses().remove(this);
    }



    public Set<Class> getClasses() {
        return classes;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean hasUser(User user){
        return users.contains(user);
    }

}
