package resources.bean;

public class Users {
    private int id;
    private String empno;
    private String user_name;
    private String department;

    public Users(int id, String empno, String user_name, String department) {
        this.id = id;
        this.empno = empno;
        this.user_name = user_name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
