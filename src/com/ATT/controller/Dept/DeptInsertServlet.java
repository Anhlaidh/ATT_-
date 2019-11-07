package com.ATT.controller.Dept;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeptInsertServlet",urlPatterns = "/DeptInsertServlet")
public class DeptInsertServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dept_id = request.getParameter("Dept_id");
        String dept_name = request.getParameter("Dept_name");
        String dept_manager = request.getParameter("Dept_manager");
        DeptInsert.DeptInsert(dept_id,dept_name,dept_manager);
        request.getRequestDispatcher(request.getContextPath()+"dept/deptSearch.jsp").forward(request,response);




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
    }
}
