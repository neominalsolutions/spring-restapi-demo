package com.mertalptekin.springrestapidemo.controller;

import com.mertalptekin.springrestapidemo.dto.category.CategoryDto;
import com.mertalptekin.springrestapidemo.dto.product.ProductListDto;
import com.mertalptekin.springrestapidemo.entities.Category;
import com.mertalptekin.springrestapidemo.repository.CategoryRepository;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper mapper;

    // kategori nesnesini ürünler ile birlikte getirme.
    @GetMapping
    public ResponseEntity getCategoryWithProducts(@PathVariable("id") Long id) {

        Optional<Category> c = categoryRepository.findById(id);
        if(c.isPresent()){
            // LAZY EGEAR davranışını görmek için yaptık.
           CategoryDto categoryDto =  mapper.map(c.get(), CategoryDto.class);
           return ResponseEntity.ok(categoryDto);
        }
        return ResponseEntity.ok().build();
    }

}
