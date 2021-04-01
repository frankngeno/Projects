import com.mysql.cj.xdevapi.SessionFactory;

import java.lang.module.Configuration;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotationClass()


    }
}
