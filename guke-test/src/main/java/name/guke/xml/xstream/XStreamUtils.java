package name.guke.xml.xstream;

import com.thoughtworks.xstream.XStream;
import name.guke.xml.Student;

/**
 * Created by GUKE on 2016/10/16.
 */
public class XStreamUtils {

    static XStream xStream = new XStream();

    public static String toXML(Object obj) {
        return xStream.toXML(obj);
    }

    public static <T> T fromXML(String xml, Class<T> valueType) {
        return (T)xStream.fromXML(xml);
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(10).setName("张三").setSn("zs");
        xStream.alias("Student", Student.class);
        String stuXml = xStream.toXML(student);
        System.err.println("toXml:"+ stuXml);
        System.err.println("fromXML:"+ xStream.fromXML(stuXml));
    }
}
