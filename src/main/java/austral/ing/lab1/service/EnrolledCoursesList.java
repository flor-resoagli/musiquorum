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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet("/secure/enrolledCoursesList")
public class EnrolledCoursesList extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        User user = Users.findByEmail(req.getRemoteUser()).get();
        Set<Course> courses = user.getCourses();


        req.setAttribute("courses", courses);

        final RequestDispatcher view = req.getRequestDispatcher("/secure/enrolledCourses.jsp");
        view.forward(req, resp);
    }


}
