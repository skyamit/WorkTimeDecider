package model;

public class Employee {
    private int employeeId;
    private String name;
    private OfficeTime inTime;
    private OfficeTime outTime;

    public Employee(){
    }

    public Employee(int employeeId, String name, OfficeTime inTime, OfficeTime outTime) {
        this.employeeId = employeeId;
        this.name = name;
        this.inTime = inTime;
        this.outTime = outTime;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OfficeTime getInTime() {
        return inTime;
    }

    public void setInTime(OfficeTime inTime) {
        this.inTime = inTime;
    }

    public OfficeTime getOutTime() {
        return outTime;
    }

    public void setOutTime(OfficeTime outTime) {
        this.outTime = outTime;
    }

    @Override
    public String toString() {
        return  "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", inTime='" + inTime + '\'' +
                ", outTime='" + outTime + '\'' +
                "\n";
    }
}
