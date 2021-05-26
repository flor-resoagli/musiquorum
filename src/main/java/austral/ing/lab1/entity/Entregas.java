package austral.ing.lab1.entity;

import austral.ing.lab1.model.Entrega;
import austral.ing.lab1.model.Material;
import austral.ing.lab1.model.Tag;

import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

import static austral.ing.lab1.util.EntityManagers.currentEntityManager;
import static austral.ing.lab1.util.LangUtils.checkedList;
import static austral.ing.lab1.util.Transactions.tx;

public class Entregas {
    public static Optional<Entrega> findByName(int id){
        return tx(() ->
                Optional.of(currentEntityManager().find(Entrega.class, id))
        );
    }



    public static List<Tag> listAll() {
        return tx(() ->
                checkedList(currentEntityManager().createQuery("SELECT u FROM Entrega u").getResultList())
        );
    }



    public static Entrega persist(Entrega entrega) {
        final EntityTransaction tx = currentEntityManager().getTransaction();

        try {
            tx.begin();

            currentEntityManager().persist(entrega);

            tx.commit();
            return entrega;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }
}
