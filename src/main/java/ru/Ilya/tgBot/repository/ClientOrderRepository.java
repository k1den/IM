package ru.Ilya.tgBot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.*;
import ru.Ilya.tgBot.entity.ClientOrder;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "clientOrders", path = "clientOrders")
public interface ClientOrderRepository extends JpaRepository<ClientOrder, Long>
{
    List<ClientOrder> findByClientId(Long id);

    ClientOrder findNewOrderByClientId(Long id);

    @Query("SELECT co FROM ClientOrder co WHERE co.client.externalId = :clientId ORDER BY co.id DESC")
    ClientOrder findLastOrderByClientId(@Param("clientId") Long clientId);

}