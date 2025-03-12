package org.example.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundAspect {

    @Pointcut("@annotation(org.example.springaop.annotation.AopTarget)")
    public void aopTargetMethods() {}

    @Around("aopTargetMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("[Around] Before executing method");

        // 실제 대상 메서드 실행
        Object result = joinPoint.proceed();

        System.out.println("[Around] After executing method");

        return result;
    }
} 
