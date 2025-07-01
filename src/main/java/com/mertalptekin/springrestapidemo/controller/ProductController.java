package com.mertalptekin.springrestapidemo.controller;

import com.mertalptekin.springrestapidemo.entities.Product;
import com.mertalptekin.springrestapidemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // api/v1/products -> GET
    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
       List<Product> products = productRepository.findAll();
       return ResponseEntity.ok(products);
    }


    // api/products/v1/1 -> pathvariable
    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        Optional<Product> product = productRepository.findById(id);

        if(product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // api/products/v1
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        // save yoksa kaydeder varsa günceller
        productRepository.save(product);
        var uri =  URI.create("/api/products/v1/" + product.getId());
        return ResponseEntity.created(uri).build(); // 201 status code
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Product> delete(@PathVariable("id") Long id) {
        productRepository.deleteById(id);
        return ResponseEntity.noContent().build(); // 204
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> update(@PathVariable("id") Long id,@RequestBody Product product) {
        productRepository.save(product);
        return ResponseEntity.noContent().build(); // 204
    }

// Not: Create -> 201, GET,GETBYID 200, DELETE,PUT 204



}
