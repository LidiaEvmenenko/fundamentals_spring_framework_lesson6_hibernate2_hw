package ru.geekbrains.hw6.services;
import ru.geekbrains.hw6.model.Product;
import ru.geekbrains.hw6.repositories.Factory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.util.List;

@Component
@Service
public class ProductDao {
    private SessionFactory factory;
    private Session session = null;

    public ProductDao(Factory factory) {
        this.factory = factory.getFactory();
    }

    public List<Product> findAll(){
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<Product> products = session.createQuery("from Product").getResultList();
        session.getTransaction().commit();
        return products;
    }

    public List<Product> printProductALLConsumers(Long id){
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<Product> productQuery = session
                .createNamedQuery("withConsumers", Product.class)
                .setParameter("id", id)
                .getResultList();
        session.getTransaction().commit();
        return productQuery;
    }

    @PreDestroy
    public void closeSession(){
        if (session != null){
            session.close();
        }
    }
}
