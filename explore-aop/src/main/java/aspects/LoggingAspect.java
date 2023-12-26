package aspects;

import lombok.extern.java.Log;
import models.Comment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Log
@Order(20)
public class LoggingAspect {
    //@Around("execution(* services.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        log.info("Method will execute " +  joinPoint.getSignature() + " with parameters " + Arrays.asList(args));
        Object proceed = joinPoint.proceed();
        log.info("Method executed " +  joinPoint.getSignature() + " and returned " + proceed);
        return proceed;
    }

    @Around("@annotation(annotations.ToLog)")
    public Object logAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        log.info("Method will execute " +  joinPoint.getSignature() + " with parameters " + Arrays.asList(args));
        Object proceed = joinPoint.proceed();
        log.info("Method executed " +  joinPoint.getSignature() + " and returned " + proceed);
        return proceed;
    }

   // @Around("execution(* services.*.*(..))")
    public Object log2(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        log.info("Method will execute " +  joinPoint.getSignature() + " with parameters " + Arrays.asList(args));
        Comment comment = new Comment();
        comment.setText("Some other text!");
        Object proceed = joinPoint.proceed(new Object[]{comment});

        log.info("Method executed " +  joinPoint.getSignature() + " and returned " + proceed);
        return "FAILED";
    }
}
