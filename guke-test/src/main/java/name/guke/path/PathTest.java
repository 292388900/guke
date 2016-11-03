package name.guke.path;

/**
 * Created by GUKE on 2016/4/2.
 */
public class PathTest {
    public static void main(String[] args) throws Exception {
        System.out.println(PathTest.class.getClassLoader().getResource("").toURI());
        System.out.println(PathTest.class.getResource("").toURI());
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("properties/commons.properties").toURI());
    }
}
