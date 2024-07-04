package ru.Ilya.tgBot;

import jakarta.transaction.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import ru.Ilya.tgBot.entity.Category;
import ru.Ilya.tgBot.entity.Client;
import ru.Ilya.tgBot.entity.Product;
import ru.Ilya.tgBot.repository.CategoryRepository;
import ru.Ilya.tgBot.repository.ClientRepository;
import ru.Ilya.tgBot.repository.ProductRepository;

@SpringBootTest
class FillingTests
{
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional
    void createTwoClients(){
        Client client1 = new Client();
        client1.setAddress("address1");
        client1.setExternalId(1L);
        client1.setPhoneNumber("111-111-111");
        client1.setFullName("fullName1");
        clientRepository.save(client1);

        Client client2 = new Client();
        client2.setAddress("address2");
        client2.setExternalId(2L);
        client2.setPhoneNumber("222-222-222");
        client2.setFullName("fullName2");
        clientRepository.save(client2);
    }
    
    @Test
    @Transactional
    void createCategoriesAndProducts() {
        //Пицца
        Category category1 = new Category();
        category1.setName("Пицца");
        categoryRepository.save(category1);

        Product product1 = new Product();
        product1.setCategory(category1);
        product1.setName("Пицца");
        product1.setDescription("Вкусная пицца пеперони");
        product1.setPrice(1000.0);
        productRepository.save(product1);

        //Роллы
        Category category2 = new Category();
        category2.setName("Роллы");
        categoryRepository.save(category2);

        Product product2 = new Product();
        product2.setCategory(category2);
        product2.setName("Классические роллы");
        product2.setDescription("Вкусные классические роллы");
        product2.setPrice(1001.0);
        productRepository.save(product2);

        Product product3 = new Product();
        product3.setCategory(category2);
        product3.setName("Запеченные роллы");
        product3.setDescription("Вкусные запеченные роллы");
        product3.setPrice(10000.0);
        productRepository.save(product3);

        Product product4 = new Product();
        product4.setCategory(category2);
        product4.setName("Сладкие роллы");
        product4.setDescription("Вкусные сладкие роллы");
        product4.setPrice(1002.0);
        productRepository.save(product4);

        Product product5 = new Product();
        product5.setCategory(category2);
        product5.setName("Наборы");
        product5.setDescription("Вкусные наборы");
        product5.setPrice(1003.0);
        productRepository.save(product5);

        //Бургер
        Category category3 = new Category();
        category3.setName("Бургер");
        categoryRepository.save(category3);

        Product product6 = new Product();
        product6.setCategory(category3);
        product6.setName("Классические бургеры");
        product6.setDescription("Вкусные классические бургеры");
        product6.setPrice(1200.0);
        productRepository.save(product6);

        Product product7 = new Product();
        product7.setCategory(category3);
        product7.setName("Острые бургеры");
        product7.setDescription("Вкусные острые бургеры");
        product7.setPrice(1250.0);
        productRepository.save(product7);

        //Напитки
        Category category4 = new Category();
        category4.setName("Напитки");
        categoryRepository.save(category4);

        Product product8 = new Product();
        product8.setCategory(category4);
        product8.setName("Газированные напитки");
        product8.setDescription("Вкусные газированные напитки");
        product8.setPrice(130.0);
        productRepository.save(product8);

        Product product9 = new Product();
        product9.setCategory(category4);
        product9.setName("Энергетические напитки");
        product9.setDescription("Вкусные энергетические напитки");
        product9.setPrice(150.0);
        productRepository.save(product9);

        Product product10 = new Product();
        product10.setCategory(category4);
        product10.setName("Соки");
        product10.setDescription("Вкусные соки");
        product10.setPrice(160.0);
        productRepository.save(product10);

        Product product11 = new Product();
        product11.setCategory(category4);
        product11.setName("Другие");
        product11.setDescription("Вкусные другие");
        product11.setPrice(160.0);
        productRepository.save(product11);
    }
}

