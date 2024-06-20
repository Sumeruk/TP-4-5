package ru.vsu.cs.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.springboot.DTO.ProductForOrderDTO;
import ru.vsu.cs.springboot.DTO.ProductWithAmountDTO;
import ru.vsu.cs.springboot.entity.Order;
import ru.vsu.cs.springboot.repository.OrderRepository;
import ru.vsu.cs.springboot.service.OrderService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/boss/orderAnalytics/{dateStart}/{dateEnd}")
    public ResponseEntity<?> orderAnalytics(@PathVariable String dateStart, @PathVariable String dateEnd) {
        try {
            return ResponseEntity.ok(orderRepository.orderAnalytic(Date.valueOf(dateStart),
                    Date.valueOf(dateEnd)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("wrong parameters");
        }
    }

    @GetMapping("/boss/dateAnalytics/{dateStart}")
    public ResponseEntity<?> dateAnalytics(@PathVariable String dateStart) {
        try {
            return ResponseEntity.ok(orderRepository.dateAnalytic(Date.valueOf(dateStart)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("wrong parameters");
        }
    }


    @PostMapping("/shop/newOrder/{shopId}")
    public ResponseEntity<String> createOrder(@PathVariable Integer shopId,
                                              @RequestBody ArrayList<ProductWithAmountDTO> productsInOrder) {
        Order createdOrder = orderService.createOrder(shopId, productsInOrder);

        if (createdOrder == null) {
            return ResponseEntity.badRequest().body("Failed to create an order");
        }

        return ResponseEntity.ok("Order created");
    }

    @GetMapping("/shop/getOrders/{shopId}")
    public ResponseEntity<List<Order>> getAllOrdersForShop(@PathVariable int shopId) {
        List<Order> ordersFromShop = orderService.getOrdersByShopId(shopId);
        if (ordersFromShop != null) {
            return ResponseEntity.ok(ordersFromShop);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // нач и магаз

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

    @GetMapping("/boss/getLastOrder")
    public ResponseEntity<Order> getFirstFreeOrder() {
        Order firstFreeOrder = orderService.getFirstFreeOrder();
        if (firstFreeOrder != null) {
            return ResponseEntity.ok(firstFreeOrder);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/boss/setEmployerToOrder/{orderId}/{employerId}")
    public ResponseEntity<String> setEmployerToOrder(@PathVariable int orderId,
                                                     @PathVariable int employerId) {
        boolean result = orderService.setEmployerToOrder(orderId, employerId);
        if (result) {
            return ResponseEntity.ok("Success update order");
        } else {
            return ResponseEntity.badRequest().body("Error update order");
        }
    }

    @GetMapping("/empl/getOrders/{employerId}")
    public ResponseEntity<List<Order>> getOrdersForEmployerJob(@PathVariable Integer employerId) {
        List<Order> jobOrders = orderService.getOrdersToLoaderJob(employerId);
        if (jobOrders != null) {
            return ResponseEntity.ok(jobOrders);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/empl/setOrder/{orderId}")
    public ResponseEntity<String> setOrderCollect(@PathVariable Integer orderId) {
        if (orderService.setOrderCollect(orderId)) {
            return ResponseEntity.ok("Successfully collected order");
        } else {
            return ResponseEntity.badRequest().body("Error while processing collected order");
        }
    }
}
