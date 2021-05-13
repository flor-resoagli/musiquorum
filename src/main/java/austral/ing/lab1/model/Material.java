package austral.ing.lab1.model;

import austral.ing.lab1.entity.Materials;

import javax.persistence.*;
import java.sql.Blob;

@Entity
public class Material {

    @Id
    @GeneratedValue
    private int materialID;

    @Column(name = "DATA")
    private Blob data;

    public Material(Blob data) {
        this.data = data;
    }

    public void persist(){
        Materials materials = new Materials();
        materials.persist(this);
    }
}
