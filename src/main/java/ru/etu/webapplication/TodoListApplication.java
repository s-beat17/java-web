package ru.etu.webapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import ru.etu.webapplication.servlet.TodoListServlet;

import javax.servlet.Filter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;

@EnableWebSecurity
@SpringBootApplication
public class TodoListApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoListApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean<HttpServlet> todoListServletRegistrationBean() {
        var servletRegistrationBean = new ServletRegistrationBean<HttpServlet>(new TodoListServlet(),
                "/todo_list");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }

}
