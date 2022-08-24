import bean.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {
    @Test
    public void Test1() {
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("sayHello.xml");
        //获取IOC容器中的bean方法
        HelloWorld helloworld = (HelloWorld) ioc.getBean("helloworld");
        helloworld.sayHello();
    }
}
