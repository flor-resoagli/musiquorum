package austral.ing.lab1.service;

import austral.ing.lab1.entity.Classes;
import austral.ing.lab1.entity.Courses;
import austral.ing.lab1.model.Class;
import austral.ing.lab1.model.Course;
import austral.ing.lab1.model.Material;

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

@WebServlet("/secure/classes/*")
public class ClassProfile  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String[] paths = req.getRequestURI().split("/");
        String id = paths[paths.length-1];

        Optional<Class> persistedClass = Classes.findByID(Integer.parseInt(id));
        Class myClass = persistedClass.get();

        final Set<Material> materials = myClass.getMaterials();

        req.setAttribute("myClass", myClass);

        req.setAttribute("materials", materials);





        final RequestDispatcher view = req.getRequestDispatcher("/secure/classProfile.jsp");
        view.forward(req, resp);

    }
}
