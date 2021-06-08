package austral.ing.lab1.service;

import austral.ing.lab1.entity.Users;
import austral.ing.lab1.model.User;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
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
//        byte[] image = user.getProfilePic();
//        resp.setContentType("image/jpeg");
//        ServletOutputStream outputStream = resp.getOutputStream();
//        outputStream.write(image);
//        outputStream.close();

        req.setAttribute("user", user);
        RequestDispatcher rd = req.getRequestDispatcher("/secure/profile.jsp");
        rd.forward(req, resp);

    }




}