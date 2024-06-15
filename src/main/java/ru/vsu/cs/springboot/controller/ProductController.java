package ru.vsu.cs.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.springboot.DTO.ProductFromDeliveryDTO;
import ru.vsu.cs.springboot.entity.Product;
import ru.vsu.cs.springboot.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/allProducts")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAll();

        products = new ArrayList<>();
        products.add(new Product());
        products.add(new Product());
        products.add(new Product());

        return ResponseEntity.ok(products);
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Product product = productService.getById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/allProducts/search")
    public ResponseEntity<List<Product>> getProductsFromSearch(@RequestParam String param) {
        List<Product> foundProducts = productService.getProductsByParameter(param);
        return ResponseEntity.ok(foundProducts);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.add(product);//?добавить в сервис проверку продукта
        if (createdProduct == null){
            return ResponseEntity.badRequest().body("Cannot create product with this parameters");
        } else {
            return ResponseEntity.ok("Product created");
        }
    }

    @PutMapping("/setProducts")
    public ResponseEntity<String> setProductFromDelivery(@RequestBody ProductFromDeliveryDTO product){
        Product updatedProduct = productService.increaseProductAmount(product);
        if (updatedProduct == null){
            return ResponseEntity.badRequest().body("Cannot find this product");
        }
        return ResponseEntity.ok("Product has been updated");

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable String id, @RequestBody Product product) {
        //product.setId(id);
        Product updatedProduct = productService.update(id, product);
        if (updatedProduct == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Product has been updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        productService.delete(id);
        return ResponseEntity.ok("Product deleted successfully.");
    }

    //    @GetMapping("/provider/{provider}")
//    public ResponseEntity<List<Product>> getProductsByProvider(@PathVariable String provider) {
//        List<Product> products = productService.getProductsByProvider(provider);
//        return ResponseEntity.ok(products);
//    }
//
//    @GetMapping("/name/{name}")
//    public ResponseEntity<List<Product>> getProductsByName(@PathVariable String name) {
//        List<Product> products = productService.getProductsByName(name);
//        return ResponseEntity.ok(products);
//    }
}
