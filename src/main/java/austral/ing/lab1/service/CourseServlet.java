package austral.ing.lab1.service;

import austral.ing.lab1.entity.Courses;
import austral.ing.lab1.entity.Users;
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
import java.util.regex.Pattern;

@WebServlet("/secure/editCourse.do")
public class CourseServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        final List<Course> courses = Courses.listAll();

        String courseID = req.getParameter("courseID");

        Optional<Course> persistedCourse = Courses.findById(Integer.parseInt(courseID));
        Course course = persistedCourse.get();

        req.setAttribute("course", course);
        final RequestDispatcher view = req.getRequestDispatcher("/secure/editCourse.jsp");

        view.forward(req, resp);
    }


    //modifyCourse
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseID = req.getParameter("courseID");

        Optional<Course> persistedCourse = Courses.findById(Integer.parseInt(courseID));
        Course course = persistedCourse.get();



        if(!req.getParameter("name").isEmpty()) {
            course.setName(req.getParameter("name"));
        }

        course.setTag(req.getParameter("tags"));

        if(!req.getParameter("description").isEmpty()) {
            course.setDescription(req.getParameter("description"));
        }

        Courses.persist(course);
        final RequestDispatcher view = req.getRequestDispatcher("/secure/home.html");

        view.forward(req, resp);
    }





}