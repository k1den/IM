package ru.Ilya.tgBot.rest;

import org.springframework.web.bind.annotation.*;
import ru.Ilya.tgBot.entity.Client;
import ru.Ilya.tgBot.entity.ClientOrder;
import ru.Ilya.tgBot.entity.Product;
import ru.Ilya.tgBot.service.EntitiesServiceImpl;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/rest/clients")
public class ClientsRestController  {
    private final EntitiesServiceImpl appService;

    public ClientsRestController (EntitiesServiceImpl appService) {
        this.appService = appService;
    }

    @GetMapping("/{id}/orders")
    public List<ClientOrder> getClientOrders(@PathVariable Long id) {
        return appService.getClientOrders(id);
    }

    @GetMapping("/{id}/products")
    public Set<Product> getProductsForClient(@PathVariable Long id) {
        return appService.getClientProducts(id);
    }

    @GetMapping("/search")
    public List<Client> getClientByName(@RequestParam String name){
        return appService.searchClientsByName(name);
    }
}
