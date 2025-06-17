package com.nisum.controller;

import com.nisum.dao.OrderDAO;
import com.nisum.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderDAO orderDAO;

    @Autowired
    public OrderController(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @GetMapping
    public String ordersLanding() {
        return "ordersLanding";
    }

    @GetMapping("/history")
    public String getOrderHistory(@RequestParam(value = "range", defaultValue = "6months") String range,
                                  Model model) {
        List<Order> orders = orderDAO.getOrdersByRange(range);
        model.addAttribute("orders", orders);
        model.addAttribute("range", range);
        return "orderHistory";
    }

    @GetMapping("/details/{orderId}")
    public String getOrderDetails(@PathVariable int orderId, Model model) {
        Order order = orderDAO.getOrderById(orderId);
        if (order == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found for ID: " + orderId);
        }
        List<OrderItem> items = orderDAO.getOrderItemsByOrderId(orderId);
        List<Shipment> shipments = orderDAO.getShipmentsByOrderId(orderId);
        Invoice invoice = orderDAO.getInvoiceByOrderId(orderId);

        // Add shipment items for each shipment
        shipments.forEach(shipment -> {
            List<ShipmentItem> shipmentItems = orderDAO.getShipmentItems(shipment.getShipmentId());
            shipment.setShipmentItems(shipmentItems);
        });

        model.addAttribute("order", order);
        model.addAttribute("items", items);
        model.addAttribute("shipments", shipments);
        model.addAttribute("invoice", invoice);
        return "orderDetails";
    }

    @PostMapping("/rating")
    @ResponseBody
    public ResponseEntity<String> submitRating(@RequestParam int orderId,
                                               @RequestParam int rating) {
        try {
            orderDAO.saveOrderRating(orderId, rating);
            return ResponseEntity.ok("Thank you for " + rating + " star rating!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error saving rating");
        }
    }

    @GetMapping("/invoice/{orderId}/download")
    public void downloadInvoice(@PathVariable int orderId, HttpServletResponse response)
            throws IOException {
        Invoice invoice = orderDAO.getInvoiceByOrderId(orderId);
        Order order = orderDAO.getOrderById(orderId);
        if (order == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found for ID: " + orderId);
        }
        List<OrderItem> items = orderDAO.getOrderItemsByOrderId(orderId);

        byte[] pdfBytes = generateInvoicePDF(invoice, order, items);

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition",
                "attachment; filename=invoice-" + invoice.getInvoiceNumber() + ".pdf");
        response.getOutputStream().write(pdfBytes);
    }

    @GetMapping("/tracking/{orderId}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getTrackingInfo(@PathVariable int orderId) {
        List<Shipment> shipments = orderDAO.getShipmentsByOrderId(orderId);
        Map<String, Object> trackingData = new HashMap<>();

        shipments.forEach(shipment -> {
            List<ShipmentItem> shipmentItems = orderDAO.getShipmentItems(shipment.getShipmentId());
            shipment.setShipmentItems(shipmentItems);
        });

        trackingData.put("shipments", shipments);
        trackingData.put("mapImage", "/static/images/tracking-map.png");
        return ResponseEntity.ok(trackingData);
    }

    private byte[] generateInvoicePDF(Invoice invoice, Order order, List<OrderItem> items) {
        // Implementation using iText
        try {
            // Add actual PDF generation logic here
            return new byte[0];
        } catch (Exception e) {
            throw new RuntimeException("PDF generation failed", e);
        }
    }
}
