package austral.ing.lab1.service;

import austral.ing.lab1.entity.Assignments;
import austral.ing.lab1.entity.Classes;
import austral.ing.lab1.entity.Courses;
import austral.ing.lab1.model.Assignment;
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

@WebServlet("/secure/assignments-list")
public class AssignmentsList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String classID = req.getParameter("classID");
        Optional<Class> persistedClass = Classes.findByID(Integer.parseInt(classID));
        Class classs = persistedClass.get();

        Set<Assignment> assignments = classs.getAssignments();

        req.setAttribute("assignments", assignments);

        final RequestDispatcher view = req.getRequestDispatcher("/secure/assignmentsList.jsp");
        view.forward(req, resp);
    }
}
