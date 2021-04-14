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

@WebServlet("/createCourse.do")
public class CreateCourse  extends HttpServlet{

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            final Course course = new Course();

            course.setName(req.getParameter("name"));
            course.setTags(req.getParameter("tags"));
            course.setDescription(req.getParameter("description"));
            course.setActive(true);

            Courses.persist(course);

            final RequestDispatcher view = req.getRequestDispatcher("createCourse.html");

            view.forward(req, resp);
        }
}
