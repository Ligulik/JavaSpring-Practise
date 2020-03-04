package pl.maciek_rychlinski.service.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import pl.maciek_rychlinski.model.Book;

import java.util.Arrays;

@Aspect
@Component
public class LoggerAspect {

    @Before("pl.maciek_rychlinski.service.aspects.AspectUtil.allBookRepositoryMethods()")
    public void logInfoBefore(JoinPoint joinPoint){
        Object[] args=joinPoint.getArgs();
        System.out.printf("Log before %s with arguments %s\n",joinPoint.getSignature(), Arrays.toString(args));
    }

    @After("pl.maciek_rychlinski.service.aspects.AspectUtil.allBookRepositoryMethods()")
    public void logInfoAfter(JoinPoint joinPoint){
        System.out.printf("Method %s Executed\n",joinPoint.getSignature());
    }

    @AfterThrowing(value = "pl.maciek_rychlinski.service.aspects.AspectUtil.allBookRepositoryMethods()",
                    throwing = "error")
    public void logError(JoinPoint joinPoint,Throwable error){
        System.out.printf("Method %s finished with error %s\n",joinPoint.getSignature(),error.getMessage());
    }

    @AfterReturning(value = "pl.maciek_rychlinski.service.aspects.AspectUtil.allBookRepositoryMethods()&&args(isbm)",
                    returning = "result")
    public void logSuccess(JoinPoint joinPoint, Book result,String isbm){
        System.out.printf("Method get() successfully returned  value %s, for isbm %s",result,isbm);
    }
}
