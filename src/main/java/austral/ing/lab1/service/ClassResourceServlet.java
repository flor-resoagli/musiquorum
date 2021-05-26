package austral.ing.lab1.service;

import austral.ing.lab1.entity.Classes;
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
import java.util.List;
import java.util.Optional;

@WebServlet("/secure/classResources.get")
public class ClassResourceServlet extends HttpServlet {
        private final int ARBITARY_SIZE = 1048;

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {


            String classID = req.getParameter("classID");
            int materialIndex = Integer.parseInt(req.getParameter("index"));

            Optional<Class> persistedClass = Classes.findByID(Integer.parseInt(classID));
            Class myClass = persistedClass.get();

            Material material = myClass.getMaterial(materialIndex);
            String fileName = material.getFileName();

            resp.setContentType(material.getContentType());
            resp.setHeader("Content-disposition", ("attachment; filename=" + fileName));

            try(InputStream in = req.getServletContext().getResourceAsStream("/classResources/"+ fileName);
                OutputStream out = resp.getOutputStream()) {

                byte[] buffer = new byte[4096];
                int bytesRead = -1;

                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }

            final RequestDispatcher view = req.getRequestDispatcher("/secure/classProfile.jsp");
            view.forward(req, resp);
        }
}
