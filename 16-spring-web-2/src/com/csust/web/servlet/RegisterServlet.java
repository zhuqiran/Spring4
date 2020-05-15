package com.csust.web.servlet;

import com.csust.web.entity.Student;
import com.csust.web.service.IStudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registerServlet", value = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码集
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        // 接收参数
        String name = req.getParameter("name");
        Integer age = Integer.valueOf(req.getParameter("age"));
        Double score = Double.valueOf(req.getParameter("score"));

        Student student = new Student(name, age, score);
        // 获取ServletContext对象，然后通过ServletContext对象获取到Spring容器对象
        ServletContext servletContext = this.getServletContext();
        // 通过WebApplicationContextUtils工具类，从ServletContext对象的域属性空间中取spring容器对象
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        IStudentService studentService = (IStudentService) context.getBean("studentService");
        int count = studentService.addStudent(student);
        if(count > 0){
            resp.sendRedirect( getServletContext().getContextPath() + "/welcome.jsp");
        }
    }
}
