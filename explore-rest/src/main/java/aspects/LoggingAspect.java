package aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("execution( * controllers.*.*(..))")
    public void aroundControllerMethods(){}

    @Around("aroundControllerMethods()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            Object object = joinPoint.proceed();
            return object;
        }finally {
            log.info("Execution {} completed in {} ms", joinPoint.getSignature(), System.currentTimeMillis() - start);
        }
    }
}
