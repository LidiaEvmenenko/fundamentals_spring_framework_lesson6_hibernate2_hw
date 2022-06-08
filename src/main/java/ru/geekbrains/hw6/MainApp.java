package ru.geekbrains.hw6;
import ru.geekbrains.hw6.model.Consumer;
import ru.geekbrains.hw6.model.Product;
import ru.geekbrains.hw6.services.ConsumerDao;
import ru.geekbrains.hw6.services.ProductDao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        ConsumerDao consumerDao = context.getBean(ConsumerDao.class);
        ProductDao productDao = context.getBean(ProductDao.class);
        List<Consumer> consumerList = consumerDao.findAll();
        for (Consumer c : consumerList) {
            List<Consumer> consumers = consumerDao.consumerWithProducts(c.getId());
            System.out.println("Покупатель: " + c.getName());
            for (int i=0; i< consumers.size(); i++){
                System.out.println("   Продукт: " + consumers.get(i).getProducts().get(i).getTitle());
            }
        }
        System.out.println();
        List<Product> productList = productDao.findAll();
        for (Product p : productList) {
            List<Product> products = productDao.printProductALLConsumers(p.getId());
            System.out.println("Продукт: " + products.get(0).getTitle());
            for (int i = 0; i < products.size(); i++) {
                System.out.println("   Покупатель: " + products.get(i).getConsumers().get(i).getName());
            }
        }
    }
}
