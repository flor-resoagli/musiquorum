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

import static austral.ing.lab1.util.LangUtils.notEmpty;

@WebServlet("/secure/seeProfile")
public class Profile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Busco el mail user usando el mail
        final Optional<User> persistedUser = Users.findByEmail(req.getRemoteUser());

        User user = persistedUser.get(); //internamente ya checkea que este presente o tira excepcion

        final PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("  <head>");
        out.println("    <title>Perfil</title>");
        out.println("  </head>");
        out.println("  <body>");
        out.println("    <h1>Perfil</h1>");
        out.println("    <ul>");
        out.println("      <li> Nombre: " +  notEmpty(user.getFirstName(), "None") + "</li>");
        out.println("      <li> Apellido: " +  notEmpty(user.getLastName(), "None") + "</li>");
        out.println("      <li> Email: " +  notEmpty(user.getEmail(), "None") + "</li>");
        out.println("      <li> Contrasela: " +  notEmpty(user.getPassword(), "None") + "</li>");
        out.println("    </ul>");
        out.println("  </body>");
        out.println("</html>");
//
//        out.flush();
//
//        final RequestDispatcher view = req.getRequestDispatcher("profile.jsp");
//        view.forward(req, resp);
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        final List<User> users = austral.ing.lab1.entity.Users.listAll();
//
//        resp.setContentType("application/json");
//        resp.setCharacterEncoding("UTF-8");
//
//        final Gson gson = new Gson();
//        String json = gson.toJson(users);
//        PrintWriter out = resp.getWriter();
//        out.print(json);
//        out.flush();
//    }



}