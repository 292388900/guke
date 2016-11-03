package name.guke.http;

import java.io.*;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;

/**
 * <描述信息>
 *
 * @author <a href="mailto:cdguke@jd.com">guke</a>
 * @version 1.0. 2016/10/18
 * @since <某个版本引入>
 */
public class HttpUtils {
    public static final String PROXY_HOST = "127.0.0.1";
    public static final int PROXY_PORT = 8888;

    static {
        try {
            Socket socket = new Socket(PROXY_HOST, PROXY_PORT);
            socket.close();
            System.setProperty("http.proxySet", "true");
            System.setProperty("http.proxyHost", PROXY_HOST);
            System.setProperty("http.proxyPort",   PROXY_PORT+"");
            System.out.println("设置代理成功！");
        } catch (Exception e) {
            System.err.println("设置代理失败！");
        }
    }

    public static byte[] read(InputStream in) throws IOException {
        byte[] buf = new byte[1024];
        boolean length = false;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();

        int length1;
        while((length1 = in.read(buf, 0, buf.length)) > 0) {
            bout.write(buf, 0, length1);
        }

        bout.flush();
        return bout.toByteArray();
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            URL url = new URL("http://www.baidu.com/index.php");
            URLConnection conn = url.openConnection();
            conn.connect();
            bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while (bufferedReader.read() != -1) {
                System.err.println("res:"+bufferedReader.readLine());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
