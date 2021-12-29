/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.entityrelationship;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kalsym
 */
@RestController
public class ProductController {

    @Autowired
    private ProductRepository repo;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getAll() {
        return repo.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestBody Product product) {
        product.getProductReviews().forEach(review -> review.setProduct(product));
        product.getProductVariants().forEach(variant -> variant.getProductVariantsAvailable().
                forEach(variantAvail -> variantAvail.setProductVariant(variant)));
        product.getProductVariants().forEach(variant -> variant.getProductVariantsAvailable().
                forEach(variantAvail -> variantAvail.setProduct(product)));
        product.getProductVariants().forEach(variant -> variant.setProduct(product));
        repo.save(product);
    }

}
