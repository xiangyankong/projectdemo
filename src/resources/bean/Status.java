package resources.bean;

public class Status {
    private int id;
    private int status_name;

    public Status(int id, int status_name) {
        this.id = id;
        this.status_name = status_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus_name() {
        return status_name;
    }

    public void setStatus_name(int status_name) {
        this.status_name = status_name;
    }
}
