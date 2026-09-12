import java.io.Serializable;

public class EmployeeSalaryBean implements Serializable {
    private static final long serialVersionUID = 1L;

    // Required properties
    private int empId;
    private String empName;

    // Additional salary properties
    private double basicSalary;
    private double hra;
    private double da;
    private double deductions;

    // Default no-argument constructor
    public EmployeeSalaryBean() {
    }

    // Getters and Setters
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getHra() {
        return hra;
    }

    public void setHra(double hra) {
        this.hra = hra;
    }

    public double getDa() {
        return da;
    }

    public void setDa(double da) {
        this.da = da;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    // Business logic methods to compute salary
    public double getGrossSalary() {
        return basicSalary + hra + da;
    }

    public double getNetSalary() {
        return getGrossSalary() - deductions;
    }
}