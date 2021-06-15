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

@WebServlet("/secure/assignmentProfile/*")
@MultipartConfig
public class AssignmentProfileServlet extends HttpServlet {


    //el doGet recibe lo que el estudiante llena en el jsp
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String[] paths = req.getRequestURI().split("/");
        String id = paths[paths.length-1];

        Assignment assignment = Assignments.findByID(Integer.parseInt(id)).get();
        User user = Users.findByEmail(req.getRemoteUser()).get();

//
        Homework homework = user.getAssignmentHomework(assignment);
//
//
//        Part filePart = req.getPart("file");
//        InputStream data = filePart.getInputStream();
//        byte[] dataBytes = toByteArray(data);
//
//
//
//        try {
//            //se podria crear en homework un metodo "handIn" que haga todo esto de una
//            homework.setContentType(filePart.getContentType());
//            homework.setData(new SerialBlob(dataBytes));
//            homework.setStatus("delivered");
//        } catch (SQLException throwable) {
//            throwable.printStackTrace();
//        }






        req.setAttribute("assignment", assignment);

        final RequestDispatcher view = req.getRequestDispatcher("/secure/assignmentStudentProfile.jsp");

        view.forward(req, resp);
    }


//    //el doPost del servlet le manda al jsp los datos de este assignement
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] paths = req.getRequestURI().split("/");
        String id = paths[paths.length-1];




        Assignment  assignment = Assignments.findByID(Integer.parseInt(id)).get();


        req.setAttribute("assignment", assignment);





        final RequestDispatcher view = req.getRequestDispatcher("/secure/assignmentStudentProfile.jsp");
        view.forward(req, resp);
    }
}
