package austral.ing.lab1.service;

import austral.ing.lab1.entity.Classes;
import austral.ing.lab1.entity.Courses;
import austral.ing.lab1.model.Class;
import austral.ing.lab1.model.Course;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static com.google.common.io.ByteStreams.toByteArray;

@WebServlet("/secure/class.do")
public class ClassServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        final List<Class> classes = Classes.listAll();

        String classID = req.getParameter("classID");

        Optional<Class> persistedClass = Classes.findByID(Integer.parseInt(classID));
        Class classs = persistedClass.get();

        req.setAttribute("classs", classs);
        final RequestDispatcher view = req.getRequestDispatcher("/secure/editClass.jsp");

        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String classID = req.getParameter("classID");

        Optional<Class> persistedClass = Classes.findByID(Integer.parseInt(classID));
        Class classs = persistedClass.get();



        if(!req.getParameter("name").isEmpty()) {
            classs.setClassName(req.getParameter("name"));
        }


        if(!req.getParameter("duration").isEmpty()) {
            classs.setDuration(Integer.parseInt(req.getParameter("duration")));
        }


        Classes.persist(classs);
        final RequestDispatcher view = req.getRequestDispatcher("/secure/home.html");

        view.forward(req, resp);
    }



}
