package org.parom.hibernate.util;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.mapping.Property;
import org.parom.hibernate.converter.BirthdayConverter;
import org.parom.hibernate.entity.User;
import org.parom.hibernate.entityAnnotated.Bid;
import org.parom.hibernate.entityAnnotated.Item;
import org.parom.hibernate.entityAnnotated.UserAnnotated;

/**
 * @author E.Parominsky 23/01/2023 08:36
 */
@UtilityClass
public class HibernateUtil {

    public static SessionFactory buildSessionFactory(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAttributeConverter(new BirthdayConverter(), true);
        configuration.registerTypeOverride(new JsonBinaryType());
        configuration.addAnnotatedClass(User.class);

        configuration.addAnnotatedClass(UserAnnotated.class);
        configuration.addAnnotatedClass(Bid.class);
        configuration.addAnnotatedClass(Item.class);

        configuration.setProperty("hibernate.hbm2ddl.auto", "update");

        configuration.configure();
        return configuration.buildSessionFactory();
    }

    public static SessionFactory buildSessionFactoryForAnnotation(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(UserAnnotated.class);
        configuration.addAnnotatedClass(Bid.class);
        configuration.addAnnotatedClass(Item.class);
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.configure();
        return configuration.buildSessionFactory();
    }
}
