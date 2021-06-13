package austral.ing.lab1.entity;

import austral.ing.lab1.model.*;
import austral.ing.lab1.util.LangUtils;

import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

import static austral.ing.lab1.util.EntityManagers.currentEntityManager;
import static austral.ing.lab1.util.LangUtils.checkedList;
import static austral.ing.lab1.util.Transactions.tx;

public class Homeworks {

    public static Optional<Homework> findByID(int id){
        return tx(() ->
                Optional.of(currentEntityManager().find(Homework.class, id))
        );
    }




    public static List<Homework> listAll() {
        return tx(() ->
                checkedList(currentEntityManager().createQuery("SELECT u FROM Homework u").getResultList())
        );
    }



    public static Homework persist(Homework homework) {
        final EntityTransaction tx = currentEntityManager().getTransaction();

        try {
            tx.begin();

            currentEntityManager().persist(homework);

            tx.commit();
            return homework;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }
}
