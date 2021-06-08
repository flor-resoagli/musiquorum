package austral.ing.lab1.service;

import austral.ing.lab1.entity.Classes;
import austral.ing.lab1.model.Class;
import austral.ing.lab1.model.Material;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;

@WebServlet("/secure/classProfileForStudent/*")
public class ClassProfileForStudent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String[] paths = req.getRequestURI().split("/");
        String id = paths[paths.length-1];

        Optional<Class> persistedClass = Classes.findByID(Integer.parseInt(id));
        Class classs = persistedClass.get();

        Set<Material> materials = classs.getMaterials();

        req.setAttribute("classs", classs);
        req.setAttribute("materials", materials);

        final RequestDispatcher view = req.getRequestDispatcher("/secure/classProfileForStudent.jsp");
        view.forward(req, resp);
    }
}
