package austral.ing.lab1.model;

import austral.ing.lab1.entity.Assignments;
import austral.ing.lab1.entity.Classes;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;
import java.util.*;

//assignment
@Entity
@Table(name = "ASSIGNMENT")
public class Assignment {


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int assignmentID;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "INSTRUCTIONS")
    private String instructions;


    @Column(name = "TEACHERS_DATA")
    private Blob teachersData;


    @Column(name = "FILENAME")
    private String fileName;



    @OneToMany(orphanRemoval=true)
    @JoinColumn(name="USER_ID") // como un curso tiene mucho material, el id del curso debe estar en la tabla de material
    private Set<Homework> studentsData = new HashSet<>();

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



    public void addInstructionFile(Blob teachersData, String contentType){
        this.teachersData = teachersData;
    }



    public void persist(){
        Assignments assignments = new Assignments();
        Assignments.persist(this);
    }

    public int getAssignmentID() {
        return assignmentID;
    }

    public String getTitle() {
        return title;
    }

    public String getInstructions() {
        return instructions;
    }

    public Blob getTeachersData() {
        return teachersData;
    }



    public String getFileName() {
        return fileName;
    }




    public Set<Homework> getStudentsData() {
        return studentsData;
    }

    public void setStudentsData(Set<Homework> studentsData) {
        this.studentsData = studentsData;
    }


    public void setTeachersData(Blob teachersData) {
        this.teachersData = teachersData;
    }
}