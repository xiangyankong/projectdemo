package resources.dao;

import resources.bean.Project;
import resources.util.DBHelp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectDaoImpl implements ProjectDao {
    @Override
    public void add(Project project) {
        Connection c = new DBHelp().getConnection();
        PreparedStatement ps = null;
        String sql = "insert into mydb.project(project_name,create_time,principal_id,acceptor_id, end_time,details) " +
                "values (?,?,?,?,?,?)";
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, project.getProject_name());
            ps.setDate(2, project.getCreate_time());
            ps.setInt(3, project.getPrincipal_id());
            ps.setInt(4, project.getAcceptor_id());
            ps.setDate(5, project.getEnd_time());
            ps.setString(6, project.getDetails());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Project project) {
        Connection c = new DBHelp().getConnection();
        PreparedStatement ps = null;
        String sql = "update mydb.project set project_name=?,status=?,creator_id=?," +
                "principal_id=?,acceptor_id=?,end_time=?,details=? where id = ?";
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, project.getProject_name());
            ps.setInt(2, project.getStatus());
            ps.setInt(3, project.getCreator_id());
            ps.setInt(4, project.getPrincipal_id());
            ps.setInt(5, project.getAcceptor_id());
            ps.setDate(6, project.getEnd_time());
            ps.setString(7, project.getDetails());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Project getProjectById(int id) {
        Connection c = new DBHelp().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from mydb.project where id = ?";
        Project project = new Project();
        try {
            ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                project.setId(id);
                project.setProject_name(rs.getString("project_name"));
                project.setStatus(rs.getInt("status"));
                project.setCreate_time(rs.getDate("create_time"));
                project.setCreator_id(rs.getInt("creator_id"));
                project.setPrincipal_id(rs.getInt("principal_id"));
                project.setAcceptor_id(rs.getInt("acceptor_id"));
                project.setEnd_time(rs.getDate("end_time"));
                project.setDetails(rs.getString("details"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return project;
    }

    @Override
    public List<Project> ProjectList() {
        Connection c = new DBHelp().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from mydb.project";
        List<Project> projectList = new ArrayList<>();
        try {
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Project project = new Project();
                project.setId(rs.getInt("id"));
                project.setProject_name(rs.getString("project_name"));
                project.setStatus(rs.getInt("status"));
                project.setCreate_time(rs.getDate("create_time"));
                project.setCreator_id(rs.getInt("creator_id"));
                project.setPrincipal_id(rs.getInt("principal_id"));
                project.setAcceptor_id(rs.getInt("acceptor_id"));
                project.setEnd_time(rs.getDate("end_time"));
                project.setDetails(rs.getString("details"));
                projectList.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return projectList;
    }

    //分页查询
    @Override
    public List<Project> ProjectList(int start, int count) {
        Connection c = new DBHelp().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Project> projectList = new ArrayList<>();
        String sql = "select * from mydb.project limit ?,?";
        try {
            ps = c.prepareStatement(sql);
            ps.setInt(1, start - 1);
            ps.setInt(2, count);
            rs = ps.executeQuery();
            while (rs.next()) {
                Project project = new Project();
                project.setId(rs.getInt("id"));
                project.setProject_name(rs.getString("project_name"));
                project.setStatus(rs.getInt("status"));
                project.setCreate_time(rs.getDate("create_time"));
                project.setCreator_id(rs.getInt("creator_id"));
                project.setPrincipal_id(rs.getInt("principal_id"));
                project.setAcceptor_id(rs.getInt("acceptor_id"));
                project.setEnd_time(rs.getDate("end_time"));
                project.setDetails(rs.getString("details"));
                projectList.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projectList;
    }

    //通过姓名查姓名id
    public int getId(String name) {
        Connection connection = new DBHelp().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id = -1;
        String sql = "select id from mydb.users where = user_name=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
