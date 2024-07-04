package ru.Ilya.tgBot;

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
    void createCategoriesAndProducts() {
        Category pizza = new Category();
        pizza.setName("Пицца");
        pizza.setParent("Пицца");
        categoryRepository.save(pizza);

        Category roll1 = new Category();
        roll1.setName("Классические роллы");
        roll1.setParent("Роллы");
        categoryRepository.save(roll1);
        Category roll2 = new Category();
        roll2.setName("Запеченные роллы");
        roll2.setParent("Роллы");
        categoryRepository.save(roll2);
        Category roll3 = new Category();
        roll3.setName("Сладкие роллы");
        roll3.setParent("Роллы");
        categoryRepository.save(roll3);
        Category roll4 = new Category();
        roll4.setName("Наборы");
        roll4.setParent("Роллы");
        categoryRepository.save(roll4);

        Category burger1 = new Category();
        burger1.setName("Классические бургеры");
        burger1.setParent("Бургер");
        categoryRepository.save(burger1);
        Category burger2 = new Category();
        burger2.setName("Острые бургеры");
        burger2.setParent("Бургер");
        categoryRepository.save(burger2);

        Category drinks1 = new Category();
        drinks1.setName("Газированные напитки");
        drinks1.setParent("Напитки");
        categoryRepository.save(drinks1);
        Category drinks2 = new Category();
        drinks2.setName("Энергетические напитки");
        drinks2.setParent("Напитки");
        categoryRepository.save(drinks2);
        Category drinks3 = new Category();
        drinks3.setName("Соки");
        drinks3.setParent("Напитки");
        categoryRepository.save(drinks3);
        Category drinks4 = new Category();
        drinks4.setName("Другие");
        drinks4.setParent("Напитки");
        categoryRepository.save(drinks4);


    }
}

