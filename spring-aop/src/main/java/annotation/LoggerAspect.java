package annotation;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
    在切面中，需要通过指定的注解将方法标识为通知方法
    @Before：前置通知，在目标对象方法热行之前执行

    切入点表达式：设置在标识通知的注解的value厲性中
    execution (public it com.atquiqu.spring.aop.annotation.calculatorImpl.add(int,int)
    execution (public it com.atquiqu.spring.aop.annotation.calculatorImpl.add(int,int)
    execution(* com.atquiqu.spring.aop.annotation.CalculatorImpl.*(..)
    第一个*表示任意的访问修饰符和返回值类型
    第二个*表天类中任意的方法
    ..表示任意的参数列表
    类的地方也可以使用*，表示包下所有的类
 */
@Component
@Aspect//将当前组件标识为切面
public class LoggerAspect {

    //    @Before("execution(public int annotation.CalculatorImpl.add(int ,int))")
    @Before("execution(* annotation.CalculatorImpl.*(..))")
    public void beforeAdviceMethod() {
        System.out.println("LoggerAspect，前置通知");
    }
}
