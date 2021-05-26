package austral.ing.lab1.model;

import austral.ing.lab1.entity.Materials;
import org.hsqldb.jdbc.JDBCBlob;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "MATERIAL")
public class Material {


    @Id
    @GeneratedValue
    private int materialID;

    @Column(name = "DATA")
    private Blob data;

    @Column(name = "FILENAME")
    private String fileName;

    @Column(name = "CONTENTTYPE")
    private String contentType;

    public Material(Blob data, String contentType, String fileName) {
        this.contentType = contentType;
        this.data = data;
    }

    public Material() {
    }

    public void persist(){
        Materials materials = new Materials();
        materials.persist(this);
    }

    public Blob getData() {
        return data;
    }

    public String getContentType() { return contentType; }

    public String getFileName() { return fileName; }

    public int getMaterialID() { return materialID; }
}
