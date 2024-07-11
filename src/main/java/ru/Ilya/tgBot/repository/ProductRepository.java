package ru.Ilya.tgBot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.*;
import ru.Ilya.tgBot.entity.Category;
import ru.Ilya.tgBot.entity.Product;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository extends JpaRepository<Product, Long>
{
    List<Product> findByCategoryId(Long categoryId);

    @Query("select p from Product p where p.name like lower(concat('%', :name, '%'))")
    List<Product> searchProductsByName(@Param("name") String name);


    Product findByName(String пеперони);

    List<Product> findProductsByCategoryName(String userText);

    @Query("SELECT p FROM Product p WHERE p.category = :category")
    List<Product> findByCategory(@Param("category") Category category);

    @Query("SELECT p FROM Product p WHERE p.id = :productId")
    Product getProductById(@Param("productId") int productId);

    Product findProductById(int productId);
}
