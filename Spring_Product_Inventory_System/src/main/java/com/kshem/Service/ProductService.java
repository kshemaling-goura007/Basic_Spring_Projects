package com.kshem.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kshem.Model.Product;
import com.kshem.Exception.ProductNotFoundException;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();

    //Add a product
    public String addProduct(Product product) {

        for (Product p : products) {
            if (p.getProductId() == product.getProductId()) {
                return "Product ID already exists";
            }
        }
        products.add(product);
        return "Product added successfully";
    }
    
    
    

    //Get all products
    public List<Product> getAllProducts() {
        return products;
    }
    
    
    

    //Get product by ID
    public Product getProductById(int id) {

        for (Product p : products) {
            if (p.getProductId() == id) {
                return p;
            }
        }

        throw new ProductNotFoundException("Product not found with ID: " + id);
    }
    
    

    //Search products by partial name
    public List<Product> searchByName(String name) {

        List<Product> result = new ArrayList<>();

        for (Product p : products) {
            if (p.getProductName() != null && p.getProductName().toLowerCase().contains(name.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

    
    
    //Search products by category
    public List<Product> getProductsByCategory(String category) {

        List<Product> result = new ArrayList<>();

        for (Product p : products) {
            if (p.getCategory().equalsIgnoreCase(category)) {
                result.add(p);
            }
        }

        return result;
    }

    
    
    //Update complete product details
    public String updateProduct(int id, Product updated) {

        for (Product p : products) {
            if (p.getProductId() == id) {

                p.setProductName(updated.getProductName());
                p.setCategory(updated.getCategory());
                p.setStock(updated.getStock());
                p.setPrice(updated.getPrice());

                return "Product updated successfully";
            }
        }

        throw new ProductNotFoundException("Product not found with ID: " + id);
    }
    
    

    //Delete a product
    public String deleteProduct(int id) {

        boolean removed = products.removeIf(
                p -> p.getProductId() == id);

        if (removed) {
            return "Product deleted successfully";
        }

        throw new ProductNotFoundException("Product not found with ID: " + id);
    }

    
    
    //Find products with low stock (stock below 10)
    public List<Product> getLowStockProducts() {

        List<Product> result = new ArrayList<>();

        for (Product p : products) {
            if (p.getStock() < 10) {
                result.add(p);
            }
        }

        return result;
    }

    
    //Get products above a specified price
    public List<Product> getProductsAbovePrice(double price) {

        List<Product> result = new ArrayList<>();

        for (Product p : products) {
            if (p.getPrice() > price) {
                result.add(p);
            }
        }

        return result;
    }

    
    
    //Get total number of products
    public int getProductCount() {
        return products.size();
    }
}
