package ru.Ilya.tgBot.rest;

import org.springframework.web.bind.annotation.*;
import ru.Ilya.tgBot.entity.Client;
import ru.Ilya.tgBot.entity.Product;
import ru.Ilya.tgBot.service.EntitiesServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/rest/products")
public class ProductsRestController  {
    private final EntitiesServiceImpl appService;

    public ProductsRestController (EntitiesServiceImpl appService) {
        this.appService = appService;
    }

    @GetMapping(value = "/search", params = "categoryId")
    public List<Product> getProductsByCategory(@RequestParam Long categoryId) {
        return appService.getProductsByCategoryId(categoryId);
    }

    @GetMapping("/popular")
    public List<Product> getPopularProducts(Integer limit) {
        return appService.getTopPopularProducts(limit);
    }

    @GetMapping(value = "/search", params = "name")
    public List<Product> getProductByName(@RequestParam String name) {
        return appService.searchProductsByName(name);
    }
}
