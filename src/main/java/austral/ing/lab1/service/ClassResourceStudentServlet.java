package austral.ing.lab1.service;

import austral.ing.lab1.entity.Assignments;
import austral.ing.lab1.entity.Classes;
import austral.ing.lab1.model.Assignment;
import austral.ing.lab1.model.Class;
import austral.ing.lab1.model.Material;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@WebServlet("/secure/classResourcesForStudent.do")
public class ClassResourceStudentServlet extends HttpServlet {
    private final int ARBITARY_SIZE = 1048;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String classID = req.getParameter("classID");
        int materialID = Integer.parseInt(req.getParameter("materialID"));

        Optional<Class> persistedClass = Classes.findByID(Integer.parseInt(classID));
        Class myClass = persistedClass.get();

        Blob material = myClass.getMaterial(materialID).getData();
        //String fileName = material.getFileName();

        //resp.setContentType(material.getContentType());
        //resp.setHeader("Content-disposition", ("attachment; filename=" + fileName));

        //try(InputStream in = req.getServletContext().getResourceAsStream("/classResources/"+ fileName);
        try(InputStream in = material.getBinaryStream();
            OutputStream out = resp.getOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead = -1;

            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        final RequestDispatcher view = req.getRequestDispatcher("/secure/classProfileForStudent/"+classID);
        view.forward(req, resp);

    }
}
