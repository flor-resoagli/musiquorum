package austral.ing.lab1.service;

import austral.ing.lab1.entity.Assignments;
import austral.ing.lab1.entity.Classes;
import austral.ing.lab1.model.Assignment;
import austral.ing.lab1.model.Class;
import austral.ing.lab1.model.Material;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Optional;
@WebServlet("/secure/assignmentResources.do")
public class AssignmentResourceServlet extends HttpServlet {

    private final int ARBITARY_SIZE = 1048;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        String id = req.getParameter("assignmentID");




        Assignment  assignment = Assignments.findByID(Integer.parseInt(id)).get();

        Blob material = assignment.getTeachersData();



        //try(InputStream in = req.getServletContext().getResourceAsStream("/classResources/"+ fileName);
        try (InputStream in = material.getBinaryStream();
             OutputStream out = resp.getOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead = -1;

            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        final RequestDispatcher view = req.getRequestDispatcher("/secure/assignments/"+id);

        view.forward(req, resp);
    }
}