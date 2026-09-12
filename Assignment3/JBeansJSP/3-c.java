import java.io.Serializable;

public class EmpBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String designation;

    public EmpBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}