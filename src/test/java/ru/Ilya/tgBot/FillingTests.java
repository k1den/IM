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
        product4.setName("Макидзуси");
        product4.setDescription("Один из самых популярных вариантов суши во всем мире, чье название в переводе означает катаные суши.");
        product4.setPrice(500.0);
        productRepository.save(product4);

        Product product14 = new Product();
        product14.setCategory(category3);
        product14.setName("Хосомаки");
        product14.setDescription("Это невероятно вкусный и простой в приготовлении низкокалорийный ролл с одним или двумя видами начинки.");
        product14.setPrice(600.0);
        productRepository.save(product14);

        Product product15 = new Product();
        product15.setCategory(category3);
        product15.setName("Футомаки ");
        product15.setDescription("Это один из самых больших роллов, внешне похожий на Макидзуси, с диаметром порции около 5 сантиметров и разнообразными начинками в различных комбинациях.");
        product15.setPrice(700.0);
        productRepository.save(product15);

        Product product5 = new Product();
        product5.setCategory(category4);
        product5.setName("Куриные роллы");
        product5.setDescription("Интересные на вкус, сытные, с большим количеством начинки!");
        product5.setPrice(550.0);
        productRepository.save(product5);

        Product product16 = new Product();
        product16.setCategory(category4);
        product16.setName("Мидийные роллы");
        product16.setDescription("Роллы с мидиями.");
        product16.setPrice(600.0);
        productRepository.save(product16);

        Product product17 = new Product();
        product17.setCategory(category4);
        product17.setName("Роллы с майонезом");
        product17.setDescription("Роллы с майонезом.");
        product17.setPrice(700.0);
        productRepository.save(product17);

        Product product6 = new Product();
        product6.setCategory(category5);
        product6.setName("Ролл с бананом и манго");
        product6.setDescription("Ролл с бананом и манго.");
        product6.setPrice(600.0);
        productRepository.save(product6);

        Product product18 = new Product();
        product18.setCategory(category5);
        product18.setName("Ролл с курагой");
        product18.setDescription("Ролл с курагой.");
        product18.setPrice(800.0);
        productRepository.save(product18);

        Product product19 = new Product();
        product19.setCategory(category5);
        product19.setName("Ролл с белым шоколадом и киви");
        product19.setDescription("Ролл с белым шоколадом и киви.");
        product19.setPrice(800.0);
        productRepository.save(product19);

        Product product7 = new Product();
        product7.setCategory(category6);
        product7.setName("Тити Оки");
        product7.setDescription("Тити Оки");
        product7.setPrice(1_599.0);
        productRepository.save(product7);

        Product product20 = new Product();
        product20.setCategory(category6);
        product20.setName("Тити Хаха");
        product20.setDescription("Тити Хаха");
        product20.setPrice(1_399.0);
        productRepository.save(product20);

        Product product21 = new Product();
        product21.setCategory(category6);
        product21.setName("Любовная любовь");
        product21.setDescription("Любовная любовь");
        product21.setPrice(4_399.0);
        productRepository.save(product21);

        //Бургеры
        Product product8 = new Product();
        product8.setCategory(category8);
        product8.setName("Гамбургер");
        product8.setDescription("Гамбургер");
        product8.setPrice(100.0);
        productRepository.save(product8);

        Product product22 = new Product();
        product22.setCategory(category8);
        product22.setName("Чизбургер");
        product22.setDescription("Чизбургер");
        product22.setPrice(150.0);
        productRepository.save(product22);

        Product product23 = new Product();
        product23.setCategory(category8);
        product23.setName("Чикен-бургер");
        product23.setDescription("Чикен-бургер");
        product23.setPrice(200.0);
        productRepository.save(product23);

        Product product9 = new Product();
        product9.setCategory(category9);
        product9.setName("Гамбургер с холопеньо");
        product9.setDescription("Гамбургер с холопеньо");
        product9.setPrice(150.0);
        productRepository.save(product9);

        Product product24 = new Product();
        product24.setCategory(category9);
        product24.setName("Чизбургер с холопеньо");
        product24.setDescription("Чизбургер с холопеньо");
        product24.setPrice(200.0);
        productRepository.save(product24);

        Product product25 = new Product();
        product25.setCategory(category9);
        product25.setName("Чикен-бургер с холопеньо");
        product25.setDescription("Чикен-бургер с холопеньо");
        product25.setPrice(250.0);
        productRepository.save(product25);

        //Напитки
        Product product10 = new Product();
        product10.setCategory(category11);
        product10.setName("Спрайт");
        product10.setDescription("Спрайт");
        product10.setPrice(200.0);
        productRepository.save(product10);

        Product product26 = new Product();
        product26.setCategory(category11);
        product26.setName("Фанта");
        product26.setDescription("Фанта");
        product26.setPrice(200.0);
        productRepository.save(product26);

        Product product27 = new Product();
        product27.setCategory(category11);
        product27.setName("Кола");
        product27.setDescription("Кола");
        product27.setPrice(250.0);
        productRepository.save(product27);

        Product product11 = new Product();
        product11.setCategory(category12);
        product11.setName("Redbull");
        product11.setDescription("Redbull");
        product11.setPrice(250.0);
        productRepository.save(product11);

        Product product28 = new Product();
        product28.setCategory(category12);
        product28.setName("Tornado");
        product28.setDescription("Tornado");
        product28.setPrice(100.0);
        productRepository.save(product28);

        Product product29 = new Product();
        product29.setCategory(category12);
        product29.setName("Flash");
        product29.setDescription("Flash");
        product29.setPrice(110.0);
        productRepository.save(product29);

        Product product12 = new Product();
        product12.setCategory(category13);
        product12.setName("Добрый");
        product12.setDescription("Добрый");
        product12.setPrice(100.0);
        productRepository.save(product12);

        Product product30 = new Product();
        product30.setCategory(category13);
        product30.setName("Злой");
        product30.setDescription("Злой");
        product30.setPrice(100.0);
        productRepository.save(product30);

        Product product31 = new Product();
        product31.setCategory(category13);
        product31.setName("Я");
        product31.setDescription("Я");
        product31.setPrice(100.0);
        productRepository.save(product31);

        Product product13 = new Product();
        product13.setCategory(category14);
        product13.setName("Вода с газом");
        product13.setDescription("Вода с газом");
        product13.setPrice(500.0);
        productRepository.save(product13);

        Product product32 = new Product();
        product32.setCategory(category14);
        product32.setName("Вода без газа");
        product32.setDescription("Вода беза газа");
        product32.setPrice(500.0);
        productRepository.save(product32);

        Product product33 = new Product();
        product33.setCategory(category14);
        product33.setName("Компот");
        product33.setDescription("Компот");
        product33.setPrice(500.0);
        productRepository.save(product33);
    }
}



