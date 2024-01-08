package org.example;


import org.example.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.List;

public class HibernateRunner {
    public static void main(String[] args) throws SQLException {

        //connection == session

        Configuration configuration = new Configuration();
        configuration.configure();

        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Item.class);
        configuration.addAnnotatedClass(UserDetails.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            //   === CREATE ===
            Session saveSession = session.getSession();
            Item item = Item.builder()
                    .title("Pumpkin")
                    .price(20)
                    .build();

            saveSession.beginTransaction();
            saveSession.save(item);
            System.out.println(item);
            saveSession.getTransaction().commit();


            // === READ ===
            Session readSession = session.getSession();
            readSession.beginTransaction();
            Item itemFromDB = readSession.get(Item.class, 2L);
            System.out.println("Item from DB ---->" + itemFromDB);
            readSession.getTransaction().commit();

            // === READ LIST ===
            Session listItemsSession = session.getSession();
            listItemsSession.beginTransaction();
            List<Item> selectIFromItemI =
                    listItemsSession.createQuery("select i from Item i", Item.class).getResultList();

            selectIFromItemI.forEach(System.out::println);
            listItemsSession.getTransaction().commit();

            //  === Update ===

            Session updateSession = session.getSession();
            updateSession.beginTransaction();
            Item itemFrDb = updateSession.get(Item.class, 2L);
            itemFromDB.setPrice(200);
            System.out.println(itemFrDb);
            updateSession.getTransaction().commit();


            // === Delete ===

            Session deleteSession = session.getSession();
            deleteSession.beginTransaction();
            Item itemFromDb = session.get(Item.class, 4L);
            session.remove(itemFromDb);
            session.getTransaction().commit();


            Session getUserFromDBSession = session.getSession();
            getUserFromDBSession.beginTransaction();
            User userFromDB = getUserFromDBSession.get(User.class, 1L);
            System.out.println(userFromDB);
            UserDetails userDetails = userFromDB.getUserDetails();
            System.out.println(userDetails);
            getUserFromDBSession.getTransaction().commit();


            Session getUniversity = session.getSession();
            getUniversity.beginTransaction();
            University university = getUniversity.get(University.class, 1L);
            List<Student> studentList = university.getStudentList();
            studentList.forEach(System.out::println);
            getUniversity.getTransaction().commit();
        }
    }
}
