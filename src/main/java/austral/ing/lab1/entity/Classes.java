package austral.ing.lab1.entity;

import austral.ing.lab1.model.Class;

import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

import static austral.ing.lab1.util.EntityManagers.currentEntityManager;
import static austral.ing.lab1.util.LangUtils.checkedList;
import static austral.ing.lab1.util.Transactions.tx;

public class Classes {

    public static Optional<Class> findByID(int id){
        return tx(() ->
                Optional.of(currentEntityManager().find(Class.class, id))
        );
    }


    public static List<Class> listAll() {
        return tx(() ->
                checkedList(currentEntityManager().createQuery("SELECT u FROM Class u").getResultList())
        );
    }






    public static Class persist(Class myClass) {
        final EntityTransaction tx = currentEntityManager().getTransaction();

        try {
            tx.begin();

            currentEntityManager().persist(myClass);

            tx.commit();
            return myClass;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }
}
