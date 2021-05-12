package austral.ing.lab1.service;

import austral.ing.lab1.entity.Classes;
import austral.ing.lab1.entity.Courses;
import austral.ing.lab1.entity.Users;
import austral.ing.lab1.model.Class;
import austral.ing.lab1.model.Course;
import austral.ing.lab1.model.User;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

import static austral.ing.lab1.util.LangUtils.notEmpty;

@WebServlet("/secure/courses/*")
public class CourseProfile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String[] paths = req.getRequestURI().split("/");
        String id = paths[paths.length-1];

        Optional<Course> persistedCourse = Courses.findById(Integer.parseInt(id));
        Course course = persistedCourse.get();

        req.setAttribute("course", course);





        final RequestDispatcher view = req.getRequestDispatcher("/secure/courseProfile.jsp");
        view.forward(req, resp);

    }

}
