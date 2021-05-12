package austral.ing.lab1.service;

import austral.ing.lab1.entity.Users;
import austral.ing.lab1.model.User;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet("/secure/user.do")
public class UserServlet extends HttpServlet {


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    final List<User> users = austral.ing.lab1.entity.Users.listAll();

    resp.setContentType("application/json");
    resp.setCharacterEncoding("UTF-8");

    final Gson gson = new Gson();
    String json = gson.toJson(users);
    PrintWriter out = resp.getWriter();
    out.print(json);
    out.flush();
  }
  //modifyProfile
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    final Optional<User> persistedUser = Users.findByEmail(req.getRemoteUser());
    User user = persistedUser.get();

    if(!req.getParameter("firstname").isEmpty()) {
      user.setFirstName(req.getParameter("firstname"));
    }
    if(!req.getParameter("lastname").isEmpty()) {
      user.setLastName(req.getParameter("lastname"));
    }
    if(!req.getParameter("password").isEmpty()) {
      user.setPassword(req.getParameter("password"));
    }


    Users.persist(user);
    final RequestDispatcher view = req.getRequestDispatcher("home.html");

    view.forward(req, resp);
  }



}


