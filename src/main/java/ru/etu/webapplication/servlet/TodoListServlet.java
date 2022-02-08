package ru.etu.webapplication.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

public class TodoListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            var bundle = loadResourceBundle(request);
            out.println("<html>");
            out.println("<head><title>" + bundle.getString("todo_list") + "</title></head>");
            out.println("<body>");
            out.println("<h1>" + bundle.getString("todo_list_student") + " " + (name != null ? name :
                    bundle.getString("noname")) + "</h1>");
            out.println("<table border='1'>");
            out.println("<tr><td><b>" + bundle.getString("todo") + "</b></td><td><b>" + bundle.getString("done") + "</b></td></tr>");
            out.println("<tr><td>Лабораторная работа №1</td><td>" + bundle.getString("yes") + "</td></tr>");
            out.println("<tr><td>Лабораторная работа №2</td><td>" + bundle.getString("no") + "</td></tr>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }

    }

    public ResourceBundle loadResourceBundle(HttpServletRequest request) {
        return Optional.ofNullable(request.getParameter("lang"))
                .filter(lang -> "en".equalsIgnoreCase(lang))
                .map(en -> ResourceBundle.getBundle("todo", Locale.ENGLISH))
                .orElseGet(() -> ResourceBundle.getBundle("todo"));
    }
}
