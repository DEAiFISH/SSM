package test;

import bean.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    @Test
    public void Test1(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring_scope.xml");

        Student student1 = ioc.getBean(Student.class);
        Student student2 = ioc.getBean(Student.class);

        System.out.println(student1 == student2);
    }
}
