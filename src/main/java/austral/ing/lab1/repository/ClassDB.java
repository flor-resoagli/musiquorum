package austral.ing.lab1.repository;

import austral.ing.lab1.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class ClassDB {

    private final EntityManager entityManager;

    public ClassDB(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Class> findById(String className){
        return tx(() ->
                Optional.of(entityManager.find(Class.class, className))
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


    public Class persist(Class myClass) {
        final EntityTransaction tx = entityManager.getTransaction();

        try {
            tx.begin();

            entityManager.persist(myClass);

            tx.commit();
            return myClass;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }



}
