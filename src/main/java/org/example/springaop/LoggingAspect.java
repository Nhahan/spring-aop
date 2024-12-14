package org.example.springaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* org.example.springaop.AopTest.test(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("메소드 시작 전");
        try {
            Object result = joinPoint.proceed();
            System.out.println("메소드 실행 후");
            return result;
        } catch (Throwable throwable) {
            System.out.println("메소드 실행 중 예외 발생: " + throwable.getMessage());
            throw throwable;
        }
    }
}
