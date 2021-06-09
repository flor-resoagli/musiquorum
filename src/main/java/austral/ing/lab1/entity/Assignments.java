package austral.ing.lab1.entity;

import austral.ing.lab1.model.Assignment;
import austral.ing.lab1.model.Tag;

import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

import static austral.ing.lab1.util.EntityManagers.currentEntityManager;
import static austral.ing.lab1.util.LangUtils.checkedList;
import static austral.ing.lab1.util.Transactions.tx;

public class Assignments {
    public static Optional<Assignment> findByID(int id){
        return tx(() ->
                Optional.of(currentEntityManager().find(Assignment.class, id))
        );
    }



    public static List<Tag> listAll() {
        return tx(() ->
                checkedList(currentEntityManager().createQuery("SELECT u FROM Assignment u").getResultList())
        );
    }



    public static Assignment persist(Assignment assignment) {
        final EntityTransaction tx = currentEntityManager().getTransaction();

        try {
            tx.begin();

            currentEntityManager().persist(assignment);

            tx.commit();
            return assignment;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }
}
