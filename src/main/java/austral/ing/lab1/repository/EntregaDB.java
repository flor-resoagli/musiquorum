package austral.ing.lab1.repository;

import austral.ing.lab1.model.Entrega;
import austral.ing.lab1.model.Material;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Optional;
import java.util.function.Supplier;

public class EntregaDB {
    private final EntityManager entityManager;

    public EntregaDB(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Entrega> findById(int id){
        return tx(() ->
                Optional.of(entityManager.find(Entrega.class, id))
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


    public Entrega persist(Entrega entrega) {
        final EntityTransaction tx = entityManager.getTransaction();

        try {
            tx.begin();

            entityManager.persist(entrega);

            tx.commit();
            return entrega;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }
}
