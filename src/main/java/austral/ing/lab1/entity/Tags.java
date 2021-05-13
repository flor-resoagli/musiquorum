package austral.ing.lab1.entity;

import austral.ing.lab1.model.Course;
import austral.ing.lab1.model.Tag;

import javax.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

import static austral.ing.lab1.util.EntityManagers.currentEntityManager;
import static austral.ing.lab1.util.LangUtils.checkedList;
import static austral.ing.lab1.util.Transactions.tx;

public class Tags {

    public static Optional<Tag> findByName(String tagName){
        return tx(() ->
                Optional.of(currentEntityManager().find(Tag.class, tagName))
        );
    }



    public static List<Tag> listAll() {
        return tx(() ->
                checkedList(currentEntityManager().createQuery("SELECT u FROM Tag u").getResultList())
        );
    }



    public static Tag persist(Tag tag) {
        final EntityTransaction tx = currentEntityManager().getTransaction();

        try {
            tx.begin();

            currentEntityManager().persist(tag);

            tx.commit();
            return tag;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }
}
