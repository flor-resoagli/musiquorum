package austral.ing.lab1.entity;

import austral.ing.lab1.model.Material;
import austral.ing.lab1.model.Tag;

import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

import static austral.ing.lab1.util.EntityManagers.currentEntityManager;
import static austral.ing.lab1.util.LangUtils.checkedList;
import static austral.ing.lab1.util.Transactions.tx;

public class Materials {

    public static Optional<Material> findByName(int id){
        return tx(() ->
                Optional.of(currentEntityManager().find(Material.class, id))
        );
    }



    public static List<Tag> listAll() {
        return tx(() ->
                checkedList(currentEntityManager().createQuery("SELECT u FROM Material u").getResultList())
        );
    }



    public static Material persist(Material material) {
        final EntityTransaction tx = currentEntityManager().getTransaction();

        try {
            tx.begin();

            currentEntityManager().persist(material);

            tx.commit();
            return material;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }
}
