package austral.ing.lab1.service;

import austral.ing.lab1.entity.Classes;
import austral.ing.lab1.model.Class;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createClass.do")
public class CreateClass extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Class myClass = new Class();

        myClass.setClassName(req.getParameter("name"));
        myClass.setDuration(0);

        Classes.persist(myClass);

        final RequestDispatcher view = req.getRequestDispatcher("createClass.html");

        view.forward(req, resp);
    }

}
