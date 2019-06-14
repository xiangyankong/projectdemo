package resources.servlet;

import resources.bean.Project;
import resources.dao.ProjectDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String projectname = req.getParameter("projectname");
        String principal = req.getParameter("principal");
        String acceptor = req.getParameter("acceptor");
        String endtime = req.getParameter("endtime");
        String details = req.getParameter("details");
        Project project = new Project();

//        new ProjectDaoImpl().add();
        System.out.println(projectname + " " + principal + " " + acceptor + "\n" + endtime + "\n" + details);
        project.setProject_name(projectname);

//        project.setCreate_time(new Date.);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}