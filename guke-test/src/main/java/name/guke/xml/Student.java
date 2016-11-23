package name.guke.xml;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * @XmlType
 * @XmlElement
 * @XmlRootElement
 * @XmlAttribute
 * @XmlAccessorType
 * @XmlAccessorOrder
 * @XmlTransient
 * @XmlJavaTypeAdapter
 *
 *
 * Created by GUKE on 2016/10/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)                 //映射对象时候访问的方式
//@XmlType(name = "shop", propOrder = { "name", "sn", "age"})
@XmlAccessorOrder(value = XmlAccessOrder.ALPHABETICAL)//属性字母排序
@XmlRootElement(name = "Student")                     //类级，根元素
public class Student implements Serializable {
    @XmlAttribute(name = "sn", required = true)
    private String sn;
    @XmlElement(name = "name", required = true)
    private String name;
    @XmlElement(name = "age")
    private int age;
    @XmlTransient
    private int sex;

    private String sexN;

    public String getSn() {
        return sn;
    }

    public Student setSn(String sn) {
        this.sn = sn;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Student setAge(int age) {
        this.age = age;
        return this;
    }

    public int getSex() {
        return sex;
    }

    public Student setSex(int sex) {
        this.sex = sex;
        return this;
    }

    public String getSexN() {
        return sexN;
    }

    public Student setSexN(String sexN) {
        this.sexN = sexN;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("sn='").append(sn).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", sex=").append(sex);
        sb.append(", sexN='").append(sexN).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
