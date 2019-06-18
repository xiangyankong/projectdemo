package resources.dao;

import resources.util.DBHelp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao {
    @Override
    public boolean success(String username, String password) {
        DBHelp db = new DBHelp();
        Connection c= null;
        String sql = "select user_name from users where user_name=? and password=?";
        PreparedStatement ps = null;
        boolean flag = false;
        try {
            c = db.getConnection();
            ps = c.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            if (ps.execute()) {
                flag = true;
            }
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
        return flag;
    }

    public static void main(String[] args) {
        LoginDaoImpl loginDao = new LoginDaoImpl();
        System.out.println(loginDao.success("li","wrttywrty"));
        System.out.println(loginDao.success("qian","zxcv"));
    }
}
