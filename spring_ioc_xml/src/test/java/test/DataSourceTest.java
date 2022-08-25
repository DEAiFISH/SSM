package test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class DataSourceTest {
    @Test
    public void Test1() throws SQLException {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring_datasource_xml.xml");

        DruidDataSource dataSource = ioc.getBean("dataSource", DruidDataSource.class);

        System.out.println(dataSource.getConnection());
    }
}
