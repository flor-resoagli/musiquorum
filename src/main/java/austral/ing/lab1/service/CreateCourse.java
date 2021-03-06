package austral.ing.lab1.service;

import austral.ing.lab1.entity.Courses;
import austral.ing.lab1.model.Course;
import austral.ing.lab1.model.Tag;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/createCourse.do")
public class CreateCourse  extends HttpServlet{

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            final Course course = new Course();

            List<Tag> tags = new ArrayList<Tag>();

            course.setName(req.getParameter("name"));
            course.setDescription(req.getParameter("description"));
            //course.addTag(req.getParameter("tags"));
            course.setActive(true);
            course.setProfessor(req.getRemoteUser());
            Courses.persist(course);

            final RequestDispatcher view = req.getRequestDispatcher("/secure/home.html");

            view.forward(req, resp);
        }
}
