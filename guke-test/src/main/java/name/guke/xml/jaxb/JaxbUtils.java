package name.guke.xml.jaxb;

import name.guke.xml.Student;

import javax.persistence.metamodel.PluralAttribute;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Collection;
import java.util.List;

/**
 * Created by GUKE on 2016/10/16.
 */
public class JaxbUtils {

    public static void read(File fileURI) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance("packageName");
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Collection collection= (Collection)unmarshaller.unmarshal(fileURI);
    }

    public static void write(File fileURI) {

    }

    public static String toXML(Object obj) {
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// //编码格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// 是否格式化生成的xml串
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xm头声明信息
            marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://vep.jd.com");// 是否格式化生成的xml串
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "http://vep.jd.com");// 是否格式化生成的xml串
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            return writer.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @SuppressWarnings("unchecked")
    public static <T> T fromXML(String xml, Class<T> valueType) {
        try {
            JAXBContext context = JAXBContext.newInstance(valueType);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new StringReader(xml));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(10).setName("张三").setSn("zs");
        String stuXml = JaxbUtils.toXML(student);
        System.err.println("toXml:"+ stuXml);
        System.err.println("fromXML:"+ JaxbUtils.fromXML(stuXml, Student.class));
    }
}
