package austral.ing.lab1.service;

import austral.ing.lab1.entity.Classes;
import austral.ing.lab1.entity.Courses;
import austral.ing.lab1.entity.Users;
import austral.ing.lab1.model.Assignment;
import austral.ing.lab1.model.Class;
import austral.ing.lab1.model.Course;
import austral.ing.lab1.model.User;

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
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static com.google.common.io.ByteStreams.toByteArray;
@MultipartConfig
@WebServlet("/secure/createAssignment.do")
public class CreateAssignment extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String classID = req.getParameter("classID");

        Optional<Class> persistedClass = Classes.findByID(Integer.parseInt(classID));
        Class classs = persistedClass.get();

        req.setAttribute("classs", classs);
        final RequestDispatcher view = req.getRequestDispatcher("/secure/createAssignment.jsp");

        view.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Assignment assignment = new Assignment();

        String classID = req.getParameter("classID");

        Optional<Class> persistedClass = Classes.findByID(Integer.parseInt(classID));
        Class classs = persistedClass.get();

        if(!req.getParameter("title").isEmpty()) {
            assignment.setTitle(req.getParameter("title"));
        }

        if(!req.getParameter("instructions").isEmpty()) assignment.setInstructions(req.getParameter("instructions"));

        if(!req.getParameter("fileName").isEmpty()) assignment.setFileName(req.getParameter("fileName"));

        Part filePart = req.getPart("file");
        InputStream data = filePart.getInputStream();
        byte[] dataBytes = toByteArray(data);

        try {
            assignment.addInstructionFile(new SerialBlob(dataBytes), filePart.getContentType());
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        //List<Course> courses = Courses.listAll();
        //for (Course course: courses) {
        //    if(course.getClasses().contains(classs)) course.giveHomework(assignment); //el curso le da a todos los usuarios incriptos la tarea del assignment
        //}

        classs.addAssignment(assignment);

        final RequestDispatcher view = req.getRequestDispatcher("/secure/home.html");
        view.forward(req, resp);
    }
}
