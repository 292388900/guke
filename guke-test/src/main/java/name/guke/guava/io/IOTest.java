package name.guke.guava.io;

import com.google.common.io.Files;

import java.io.File;

/**
 * Created by GUKE on 2016/4/1.
 */
public class IOTest {
    public static void main(String[] args) throws Exception {
        Files.touch(new File(Thread.currentThread().getContextClassLoader().getResource("commons1.properties").toURI()));
    }
}
