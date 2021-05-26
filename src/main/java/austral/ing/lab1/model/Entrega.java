package austral.ing.lab1.model;

import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

//assignment
@Entity
public class Entrega {


    @Id
    @GeneratedValue
    private int entregaID;

    @Column(name = "CONSIGNA")
    private String consigna;

    @Column(name = "DATA_TYPE")
    private String dataType;

    @Column(name = "DATA")
    private Blob data;

    @Column(name = "HANDED_IN")//entregado, delivered
    private String isActive; //solo puede ser "pending", "true" o "false"

    @ManyToMany(mappedBy = "entregas")
    private List<User> users = new ArrayList<>();



    //un profesor asigna una tarea




}
