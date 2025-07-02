package com.mertalptekin.springrestapidemo.dto.category;

import com.mertalptekin.springrestapidemo.dto.product.ProductListDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private Long id;
    private String name;
    private List<ProductListDto> products;
}
