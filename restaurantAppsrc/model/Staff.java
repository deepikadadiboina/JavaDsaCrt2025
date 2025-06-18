package model;



import javafx.beans.property.*;

public class Staff {
    private final StringProperty name;
    private final StringProperty role;
    private final StringProperty shift;
    private final DoubleProperty salary;

    public Staff(String name, String role, String shift, double salary) {
        this.name = new SimpleStringProperty(name);
        this.role = new SimpleStringProperty(role);
        this.shift = new SimpleStringProperty(shift);
        this.salary = new SimpleDoubleProperty(salary);
    }

    public StringProperty nameProperty() { return name; }
    public StringProperty roleProperty() { return role; }
    public StringProperty shiftProperty() { return shift; }
    public DoubleProperty salaryProperty() { return salary; }

    public String getName() { return name.get(); }
    public String getRole() { return role.get(); }
    public String getShift() { return shift.get(); }
    public double getSalary() { return salary.get(); }
}
