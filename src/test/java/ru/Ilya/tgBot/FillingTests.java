package ru.Ilya.tgBot;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import ru.Ilya.tgBot.entity.*;
import ru.Ilya.tgBot.repository.*;

import java.math.BigDecimal;

@SpringBootTest
class FillingTests
{
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderProductRepository orderProductRepository;
    @Autowired
    private ClientOrderRepository clientOrderRepository;

    @Test
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
    void createCategoriesAndProducts() {
        //Пицца
        Category pizza = new Category();
        pizza.setName("Пицца");
        pizza.setParent(null);
        categoryRepository.save(pizza);

        //Роллы
        Category rolls = new Category();
        rolls.setName("Роллы");
        rolls.setParent(null);
        categoryRepository.save(rolls);

        Category classic_rolls = new Category();
        classic_rolls.setName("Классические роллы");
        classic_rolls.setParent(rolls);
        categoryRepository.save(classic_rolls);

        Category baked_rolls = new Category();
        baked_rolls.setName("Запеченные роллы");
        baked_rolls.setParent(rolls);
        categoryRepository.save(baked_rolls);

        Category sweet_rolls = new Category();
        sweet_rolls.setName("Сладкие роллы");
        sweet_rolls.setParent(rolls);
        categoryRepository.save(sweet_rolls);

        Category sets = new Category();
        sets.setName("Наборы");
        sets.setParent(rolls);
        categoryRepository.save(sets);

        //Бургер
        Category burger = new Category();
        burger.setName("Бургер");
        burger.setParent(null);
        categoryRepository.save(burger);

        Category classic_burger = new Category();
        classic_burger.setName("Классические бургеры");
        classic_burger.setParent(burger);
        categoryRepository.save(classic_burger);

        Category spicy_burgers = new Category();
        spicy_burgers.setName("Острые бургеры");
        spicy_burgers.setParent(burger);
        categoryRepository.save(spicy_burgers);

        //Напитки
        Category drinks = new Category();
        drinks.setName("Напитки");
        drinks.setParent(null);
        categoryRepository.save(drinks);

        Category carbonated_drinks = new Category();
        carbonated_drinks.setName("Газированные напитки");
        carbonated_drinks.setParent(drinks);
        categoryRepository.save(carbonated_drinks);

        Category energy_drinks = new Category();
        energy_drinks.setName("Энергетические напитки");
        energy_drinks.setParent(drinks);
        categoryRepository.save(energy_drinks);

        Category juices = new Category();
        juices.setName("Соки");
        juices.setParent(drinks);
        categoryRepository.save(juices);

        Category other = new Category();
        other.setName("Другие");
        other.setParent(drinks);
        categoryRepository.save(other);

        //Пицца
        Product pepperoni = new Product();
        pepperoni.setCategory(pizza);
        pepperoni.setName("Пеперони");
        pepperoni.setDescription("Разновидность острой салями, приготовленной из вяленой свинины и говядины, приправленной паприкой и перцем чили");
        pepperoni.setPrice(BigDecimal.valueOf(150.0));
        productRepository.save(pepperoni);

        Product mexican = new Product();
        mexican.setCategory(pizza);
        mexican.setName("Мексиканская");
        mexican.setDescription("Острая пицца");
        mexican.setPrice(BigDecimal.valueOf(200.0));
        productRepository.save(mexican);

        Product pineapple = new Product();
        pineapple.setCategory(pizza);
        pineapple.setName("С ананасами");
        pineapple.setDescription("Пицца с ананасами");
        pineapple.setPrice(BigDecimal.valueOf(250.0));
        productRepository.save(pineapple);

        //Роллы
        Product makizushi = new Product();
        makizushi.setCategory(classic_rolls);
        makizushi.setName("Макидзуси");
        makizushi.setDescription("Один из самых популярных вариантов суши во всем мире, чье название в переводе означает катаные суши.");
        makizushi.setPrice(BigDecimal.valueOf(500.0));
        productRepository.save(makizushi);

        Product hosomaki = new Product();
        hosomaki.setCategory(classic_rolls);
        hosomaki.setName("Хосомаки");
        hosomaki.setDescription("Это невероятно вкусный и простой в приготовлении низкокалорийный ролл с одним или двумя видами начинки.");
        hosomaki.setPrice(BigDecimal.valueOf(600.0));
        productRepository.save(hosomaki);

        Product futomaki = new Product();
        futomaki.setCategory(classic_rolls);
        futomaki.setName("Футомаки");
        futomaki.setDescription("Это один из самых больших роллов, внешне похожий на Макидзуси, с диаметром порции около 5 сантиметров и разнообразными начинками в различных комбинациях.");
        futomaki.setPrice(BigDecimal.valueOf(700.0));
        productRepository.save(futomaki);

        Product chicken_rolls = new Product();
        chicken_rolls.setCategory(baked_rolls);
        chicken_rolls.setName("Куриные роллы");
        chicken_rolls.setDescription("Интересные на вкус, сытные, с большим количеством начинки!");
        chicken_rolls.setPrice(BigDecimal.valueOf(550.0));
        productRepository.save(chicken_rolls);

        Product mussel_rolls = new Product();
        mussel_rolls.setCategory(baked_rolls);
        mussel_rolls.setName("Мидийные роллы");
        mussel_rolls.setDescription("Роллы с мидиями.");
        mussel_rolls.setPrice(BigDecimal.valueOf(600.0));
        productRepository.save(mussel_rolls);

        Product rolls_with_mayonnaise = new Product();
        rolls_with_mayonnaise.setCategory(baked_rolls);
        rolls_with_mayonnaise.setName("Роллы с майонезом");
        rolls_with_mayonnaise.setDescription("Роллы с майонезом.");
        rolls_with_mayonnaise.setPrice(BigDecimal.valueOf(700.0));
        productRepository.save(rolls_with_mayonnaise);

        Product banana_and_mango_roll = new Product();
        banana_and_mango_roll.setCategory(sweet_rolls);
        banana_and_mango_roll.setName("Ролл с бананом и манго");
        banana_and_mango_roll.setDescription("Ролл с бананом и манго.");
        banana_and_mango_roll.setPrice(BigDecimal.valueOf(600.0));
        productRepository.save(banana_and_mango_roll);

        Product roll_with_dried_apricots = new Product();
        roll_with_dried_apricots.setCategory(sweet_rolls);
        roll_with_dried_apricots.setName("Ролл с курагой");
        roll_with_dried_apricots.setDescription("Ролл с курагой.");
        roll_with_dried_apricots.setPrice(BigDecimal.valueOf(800.0));
        productRepository.save(roll_with_dried_apricots);

        Product roll_with_white_chocolate_and_kiwi = new Product();
        roll_with_white_chocolate_and_kiwi.setCategory(sweet_rolls);
        roll_with_white_chocolate_and_kiwi.setName("Ролл с белым шоколадом и киви");
        roll_with_white_chocolate_and_kiwi.setDescription("Ролл с белым шоколадом и киви.");
        roll_with_white_chocolate_and_kiwi.setPrice(BigDecimal.valueOf(800.0));
        productRepository.save(roll_with_white_chocolate_and_kiwi);

        Product titi_oki = new Product();
        titi_oki.setCategory(sets);
        titi_oki.setName("Тити Оки");
        titi_oki.setDescription("Тити Оки");
        titi_oki.setPrice(BigDecimal.valueOf(1_599.0));
        productRepository.save(titi_oki);

        Product titi_haha = new Product();
        titi_haha.setCategory(sets);
        titi_haha.setName("Тити Хаха");
        titi_haha.setDescription("Тити Хаха");
        titi_haha.setPrice(BigDecimal.valueOf(1_399.0));
        productRepository.save(titi_haha);

        Product love_love = new Product();
        love_love.setCategory(sets);
        love_love.setName("Любовная любовь");
        love_love.setDescription("Любовная любовь");
        love_love.setPrice(BigDecimal.valueOf(4_399.0));
        productRepository.save(love_love);

        //Бургеры
        Product hamburger = new Product();
        hamburger.setCategory(classic_burger);
        hamburger.setName("Гамбургер");
        hamburger.setDescription("Гамбургер");
        hamburger.setPrice(BigDecimal.valueOf(100.0));
        productRepository.save(hamburger);

        Product cheeseburger = new Product();
        cheeseburger.setCategory(classic_burger);
        cheeseburger.setName("Чизбургер");
        cheeseburger.setDescription("Чизбургер");
        cheeseburger.setPrice(BigDecimal.valueOf(150.0));
        productRepository.save(cheeseburger);

        Product chicken_burger = new Product();
        chicken_burger.setCategory(classic_burger);
        chicken_burger.setName("Чикен-бургер");
        chicken_burger.setDescription("Чикен-бургер");
        chicken_burger.setPrice(BigDecimal.valueOf(200.0));
        productRepository.save(chicken_burger);

        Product hamburger_o = new Product();
        hamburger_o.setCategory(spicy_burgers);
        hamburger_o.setName("Гамбургер с холопеньо");
        hamburger_o.setDescription("Гамбургер с холопеньо");
        hamburger_o.setPrice(BigDecimal.valueOf(150.0));
        productRepository.save(hamburger_o);

        Product cheeseburger_o = new Product();
        cheeseburger_o.setCategory(spicy_burgers);
        cheeseburger_o.setName("Чизбургер с холопеньо");
        cheeseburger_o.setDescription("Чизбургер с холопеньо");
        cheeseburger_o.setPrice(BigDecimal.valueOf(200.0));
        productRepository.save(cheeseburger_o);

        Product chicken_burger_o = new Product();
        chicken_burger_o.setCategory(spicy_burgers);
        chicken_burger_o.setName("Чикен-бургер с холопеньо");
        chicken_burger_o.setDescription("Чикен-бургер с холопеньо");
        chicken_burger_o.setPrice(BigDecimal.valueOf(250.0));
        productRepository.save(chicken_burger_o);

        //Напитки
        Product sprite = new Product();
        sprite.setCategory(carbonated_drinks);
        sprite.setName("Спрайт");
        sprite.setDescription("Спрайт");
        sprite.setPrice(BigDecimal.valueOf(200.0));
        productRepository.save(sprite);

        Product fanta = new Product();
        fanta.setCategory(carbonated_drinks);
        fanta.setName("Фанта");
        fanta.setDescription("Фанта");
        fanta.setPrice(BigDecimal.valueOf(200.0));
        productRepository.save(fanta);

        Product cola = new Product();
        cola.setCategory(carbonated_drinks);
        cola.setName("Кола");
        cola.setDescription("Кола");
        cola.setPrice(BigDecimal.valueOf(250.0));
        productRepository.save(cola);

        Product redbull = new Product();
        redbull.setCategory(energy_drinks);
        redbull.setName("Redbull");
        redbull.setDescription("Redbull");
        redbull.setPrice(BigDecimal.valueOf(250.0));
        productRepository.save(redbull);

        Product tornado = new Product();
        tornado.setCategory(energy_drinks);
        tornado.setName("Tornado");
        tornado.setDescription("Tornado");
        tornado.setPrice(BigDecimal.valueOf(100.0));
        productRepository.save(tornado);

        Product flash = new Product();
        flash.setCategory(energy_drinks);
        flash.setName("Flash");
        flash.setDescription("Flash");
        flash.setPrice(BigDecimal.valueOf(110.0));
        productRepository.save(flash);

        Product kind = new Product();
        kind.setCategory(juices);
        kind.setName("Добрый");
        kind.setDescription("Добрый");
        kind.setPrice(BigDecimal.valueOf(100.0));
        productRepository.save(kind);

        Product evil = new Product();
        evil.setCategory(juices);
        evil.setName("Злой");
        evil.setDescription("Злой");
        evil.setPrice(BigDecimal.valueOf(100.0));
        productRepository.save(evil);

        Product im = new Product();
        im.setCategory(juices);
        im.setName("Я");
        im.setDescription("Я");
        im.setPrice(BigDecimal.valueOf(100.0));
        productRepository.save(im);

        Product water_g = new Product();
        water_g.setCategory(other);
        water_g.setName("Вода с газом");
        water_g.setDescription("Вода с газом");
        water_g.setPrice(BigDecimal.valueOf(500.0));
        productRepository.save(water_g);

        Product water = new Product();
        water.setCategory(other);
        water.setName("Вода без газа");
        water.setDescription("Вода беза газа");
        water.setPrice(BigDecimal.valueOf(500.0));
        productRepository.save(water);

        Product compote = new Product();
        compote.setCategory(other);
        compote.setName("Компот");
        compote.setDescription("Компот");
        compote.setPrice(BigDecimal.valueOf(500.0));
        productRepository.save(compote);
    }

    @Test
    void addOrdersForClients() {
        // Предполагаем, что клиенты и продукты уже созданы и сохранены в базе данных
        // Получаем клиентов по их externalId
        Client client1 = clientRepository.findByExternalId(1L);
        Client client2 = clientRepository.findByExternalId(2L);

        // Создаем заказы для каждого клиента
        ClientOrder order1 = new ClientOrder();
        order1.setClient(client1);
        order1.setStatus(1); // Пример статуса заказа
        order1.setTotal(new BigDecimal("1000.00")); // Пример общей суммы заказа
        clientOrderRepository.save(order1);

        ClientOrder order2 = new ClientOrder();
        order2.setClient(client2);
        order2.setStatus(1); // Пример статуса заказа
        order2.setTotal(new BigDecimal("1500.00")); // Пример общей суммы заказа
        clientOrderRepository.save(order2);

        // Предполагаем, что продукты уже созданы и сохранены в базе данных
        // Получаем продукты по их названиям
        Product product1 = productRepository.findByName("Пеперони");
        Product product2 = productRepository.findByName("Макидзуси");

        // Добавляем продукты в заказы
        OrderProduct orderProduct1 = new OrderProduct();
        orderProduct1.setClientOrder(order1);
        orderProduct1.setProduct(product1);
        orderProduct1.setCountProduct(1); // Количество продукта в заказе
        orderProductRepository.save(orderProduct1);

        OrderProduct orderProduct2 = new OrderProduct();
        orderProduct2.setClientOrder(order2);
        orderProduct2.setProduct(product2);
        orderProduct2.setCountProduct(1); // Количество продукта в заказе
        orderProductRepository.save(orderProduct2);
    }

}