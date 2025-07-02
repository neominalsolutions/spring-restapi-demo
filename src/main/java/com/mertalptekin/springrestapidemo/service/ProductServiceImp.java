package com.mertalptekin.springrestapidemo.service;

import com.mertalptekin.springrestapidemo.dto.product.ProductCreateDto;
import com.mertalptekin.springrestapidemo.dto.product.ProductDetailDto;
import com.mertalptekin.springrestapidemo.dto.product.ProductListDto;
import com.mertalptekin.springrestapidemo.dto.product.ProductUpdateDto;
import com.mertalptekin.springrestapidemo.entities.Product;
import com.mertalptekin.springrestapidemo.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public Long create(ProductCreateDto dto) {
        Product product = new Product();
        // Beanleri kopyalama işlemi için kullandık.
        BeanUtils.copyProperties(dto, product);
        productRepository.save(product);
        return product.getId();
    }

    @Override
    public void update(Long id, ProductUpdateDto dto) {

        Optional<Product> product = productRepository.findById(id);
        Product p = productRepository.findById(id).orElseThrow(()-> new EntityNotFoundException());

        BeanUtils.copyProperties(dto, product);
        productRepository.save(p);

    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductListDto> find() {

      List<ProductListDto> response =  productRepository.findAll()
              .stream().map(product -> mapper.map(product, ProductListDto.class)).collect(Collectors.toList());

        return response;
    }

    @Override
    public ProductDetailDto findById(Long id) {
        Product p = productRepository.findById(id).orElseThrow(()-> new EntityNotFoundException());

        return mapper.map(p, ProductDetailDto.class);

    }
}
