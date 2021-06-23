package austral.ing.lab1.service;

import austral.ing.lab1.entity.Assignments;
import austral.ing.lab1.entity.Classes;
import austral.ing.lab1.entity.Courses;
import austral.ing.lab1.model.*;
import austral.ing.lab1.model.Class;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
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
        Set<Homework> completedHomeworks = assignment.getCompletedHomeworks();
        Set<Homework> deliveredHomeworks = assignment.getDeliveredHomeworks();

        //Set<Homework> homeworkSetD = assignment.getStudentsData();
        //Set<Homework> homeworkSetC = assignment.getStudentsData();

        //homeworkSetD.removeIf(h -> completedUsers.contains(h.getUser()));
        //homeworkSetC.removeAll(homeworkSetD);
        //homeworkSetC.removeIf(h -> !completedUsers.contains(h.getUser()));
        /*
        for(Homework h : homeworkSetD){
            if(completedUsers.contains(h.getUser())) homeworkSetC.add(h);
        }

         */
        //homeworkSetD.removeIf(homework -> homework.getStatus().equals("completed"));

        req.setAttribute("deliveredHomeworks", deliveredHomeworks);
        req.setAttribute("completedHomeworks", completedHomeworks);

        final RequestDispatcher view = req.getRequestDispatcher("/secure/assignments/"+assignmentID);
        view.forward(req, resp);
    }
}