package test;

import bean.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
    获取bean的三种方法
    1、根据bean的id获取
    2、根据bean的类型获取
    注意：根据类型获取bean时，要求IOC容器中有且只有一个类型匹配的bean
    3、根据bean的id和类型获取
 */

public class IOCByXMLTest {
    @Test
    public void Test1() {
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring_ioc_xml.xml");
        //获取bean
//        Student studentOne = (Student)ioc.getBean("studentOne");
//        Student studentOne = ioc.getBean(Student.class);
        Student studentOne = ioc.getBean("studentOne", Student.class);

        System.out.println(studentOne);

    }
}
