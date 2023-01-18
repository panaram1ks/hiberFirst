package org.parom.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;
import org.parom.hibernate.entity.Role;
import org.parom.hibernate.entity.User;

import java.time.LocalDate;

/**
 * @author E.Parominsky 17/01/2023 08:29
 */
public class HibernateRunner {
    public static void main(String[] args) {
//        BlockingDeque<Connection> pool = null;
//        Connection connection = pool.take();
//        SessionFactory

//        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "admin", "admin");
//        Connection connection = DriverManager.getConnection("db.url", "db.username", "db.password");
//        Session

//      перед созданием SessionFactory нам нужно её сконфирурировать в файле hibernate.cfg.xml
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
//        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());

        //для работы с сущьностью нужно её сконфигурировать
        // 1ый вариант, 2ой вариант в файле hibernate.cfg.xml <mapping
        configuration.addAnnotatedClass(User.class);


        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            User user = User.builder()
                    .age(19)
                    .birthDate(LocalDate.of(2000, 1, 19))
                    .username("ivan@gmail.com")
                    .firstname("Ivan")
                    .lastname("Ivanov")
                    .role(Role.ADMIN)
                    .build();

            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
//            session.getTransaction().rollback();

            System.out.println("OK ");

        }


    }
}
