package austral.ing.lab1.service;

import austral.ing.lab1.entity.*;
import austral.ing.lab1.model.*;
import austral.ing.lab1.model.Class;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Set;

import static com.google.common.io.ByteStreams.toByteArray;

@WebServlet("/secure/assignments/*")
@MultipartConfig
public class AssignmentProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String[] paths = req.getRequestURI().split("/");
        String id = paths[paths.length-1];

        Assignment assignment = Assignments.findByID(Integer.parseInt(id)).get();

        req.setAttribute("assignment", assignment);

        final RequestDispatcher view = req.getRequestDispatcher("/secure/assignmentProfile.jsp");

        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] paths = req.getRequestURI().split("/");
        String id = paths[paths.length-1];

        Assignment  assignment = Assignments.findByID(Integer.parseInt(id)).get();
        req.setAttribute("assignment", assignment);

        final RequestDispatcher view = req.getRequestDispatcher("/secure/assignmentProfile.jsp");
        view.forward(req, resp);
    }
}

