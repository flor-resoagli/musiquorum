package austral.ing.lab1.repository;

import austral.ing.lab1.model.Course;
import austral.ing.lab1.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class CourseDB {

    private final EntityManager entityManager;

    public CourseDB(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Course> findById(Long id){
        return tx(() ->
                Optional.of(entityManager.find(Course.class, id))
        );
    }

    public void deleteById(int id) {
        // Retrieve the course with this ID
        Course course = entityManager.find(Course.class, id);
        if (course != null) {
            try {
                // Start a transaction because we're going to change the database
                entityManager.getTransaction().begin();

                // Remove all references to this course by tags
                course.getTags().forEach(tag -> {
                    tag.getCourses().remove(course);
                });

                // Now remove the course
                entityManager.remove(course);

                // Commit the transaction
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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

    public List<Course> listAll() {
        return Collections.emptyList();
    }

    public Course persist(Course course) {
        final EntityTransaction tx = entityManager.getTransaction();

        try {
            tx.begin();

            entityManager.persist(course);

            tx.commit();
            return course;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }





}
