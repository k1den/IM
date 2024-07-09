package ru.Ilya.tgBot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.*;
import ru.Ilya.tgBot.entity.Client;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "clients", path = "clients")
public interface ClientRepository extends JpaRepository<Client, Long>
{

    @Query("select c from Client c where lower(c.fullName) like lower(concat('%', :name, '%'))")
    List<Client> searchClientsByName(@Param("name") String name);

    Client findByExternalId(long l);
}