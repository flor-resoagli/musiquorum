package austral.ing.lab1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Material {

    //atributo temporario para que tome la entidad
    @Id
    @GeneratedValue
    private String materialCode;



}
