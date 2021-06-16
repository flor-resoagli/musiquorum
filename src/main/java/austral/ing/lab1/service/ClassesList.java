package austral.ing.lab1.service;

import austral.ing.lab1.entity.Classes;
import austral.ing.lab1.entity.Courses;
import austral.ing.lab1.model.Class;
import austral.ing.lab1.model.Course;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@WebServlet("/secure/classes-list")
public class ClassesList extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String courseID = req.getParameter("courseID");
        Optional<Course> persistedCourse = Courses.findById(Integer.parseInt(courseID));
        Course course = persistedCourse.get();

        Set<Class> classes = course.getClasses();

        final List<Class> c = Classes.listAll();

        for(Class cc : c){
            if(!classes.contains(cc)) classes.remove(cc);
        }

        req.setAttribute("classList", classes);

        final RequestDispatcher view = req.getRequestDispatcher("/secure/courses/"+courseID);
        view.forward(req, resp);
    }
}