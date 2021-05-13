package austral.ing.lab1.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//
@Entity
@Table
public class Tag {

    @Id
    private String name;

    //NO BORRAR constructor vacio
    public Tag(){}

    public Tag(String name) {
        this.name = name;
    }



    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "TAGS_COURSE",
            joinColumns = {@JoinColumn(name = "tags_name")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")}
    )
    private Set<Course> courses = new HashSet<>();

    public Set<Course> getCourses() {
        return courses;
    }


}
