package model;


import javafx.beans.property.*;

public class OrderItem {
    private final StringProperty itemName;
    private final IntegerProperty quantity;
    private final DoubleProperty totalPrice;

    public OrderItem(String itemName, int quantity, double unitPrice) {
        this.itemName = new SimpleStringProperty(itemName);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.totalPrice = new SimpleDoubleProperty(quantity * unitPrice);
    }

    public StringProperty itemNameProperty() { return itemName; }
    public IntegerProperty quantityProperty() { return quantity; }
    public DoubleProperty totalPriceProperty() { return totalPrice; }

    public String getItemName() { return itemName.get(); }
    public int getQuantity() { return quantity.get(); }
    public double getTotalPrice() { return totalPrice.get(); }
}
