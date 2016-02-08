package org.aadsp.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil
{
private static final SessionFactory sessionFactory = buildSessionFactory();
    
    private static SessionFactory buildSessionFactory(){
        try{
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            StandardServiceRegistryBuilder registradorServico = new StandardServiceRegistryBuilder();
            registradorServico.applySettings(cfg.getProperties());
            StandardServiceRegistry servico = registradorServico.build();
            return cfg.buildSessionFactory(servico);
            
        }catch(Throwable e){
            System.out.println("CriaÃ§Ã£o Inicial do objeto sessiona factory falhou:" + e);
            throw  new ExceptionInInitializerError(e);
        }
    }
    
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

}
