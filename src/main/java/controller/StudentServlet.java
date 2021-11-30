package controller;

import model.Student;
import service.StudentService;
import service.StudentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StudentServlet", value = "/Student")
public class StudentServlet extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                showEdit(request, response);
                break;
            case "delete":
                showDelete(request, response);
                break;
            default:
                listStudents(request, response);
        }
    }


    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int student = studentService.findId(id);
        request.setAttribute("student", student);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/edit.jsp");
        requestDispatcher.forward(request, response);
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Student> students = (ArrayList<Student>) studentService.findAll();

        request.setAttribute("student", students);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/list.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int student = studentService.findId(id);
        request.setAttribute("student", student);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/delete.jsp");

        requestDispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete":
                break;
            case "edit":
//                editStudent(request, response);
                break;
        }
    }

//    private void editStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/edit.jsp");
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        double math = Double.parseDouble(request.getParameter("math"));
//        double phy = Double.parseDouble(request.getParameter("phy"));
//        double chem = Double.parseDouble(request.getParameter("chem"));
//        int student = studentService.findId(id);
//        Student newStudent = new Student(id, name, math, phy,chem);
//
//    }
private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    int student = studentService.findId(id);
    request.setAttribute("student", student);
    studentService.delete(id);
    request.setAttribute("abc", "Xoa Thanh Cong");
    response.sendRedirect("/students");

}
}
