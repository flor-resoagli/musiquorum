package austral.ing.lab1.service;
import austral.ing.lab1.entity.Assignments;
import austral.ing.lab1.entity.Classes;
import austral.ing.lab1.entity.Courses;
import austral.ing.lab1.entity.Homeworks;
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
@WebServlet("/secure/markHomeworkAsComplete.do")
public class HomeworkAsComplete extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String assignmentID = req.getParameter("assignmentID");
        String studentEmail = req.getParameter("studentEmail");

        Assignment assignment = Assignments.findByID(Integer.parseInt(assignmentID)).get();
        Homework homework = assignment.findStudentDataById(studentEmail);


        req.setAttribute("homework", homework);

        final RequestDispatcher view = req.getRequestDispatcher("/secure/homeworkList?assignmentID="+assignmentID);
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String assignmentID = req.getParameter("assignmentID");
        String studentEmail = req.getParameter("studentEmail");

        Assignment assignment = Assignments.findByID(Integer.parseInt(assignmentID)).get();
        Homework homework = assignment.findStudentDataById(studentEmail);
        Homework h = Homeworks.findByID(homework.getID()).get();
        h.setStatus("completed");

        Homeworks.persist(h);
        Assignments.persist(assignment);
        final RequestDispatcher view = req.getRequestDispatcher("/secure/homeworkList?assignmentID="+assignmentID);
        view.forward(req, resp);
    }
}
