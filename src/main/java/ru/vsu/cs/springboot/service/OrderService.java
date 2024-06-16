package ru.vsu.cs.springboot.service;

import ru.vsu.cs.springboot.DTO.ProductWithAmountDTO;
import ru.vsu.cs.springboot.entity.Order;

import java.util.List;

public interface OrderService extends Service<Order, Integer> {

    List<Order> getOrdersByLoaderId(int loaderId);

    List<Order> getOrdersByStatus(String status);

    Order createOrder(int shopId, List<ProductWithAmountDTO> newOrder);
}

