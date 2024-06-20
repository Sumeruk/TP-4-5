package ru.vsu.cs.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.springboot.DTO.ProductIdNameDTO;
import ru.vsu.cs.springboot.DTO.ProductWithAmountDTO;
import ru.vsu.cs.springboot.entity.Product;
import ru.vsu.cs.springboot.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/allProducts")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAll();

        return ResponseEntity.ok(products);
    }

    @GetMapping("/adm/edit/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Product product = productService.getById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    //нач и магаз
    @GetMapping("/allProducts/searchAllProducts")
    public ResponseEntity<List<ProductIdNameDTO>> getProductsForSearch(){
        List<ProductIdNameDTO> productsForSearch = productService.getProductsForSearch();
        if(productsForSearch != null){
            return ResponseEntity.ok(productsForSearch);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // нач и админ
    @GetMapping("/allProducts/search")
    public ResponseEntity<List<Product>> getProductsFromSearch(@RequestParam String search) {
        List<Product> foundProducts = productService.getProductsByParameter(search);
        if (foundProducts != null) {
//            System.out.println(search);
            return ResponseEntity.ok(foundProducts);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

//    @GetMapping("/allProducts/searchByName")
//    public ResponseEntity<List<Product>> getProductsByName(@RequestParam String search) {
//        List<Product> foundProducts = productService.getProductsByName(search);
//        if (foundProducts != null) {
//            System.out.println(search);
//            return ResponseEntity.ok(foundProducts);
//        } else {
//            return ResponseEntity.badRequest().body(null);
//        }
//    }

    @PostMapping("/adm/create")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.add(product);//?добавить в сервис проверку продукта
        if (createdProduct == null){
            return ResponseEntity.badRequest().body("Cannot create product with this parameters");
        } else {
            return ResponseEntity.ok("Product created");
        }
    }

    @PutMapping("/boss/setProducts")
    public ResponseEntity<String> setProductFromDelivery(@RequestBody ProductWithAmountDTO product){
        Product updatedProduct = productService.updateProductAmount(product);
        if (updatedProduct == null){
            return ResponseEntity.badRequest().body("Cannot find this product");
        }
        return ResponseEntity.ok("Product has been updated");

    }

    @PutMapping("/adm/update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable String id,
                                                @RequestBody Product product) {
        //product.setId(id);
        Product updatedProduct = productService.update(id, product);
        if (updatedProduct == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Product has been updated");
    }

    @DeleteMapping("/adm/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        productService.delete(id);
        return ResponseEntity.ok("Product deleted successfully.");
    }
}
