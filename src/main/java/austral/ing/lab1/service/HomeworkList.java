package austral.ing.lab1.service;

import austral.ing.lab1.entity.Assignments;
import austral.ing.lab1.entity.Classes;
import austral.ing.lab1.entity.Courses;
import austral.ing.lab1.model.Assignment;
import austral.ing.lab1.model.Class;
import austral.ing.lab1.model.Course;
import austral.ing.lab1.model.Homework;

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

@WebServlet("/secure/homeworkList")
public class HomeworkList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String assignmentID = req.getParameter("assignmentID");

        Optional<Assignment> persistedAssignment = Assignments.findByID(Integer.parseInt(assignmentID));
        Assignment assignment = persistedAssignment.get();


        Set<Homework> homeworkSet = assignment.getStudentsData();
        homeworkSet.removeIf(homework -> homework.getStatus().equals("completed"));

        req.setAttribute("homeworks", homeworkSet);

        final RequestDispatcher view = req.getRequestDispatcher("/secure/assignments/"+assignmentID);
        view.forward(req, resp);
    }
}