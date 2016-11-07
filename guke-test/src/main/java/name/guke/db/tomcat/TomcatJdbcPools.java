package name.guke.db.tomcat;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 <Resource name="jdbc/TestDB"
     auth="Container"
     type="javax.sql.DataSource"
     factory="org.apache.tomcat.jdbc.pool.DataSourceFactory"
     testWhileIdle="true"
     testOnBorrow="true"
     testOnReturn="false"
     validationQuery="SELECT 1"
     validationInterval="30000"
     timeBetweenEvictionRunsMillis="30000"
     maxActive="100"
     minIdle="10"
     maxWait="10000"
     initialSize="10"
     removeAbandonedTimeout="60"
     removeAbandoned="true"
     logAbandoned="true"
     minEvictableIdleTimeMillis="30000"
     jmxEnabled="true"
     jdbcInterceptors="org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;
     org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer"
     username="root"
     password="password"
     driverClassName="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/mysql"/>
 *
 * @author <a href="mailto:cdguke@jd.com">guke</a>
 * @version 1.0. 2016/11/7
 * @since <某个版本引入>
 */
public class TomcatJdbcPools {

    public static void main(String[] args) throws SQLException {
        PoolProperties p = new PoolProperties();
        p.setUrl("jdbc:mysql://localhost:3306/mysql");
        p.setDriverClassName("com.mysql.jdbc.Driver");
        p.setUsername("root");
        p.setPassword("password");
        p.setJmxEnabled(true);
        p.setTestWhileIdle(false);
        p.setTestOnBorrow(true);
        p.setValidationQuery("SELECT 1");
        p.setTestOnReturn(false);
        p.setValidationInterval(30000);
        p.setTimeBetweenEvictionRunsMillis(30000);
        p.setMaxActive(100);
        p.setInitialSize(10);
        p.setMaxWait(10000);
        p.setRemoveAbandonedTimeout(60);
        p.setMinEvictableIdleTimeMillis(30000);
        p.setMinIdle(10);
        p.setLogAbandoned(true);
        p.setRemoveAbandoned(true);
        p.setJdbcInterceptors(
                "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;" +
                        "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
        DataSource datasource = new DataSource();
        datasource.setPoolProperties(p);

        Connection con = null;
        try {
            con = datasource.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from user");
            int cnt = 1;
            while (rs.next()) {
                System.out.println((cnt++) + ". Host:" + rs.getString("Host") +
                        " User:" + rs.getString("User") + " Password:" + rs.getString("Password"));
            }
            rs.close();
            st.close();
        } finally {
            if (con != null) try {
                con.close();
            } catch (Exception ignore) {
            }
        }
    }
}
