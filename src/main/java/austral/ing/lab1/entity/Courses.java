package austral.ing.lab1.entity;

import austral.ing.lab1.model.Course;
import austral.ing.lab1.model.User;
import austral.ing.lab1.util.LangUtils;

import javax.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

import static austral.ing.lab1.util.EntityManagers.currentEntityManager;
import static austral.ing.lab1.util.LangUtils.checkedList;
import static austral.ing.lab1.util.Transactions.tx;

public class Courses {


    public static Optional<Course> findById(int id){
        return tx(() ->
                Optional.of(currentEntityManager().find(Course.class, id))
        );
    }

    //devuelve una lista con todos los cursos en los que el usuario del parametro es profesor
    public static Optional<Course> findProfessorCourse(String email, int courseId){
        return tx(() -> LangUtils.<Course>checkedList(currentEntityManager()
                .createQuery("SELECT u FROM Course u WHERE u.professor LIKE :email AND u.courseID = :courseId")
                .setParameter("email", email)
                .setParameter("courseId", courseId).getResultList()).stream()
                .findFirst()
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
