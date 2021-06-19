package austral.ing.lab1.service;

import austral.ing.lab1.entity.Courses;
import austral.ing.lab1.entity.Users;
import austral.ing.lab1.model.Course;
import austral.ing.lab1.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/secure/enrollToCourse/*")
public class EnrollmentServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //GET COURSE TO ENROLL AT
        String[] paths = req.getRequestURI().split("/");
        String courseID = paths[paths.length-1];
        Optional<Course> persistedCourse = Courses.findById(Integer.parseInt(courseID));
        Course course = persistedCourse.get();

        //USER BEING ENROLLED
        User user = Users.findByEmail(req.getRemoteUser()).get();

        //ADD COURSE IN USER
        user.addCourse(course);

        //ADD PENDING ASSIGNMENTS (ALL ASSIGNMENTS IN COURSE)
        //course.giveHomeworktoNewStudent(user);

        //PERSIST USER
        Users.persist(user);

        final RequestDispatcher view = req.getRequestDispatcher("/secure/home.html");

        view.forward(req, resp);
    }
}
