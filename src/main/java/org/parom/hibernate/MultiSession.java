package org.parom.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.parom.hibernate.entity.User;
import org.parom.hibernate.util.HibernateUtil;

/**
 * @author E.Parominsky 23/01/2023 08:33
 */
public class MultiSession {
    public static void main(String[] args) {
        User user1 = User.builder()
                .username("peter@gmail.com")
                .firstname("Peter")
                .lastname("Peterov")
                .build();
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (Session session1 = sessionFactory.openSession()) {
                session1.beginTransaction();

                session1.saveOrUpdate(user1);

                session1.getTransaction().commit();
            }

            try (Session session2 = sessionFactory.openSession()) {
                session2.beginTransaction();
//                session2.delete(user1);
//                    refresh/merge
                user1.setFirstname("Sveta");
                session2.refresh(user1);
                //происходит
//                User freshUser = session2.get(User.class, user1.getFirstname());
//                user1.setLastname(freshUser.getLastname());
//                user1.setUsername(freshUser.getUsername());

                user1.setFirstname("Sveta");
                session2.merge(user1);
                //происходит
                //тепеть user1 главнее и все что мы меняем попадет в базу данных
//                User freshUser = session2.get(User.class, user1.getFirstname());
//                freshUser.setLastname(user1.getLastname());
//                freshUser.setUsername(user1.getUsername());

                session2.getTransaction().commit();
            }
        }

    }
}
