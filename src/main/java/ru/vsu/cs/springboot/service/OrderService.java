package ru.vsu.cs.springboot.service;

import ru.vsu.cs.springboot.DTO.ProductForOrderDTO;
import ru.vsu.cs.springboot.DTO.ProductWithAmountDTO;
import ru.vsu.cs.springboot.entity.Order;
import ru.vsu.cs.springboot.entity.OrderProduct;
import ru.vsu.cs.springboot.entity.Product;

import java.util.List;

public interface OrderService extends Service<Order, Integer> {

    List<Order> getOrdersByLoaderId(int loaderId);

    List<Order> getOrdersByStatus(String status);

    List<Order> getOrdersByShopId(int shopId);

    Order createOrder(int shopId, List<ProductWithAmountDTO> newOrder);

    List<ProductForOrderDTO> getProductsFromOrder(int shopId, int orderId);

    Order getFirstFreeOrder();

    boolean setEmployerToOrder(int orderId, int employerId);
}

