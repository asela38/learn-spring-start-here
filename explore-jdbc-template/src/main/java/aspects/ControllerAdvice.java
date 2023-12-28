package aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class ControllerAdvice {

    @Before("execution(* controllers.*.*(..))")
    public void log(JoinPoint joinPoint) {
        log.info("Entering {}", joinPoint.getSignature());
    }

    @Around("execution(* repositories.*.*(..))")
    public Object logJdbc(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            log.info("Execution {} took {} ms", joinPoint.getSignature(), System.currentTimeMillis() - start);
        }
    }
}
