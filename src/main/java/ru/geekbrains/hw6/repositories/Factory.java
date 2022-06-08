package ru.geekbrains.hw6.repositories;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Factory {
    private org.hibernate.SessionFactory factory;

    @PostConstruct
    public void init(){
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public Factory() {
    }

    public org.hibernate.SessionFactory getFactory() {
        return factory;
    }

    @PreDestroy
    public void closeSessionFactory(){
        factory.close();
    }
}
