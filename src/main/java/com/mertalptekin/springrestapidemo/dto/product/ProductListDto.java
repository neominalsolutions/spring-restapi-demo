package com.mertalptekin.springrestapidemo.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductListDto {
    private Long id;
    private String productName;
    private BigDecimal unitPrice;
    private Integer unitsinStock;
}
