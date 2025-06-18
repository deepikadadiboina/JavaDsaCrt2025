package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.OrderItem;

public class BillingController {

    @FXML private TableView<OrderItem> orderTable;
    @FXML private TableColumn<OrderItem, String> colItem;
    @FXML private TableColumn<OrderItem, Integer> colQty;
    @FXML private TableColumn<OrderItem, Double> colPrice;
    @FXML private Label totalLabel;

    // Shared order list
    private static final ObservableList<OrderItem> billingData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colItem.setCellValueFactory(data -> data.getValue().itemNameProperty());
        colQty.setCellValueFactory(data -> data.getValue().quantityProperty().asObject());
        colPrice.setCellValueFactory(data -> data.getValue().totalPriceProperty().asObject());

        orderTable.setItems(billingData);
        updateTotal();
    }

    private void updateTotal() {
        double total = billingData.stream().mapToDouble(OrderItem::getTotalPrice).sum();
        totalLabel.setText("₹" + String.format("%.2f", total));
    }

    @FXML
    private void handlePayment() {
        if (billingData.isEmpty()) {
            showAlert("No Orders", "There are no items to pay for.");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Payment Successful");
        alert.setHeaderText(null);
        alert.setContentText("Thank you! Payment received.");
        alert.showAndWait();

        billingData.clear();
        updateTotal();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Used by MenuController to add orders
    public static void addOrderItem(OrderItem item) {
        billingData.add(item);
    }
}
