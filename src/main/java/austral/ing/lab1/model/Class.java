package austral.ing.lab1.model;

import javax.persistence.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CLASS")
public class Class {



    @Id
    @GeneratedValue
    private String className;

    @Column(name = "CLASS_DURATION")
    private int duration;

    @Column(name = "MATERIAL")
    private Blob material;

    //un curso tiene muchas clases --> muchas clases perteneces a un mismo curso
//    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    private List<Course> courses = new ArrayList<>();

//   Una clase tiene un conjunto de materiales o una clase tiene muchos materiales ??
//   @OneToOne o @OneToMany
//   private List<Material> materiales = new ArrayList<>();


    public String getClassName() {
        return className;
    }

    public int getDuration() {
        return duration;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


}
