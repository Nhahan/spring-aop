# Spring AOP 예제 프로젝트

이 프로젝트는 Spring AOP(관점 지향 프로그래밍)의 주요 어드바이스 타입인 Before, After, Around에 대한 예제 코드를 포함하고 있습니다.

## 개요

Spring AOP는 로깅, 트랜잭션 관리, 보안과 같은 횡단 관심사(Cross-cutting concerns)를 모듈화하여 코드의 중복을 줄이고 핵심 비즈니스 로직에 집중할 수 있게 해주는 프로그래밍 패러다임입니다.

이 프로젝트에서는 다음과 같은 AOP 어드바이스 타입의 예제를 확인할 수 있습니다:

1. **Before**: 메서드 실행 전에 실행되는 어드바이스
2. **After**: 메서드 실행 후에 실행되는 어드바이스
3. **Around**: 메서드 실행 전후에 모두 실행되는 어드바이스

## 프로젝트 구조

```
src/main/java/org/example/springaop/
├── annotation
│   └── AopTarget.java           # Around 어드바이스를 적용하기 위한 커스텀 어노테이션
├── aspect
│   ├── AfterAspect.java         # After 어드바이스 예제
│   ├── AroundAspect.java        # Around 어드바이스 예제
│   └── BeforeAspect.java        # Before 어드바이스 예제
├── controller
│   └── TestController.java      # 테스트를 위한 REST 컨트롤러
└── SpringAopApplication.java    # 메인 애플리케이션
```

## 주요 기능 설명

### 1. Before 어드바이스

`BeforeAspect.java`에서 구현된 Before 어드바이스는 지정된 메서드가 실행되기 전에 동작합니다.

```java
@Before("execution(* org.example.springaop.controller.TestController.testAopBefore(..))")
public void beforeAdvice(JoinPoint joinPoint) {
    System.out.println("[Before] Before executing method: " + joinPoint.getSignature());
}
```

- `/before` 엔드포인트를 호출하면 컨트롤러 메서드 실행 전에 로그가 출력됩니다.

### 2. After 어드바이스

`AfterAspect.java`에서 구현된 After 어드바이스는 지정된 메서드가 실행된 후에 동작합니다.

```java
@After("execution(* org.example.springaop.controller.TestController.testAopAfter(..))")
public void afterAdvice(JoinPoint joinPoint) {
    System.out.println("[After] After executing method: " + joinPoint.getSignature());
}
```

- `/after` 엔드포인트를 호출하면 컨트롤러 메서드 실행 후에 로그가 출력됩니다.

### 3. Around 어드바이스

`AroundAspect.java`에서 구현된 Around 어드바이스는 지정된 메서드의 실행 전후에 모두 동작합니다.

```java
@Around("aopTargetMethods()")
public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
    System.out.println("[Around] Before executing method");
    
    // 실제 대상 메서드 실행
    Object result = joinPoint.proceed();
    
    System.out.println("[Around] After executing method");
    
    return result;
}
```

- `@AopTarget` 어노테이션이 적용된 메서드에 대해 실행 전후로 로그가 출력됩니다.
- `/around` 엔드포인트를 호출하면 컨트롤러 메서드 실행 전후에 로그가 출력됩니다.

## 실행 방법

1. 프로젝트를 클론합니다.
2. Gradle을 사용하여 프로젝트를 빌드합니다: `./gradlew build`
3. 애플리케이션을 실행합니다: `./gradlew bootRun`
4. 브라우저나 Postman 등을 사용하여 다음 엔드포인트에 접근해 테스트합니다:
   - `http://localhost:8080/before` - Before 어드바이스 테스트
   - `http://localhost:8080/after` - After 어드바이스 테스트
   - `http://localhost:8080/around` - Around 어드바이스 테스트

## 기술 스택

- Java 17
- Spring Boot 3.4.0
- Spring AOP
- Gradle 