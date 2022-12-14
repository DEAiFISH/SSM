package annotation;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 1、在切面中，需要通过指定的注解将方法标识为通知方法
 *
 * @Before：前置通知，在目标对象方法热行之前执行
 * @After：后置通知，在目标对象finally字句中执行
 * @AfterREturning：在目标对象返回值之后执行
 * @AfterThrowing：异常通知，在目标对象catch字句中执行 2、切入点表达式：设置在标识通知的注解的value厲性中
 * execution (public it com.atquiqu.spring.aop.annotation.calculatorImpl.add(int,int)
 * execution (public it com.atquiqu.spring.aop.annotation.calculatorImpl.add(int,int)
 * execution(* com.atquiqu.spring.aop.annotation.CalculatorImpl.*(..)
 * 第一个*表示任意的访问修饰符和返回值类型
 * 第二个*表天类中任意的方法
 * ..表示任意的参数列表
 * 类的地方也可以使用*，表示包下所有的类
 * <p>
 * 3、重用切入点表达式
 * @PointCut() 声明一个公共的切入点表达式
 * @Pointcut("execution(* annotation.CalculatorImpl.*(..))")
 * public void pointCut(){}
 * 使用方法：    @Before("pointCut()")
 * <p>
 * 4、获取连接点的信息
 * 在通知方法的参数位置，设置JoinPoint 类型的参数，就可以获取连接点所对应方法的信息
 * <p>
 * 5、切面优先级
 * 可以通过@Order注解的value属性设置优先级，默认值为Integer.MAX_VALUE
 * @Order注解的value属性值越小，优先级越高
 */
@Component
@Aspect//将当前组件标识为切面
public class LoggerAspect {

    @Pointcut("execution(* annotation.CalculatorImpl.*(..))")
    public void pointCut() {
    }

    //    @Before("execution(public int annotation.CalculatorImpl.add(int ,int))")
    //    @Before("execution(* annotation.CalculatorImpl.*(..))")
    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint) {
        System.out.println("\tLoggerAspect，前置通知");
        //获取连接点对应方法的方法名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        //获取连接点对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect，方法：" + name + ",参数：" + Arrays.toString(args));
    }

    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint) {
        System.out.println("\tLoggerAspect，后 置通知");

        //获取连接点对应方法的方法名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("LoggerAspect，方法：" + name + ",执行完毕");
    }

    /**
     * 在返回通知中若要获取目标对象方法的返回值
     * 只需要通过@AfterReturning注解的returning厲性
     * 就可以将通知方法的某个参数指定为接收目标对象方法的返回值的参数
     */
    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result) {
        System.out.println("\tLoggerAspect，返回通知");

        //获取连接点对应方法的方法名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("LoggerAspect，方法：" + name + ",结果：" + result);
    }

    /**
     * 在异常通知中若要获取目标对象方法的返回值
     * 只需要通过@AfterThrowing注解的throwing厲性
     * 就可以将通知方法的某个参数指定为接收目标对象方法出现的异常的参数
     */
    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Exception ex) {
        System.out.println("\tLoggerAspect，异常通知");

        //获取连接点对应方法的方法名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();

        System.out.println("LoggerAspect，方法：" + name + ",异常：" + ex);
    }

    @Around("pointCut()")
    //环绕通知的返回值一定要跟目标对象方法的通知一致
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint) {
        Object result = null;

        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        Object[] args = joinPoint.getArgs();
        try {
            System.out.println("环绕通知-->前置通知");
            System.out.println("LoggerAspect，方法：" + name + ",参数：" + Arrays.toString(args));
            //表示目标点对象的执行
            result = joinPoint.proceed();
            System.out.println("环绕通知-->返回通知");
            System.out.println("LoggerAspect，方法：" + name + ",结果：" + result);

        } catch (Throwable e) {
            System.out.println("环绕通知-->异常通知");
            System.out.println("LoggerAspect，方法：" + name + ",异常：" + e);
        } finally {
            System.out.println("环绕通知-->后置通知");
            System.out.println("LoggerAspect，方法：" + name + ",执行完毕");

        }

        return result;
    }
}
