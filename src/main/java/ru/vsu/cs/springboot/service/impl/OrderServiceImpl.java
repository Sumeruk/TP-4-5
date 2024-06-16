package ru.vsu.cs.springboot.service.impl;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.cs.springboot.DTO.ProductWithAmountDTO;
import ru.vsu.cs.springboot.entity.Order;
import ru.vsu.cs.springboot.entity.OrderProduct;
import ru.vsu.cs.springboot.repository.OrderProductRepository;
import ru.vsu.cs.springboot.repository.OrderRepository;
import ru.vsu.cs.springboot.service.OrderService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderProductRepository orderProductRepository;


    @Override
    public Order add(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order getById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrdersByLoaderId(int loaderId) {
        return orderRepository.findByLoaderId(loaderId);
    }

    @Override
    public List<Order> getOrdersByStatus(String status) {
        return orderRepository.findByStatus(status);
    }

    @Override
    public Order createOrder(int shopId, List<ProductWithAmountDTO> productsFromController) {
        try {
            Date currentDate = Date.valueOf(LocalDate.now());
            Order newOrder = new Order(shopId, 0, currentDate, null);
            newOrder = orderRepository.save(newOrder);

            List<OrderProduct> productsWithOrderId =
                    setProductsFromOrderToCreatedOrder(newOrder.getId(), productsFromController);

            if(productsWithOrderId != null) {
                return newOrder;
            } else
                return null;
        } catch (Exception e){
            return null;
        }
    }

    private List<OrderProduct> setProductsFromOrderToCreatedOrder(int createdOrderId,
                                                    List<ProductWithAmountDTO> productsFromController){
        try{
            List<OrderProduct> productsAddedToTheOrder = new ArrayList<>();

            for (ProductWithAmountDTO productFromOrder: productsFromController) {

                OrderProduct currOrderProduct = new OrderProduct(createdOrderId, productFromOrder.getId(),
                        productFromOrder.getAmount());
                productsAddedToTheOrder.add(currOrderProduct);

                orderProductRepository.save(currOrderProduct);

            }

            return productsAddedToTheOrder;

        } catch (Exception e){
            return null;
        }
    }

}
