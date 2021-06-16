package austral.ing.lab1.service;

import austral.ing.lab1.entity.Assignments;
import austral.ing.lab1.entity.Classes;
import austral.ing.lab1.entity.Courses;
import austral.ing.lab1.entity.Users;
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
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static com.google.common.io.ByteStreams.toByteArray;

@MultipartConfig
@WebServlet("/secure/assignmentHandIn.do")
public class AssignmentHandIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String assignmentID = req.getParameter("assignmentID");

        Optional<Assignment> persistedAssignment = Assignments.findByID(Integer.parseInt(assignmentID));
        Assignment assignment = persistedAssignment.get();

        req.setAttribute("assignment", assignment);
        final RequestDispatcher view = req.getRequestDispatcher("/secure/handInHomework.jsp");

        view.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = Users.findByEmail(req.getRemoteUser()).get();
        String assignmentID = req.getParameter("assignmentID");

        Optional<Assignment> persistedAssignment = Assignments.findByID(Integer.parseInt(assignmentID));
        Assignment assignment = persistedAssignment.get();

        Homework homework = new Homework();
        homework.setStudentEmail(user.getEmail());

        Part filePart = req.getPart("file");
        InputStream data = filePart.getInputStream();
        byte[] dataBytes = toByteArray(data);

        try {

            homework.setContentType(filePart.getContentType());
            homework.setData(new SerialBlob(dataBytes));
            homework.setStatus("delivered");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        assignment.addStudentsData(homework);
        final RequestDispatcher view = req.getRequestDispatcher("/secure/assignments-student/"+assignmentID);
        view.forward(req, resp);

    }

}
