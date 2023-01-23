package org.parom.hibernate.util;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.parom.hibernate.converter.BirthdayConverter;
import org.parom.hibernate.entity.User;

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
        configuration.configure();
        return configuration.buildSessionFactory();
    }
}
