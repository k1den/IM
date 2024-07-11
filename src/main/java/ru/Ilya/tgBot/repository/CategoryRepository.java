package ru.Ilya.tgBot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.Ilya.tgBot.entity.Category;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT c FROM Category c WHERE c.parent IS NULL")
    List<Category> findCategoriesByParentIdIsNull();

    @Query("SELECT c FROM Category c WHERE c.parent.id = :parentId")
    List<Category> findCategoriesByParentId(@Param("parentId") Long parentId);

    @Query("SELECT c FROM Category c WHERE c.name = :name")
    Category findByName(@Param("name") String name);

    @Query("SELECT c FROM Category c WHERE c.parent.id = :parentId")
    List<Category> findSubcategoriesByParentId(@Param("parentId") Long parentId);
}