package austral.ing.lab1.repository;

import austral.ing.lab1.model.Tag;
import austral.ing.lab1.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class TagDB {

    private final EntityManager entityManager;

    public TagDB(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Tag> findById(String tag){
        return tx(() ->
                Optional.of(entityManager.find(Tag.class, tag))
        );
    }

    public <R> R tx(Supplier<R> s) {
        final EntityTransaction tx = entityManager.getTransaction();

        try {
            tx.begin();

            R r = s.get();

            tx.commit();
            return r;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }

    public void tx(Runnable r){
        final EntityTransaction tx = entityManager.getTransaction();

        try {
            tx.begin();

            r.run();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }


    public Tag persist(Tag tag) {
        final EntityTransaction tx = entityManager.getTransaction();

        try {
            tx.begin();

            entityManager.persist(tag);

            tx.commit();
            return tag;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }

}
