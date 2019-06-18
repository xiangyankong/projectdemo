package resources.servlet;

import resources.bean.Project;
import resources.dao.ProjectDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String projectname = req.getParameter("projectname");
        String principal = req.getParameter("principal");
        String acceptor = req.getParameter("acceptor");
        String endtime = req.getParameter("endtime");
        String details = req.getParameter("details");
        Project project = new Project();

        ProjectDaoImpl projectDao = new ProjectDaoImpl();
        System.out.println(projectname + " " + principal + " " + acceptor + "\n" + endtime + "\n" + details);
        project.setProject_name(projectname);
        project.setStatus(1);
        project.setPrincipal_id(projectDao.getId(principal));
        project.setAcceptor_id(projectDao.getId(acceptor));

        Date date = null;
        try {
            date = format.parse(endtime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        project.setEnd_time(date);
        project.setDetails(details);
        projectDao.add(project);
        System.out.println("success");
//
//        project.setCreate_time(new Date.);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}