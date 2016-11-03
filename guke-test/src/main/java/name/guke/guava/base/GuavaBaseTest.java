package name.guke.guava.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.internal.SessionFactoryBuilderImpl;
import org.hibernate.boot.spi.SessionFactoryBuilderImplementor;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;

/**
 * Created by GUKE on 2016/4/7.
 */
public class GuavaBaseTest {

    public static void main(String[] args) {
        Configuration cfg = new Configuration()
                // addResource does a classpath resource lookup
                //.addResource("Item.hbm.xml")
                //.addResource("Bid.hbm.xml")

                // calls addResource using "/org/hibernate/auction/User.hbm.xml"
                //.addClass(`org.hibernate.auction.User.class`)

                // parses Address class for mapping annotations
                //.addAnnotatedClass( Address.class )

                // reads package-level (package-info.class) annotations in the named package
                .addPackage( "org.hibernate.auction" )

                .setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect")
                .setProperty("hibernate.connection.datasource", "java:comp/env/jdbc/test")
                .setProperty("hibernate.order_updates", "true");
        Session currentSession = new Configuration().buildSessionFactory().getCurrentSession();
        System.err.println("session:" + currentSession);

    }
}
