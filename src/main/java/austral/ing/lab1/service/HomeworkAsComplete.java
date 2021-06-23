package austral.ing.lab1.service;
import austral.ing.lab1.entity.*;
import austral.ing.lab1.model.*;
import austral.ing.lab1.model.Class;

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



/*
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

 */







    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //GET ASSIGNMENT
        String assignmentID = req.getParameter("assignmentID");
        Assignment assignment = Assignments.findByID(Integer.parseInt(assignmentID)).get();

        //GET STUDENT
        String studentEmail = req.getParameter("studentEmail");
        User student = Users.findByEmail(studentEmail).get();

        assignment.addCompletedStudent(student);
        student.addAssignmentsCompleted(assignment);
        //student.markAsCompleted(assignment);
        //FIND DELIVERED HOMEWORK
        //Homework homework = assignment.findStudentDataById(studentEmail);
        //homework.setStatus("completed");
        //Homeworks.complete(homework);
        //COMPLETE HOMEWORK
        //homework.setStatus("completed");
        //homework.persist();
        //assignment.setHomeworkAsComplete(studentEmail);
        //Homeworks.persist(homework);
        final RequestDispatcher view = req.getRequestDispatcher("/secure/homeworkList?assignmentID=" +assignmentID);
        view.forward(req, resp);
    }
}
