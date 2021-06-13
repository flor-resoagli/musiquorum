package austral.ing.lab1.repository;

import austral.ing.lab1.model.Homework;
import austral.ing.lab1.model.Material;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Optional;
import java.util.function.Supplier;

public class HomeworkDB {

    private final EntityManager entityManager;

    public HomeworkDB(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Material> findById(int id){
        return tx(() ->
                Optional.of(entityManager.find(Material.class, id))
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


    public Homework persist(Homework homework) {
        final EntityTransaction tx = entityManager.getTransaction();

        try {
            tx.begin();

            entityManager.persist(homework);

            tx.commit();
            return homework;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }
}
