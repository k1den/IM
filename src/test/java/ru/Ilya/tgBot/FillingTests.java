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
        client1.setAddress("Симферополь");
        client1.setExternalId(1L);
        client1.setPhoneNumber("89780010101");
        client1.setFullName("Клочков Богдан Константинович");
        clientRepository.save(client1);

        Client client2 = new Client();
        client2.setAddress("Севастополь");
        client2.setExternalId(2L);
        client2.setPhoneNumber("89780020202");
        client2.setFullName("Лапицкая Мария Романовна");
        clientRepository.save(client2);
    }

    @Test
    @Transactional
    void createCategoriesAndProducts() {
        //Пицца
        Category category1 = new Category();
        category1.setName("Пицца");
        category1.setParent(null);
        categoryRepository.save(category1);

        //Роллы
        Category category2 = new Category();
        category2.setName("Роллы");
        category2.setParent(null);
        categoryRepository.save(category2);

        Category category3 = new Category();
        category3.setName("Классические роллы");
        category3.setParent(category2);
        categoryRepository.save(category3);

        Category category4 = new Category();
        category4.setName("Запеченные роллы");
        category4.setParent(category2);
        categoryRepository.save(category4);

        Category category5 = new Category();
        category5.setName("Сладкие роллы");
        category5.setParent(category2);
        categoryRepository.save(category5);

        Category category6 = new Category();
        category6.setName("Наборы");
        category6.setParent(category2);
        categoryRepository.save(category6);

        //Бургер
        Category category7 = new Category();
        category7.setName("Бургер");
        category7.setParent(null);
        categoryRepository.save(category7);

        Category category8 = new Category();
        category8.setName("Классические бургеры");
        category8.setParent(category7);
        categoryRepository.save(category8);

        Category category9 = new Category();
        category9.setName("Острые бургеры");
        category9.setParent(category7);
        categoryRepository.save(category9);

        //Напитки
        Category category10 = new Category();
        category10.setName("Напитки");
        category10.setParent(null);
        categoryRepository.save(category10);

        Category category11 = new Category();
        category11.setName("Газированные напитки");
        category11.setParent(category10);
        categoryRepository.save(category11);

        Category category12 = new Category();
        category12.setName("Энергетические напитки");
        category12.setParent(category10);
        categoryRepository.save(category12);

        Category category13 = new Category();
        category13.setName("Соки");
        category13.setParent(category10);
        categoryRepository.save(category13);

        Category category14 = new Category();
        category14.setName("Другие");
        category14.setParent(category10);
        categoryRepository.save(category14);

        //Пицца
        Product product1 = new Product();
        product1.setCategory(category1);
        product1.setName("Пеперони");
        product1.setDescription("Разновидность острой салями, приготовленной из вяленой свинины и говядины, приправленной паприкой и перцем чили");
        product1.setPrice(150.0);
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setCategory(category1);
        product2.setName("Мексиканская");
        product2.setDescription("Острая пицца");
        product2.setPrice(200.0);
        productRepository.save(product2);

        Product product3 = new Product();
        product3.setCategory(category1);
        product3.setName("С ананасами");
        product3.setDescription("Пицца с ананасами");
        product3.setPrice(250.0);
        productRepository.save(product3);

        //Роллы
        Product product4 = new Product();
        product4.setCategory(category3);
        product4.setName("Классические роллы");
        product4.setDescription("Роллы с красной рыбой");
        product4.setPrice(500.0);
        productRepository.save(product4);

        Product product5 = new Product();
        product5.setCategory(category4);
        product5.setName("Запеченные роллы");
        product5.setDescription("Роллы из духовки");
        product5.setPrice(550.0);
        productRepository.save(product5);

        Product product6 = new Product();
        product6.setCategory(category5);
        product6.setName("Сладкие роллы");
        product6.setDescription("Роллы с кислосладким соусом");
        product6.setPrice(600.0);
        productRepository.save(product6);

        Product product7 = new Product();
        product7.setCategory(category6);
        product7.setName("Наборы");
        product7.setDescription("Разные наборы");
        product7.setPrice(1200.0);
        productRepository.save(product7);

        //Бургеры
        Product product8 = new Product();
        product8.setCategory(category8);
        product8.setName("Классические бургеры");
        product8.setDescription("Две булки, котлета");
        product8.setPrice(100.0);
        productRepository.save(product8);

        Product product9 = new Product();
        product9.setCategory(category9);
        product9.setName("Острые бургеры");
        product9.setDescription("Бургер с холопеньо");
        product9.setPrice(150.0);
        productRepository.save(product9);

        //Напитки
        Product product10 = new Product();
        product10.setCategory(category11);
        product10.setName("Газированные напитки");
        product10.setDescription("Кола, спрайт, фанта");
        product10.setPrice(200.0);
        productRepository.save(product10);

        Product product11 = new Product();
        product11.setCategory(category12);
        product11.setName("Энергетические напитки");
        product11.setDescription("Redbull, tornado");
        product11.setPrice(250.0);
        productRepository.save(product11);

        Product product12 = new Product();
        product12.setCategory(category13);
        product12.setName("Соки");
        product12.setDescription("Добрый, дивный сад");
        product12.setPrice(100.0);
        productRepository.save(product12);

        Product product13 = new Product();
        product13.setCategory(category13);
        product13.setName("Другие");
        product13.setDescription("Алкоголь");
        product13.setPrice(500.0);
        productRepository.save(product13);
    }
}



