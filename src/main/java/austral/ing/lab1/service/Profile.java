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

@WebServlet("/seeProfile.do")
public class Profile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Busco el mail user usando el mail
        final Optional<User> persistedUser = Users.findByEmail(req.getRemoteUser());

        User user = persistedUser.get(); //internamente ya checkea que este presente o tira excepcion

        req.setAttribute("user", user);

        final RequestDispatcher view = req.getRequestDispatcher("/secure/profile.html");
        view.forward(req, resp);
        //devuelve el mismo formato que
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Busco el mail user usando el mail
        final Optional<User> persistedUser = Users.findByEmail(req.getRemoteUser());

        User user = persistedUser.get(); //internamente ya checkea que este presente o tira excepcion

        user.setFirstName(req.getParameter("firstname"));
        user.setLastName(req.getParameter("lastname"));
        user.setPassword(req.getParameter("password"));
        user.setActive(true);

        Users.persist(user);

        //probablemente deberia volver al perfil en vez de al home pero todavia no esta implementado
        final RequestDispatcher view = req.getRequestDispatcher("/secure/home.html");

        view.forward(req, resp);
    }

}