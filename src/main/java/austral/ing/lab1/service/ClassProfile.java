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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
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

        final List<Material> materials = myClass.getMaterials();

        req.setAttribute("myClass", myClass);

        //List<Blob> data = new ArrayList<>();
        //for(Material m : materials){
        //   data.add(m.getData());
        //}
        //req.setAttribute("materialData", data);

        //req.setAttribute("materialsLength", materials.size());
        //List<Integer> indexes = new ArrayList<>();
        //for(int i = 1; i < materials.size(); i++){ indexes.add(i);}
        //req.setAttribute("materialIndexes", indexes);
        final RequestDispatcher view = req.getRequestDispatcher("/secure/classProfile.jsp");
        view.forward(req, resp);
    }
}
