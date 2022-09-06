package Annotation;


import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect//将当前组件标识为切面

public class LoggerAspect {
}
