package pl.maciek_rychlinski.service.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Component
@Aspect
public class TimeLoggerAspect {

    @Around("execution(* pl.maciek_rychlinski.service.BookRepository.*(..))")
    public Object measureExecTime(ProceedingJoinPoint pjp) throws Throwable{
        Instant before=Instant.now();
        try{
            Object result=pjp.proceed();
            return result;
        }finally {
            Instant after=Instant.now();
            Duration execTime=Duration.between(before,after);
            System.out.printf("%s execution took %d ms\n",pjp.toShortString(),execTime.toMillis());
        }
    }
}
