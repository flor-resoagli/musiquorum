package austral.ing.lab1.model;

import javax.persistence.*;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

//
@Entity
@Table
public class Tag {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(unique = true, nullable = false)
    private String name;

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;
//
//
//    @Column(name = "TAG_NAME")
//    private String name;

    //NO BORRAR constructor vacio
    public Tag(){}

    public Tag(String name) {
        this.name = name;
    }



    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
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
