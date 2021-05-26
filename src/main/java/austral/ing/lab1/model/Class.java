package austral.ing.lab1.model;

import austral.ing.lab1.entity.Classes;
import austral.ing.lab1.entity.Materials;

import javax.persistence.*;
import java.sql.Blob;
import java.util.*;

import static austral.ing.lab1.util.EntityManagers.currentEntityManager;
import static austral.ing.lab1.util.Transactions.tx;

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
    private Set<Material> materials = new HashSet<>();

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

    public void addMaterial(Blob data, String contentType, String fileName){
        Material material = new Material(data,contentType, fileName);
        material.persist();
        getMaterials().add(material);
    }
    public void persist(){
        Classes classes = new Classes();
        Classes.persist(this);
    }

    public int getClassID() {
        return classID;
    }

    public Set<Material> getMaterials() {
        return materials;
    }

    public Material getMaterial(int id){

        for (Material material: materials) {
            if(material.getMaterialID()==id) return material;
        }
        return null;
    }
}
