package com.mertalptekin.springrestapidemo.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateDto {
    private Long id;
    private String productName;
    @JsonProperty("price")
    private BigDecimal unitPrice;
}
