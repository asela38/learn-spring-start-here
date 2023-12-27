package services;

import models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServices {
    private final List<Product> products = new ArrayList<>();

    public boolean add(Product product) {
        return products.add(product);
    }

    public List<Product> findAll() {
        return products;
    }
}
