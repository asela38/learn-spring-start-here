package aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(* *..controllers.*.*(..))")
    public void allControllers(){}

    @Around("allControllers()")
    public Object logs(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            log.info("Execution of {} took {} ms", joinPoint.getSignature(), System.currentTimeMillis() - start);
        }
    }

    @Around("execution(* org.springframework.cloud.openfeign..*(..)) || execution(* feign..*(..))")
    public Object openFeignLogs(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            log.info("Execution of {} took {} ms", joinPoint.getSignature(), System.currentTimeMillis() - start);
        }
    }
}
