package austral.ing.lab1.service;

import austral.ing.lab1.entity.Classes;
import austral.ing.lab1.entity.Courses;
import austral.ing.lab1.model.Class;
import austral.ing.lab1.model.Course;
import sun.misc.IOUtils;

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
@WebServlet("/secure/createClass.do")
public class CreateClass extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String courseID = req.getParameter("courseID");

        Optional<Course> persistedCourse = Courses.findById(Integer.parseInt(courseID));
        Course course = persistedCourse.get();

        req.setAttribute("course", course);
        final RequestDispatcher view = req.getRequestDispatcher("/secure/createClass.jsp");

        view.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Class myClass = new Class();

        String courseID = req.getParameter("courseID");

        Optional<Course> persistedCourse = Courses.findById(Integer.parseInt(courseID));
        Course course = persistedCourse.get();


        if(!req.getParameter("name").isEmpty()) {
            myClass.setClassName(req.getParameter("name"));
        }
        if(!req.getParameter("duration").isEmpty()) {
            myClass.setDuration(Integer.parseInt(req.getParameter("duration")));
        }


        Part filePart = req.getPart("file");
        InputStream data = filePart.getInputStream();
        byte[] dataBytes = toByteArray(data);

        try {
            myClass.addMaterial(new SerialBlob(dataBytes), filePart.getContentType(), filePart.getSubmittedFileName());
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        course.addClass(myClass);

        //final RequestDispatcher view = req.getRequestDispatcher(("/secure/courses/"+courseID));
        final RequestDispatcher view = req.getRequestDispatcher("/secure/home.html");
        view.forward(req, resp);
    }

}
