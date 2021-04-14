package austral.ing.lab1.entity;

import austral.ing.lab1.model.Course;
import austral.ing.lab1.model.User;

import javax.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

import static austral.ing.lab1.util.EntityManagers.currentEntityManager;
import static austral.ing.lab1.util.LangUtils.checkedList;
import static austral.ing.lab1.util.Transactions.tx;

public class Courses {


    public static Optional<Course> findById(Long id){
        return tx(() ->
                Optional.of(currentEntityManager().find(Course.class, id))
        );
    }


    public static List<Course> listAll() {
        return tx(() ->
                checkedList(currentEntityManager().createQuery("SELECT u FROM Course u").getResultList())
        );
    }



    public static Course persist(Course course) {
        final EntityTransaction tx = currentEntityManager().getTransaction();

        try {
            tx.begin();

            currentEntityManager().persist(course);

            tx.commit();
            return course;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }



}
