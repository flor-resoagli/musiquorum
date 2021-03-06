package austral.ing.lab1.service;

import austral.ing.lab1.entity.Users;
import austral.ing.lab1.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

import static com.google.common.io.ByteStreams.toByteArray;

@WebServlet("/signup.do")
@MultipartConfig
public class Signup extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    final User user = new User();

    user.setFirstName(req.getParameter("firstname"));
    user.setLastName(req.getParameter("lastname"));
    user.setEmail(req.getParameter("email"));
    user.setPassword(req.getParameter("password"));

    Part filePart = req.getPart("file");
    InputStream data = filePart.getInputStream();
    byte[] dataBytes = toByteArray(data);

    user.setProfilePic(dataBytes);
    user.setActive(true);

    Users.persist(user);

    final RequestDispatcher view = req.getRequestDispatcher("login.html");

    view.forward(req, resp);
  }


}
