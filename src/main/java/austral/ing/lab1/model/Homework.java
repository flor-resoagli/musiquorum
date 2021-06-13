package austral.ing.lab1.model;

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


    @Column(name = "CONTENTTYPE")
    private String contentType;


    @Column(name = "STATUS")//entregado, delivered
    private String status; //solo puede ser "pending", "delivered" o "returned"

    public Homework() {
        status="pending";
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
}
