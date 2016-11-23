package name.guke.xml.dom;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by GUKE on 2016/10/16.
 */
public class DomUtils {

    public static void read(File fileURI) {
        //写XML文件要用到
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //允许名字空间
        factory.setNamespaceAware(true);
        //允许验证
        factory.setValidating(true);
        //获得DocumentBuilder的一个实例
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException pce) {
            System.err.println(pce);
        // 出异常时输出异常信息，然后退出，下同
            System.exit(1);
        }
        //解析文档，并获得一个Document实例。
        Document doc = null;
        try {
            doc = builder.parse(fileURI);
        } catch (DOMException dom) {
            System.err.println(dom.getMessage());
            System.exit(1);
        } catch (IOException ioe) {
            System.err.println(ioe);
            System.exit(1);
        } catch (SAXException e) {
            e.printStackTrace();
        }
        //获得根节点StuInfo
        Element elmtStuInfo = doc.getDocumentElement();
        //得到所有student节点
        NodeList nlStudent = elmtStuInfo.getElementsByTagNameNS("strNamespace", "student");
        for (int i = 0; i < nlStudent.getLength(); i++) {
        //当前student节点元素
            Element elmtStudent = (Element) nlStudent.item(i);
            NodeList nlCurrent = elmtStudent.getElementsByTagNameNS("strNamespace", "name");
        }
    }

    public static void write(File fileURI) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory .newDocumentBuilder();
        } catch (ParserConfigurationException pce) {
            System.err.println(pce);
            System.exit(1);
        }
        Document doc = null;
        doc = builder .newDocument();
        //下面是建立XML文档内容的过程，
        //先建立根元素"学生花名册"
        Element root = doc.createElement("学生花名册");
        //根元素添加上文档
        doc.appendChild(root);
        //建立"学生"元素，添加到根元素
        Element student = doc.createElement("学生");
        student.setAttribute("性别", "男");
        root.appendChild(student);
        //建立"姓名"元素，添加到学生下面，下同
        Element name = doc.createElement("姓名");
        student.appendChild(name);
        Text tName = doc.createTextNode("张三");
        name.appendChild(tName);
        Element age = doc.createElement("年龄");
        student.appendChild(age);
        Text tAge = doc.createTextNode(String.valueOf(10));
        age.appendChild(tAge);
        System.err.println("xml:"+doc.toString());
    }

}
