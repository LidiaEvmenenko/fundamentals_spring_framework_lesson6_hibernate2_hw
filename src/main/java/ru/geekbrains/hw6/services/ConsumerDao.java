package ru.geekbrains.hw6.services;
import ru.geekbrains.hw6.model.Consumer;
import ru.geekbrains.hw6.repositories.Factory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.util.List;

@Component
@Service
public class ConsumerDao {
    private SessionFactory factory;
    private Session session = null;

    public ConsumerDao(Factory factory) {
        this.factory = factory.getFactory();
    }

    public List<Consumer> findAll(){
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<Consumer> consumers = session.createQuery("from Consumer").getResultList();
        session.getTransaction().commit();
        return consumers;
    }

    public List<Consumer> consumerWithProducts(Long id){
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<Consumer> consumerQuery = session
                .createNamedQuery("consumerIdWithProducts", Consumer.class)
                .setParameter("id", id)
                .getResultList();

        session.getTransaction().commit();
        return consumerQuery;
    }

    @PreDestroy
    public void closeSession(){
        if (session != null){
            session.close();
        }
    }

}
