package name.guke.io;

import java.io.*;
import java.util.Scanner;

/**
 * Created by GUKE on 2016/10/17.
 */
public class IOTest {

    public static void testFileInputStream() {
        //声明流对象
        FileInputStream fis = null;
        try{
            //创建流对象
            fis = new FileInputStream("d:\\out.txt");
            //读取数据，并将读取到的数据存储到数组中
            byte[] data = new byte[1024]; //数据存储的数组
            int i = fis.read(data);

            //解析数据
            String s = new String(data,0,i);
            //输出字符串
            System.out.println(s);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                //关闭流，释放资源
                fis.close();
            }catch(Exception e){}
        }
    }

    public static void testFileOutputStream() {
        String s = "Java语言";
        int n = 100;
        //声明流对象
        FileOutputStream fos = null;
        try{
            //创建流对象
            fos = new FileOutputStream("d:\\out.txt");
            //转换为byte数组
            byte[] b1 = s.getBytes();
            //换行符
            byte[] b2 = "\r\n".getBytes();
            byte[] b3 = String.valueOf(n).getBytes();
            //依次写入文件
            fos.write(b1);
            fos.write(b2);
            fos.write(b3);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                fos.close();
            }catch(Exception e){}
        }
    }

    public static void testBufferedReader() {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        System.out.println("请输入内容");
        try {
            str = buf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("你输入的内容是：" + str);
    }

    public static void testScanner() {
        Scanner sca = new Scanner(System.in);
        System.out.println("请输入内容");
        // 读一个整数
        int temp = sca.nextInt();
        System.out.println(temp);
        //读取浮点数
        float flo=sca.nextFloat();
        System.out.println(flo);
    }
    public static void main(String[] args) {
//        testFileOutputStream();
//        testFileInputStream();
//        testBufferedReader();
        testScanner();
    }
}
