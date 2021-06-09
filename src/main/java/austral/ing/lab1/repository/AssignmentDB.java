package austral.ing.lab1.repository;

import austral.ing.lab1.model.Assignment;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Optional;
import java.util.function.Supplier;

public class AssignmentDB {
    private final EntityManager entityManager;

    public AssignmentDB(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Assignment> findById(int id){
        return tx(() ->
                Optional.of(entityManager.find(Assignment.class, id))
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


    public Assignment persist(Assignment assignment) {
        final EntityTransaction tx = entityManager.getTransaction();

        try {
            tx.begin();

            entityManager.persist(assignment);

            tx.commit();
            return assignment;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }
}
