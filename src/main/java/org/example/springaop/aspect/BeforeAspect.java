package org.example.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BeforeAspect {

    @Before("execution(* org.example.springaop.controller.TestController.testAopBefore(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("[Before] Before executing method: " + joinPoint.getSignature());
    }
}

