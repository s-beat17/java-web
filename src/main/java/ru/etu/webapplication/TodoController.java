package ru.etu.webapplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class TodoController {

    public static final String VISITS = "visits";

    @RequestMapping(value = {"/todo"}, method = RequestMethod.GET)
    public String viewTodoList() {
        return "todo";
    }

    @RequestMapping(value = {"/cookie"}, method = RequestMethod.GET)
    public String viewCookie(HttpServletRequest request, HttpServletResponse response) {
        increaseVisits(request.getSession());
        return "cookie";
    }

    @RequestMapping(value = {"/setcookie"}, method = RequestMethod.GET)
    public String setCookie(@RequestParam("name") String name,
                            @RequestParam("colour") String colour,
                            HttpSession session,
                            HttpServletResponse response) {
        increaseVisits(session);
        response.addCookie(new Cookie("name", name));
        response.addCookie(new Cookie("colour", colour));
        return "cookie";
    }

    private void increaseVisits(HttpSession session) {
        Integer visits = session.getAttribute(VISITS) == null ? 1 : (Integer) session.getAttribute(VISITS) + 1;
        session.setAttribute(VISITS, visits);
    }
}

