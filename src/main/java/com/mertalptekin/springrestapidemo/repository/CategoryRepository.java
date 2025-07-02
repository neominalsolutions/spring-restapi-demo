package com.mertalptekin.springrestapidemo.repository;

import com.mertalptekin.springrestapidemo.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long>{
      // isme göre
    Optional<Category> findByName(String name);

    // like sorgusu gibi name içinde geçenleri bulma
    List<Category> findByNameContaining(String name);

    // tersten sıralı getirme
    List<Category> findAllByOrderByNameAsc();

//    @Query(value = "select * from categories c where c.id= ?1",nativeQuery = true)
    @Query("from Category c where c.id = :id")
    Category findByCategoryId(@Param("id") Long id);

}
