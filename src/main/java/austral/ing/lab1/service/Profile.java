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

@WebServlet("/seeProfile.do")
public class Profile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Busco el mail user usando el mail
        final Optional<User> persistedUser = Users.findByEmail(req.getRemoteUser());

        User user = persistedUser.get(); //internamente ya checkea que este presente o tira excepcion

        final PrintWriter out = resp.getWriter();

//        RequestDispatcher rd = req.getRequestDispatcher("/secure/home.html");
//        rd.include(req, resp);

        out.println("<html>");
        out.println("  <head>");
        out.println("    <title>Perfil</title>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <meta http-equiv=\"Cache-Control\" content=\"no-cache, no-store, must-revalidate\" />");
        out.println("    <meta http-equiv=\"Pragma\" content=\"no-cache\" />");
        out.println("    <meta http-equiv=\"Expires\" content=\"0\" />");
        out.println("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">");
        out.println("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>");
        out.println("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>");
        out.println("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>");
        out.println("  </head>");
        out.println("  <style>");
        out.println("       body{");
        out.println("           font-family: 'Century Gothic';");
        out.println("       }");
        out.println("  </style>");
        out.println("  <body>");
        out.println("       <div class=\"card\" style=\"width:400px\" align= \"center\">");
        out.println("               <img class=\"card-img-top\" src=\"../images/img_avatar1.png\" style=\"width:100%\" alt=\"Profile Picture\">");
        out.println("               <div class=\"card-body\">");
        out.println("                   <h4 class=\"card-title\"> <b>" + notEmpty(user.getFirstName(), "None") + " " + notEmpty(user.getLastName(), "None") +  "</b> </h4>");
        out.println("                   <p class=\"card-text\" style=\"font-size:15px\"> **User Bio** </p>");
        out.println("                   <p> <b> Email: </b>" +  notEmpty(user.getEmail(), "None") + "</p>");
        out.println("       </div");
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