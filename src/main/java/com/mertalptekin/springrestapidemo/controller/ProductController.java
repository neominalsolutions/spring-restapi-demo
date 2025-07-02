package com.mertalptekin.springrestapidemo.controller;

import com.mertalptekin.springrestapidemo.dto.product.ProductCreateDto;
import com.mertalptekin.springrestapidemo.dto.product.ProductDetailDto;
import com.mertalptekin.springrestapidemo.dto.product.ProductListDto;
import com.mertalptekin.springrestapidemo.entities.Product;
import com.mertalptekin.springrestapidemo.repository.ProductRepository;
import com.mertalptekin.springrestapidemo.service.IProductService;
import jakarta.validation.Valid;
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

    @Autowired
    private IProductService productService;


    // api/v1/products -> GET
    @GetMapping
    public ResponseEntity<List<ProductListDto>> getProducts() {
       List<ProductListDto> products = productService.find();
       return ResponseEntity.ok(products);
    }


    // api/products/v1/1 -> pathvariable
    @GetMapping("{id}")
    public ResponseEntity<ProductDetailDto> getProduct(@PathVariable("id") Long id) {
        ProductDetailDto response = productService.findById(id);
        return ResponseEntity.ok(response);

    }

    // api/products/v1
    @PostMapping
    public ResponseEntity create(@Valid @RequestBody ProductCreateDto product) {
        // save yoksa kaydeder varsa günceller
        Long Id = productService.create(product);
        var uri =  URI.create("/api/products/v1/" + Id);
        return ResponseEntity.created(uri).build(); // 201 status code
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build(); // 204
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id,@RequestBody Product product) {
        productRepository.save(product);
        return ResponseEntity.noContent().build(); // 204
    }

// Not: Create -> 201, GET,GETBYID 200, DELETE,PUT 204



}
