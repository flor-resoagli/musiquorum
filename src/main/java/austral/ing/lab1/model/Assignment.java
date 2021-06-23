package austral.ing.lab1.model;

import austral.ing.lab1.entity.Assignments;
import austral.ing.lab1.entity.Classes;
import austral.ing.lab1.entity.Homeworks;
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
    @JoinColumn(name="USER_ID")
    private Set<Homework> studentsData = new HashSet<>();

    public void setTitle(String title) {
        this.title = title;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

//    public List<Homework> viewPending(){
//        List<Homework> pending = new ArrayList<>();
//        for (Homework homework: studentsData) {
//            if(homework.isPending()) pending.add(homework);
//        }
//        return pending;
//    }


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


    public void addStudentsData(Homework homework) {
        studentsData.add(homework);
        homework.persist();
    }

    public Set<Homework> getStudentsData() {
        return studentsData;
    }

    public void setStudentsData(Set<Homework> studentsData) {
        this.studentsData = studentsData;
    }

    public Homework findStudentDataById(String email){
        for(Homework homework: studentsData){
            if(homework.getStudentEmail().equals(email)) return homework;
        }
        return null;
    }

    public void setTeachersData(Blob teachersData) {
        this.teachersData = teachersData;
    }

    public void markStudentAsComplete(String studentEmail) {
        Homework h = findStudentDataById(studentEmail);
        h.setStatus("completed");
//        h.persist();
    }

    public boolean hasStudentHandedIn(String user) {
        if(studentsData.isEmpty()) return false;
        for(Homework homework: studentsData){
            if(homework.getStudentEmail().equals(user)) return true;
        }
        return false;
    }
}
