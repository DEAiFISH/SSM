package test;

import bean.User;
import factory.UserFactoryBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeanTest {
    @Test
    public void Test1(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring_factoryBean.xml");

        User user = ioc.getBean(User.class);

        System.out.println(user);


    }
}
