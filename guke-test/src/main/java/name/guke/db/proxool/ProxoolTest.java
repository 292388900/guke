package name.guke.db.proxool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by GUKE on 2016/4/18.
 */
public class ProxoolTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        HashMap s = new HashMap();
        s.put(1,2);
        s.put(1,2);
        s.put(2,2);
        /*Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
        Properties info = new Properties();
        info.setProperty("proxool.maximum-connection-count", "20");
        info.setProperty("proxool.house-keeping-test-sql", "select CURRENT_DATE");
        info.setProperty("user", "sa");
        info.setProperty("password", "");
        String alias = "test";
        String driverClass = "org.hsqldb.jdbcDriver";
        String driverUrl = "jdbc:hsqldb:test";
        String url = "proxool." + alias + ":" + driverClass + ":" + driverUrl;
        Connection connection = DriverManager.getConnection(url, info);*/
    }
}
