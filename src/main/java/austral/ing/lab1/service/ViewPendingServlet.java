package austral.ing.lab1.service;

import austral.ing.lab1.entity.Classes;
import austral.ing.lab1.entity.Courses;
import austral.ing.lab1.entity.Users;
import austral.ing.lab1.model.Assignment;
import austral.ing.lab1.model.Homework;
import austral.ing.lab1.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@WebServlet("/secure/viewPending.do")
public class ViewPendingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = Users.findByEmail(req.getRemoteUser()).get();


        List<Homework> homeworks = user.viewPending();

        List<Assignment> assignments = new ArrayList<>();

        for (Homework homework: homeworks) {
            assignments.add(homework.getAssignment());
        }


        req.setAttribute("assignments", assignments);

        final RequestDispatcher view = req.getRequestDispatcher("/secure/viewPending.jsp");
        view.forward(req, resp);
    }


}
