package controllers;

import models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import services.ProductServices;

@Controller
public class ProductController {

    private final ProductServices productServices;

    @Autowired
    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }

    @GetMapping(value = "/products")
    public String viewProducts(Model model) {
        model.addAttribute("products", productServices.findAll());
        return "products.html";
    }

    @PostMapping(value = "/products")
    public String addProduct(Product product,
            Model model) {
        productServices.add(product);

        model.addAttribute("products", productServices.findAll());
        return "products.html";
    }
}
