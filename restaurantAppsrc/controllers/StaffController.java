package controllers;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Staff;

public class StaffController {

    @FXML private TableView<Staff> staffTable;
    @FXML private TableColumn<Staff, String> colName;
    @FXML private TableColumn<Staff, String> colRole;
    @FXML private TableColumn<Staff, String> colShift;
    @FXML private TableColumn<Staff, Double> colSalary;

    private ObservableList<Staff> staffData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colName.setCellValueFactory(cell -> cell.getValue().nameProperty());
        colRole.setCellValueFactory(cell -> cell.getValue().roleProperty());
        colShift.setCellValueFactory(cell -> cell.getValue().shiftProperty());
        colSalary.setCellValueFactory(cell -> cell.getValue().salaryProperty().asObject());

        loadStaffData(); // Load dummy or real data
    }

    @FXML
    private void loadStaffData() {
        staffData.clear();

        // In a real app, fetch this from database
        staffData.addAll(
            new Staff("Amit", "Chef", "Morning", 30000),
            new Staff("Priya", "Waiter", "Evening", 18000),
            new Staff("Ravi", "Manager", "Full-day", 50000)
        );

        staffTable.setItems(staffData);
    }
}
