package resources.bean;

import java.sql.Date;

public class Project {
    private int id;
    private String project_name;
    private int status;
    private Date create_time;
    private int creator_id;
    private int principal_id;
    private int acceptor_id;
    private Date end_time;
    private String details;

    public Project(int id, String project_name, int status, Date create_time, int creator_id, int principal_id,
                   int acceptor_id, Date end_time, String details) {
        this.id = id;
        this.project_name = project_name;
        this.status = status;
        this.create_time = create_time;
        this.creator_id = creator_id;
        this.principal_id = principal_id;
        this.acceptor_id = acceptor_id;
        this.end_time = end_time;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public int getCreator_id() {
        return creator_id;
    }

    public void setCreator_id(int creator_id) {
        this.creator_id = creator_id;
    }

    public int getPrincipal_id() {
        return principal_id;
    }

    public void setPrincipal_id(int principal_id) {
        this.principal_id = principal_id;
    }

    public int getAcceptor_id() {
        return acceptor_id;
    }

    public void setAcceptor_id(int acceptor_id) {
        this.acceptor_id = acceptor_id;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
