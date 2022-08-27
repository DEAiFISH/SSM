package factory;

import bean.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * FactoryBean：是一个接口需要创建一个类实现该接口
 * 其中有三个方法：
 * getObject()：通过一个对象交给IOC容器管理
 * getObjectType()：设置所提供对象的类型
 * iosSingleton()：所提供的对象是否是单例
 * 当把FactoryBean的实现类配置为bean时，会将当前类中的Object()所返回的对象交给IOC容器管理
 *
 */
public class UserFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
