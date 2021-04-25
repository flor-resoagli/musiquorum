package austral.ing.lab1.service;

import austral.ing.lab1.entity.Classes;
import austral.ing.lab1.model.Class;
import austral.ing.lab1.model.Course;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/secure/class.do")
public class ClassServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final List<Class> classes = Classes.listAll();

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        final Gson gson = new Gson();
        String json = gson.toJson(classes);
        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();
    }

}
