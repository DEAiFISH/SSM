package test;

import bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifecycleTest {

    /*
        1、实例化
        2、依赖注入
        3、初始化，需要通过bean的init-method属性指定初始化的方法
        4、IOC容器关闭时销毁，需要通过bean的destroy-method属性指定的销毁方法

        注意：
        若bean的作用域为单例时，生命周期的前三个步骤会在获取IOC容器时执行
        若bean的作用域为多例时，生命周期的前三个步骤会在获取bean时执行
     */
    @Test
    public void Test1(){
        //ConfigurableApplicationContext是ApplicationContext的一个子接口，其扩展了刷新和关闭容器的方法
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring_lifecycle.xml");

        User bean = ioc.getBean(User.class);

        System.out.println(bean);

        ioc.close();
    }
}

