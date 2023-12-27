package aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspects {

    @Around("execution(* controllers.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
      long start = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        log.info("{} execution completed in {} ms", joinPoint.getSignature(), System.currentTimeMillis() - start);
        return object;
    }

}
