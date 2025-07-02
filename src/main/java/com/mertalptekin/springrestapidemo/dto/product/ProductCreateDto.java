package com.mertalptekin.springrestapidemo.dto.product;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateDto {

    // @NotNull(message = "ProductName null geçilemez")    // NULL
    @NotBlank(message = "ProductName boşluklu geçilemez") // "   "
    @NotEmpty(message = "ProductName boş bırakılamaz")   //   ""
    @Size(min = 3,max = 10, message = "En fazla 10 karakter girilebilir")
    private String productName;

    @NotNull(message = "Fiyat bilgisi giriniz")
    @Positive(message = "Fiyat Negatif değer olamaz")
    private BigDecimal unitPrice;

    @NotNull(message = "Stok bilgisi giriniz")
//    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$",message = "bu formata olmalıdır")
    private Integer unitsinStock;
}
