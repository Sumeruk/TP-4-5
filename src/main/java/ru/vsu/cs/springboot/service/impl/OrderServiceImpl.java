package ru.vsu.cs.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Service;
import ru.vsu.cs.springboot.DTO.ProductForOrderDTO;
import ru.vsu.cs.springboot.DTO.ProductWithAmountDTO;
import ru.vsu.cs.springboot.entity.Order;
import ru.vsu.cs.springboot.entity.OrderProduct;
import ru.vsu.cs.springboot.entity.Product;
import ru.vsu.cs.springboot.entity.User;
import ru.vsu.cs.springboot.repository.OrderProductRepository;
import ru.vsu.cs.springboot.repository.OrderRepository;
import ru.vsu.cs.springboot.repository.ProductRepository;
import ru.vsu.cs.springboot.repository.UserRepository;
import ru.vsu.cs.springboot.service.OrderService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderProductRepository orderProductRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;


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
        try {
            return orderRepository.findByLoaderId(loaderId);
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Order> getOrdersToLoaderJob(int loaderId) {
        try {
            return orderRepository.findByStatusAndLoaderId("в работе", loaderId);
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Order> getOrdersByStatus(String status) {
        return orderRepository.findByStatus(status);
    }

    @Override
    public List<Order> getOrdersByShopId(int shopId) {
        try {
            return orderRepository.findByShopId(shopId);
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public Order createOrder(int shopId, List<ProductWithAmountDTO> productsFromController) {
        try {
            if(isProductsInDB(productsFromController)) {
                Date currentDate = Date.valueOf(LocalDate.now());
                Order newOrder = new Order(shopId, 0, currentDate, "создан");
                newOrder = orderRepository.save(newOrder);

                List<OrderProduct> productsWithOrderId =
                        setProductsFromOrderToCreatedOrder(newOrder.getId(), productsFromController);

                if (productsWithOrderId != null) {
                    return newOrder;
                } else
                    return null;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    private boolean isProductsInDB(List<ProductWithAmountDTO> productsFromController){
        for (ProductWithAmountDTO product: productsFromController) {

            if (productRepository.findById(product.getId()).isEmpty()){
                return false;
            }

        }

        return true;
    }

    @Override
    public List<ProductForOrderDTO> getProductsFromOrder(int shopId, int orderId) {
        try {
            List<OrderProduct> infoFromOrder = orderProductRepository.getOrderProductByOrderId(orderId);
            List<Optional<Product>> productsFromOrder = new ArrayList<>();

            for (OrderProduct productInfoFromOrder : infoFromOrder) {
                productsFromOrder.add(productRepository.findById(productInfoFromOrder.getProductId()));
            }

            List<ProductForOrderDTO> productsInOrder = new ArrayList<>();

            for (int i = 0; i < infoFromOrder.size(); i++) {
                if (productsFromOrder.get(i).isPresent()) {
                    productsInOrder.add(new ProductForOrderDTO(productsFromOrder.get(i).get().getId(),
                            productsFromOrder.get(i).get().getName(),
                            infoFromOrder.get(i).getAmount()));
                }
            }

            return productsInOrder;
        } catch (Exception e) {
            return null;
        }
    }

    private List<OrderProduct> setProductsFromOrderToCreatedOrder(int createdOrderId,
                                                                  List<ProductWithAmountDTO> productsFromController) {
        try {
            List<OrderProduct> productsAddedToTheOrder = new ArrayList<>();

            for (ProductWithAmountDTO productFromOrder : productsFromController) {

                OrderProduct currOrderProduct = new OrderProduct(createdOrderId, productFromOrder.getId(),
                        productFromOrder.getAmount());
                productsAddedToTheOrder.add(currOrderProduct);

                orderProductRepository.save(currOrderProduct);

            }

            return productsAddedToTheOrder;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Order getFirstFreeOrder() {
        try {
            return orderRepository.findOrderByStatus("создан", Limit.of(1));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean setEmployerToOrder(int orderId, int employerId) {
        try{
            Order updOrder = orderRepository.getReferenceById(orderId);
            updOrder.setLoaderId(employerId);
            updOrder.setStatus("в работе");
            orderRepository.save(updOrder);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean setOrderCollect(int orderId) {
        try {
            Order collectedOrder = orderRepository.getReferenceById(orderId);

            collectedOrder.setStatus("собран");

            User loader = userRepository.getReferenceById(collectedOrder.getLoaderId());
            loader.setStatus(0);
            userRepository.save(loader);
            //System.out.println("DEBUG----инфа про собранный заказ" + collectedOrder);

            List<OrderProduct> productsFromOrder = orderProductRepository.getOrderProductByOrderId(orderId);
            for (OrderProduct orderProduct : productsFromOrder) {
                Product currProd = productRepository.getReferenceById(orderProduct.getProductId());

                //System.out.println("DEBUG----инфа про товар" + currProd);
                int oldAmount = currProd.getQuantity();
                int newAmount = oldAmount - orderProduct.getAmount();

                currProd.setQuantity(newAmount);
                productRepository.save(currProd);
            }
            return true;
        } catch (Exception e){
            return false;
        }
    }


}
