package com.nisum.dao;

import com.nisum.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class OrderDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Order> getOrdersByRange(String range) {
        String query;
        switch (range) {
            case "1week":
                query = "SELECT * FROM Orders WHERE OrderDate >= CURDATE() - INTERVAL 7 DAY ORDER BY OrderDate DESC";
                break;
            case "1month":
                query = "SELECT * FROM Orders WHERE OrderDate >= CURDATE() - INTERVAL 1 MONTH ORDER BY OrderDate DESC";
                break;
            case "6months":
                query = "SELECT * FROM Orders WHERE OrderDate >= CURDATE() - INTERVAL 6 MONTH ORDER BY OrderDate DESC";
                break;
            case "1year":
                query = "SELECT * FROM Orders WHERE OrderDate >= CURDATE() - INTERVAL 1 YEAR ORDER BY OrderDate DESC";
                break;
            default:
                query = "SELECT * FROM Orders ORDER BY OrderDate DESC";
        }
        return jdbcTemplate.query(query, (rs, rowNum) -> new Order(
                rs.getInt("OrderID"),
                rs.getInt("UserID"),
                rs.getDate("OrderDate"),
                rs.getString("OrderStatus"),
                rs.getDouble("OrderTotal"),
                rs.getInt("SellerID"),
                rs.getInt("WarehouseID")
        ));
    }

    public Order getOrderById(int orderId) {
        String query = "SELECT * FROM Orders WHERE OrderID = ?";
        try{
            return jdbcTemplate.queryForObject(query, new Object[]{orderId}, (rs, rowNum) -> new Order(
                    rs.getInt("OrderID"),
                    rs.getInt("UserID"),
                    rs.getDate("OrderDate"),
                    rs.getString("OrderStatus"),
                    rs.getDouble("OrderTotal"),
                    rs.getInt("SellerID"),
                    rs.getInt("WarehouseID")
            ));
        }
        catch (Exception e){
            return null;
        }

    }

    public List<OrderItem> getOrderItemsByOrderId(int orderId) {
        String query = "SELECT * FROM OrderItems WHERE OrderID = ?";
        try{
            return jdbcTemplate.query(query, new Object[]{orderId}, (rs, rowNum) -> new OrderItem(
                    rs.getInt("OrderItemID"),
                    rs.getInt("OrderID"),
                    rs.getInt("ProductID"),
                    rs.getString("SKU"),
                    rs.getInt("Quantity"),
                    rs.getDouble("UnitPrice"),
                    rs.getDouble("Discount"),
                    rs.getDouble("FinalPrice"),
                    rs.getString("Size"),
                    rs.getString("Color"),
                    rs.getString("Status")
            ));
        }
        catch (Exception e){
            return null;
        }

    }

    public List<Shipment> getShipmentsByOrderId(int orderId) {
        String query = "SELECT * FROM Shipments WHERE OrderID = ?";
        return jdbcTemplate.query(query, new Object[]{orderId}, (rs, rowNum) ->
                new Shipment(
                        rs.getInt("ShipmentID"),
                        rs.getInt("OrderID"),
                        rs.getString("ShipmentStatus"),
                        rs.getString("ShipmentTrackingID"),
                        rs.getString("ShipmentDate"),
                        rs.getString("DeliveredDate")
                )
        );
    }

    public List<ShipmentItem> getShipmentItems(int shipmentId) {
        return jdbcTemplate.query(
                "SELECT * FROM ShipmentItems WHERE ShipmentID = ?",
                new Object[]{shipmentId},
                (rs, rowNum) -> new ShipmentItem(
                        rs.getInt("ShipmentItemID"),
                        rs.getInt("ShipmentID"),
                        rs.getInt("OrderItemID"),
                        rs.getInt("ShippedQty")
                )
        );
    }

    public Invoice getInvoiceByOrderId(int orderId) {
        String query = "SELECT * FROM OrderInvoice WHERE OrderID = ?";
        try{
            return jdbcTemplate.queryForObject(query, new Object[]{orderId}, (rs, rowNum) ->
                    new Invoice(
                            rs.getInt("InvoiceID"),
                            rs.getInt("OrderID"),
                            rs.getString("InvoiceNumber"),
                            rs.getDate("InvoiceDate"),
                            rs.getString("PaymentMode"),
                            rs.getDouble("InvoiceAmount")
                    )
            );
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public void saveOrderRating(int orderId, int rating) {
        String query = "INSERT INTO OrderRatings (OrderID, Rating, RatingDate) VALUES (?, ?, NOW())";
        jdbcTemplate.update(query, orderId, rating);
    }

}
