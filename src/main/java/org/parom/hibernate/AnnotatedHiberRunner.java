package org.parom.hibernate;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.parom.hibernate.entityAnnotated.Bid;
import org.parom.hibernate.entityAnnotated.Item;
import org.parom.hibernate.entityAnnotated.UserAnnotated;
import org.parom.hibernate.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * @author E.Parominsky 23/01/2023 11:28
 */
public class AnnotatedHiberRunner {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactoryForAnnotation()) {
            try (Session session = sessionFactory.openSession()) {
                EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
                Long pid = 1l;
//                Item item = entityManager.find(Item.class, pid);
                UserAnnotated userAnnotated = entityManager.find(UserAnnotated.class, pid);
                Bid bid = entityManager.find(Bid.class, pid);
                System.out.println();

//                session.beginTransaction();
////                UserAnnotated user1 = UserAnnotated.builder()
////                        .username("third@gmail.com")
////                        .firstname("ThirdUser")
////                        .lastname("Thirdovich")
////                        .build();
////                Item item1 = Item.builder()
////                        .seller(user1)
////                        .build();
////                Query query = session.createQuery("select i from Item i inner join UserAnnotated  u on i.pid = u.pid where i.pid = :pid");
////                query.setParameter("pid", 1l);
////                Item item = (Item) query.uniqueResult();
////                item.setNameLot("ExpensiveCar");
////                UserAnnotated seller = item.getSeller();
////
////                Bid bid1 = Bid.builder()
////                        .dateOfbid(new Date(2021, 3, 19))
////                        .item(item)
////                        .value(399.55)
////                        .build();
////
////                session.saveOrUpdate(item);
////                session.saveOrUpdate(bid1);
//                Long pid = 1l;
//                Criteria criteria1 = session.createCriteria(Item.class);
//
//                Item result = (Item) criteria1.add(Restrictions.eq("pid", pid))
//                        .setFetchMode("seller", FetchMode.JOIN)
//                        .uniqueResult();
//                Criteria criteria2 = session.createCriteria(Bid.class);
//                List<Bid> bids = criteria2
//                        .add(Restrictions.eq("item.pid", pid))
//                        .list();
//                result.setBids(new HashSet<>(bids));
//
//                session.saveOrUpdate(result);
//
//                System.out.println();
//                session.getTransaction().commit();
            }
        }




    }
}
