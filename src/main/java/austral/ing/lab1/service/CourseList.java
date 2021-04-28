package austral.ing.lab1.service;

import austral.ing.lab1.entity.Courses;
import austral.ing.lab1.model.Course;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/secure/course-list")
public class CourseList extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        final List<Course> courses = Courses.listAll();

        req.setAttribute("courses", courses);

        final RequestDispatcher view = req.getRequestDispatcher("/secure/courseList.jsp");
        view.forward(req, resp);
    }
}