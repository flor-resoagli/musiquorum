package austral.ing.lab1.repository;

import austral.ing.lab1.model.Material;
import austral.ing.lab1.model.Tag;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.ManyToOne;
import java.util.Optional;
import java.util.function.Supplier;

public class MaterialDB {

    private final EntityManager entityManager;

    public MaterialDB(EntityManager entityManager) {
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


    public Material persist(Material material) {
        final EntityTransaction tx = entityManager.getTransaction();

        try {
            tx.begin();

            entityManager.persist(material);

            tx.commit();
            return material;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }
}
