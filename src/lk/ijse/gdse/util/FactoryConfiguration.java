package lk.ijse.gdse.util;

import lk.ijse.gdse.entity.Rooms;
import lk.ijse.gdse.entity.Student;
import lk.ijse.gdse.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;

    private SessionFactory sessionFactory;
    private FactoryConfiguration(){
        Configuration configuration = new Configuration().configure()
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Rooms.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance() {
        return factoryConfiguration == null?
                factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}
