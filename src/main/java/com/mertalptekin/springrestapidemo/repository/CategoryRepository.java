package com.mertalptekin.springrestapidemo.repository;

import com.mertalptekin.springrestapidemo.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long>{
      // isme göre
    Optional<Category> findByName(String name);

    // like sorgusu gibi name içinde geçenleri bulma
    List<Category> findByNameContaining(String name);

    // tersten sıralı getirme
    List<Category> findAllByOrderByNameAsc();

}
