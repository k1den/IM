package ru.Ilya.tgBot.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.*;
import ru.Ilya.tgBot.entity.OrderProduct;
import ru.Ilya.tgBot.entity.Product;

import java.util.List;
import java.util.Set;

@RepositoryRestResource(collectionResourceRel = "orderProducts", path = "orderProducts")
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long>
{
    @Query("select op.product from OrderProduct op where op.clientOrder.client.id = :clientId")
    Set<Product> findProductsByClientId(@Param("clientId") Long id);

    @Query("select op.product from OrderProduct op group by op.product order by sum(op.countProduct) desc")
    List<Product> findMostPopularProducts(PageRequest pageable);
}