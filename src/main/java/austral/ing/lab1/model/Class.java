package austral.ing.lab1.model;

import austral.ing.lab1.entity.Classes;
import austral.ing.lab1.entity.Materials;

import javax.persistence.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "CLASS")
public class Class {



    @Id
    @GeneratedValue
    private int classID;

    @Column(name = "CLASS_NAME")
    private String className;

    @Column(name = "CLASS_DURATION")
    private int duration;

    @OneToMany(orphanRemoval=true)
    @JoinColumn(name="CLASS_ID") // como un curso tiene mucho material, el id del curso debe estar en la tabla de material
    private List<Material> materials = new ArrayList<>();

    @OneToMany(orphanRemoval=true)
    @JoinColumn(name="CLASS_ID") // como un curso tiene mucho material, el id del curso debe estar en la tabla de material
    private Set<Entrega> entregas = new HashSet<>();


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

    public void addMaterial(Blob data){
        Material material = new Material(data);
        material.persist();
        getMaterials().add(material);

    }
    public void persist(){
        Classes classes = new Classes();
        classes.persist(this);
    }

    public int getClassID() {
        return classID;
    }

    public Set<Material> getMaterials() {
        return materials;
    }
}
