package austral.ing.lab1.model;


import austral.ing.lab1.entity.Assignments;
import austral.ing.lab1.entity.Homeworks;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="HOMEWORK")
public class Homework {

    //una homework tiene un unico alumno
    //un alumno tiene muchas homeworks

    //una homework tiene un unico assignment
    //un assignment tiene muchas homeworks (una para cada alumno)

    //una homework tiene un unico Material

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int homeworkID;


    @Column(name = "STUDENT_DATA")
    private Blob data;

    @Column(name = "STUDENT")
    private String studentEmail;

    @Column(name = "CONTENTTYPE")
    private String contentType;


    @Column(name = "STATUS")//entregado, delivered
    private String status; //solo puede ser "pending", "delivered" o "returned"


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ASSIGNMENT_ID") // como un curso tiene mucho material, el id del curso debe estar en la tabla de material
    private Assignment assignment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="USER_ID")
    private User user;

    public Homework(Assignment assignment, User user) {
        this.assignment = assignment;
        this.user = user;
        studentEmail = user.getEmail();
        status="pending";
        //Homeworks.persist(this);
    }

    // NO BORRAR
    public Homework() {
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    }

    public Blob getData() {
        return data;
    }

    public void setData(Blob data) {
        this.data = data;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public void persist() {
      Homeworks homeworks = new Homeworks();
      Homeworks.persist(this);
    }

    public void setStudentEmail(String email) { this.studentEmail = email; }

    public String getStudentEmail() { return studentEmail; }

    public int getID() { return homeworkID; }


    public boolean isPending(){
        if(status.equals("pending"))return true;
        return false;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public User getUser() {
        return user;
    }

}

