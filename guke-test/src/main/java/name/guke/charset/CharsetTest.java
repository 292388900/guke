package name.guke.charset;

import org.apache.commons.lang3.CharUtils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Created by GUKE on 2016/4/5.
 */
public class CharsetTest {

    public static final Charset UTF8_CHARSET = Charset.forName("UTF-8");

    public static String decodeUTF8(byte[] bytes) {
        return new String(bytes, UTF8_CHARSET);
    }

    public static byte[] encodeUTF8(String string) {
        return string.getBytes(UTF8_CHARSET);
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.err.println(Charset.defaultCharset().name());
        char a= '\uD852';
        System.out.println(CharUtils.unicodeEscaped(a));
        System.out.println("\uD852\uDF62".getBytes().length);
        System.out.println(decodeUTF8(encodeUTF8("\uD852\uDF62")));
        System.out.println("array"+ Arrays.toString("我们".toCharArray()));

        String string = "abc\u5639";
        byte[] utf8 = string.getBytes("UTF-8");
        string = new String(utf8, "UTF-8");
        System.out.println(string);
        char[] c = string.toCharArray();
        for(char tmp:c)
            System.out.print("\\u" + Integer.toHexString(tmp) + " ");
    }
}
