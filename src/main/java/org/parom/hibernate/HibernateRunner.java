package org.parom.hibernate;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.parom.hibernate.converter.BirthdayConverter;
import org.parom.hibernate.entity.Birthday;
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
        configuration.addAttributeConverter(new BirthdayConverter(), true);

        //регистрируем тип в конфигурации
        configuration.registerTypeOverride(new JsonBinaryType());

        //для работы с сущьностью нужно её сконфигурировать
        // 1ый вариант, 2ой вариант в файле hibernate.cfg.xml <mapping
        configuration.addAnnotatedClass(User.class);


        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
//            User user = User.builder()
//                    .birthDate(new Birthday(LocalDate.of(2000, 1, 19)))
//                    .username("1ivan@gmail.com")
//                    .firstname("Ivan")
//                    .lastname("Ivanov")
//                    .role(Role.ADMIN)
//                    .info("""
//                            {
//                            "name": "Ivan",
//                            "id": 25
//                            }
//                            """)
//                    .build();

            session.beginTransaction();
//            session.save(user);
            User user1 = session.get(User.class, "ivan@gmail.com");
            System.out.println(session.isDirty());
            user1.setLastname("Petrov");//изменение которое вызовет update в базе данных при закрытии сессии или коммите
            System.out.println(session.isDirty());

            //3 способа очистить кеш сессии
//            session.evict(user1);//удаляет user1 из кеша 1 уровня (persistanceContexta)
//            session.clear();//очищает весь кеш первого уровня (persistanceContext)
//            session.close();
            User user2 = session.get(User.class, "ivan@gmail.com");

            session.getTransaction().commit();
//            session.getTransaction().rollback();
            System.out.println("OK ");
        }


    }
}
