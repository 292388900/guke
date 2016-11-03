package name.guke.file;

import java.io.File;

/**
 * Created by GUKE on 2016/10/17.
 */
public class FileTest {

    private static void testFile() {
        //创建File对象
        File f1 = new File("c:\\test");
        File f2 = new File("1.txt");
        File f3 = new File("c:\\test\\file.txt");
        File f4 = new File("c:\\test\\","1.txt");
        //创建文件
        try{
            boolean b = f3.createNewFile();
        }catch(Exception e){
            e.printStackTrace();
        }
        //判断文件是否存在
        System.out.println(f4.exists());
        //获得文件的绝对路径
        System.out.println(f3.getAbsolutePath());
        //获得文件名
        System.out.println(f3.getName());
        //获得父路径
        System.out.println(f3.getParent());
        //判断是否是目录
        System.out.println(f1.isDirectory());
        //判断是否是文件
        System.out.println(f3.isFile());
        //获得文件长度
        System.out.println(f3.length());
        //获得当前文件夹下所有文件和文件夹名称
        String[] s = f1.list();
        for(int i = 0;i < s.length;i++){
            System.out.println(s[i]);
        }
        //获得文件对象
        File[] f5 = f1.listFiles();
        for(int i = 0;i < f5.length;i++){
            System.out.println(f5[i]);
        }
        //创建文件夹
        File f6 = new File("c:\\test\\abc");
        boolean b1 = f6.mkdir();
        System.out.println(b1);
        b1 = f6.mkdirs();
        System.out.println(b1);
        //修改文件名
        File f7 = new File("c:\\test\\a.txt");
        boolean b2 = f3.renameTo(f7);
        System.out.println(b2);
        //设置文件为只读
        f7.setReadOnly();
    }

    /**
     * 打印f路径下所有的文件和文件夹
     * @param f 文件对象
     */
    public static void printAllFile(File f){
        //打印当前文件名
        System.out.println(f.getAbsolutePath());
        //是否是文件夹
        if(f.isDirectory()){
            //获得该文件夹下所有子文件和子文件夹
            File[] f1 = f.listFiles();
            //循环处理每个对象
            int len = f1.length;
            for(int i = 0;i < len;i++){
                //递归调用，处理每个文件对象
                printAllFile(f1[i]);
            }
        }
    }

    /**
     * 删除对象f下的所有文件和文件夹
     * @param f 文件路径
     */
    public static void deleteAll(File f){
        //文件
        if(f.isFile()){
            f.delete();
        }else{ //文件夹
            //获得当前文件夹下的所有子文件和子文件夹
            File f1[] = f.listFiles();
            //循环处理每个对象
            int len = f1.length;
            for(int i = 0;i < len;i++){
                //递归调用，处理每个文件对象
                deleteAll(f1[i]);
            }
            //删除当前文件夹
            f.delete();
        }
    }

    public static void main(String[] args) {
        //testFile();
        printAllFile(new File("c:\\Intel"));
    }
}
