package resources.dao;

import resources.bean.Project;
import resources.util.DBHelp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProjectDaoImpl implements ProjectDao {
    @Override
    public void add(Project project) {
        Connection c = new DBHelp().getConnection();
        String sql = "insert into mydb.project(project_name,create_time,principal_id,acceptor_id, end_time,details) values (?,?,?,?)";
        try {
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, project.getProject_name());
            ps.setDate(2,project.getCreate_time());
            ps.setInt(3,project.getPrincipal_id());
            ps.setInt(4,project.getAcceptor_id());
            ps.setString(5, project.getDetails());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Project project) {
        Connection c = new DBHelp().getConnection();
        String sql = "";
        PreparedStatement ps = c.prepareStatement("update mydb.project set pro");
    }

    @Override
    public Project getProjectById(int id) {
        return null;
    }

    @Override
    public List<Project> ProjectList() {
        return null;
    }

    @Override
    public List<Project> ProjectList(int start, int count) {
        return null;
    }
}
