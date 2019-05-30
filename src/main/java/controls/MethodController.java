package controls;

import entities.Storage;
import entities.Users;

import entities.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;


public class MethodController {
    public Session session;
    public SessionFactory sessionFactory;

    public Session getSession() {
        return session;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void initDb() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Users.class);
        configuration.addAnnotatedClass(Orders.class);
        configuration.addAnnotatedClass(Storage.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        this.sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        this.session = sessionFactory.openSession();


    }


    List<Users> getUsers() {
        List<Users> users = session.createQuery("from Users").getResultList();
        System.out.println(users);
        return users;
    }
    List<Orders> getOrders() {
        List<Orders> orders = session.createQuery("from Orders ").getResultList();
        System.out.println(orders);
        return orders;
    }

    public void transactionStart() {
        Transaction transaction = session.beginTransaction();
        transaction.commit();
    }

    public void saveData(Object object) {
        transactionStart();
        session.save(object);

    }

    public void update(Object object) {
        transactionStart();
        session.merge(object);
    }

    public void deleteFromDb(Object object) {
        transactionStart();
        session.delete(object);

    }


}

