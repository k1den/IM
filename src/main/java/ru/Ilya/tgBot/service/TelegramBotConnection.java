package ru.Ilya.tgBot.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import ru.Ilya.tgBot.entity.*;
import ru.Ilya.tgBot.repository.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TelegramBotConnection {
    private Map<Long, Integer> userStates = new HashMap<>();
    Map<Long, List<Product>> selectedProducts = new HashMap<>();
    private class TelegramUpdatesListener implements UpdatesListener {
        @Override
        public int process(List<Update> updates) {
            updates.forEach(this::processUpdate);
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        }

        private void processUpdate(Update update) {
            if (update.callbackQuery() != null) {
                String callbackData = update.callbackQuery().data();
                Long chatId = update.callbackQuery().message().chat().id();
                handleCallback(callbackData, chatId);
            } else {
                String userText = update.message().text();
                Long chatId = update.message().chat().id();
                Integer state = userStates.getOrDefault(chatId, 0);
                switch (state) {
                    case 0 -> {
                        if (userText.startsWith("/start") && !userText.startsWith("Инфо:")) {
                            SendMessage simpleMessage = new SendMessage(update.message().chat().id(), "Привет! Это Телеграм-бот для автоматизации службы доставки");
                            bot.execute(simpleMessage);
                            SendMessage clientsMessage = new SendMessage(update.message().chat().id(), "Введите данные пользователя:\n\n" +
                                    "Учтите!!!\n\n Формат: 'Инфо: ФИО, номер, адрес'");
                            bot.execute(clientsMessage);
                        } else if (userText.startsWith("Инфо: ")) {
                            String[] userData = userText.substring("Инфо: ".length()).split(", ");
                            if (userData.length >= 3) {
                                Client client = new Client();
                                client.setExternalId(chatId);
                                client.setFullName(userData[0]);
                                client.setPhoneNumber(userData[1]);
                                client.setAddress(userData[2]);
                                clientRepository.save(client);

                                ClientOrder clientOrder = new ClientOrder();
                                clientOrder.setClient(client);
                                clientOrder.setStatus(1);
                                clientOrder.setTotal(BigDecimal.valueOf(0));
                                clientOrderRepository.save(clientOrder);
                                SendMessage message = new SendMessage(chatId, "Данные успешно записаны");
                                bot.execute(message);
                                List<KeyboardButton> categories = categoryRepository.findCategoriesByParentIdIsNull()
                                        .stream()
                                        .map(category -> new KeyboardButton(category.getName()))
                                        .collect(Collectors.toList());
                                ReplyKeyboardMarkup markup = new
                                        ReplyKeyboardMarkup(categories.toArray(KeyboardButton[]::new));
                                markup.resizeKeyboard(true);
                                markup.addRow(new KeyboardButton("Оформить заказ"));
                                markup.addRow(new KeyboardButton("В основное меню"));
                                bot.execute(new SendMessage(update.message().chat().id(),
                                        "Товары").replyMarkup(markup));
                                userStates.put(chatId, 1);
                            } else if (!userText.startsWith("Инфо: ") || !userText.startsWith("/start")) {
                                SendMessage errorMessage = new SendMessage(chatId, "Неверный формат ввода. Пожалуйста, введите данные в следующем формате: <Имя; Адрес; Номер>.");
                                bot.execute(errorMessage);
                                SendMessage retryMessage = new SendMessage(chatId, "Введите данные пользователя заново:");
                                bot.execute(retryMessage);
                            }
                        }
                    }
                    case 1 -> {
                        switch (userText) {
                            case "Пицца",
                                 "Классические роллы", "Запеченные роллы", "Сладкие роллы", "Наборы",
                                 "Классические бургеры", "Острые бургеры",
                                 "Газированные напитки", "Энергетические напитки", "Соки", "Другие" -> {
                                List<Product> products = entitiesService.getCategoryProducts(userText);
                                InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
                                for (Product product: products){
                                    InlineKeyboardButton button = new
                                            InlineKeyboardButton(String.format("Товар %s. Цена %.2f руб.",
                                            product.getName(), product.getPrice()))
                                            .callbackData(String.format("product:%d:%s", product.getId(), userText)); // добавляем информацию о категории товара в callbackData
                                    markup.addRow(button);
                                }
                                bot.execute(new SendMessage(update.message().chat().id(),
                                        "Товары").replyMarkup(markup));
                            }
                            case "Роллы" -> {
                                List<KeyboardButton> categories = categoryRepository.findCategoriesByParentId(2L)
                                        .stream()
                                        .map(category -> new KeyboardButton(category.getName()))
                                        .collect(Collectors.toList());
                                ReplyKeyboardMarkup markup = new
                                        ReplyKeyboardMarkup(categories.toArray(KeyboardButton[]::new));
                                markup.resizeKeyboard(true);
                                markup.addRow(new KeyboardButton("Оформить заказ"));
                                markup.addRow(new KeyboardButton("В основное меню"));
                                bot.execute(new SendMessage(update.message().chat().id(),
                                        "Товары").replyMarkup(markup));
                            }
                            case "Бургер" -> {
                                List<KeyboardButton> categories = categoryRepository.findCategoriesByParentId(7L)
                                        .stream()
                                        .map(category -> new KeyboardButton(category.getName()))
                                        .collect(Collectors.toList());
                                ReplyKeyboardMarkup markup = new
                                        ReplyKeyboardMarkup(categories.toArray(KeyboardButton[]::new));
                                markup.resizeKeyboard(true);
                                markup.addRow(new KeyboardButton("Оформить заказ"));
                                markup.addRow(new KeyboardButton("В основное меню"));
                                bot.execute(new SendMessage(update.message().chat().id(),
                                        "Товары").replyMarkup(markup));
                            }
                            case "Напитки" -> {
                                List<KeyboardButton> categories = categoryRepository.findCategoriesByParentId(10L)
                                        .stream()
                                        .map(category -> new KeyboardButton(category.getName()))
                                        .collect(Collectors.toList());
                                ReplyKeyboardMarkup markup = new
                                        ReplyKeyboardMarkup(categories.toArray(KeyboardButton[]::new));
                                markup.resizeKeyboard(true);
                                markup.addRow(new KeyboardButton("Оформить заказ"));
                                markup.addRow(new KeyboardButton("В основное меню"));
                                bot.execute(new SendMessage(update.message().chat().id(),
                                        "Товары").replyMarkup(markup));
                            }
                            case "В основное меню" -> {
                                List<KeyboardButton> categories = categoryRepository.findCategoriesByParentIdIsNull()
                                        .stream()
                                        .map(category -> new KeyboardButton(category.getName())).toList();

                                defaultMessage(update, categories);
                            }
                            case "Оформить заказ" -> {
                                sendOrderSummaryMessage(update.message().chat().id());
                            }
                            default -> {

                            }
                        }
                    }
                }
            }
        }

        private void defaultMessage(Update update, List<KeyboardButton> categories) {
            ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup(categories.toArray(KeyboardButton[]::new));
            markup.resizeKeyboard(true);
            new KeyboardButton("Оформить заказ");
            markup.addRow(new KeyboardButton("В основное меню"));
            bot.execute(new SendMessage(update.message().chat().id(),
                    "Товары").replyMarkup(markup));
        }
        void handleCallback(String callbackData, long chatId) {
            if (callbackData.startsWith("product:")) {
                String[] callbackParts = callbackData.replace("product:", "").split(":");
                int productId = Integer.parseInt(callbackParts[0]);
                String productCategory = callbackParts[1]; // получаем категорию товара

                Product selectedProduct = entitiesService.getProductById(productId);

                List<Product> products = selectedProducts.getOrDefault(chatId, new ArrayList<>());
                products.add(selectedProduct);
                selectedProducts.put(chatId, products);

                bot.execute(new SendMessage(chatId, "Товар " + selectedProduct.getName() + " из категории " + productCategory + " добавлен в заказ."));
            }
        }
        void sendOrderSummaryMessage(long chatId) {
            List<Product> products = selectedProducts.getOrDefault(chatId, new ArrayList<>());
            if (!products.isEmpty()) {
                StringBuilder orderSummary = new StringBuilder("Ваш заказ:\n");
                BigDecimal totalCost = BigDecimal.ZERO;

                for (Product product : products) {
                    orderSummary.append(product.getName()).append(". Цена: ").append(product.getPrice()).append(" руб.\n");
                    totalCost = totalCost.add(product.getPrice());
                }

                ClientOrder clientOrder = new ClientOrder();
                Client client = clientRepository.findByExternalId(chatId);
                clientOrder.setClient(client);
                clientOrder.setStatus(2); // Статус 2 - заказ оформлен
                clientOrder.setTotal(totalCost);
                clientOrderRepository.save(clientOrder);

                for (Product product : products) {
                    OrderProduct orderProduct = new OrderProduct();
                    orderProduct.setClientOrder(clientOrder);
                    orderProduct.setProduct(product);
                    orderProduct.setCountProduct(1);
                    orderProductRepository.save(orderProduct);
                }

                selectedProducts.remove(chatId);

                orderSummary.append("Общая стоимость: ").append(totalCost).append(" руб.");
                bot.execute(new SendMessage(chatId, orderSummary.toString()));
            } else {
                bot.execute(new SendMessage(chatId, "Ошибка: Ваш заказ пуст."));
            }
        }


    }

    private final EntitiesService entitiesService;
    private final ProductRepository productRepository;
    private final OrderProductRepository orderProductRepository;
    private final ClientOrderRepository clientOrderRepository;
    private final ClientRepository clientRepository;
    private final CategoryRepository categoryRepository;
    private TelegramBot bot;

    public TelegramBotConnection(EntitiesService entitiesService, ProductRepository productRepository, OrderProductRepository orderProductRepository, ClientOrderRepository clientOrderRepository, ClientRepository clientRepository, CategoryRepository categoryRepository) {
        this.entitiesService = entitiesService;
        this.productRepository = productRepository;
        this.orderProductRepository = orderProductRepository;
        this.clientOrderRepository = clientOrderRepository;
        this.clientRepository = clientRepository;
        this.categoryRepository = categoryRepository;
    }

    @PostConstruct
    public void createConnection() {
        bot = new TelegramBot("7363494781:AAHkIIDBlaeuoTZTRyOVTQ0aqHynT_6rULo");
        bot.setUpdatesListener(new TelegramUpdatesListener());
    }
}