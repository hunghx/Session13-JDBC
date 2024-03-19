package ra.example.session13jdbc.controller;

import ra.example.session13jdbc.model.Student;
import ra.example.session13jdbc.service.IStudentService;
import ra.example.session13jdbc.service.impl.StudentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StudentController", value = "/StudentController")
public class StudentController extends HttpServlet {
    private  static final IStudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action!=null){
            switch (action){
                case "GETALL":
                    request.setAttribute("action","GETALL");
                    request.setAttribute("students",studentService.getAll());
                    request.getRequestDispatcher("/index.jsp").forward(request,response);
                    break;
                case "ADD":
                    request.getRequestDispatcher("/WEB-INF/views/add.jsp").forward(request,response);
                    break;

            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action!=null) {
            switch (action) {
                case "ADD" :
                    String newName = request.getParameter("name");
                    Integer newAge = Integer.valueOf(request.getParameter("age"));
                    Boolean newSex = Boolean.valueOf(request.getParameter("sex"));
                    Student newStudent = new Student(null,newName,newAge,newSex);
                    studentService.add(newStudent);
                    response.sendRedirect("/");
                    break;
            }
        }
    }
}
 
