package controllers;

import applicationrest.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.MenuItem;
import model.OrderItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MenuController {

    @FXML private TableView<MenuItem> menuTable;
    @FXML private TableColumn<MenuItem, String> colName;
    @FXML private TableColumn<MenuItem, Double> colPrice;
    @FXML private TableColumn<MenuItem, String> colCategory;

    @FXML private Spinner<Integer> quantitySpinner;
    @FXML private ListView<String> orderList;

    private ObservableList<MenuItem> menuData = FXCollections.observableArrayList();
    private ObservableList<String> orderData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));

        quantitySpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 20, 1));

        loadMenuFromDatabase();
        orderList.setItems(orderData);
    }

    private void loadMenuFromDatabase() {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT name, price, category FROM menu_items";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                menuData.add(new MenuItem(
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("category")
                ));
            }

            menuTable.setItems(menuData);

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAddToOrder() {
        MenuItem selected = menuTable.getSelectionModel().getSelectedItem();
        int quantity = quantitySpinner.getValue();

        if (selected != null) {
            double totalPrice = selected.getPrice() * quantity;
            String orderItem = selected.getName() + " x" + quantity + " = ₹" + totalPrice;
            orderData.add(orderItem);

            // ✅ Send to BillingController
            BillingController.addOrderItem(new OrderItem(
                    selected.getName(),
                    quantity,
                    totalPrice
            ));
        } else {
            showAlert("Selection Error", "Please select a menu item first.");
        }
    }

    @FXML
    private void handlePlaceOrder() {
        if (orderData.isEmpty()) {
            showAlert("No Items", "No items in the order list.");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Placed");
        alert.setHeaderText(null);
        alert.setContentText("Your order has been placed successfully!");
        alert.showAndWait();

        orderData.clear();
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
