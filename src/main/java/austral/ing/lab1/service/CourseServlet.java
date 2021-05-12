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

@WebServlet("/secure/course.do")
public class CourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final List<Course> courses = Courses.listAll();

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        final Gson gson = new Gson();
        String json = gson.toJson(courses);
        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();
    }

    //modifyCourse
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Optional<Course> persistedCourse = Courses.findById(Integer.parseInt(req.getParameter("id")));

        Course course = persistedCourse.get();
        course.setName(req.getParameter("name"));
        course.setTag(req.getParameter("tags"));
        course.setDescription(req.getParameter("description"));


        Courses.persist(course);
        final RequestDispatcher view = req.getRequestDispatcher("home.html");

        view.forward(req, resp);
    }





}