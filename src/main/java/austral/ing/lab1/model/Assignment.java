package austral.ing.lab1.model;

import austral.ing.lab1.entity.Assignments;
import austral.ing.lab1.entity.Classes;

import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

//assignment
@Entity
@Table(name = "ASSIGNMENT")
public class Assignment {


    @Id
    @GeneratedValue
    private int assignmentID;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "INSTRUCTIONS")
    private String instructions;


    @Column(name = "DATA")
    private Blob data;

    @Column(name = "FILENAME")
    private String fileName;

    @Column(name = "STATUS")//entregado, delivered
    private String status; //solo puede ser "pending", "delivered" o "returned"


    //@ManyToMany(mappedBy = "entregas")
    //private List<User> users = new ArrayList<>();

    public void setTitle(String title) {
        this.title = title;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }


    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addFile(Blob data, String contentType){
        this.data = data;
    }


    public void persist(){
        Assignments assignments = new Assignments();
        Assignments.persist(this);
    }

    //un profesor asigna una tarea




}
