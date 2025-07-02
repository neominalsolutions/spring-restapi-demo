package com.mertalptekin.springrestapidemo.service;

import com.mertalptekin.springrestapidemo.dto.product.ProductCreateDto;
import com.mertalptekin.springrestapidemo.dto.product.ProductDetailDto;
import com.mertalptekin.springrestapidemo.dto.product.ProductListDto;
import com.mertalptekin.springrestapidemo.dto.product.ProductUpdateDto;

import java.util.List;

public interface IProductService {

    Long create(ProductCreateDto dto);
    void update(Long id,ProductUpdateDto dto);
    void delete(Long id);
    List<ProductListDto> find();
    ProductDetailDto findById(Long id);

}
