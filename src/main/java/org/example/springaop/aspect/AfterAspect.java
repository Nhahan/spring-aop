package org.example.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterAspect {

    // TestController의 testAopAfter 메서드에 적용
    @After("execution(* org.example.springaop.controller.TestController.testAopAfter(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("[After] After executing method: " + joinPoint.getSignature());
    }
}
