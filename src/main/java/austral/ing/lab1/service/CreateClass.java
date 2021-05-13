package austral.ing.lab1.service;

import austral.ing.lab1.entity.Classes;
import austral.ing.lab1.model.Class;
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

import static com.google.common.io.ByteStreams.toByteArray;
@MultipartConfig
@WebServlet("/createClass.do")
public class CreateClass extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Class myClass = new Class();

        myClass.setClassName(req.getParameter("name"));
        Part filePart = req.getPart("file");
        InputStream data = filePart.getInputStream();
        byte[] dataBytes = toByteArray(data);

        try {
            myClass.addMaterial(new SerialBlob(dataBytes));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Classes.persist(myClass);

        final RequestDispatcher view = req.getRequestDispatcher("/secure/courseProfile.jsp");

        view.forward(req, resp);
    }

}
