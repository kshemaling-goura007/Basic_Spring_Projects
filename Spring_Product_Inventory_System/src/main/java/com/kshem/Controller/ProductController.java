package com.kshem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.kshem.Model.Product;
import com.kshem.Service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

      //Add product
      @PostMapping("/add")
      public String addProduct(@Valid @RequestBody Product product) {
         return service.addProduct(product);
      }

     //Get all products
     @GetMapping("/all")
      public List<Product> getAllProducts() {
         return service.getAllProducts();
      }

    //Get product by ID
      @GetMapping("/{id}")
      public Product getProductById(@PathVariable int id) {
         return service.getProductById(id);
      }

      //Search by partial product name
       @GetMapping("/search")
       public List<Product> searchByName(@RequestParam String name) {
          return service.searchByName(name);
       }

      //Search by category
       @GetMapping("/category")
      public List<Product> getProductsByCategory(@RequestParam String name) {
        return service.getProductsByCategory(name);
      }

     //Update product
     @PutMapping("/update/{id}")
    public String updateProduct(@PathVariable int id, @Valid @RequestBody Product product) {
        return service.updateProduct(id, product);
    }

    //Delete product
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
    
    

    //Get products with low stock
    @GetMapping("/low-stock")
    public List<Product> getLowStockProducts() {
        return service.getLowStockProducts();
    }

    //Get products above a specified price
    @GetMapping("/above-price")
    public List<Product> getProductsAbovePrice(
            @RequestParam double price) {
        return service.getProductsAbovePrice(price);
    }

    //Get product count
    @GetMapping("/count")
    public int getProductCount() {
        return service.getProductCount();
    }
}

