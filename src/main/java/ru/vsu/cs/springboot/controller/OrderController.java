package ru.vsu.cs.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.springboot.DTO.ProductForOrderDTO;
import ru.vsu.cs.springboot.DTO.ProductWithAmountDTO;
import ru.vsu.cs.springboot.entity.Order;
import ru.vsu.cs.springboot.entity.OrderProduct;
import ru.vsu.cs.springboot.entity.Product;
import ru.vsu.cs.springboot.service.OrderService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/newOrder/{shopId}")
    public ResponseEntity<String> createOrder(@PathVariable Integer shopId,
                                              @RequestBody ArrayList<ProductWithAmountDTO> productsInOrder) {
        Order createdOrder = orderService.createOrder(shopId, productsInOrder);

        if (createdOrder == null) {
            return ResponseEntity.badRequest().body("Failed to create an order");
        }

        return ResponseEntity.ok("Order created");
    }

    @GetMapping("/getOrders/{shopId}")
    public ResponseEntity<List<Order>> getAllOrdersForShop(@PathVariable int shopId) {
        List<Order> ordersFromShop = orderService.getOrdersByShopId(shopId);
        if (ordersFromShop != null) {
            return ResponseEntity.ok(ordersFromShop);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/getOrders/{shopId}/{orderId}")
    public ResponseEntity<List<ProductForOrderDTO>> getProductsFromOrder(@PathVariable int shopId,
                                                                         @PathVariable int orderId) {
        List<ProductForOrderDTO> productsFromOrder = orderService.getProductsFromOrder(shopId, orderId);

        if (productsFromOrder != null) {
            return ResponseEntity.ok(productsFromOrder);
        } else {
            return ResponseEntity.badRequest().body(null);
        }

    }

    @GetMapping("/getLastOrder")
    public ResponseEntity<Order> getFirstFreeOrder(){
        Order firstFreeOrder= orderService.getFirstFreeOrder();
        if (firstFreeOrder != null){
            return ResponseEntity.ok(firstFreeOrder);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/setEmployerToOrder/{orderId}/{employerId}")
    public ResponseEntity<String> setEmployerToOrder(@PathVariable int orderId,
                                                     @PathVariable int employerId){
        boolean result = orderService.setEmployerToOrder(orderId, employerId);
        if (result){
            return ResponseEntity.ok("Success update order");
        } else {
            return ResponseEntity.badRequest().body("Error update order");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable int id) {
        Order order = orderService.getById(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/loader/{loaderId}")
    public ResponseEntity<List<Order>> getOrdersByLoaderId(@PathVariable int loaderId) {
        List<Order> orders = orderService.getOrdersByLoaderId(loaderId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Order>> getOrdersByStatus(@PathVariable String status) {
        List<Order> orders = orderService.getOrdersByStatus(status);
        return ResponseEntity.ok(orders);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAll();
        return ResponseEntity.ok(orders);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable int id, @RequestBody Order order) {
        order.setId(id);
        Order updatedOrder = orderService.update(order);
        if (updatedOrder != null) {
            return ResponseEntity.ok(updatedOrder);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable int id) {
        orderService.delete(id);
        return ResponseEntity.ok("Order deleted successfully.");
    }
}
