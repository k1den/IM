package ru.Ilya.tgBot.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.Ilya.tgBot.entity.Client;
import ru.Ilya.tgBot.entity.ClientOrder;
import ru.Ilya.tgBot.entity.Product;
import ru.Ilya.tgBot.repository.ClientOrderRepository;
import ru.Ilya.tgBot.repository.ClientRepository;
import ru.Ilya.tgBot.repository.OrderProductRepository;
import ru.Ilya.tgBot.repository.ProductRepository;

import java.util.*;

@Service
@Transactional
public class EntitiesServiceImpl implements EntitiesService {
    private final ProductRepository productRepository;
    private final OrderProductRepository orderProductRepository;
    private final ClientOrderRepository clientOrderRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public EntitiesServiceImpl(ProductRepository productRepository, ClientOrderRepository clientOrderRepository, OrderProductRepository orderProductRepository, ClientRepository clientRepository) {
        this.productRepository = productRepository;
        this.clientOrderRepository = clientOrderRepository;
        this.orderProductRepository = orderProductRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Product> getProductsByCategoryId(Long id) {
        return productRepository.findByCategoryId(id);
    }

    @Override
    public List<ClientOrder> getClientOrders(Long id) {
        return clientOrderRepository.findByClientId(id);
    }

    @Override
    public Set<Product> getClientProducts(Long id) {
        return orderProductRepository.findProductsByClientId(id);
    }

    @Override
    public List<Product> getTopPopularProducts(Integer limit) {
        PageRequest pageable = PageRequest.of(0, limit);
        return orderProductRepository.findMostPopularProducts(pageable);
    }

    @Override
    public List<Client> searchClientsByName(String name) {
        return clientRepository.searchClientsByName(name);
    }

    @Override
    public List<Product> searchProductsByName(String name) {
        return productRepository.searchProductsByName(name);
    }
}

