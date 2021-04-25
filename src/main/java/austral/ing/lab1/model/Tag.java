package austral.ing.lab1.model;

import javax.persistence.*;

//
@Entity
@Table
public class Tag {

    @Id
    @GeneratedValue
    private String name;
}
