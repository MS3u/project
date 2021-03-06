package controls;

import entities.Storage;
import entities.Users;
import entities.Orders;
import entities.eSerwis;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

/**
 * Klasa sterujaca Hibernate
 */
public class MethodController {
    public Session session;
    public SessionFactory sessionFactory;

    public Session getSession() {
        return session;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Inicjalizacja polaczania z baza
     */
    public void initDb() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Users.class);
        configuration.addAnnotatedClass(Orders.class);
        configuration.addAnnotatedClass(Storage.class);
        configuration.addAnnotatedClass(eSerwis.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        this.sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        this.session = sessionFactory.openSession();


    }


    List<Users> getUsers() {
        List<Users> users = session.createQuery("from Users").getResultList();
        System.out.println(users);
        return users;
    }
    public String getStanowisko(String login, String haslo){

        String stanowisko="";
        String nazwisko = login;
        String imie="";
        String hql = "SELECT stanowisko FROM Users WHERE nazwisko = :login AND haslo = :haslo";
        Query query = session.createQuery(hql);
        query.setParameter("login", login.toString());
        query.setParameter("haslo", haslo.toString());
        List results = query.list();
        stanowisko=results.toString().replace("[","").replace("]","");
//        for(results[] : results){
//            stanowisko = results[0].toString();
//            imie = results[1].toString();
//        }
        return stanowisko;
    }

    public String getRodo(String login, String haslo){
       // String nazwisko = login;
        String imie="";

        String hql = "SELECT imie FROM Users WHERE nazwisko = :login AND haslo = :haslo";
        Query query = session.createQuery(hql);
        query.setParameter("login", login.toString());
        query.setParameter("haslo", haslo.toString());
        List results = query.list();
        imie= results.toString().replace("[","").replace("]","");
        return imie;
    }

    List<Orders> getOrders() {
        List<Orders> orders = session.createQuery("from Orders ").getResultList();
        System.out.println(orders);
        return orders;
    }
    List<eSerwis> getSerwis() {
        List<eSerwis> sewis = session.createQuery("from eSerwis ").getResultList();
        System.out.println(sewis);
        return sewis;
    }

    /**
     * rozpoczecie tranzakcji
     */
    public void transactionStart() {
        Transaction transaction = session.beginTransaction();
        transaction.commit();
    }

    /**
     * Zapis do bazy
     * @param object
     */
    public void saveData(Object object) {
        transactionStart();
        session.save(object);

    }

    /**
     * Modifikacja w bazie danych
     * @param object
     */
    public void update(Object object) {
        transactionStart();
        session.merge(object);
    }

    private void loadItems(int id){
    List rs = null;
        Transaction tx=session.beginTransaction();
        Query q = session.createQuery("select Nazwa, ilosc from storage, orders, tempserwis"+
                "where tempserwis.orderId=orders.Id"+       // BRAK ZMAPOWANIA TABEL WIELE DO WIELE DLA TABELI LACZACEJ
                "and tempserwis.storageId=storage.Id"+
                "and orders.Id=:qid");
        q.setParameter("qid", id);

      rs =q.getResultList();
//    while(rs.next()){
//        String name = rs.getString("Name)";
//        String ilosc = rs.getString("ilosc");
//    }



        tx.commit();

    }

public void updateOder(int id,
                       String dataPrzyjeciaText,
                       String nrZleceniaText,
                       String imieText,
                       String nazwiskoTextskoT,
                       String miastoTexttoT,
                       String ulicaTextcaT,
                       String nrDomuText,
                       String nrLokauText,
                       String nipText,
                       String serwisantText,
                       String opiStext) {
    Transaction tx=session.beginTransaction();


    Query q=session.createQuery("UPDATE Orders SET " +
            "dataPrzyjecia=:dp, " +
            "nrZlecenia=:nz, " +
            "imie=:i, " +
            "nazwisko=:n, " +
            "miasto=:m, " +
            "ulica=:u, " +
            "nrDomu=:nd, " +
            "nrLokalu=:nl,  " +
            "nip=:nip, " +
            "opis=:o, " +
            "serwisant=:s" +
            " WHERE id=:Id");
    q.setParameter("dp",dataPrzyjeciaText);
    q.setParameter("nz",nrZleceniaText);
    q.setParameter("i",imieText);
    q.setParameter("n",nazwiskoTextskoT);
    q.setParameter("m",miastoTexttoT);
    q.setParameter("u",ulicaTextcaT);
    q.setParameter("nd",nrDomuText);
    q.setParameter("nl",nrLokauText);
    q.setParameter("nip",nipText);
    q.setParameter("o",opiStext);
    q.setParameter("s",serwisantText);
    q.setParameter("Id",id);

    int status=q.executeUpdate();
    System.out.println(status);
    tx.commit();
    }

    /**
     * Usuwanie z bazy
     * @param object
     */
    public void deleteFromDb(Object object) {
        transactionStart();
        session.delete(object);

    }


}

