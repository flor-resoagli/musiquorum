package austral.ing.lab1.service;

import austral.ing.lab1.entity.Courses;
import austral.ing.lab1.model.Course;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRefs;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/searchForCourse.do")
public class CourseSearchServlet  extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {



        List<Course> courses = Courses.findByName(req.getParameter("name"));

//        Course course = persistedCourse.get();

        req.setAttribute("courses", courses);





        final RequestDispatcher view = req.getRequestDispatcher("/secure/coursesSearchedForList.jsp");
        view.forward(req, resp);

    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        List<Course> courses = Courses.findByName(req.getParameter("name"));
////        List<Course> courses = Courses.listAll();
////        Course course = persistedCourse.get();
//
//        req.setAttribute("courses", courses);
//
//
//        final RequestDispatcher view = req.getRequestDispatcher("/secure/coursesSearchedForList.jsp");
//        view.forward(req, resp);
//
//    }
}
