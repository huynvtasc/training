//package org.huynv.projectionstoreprocedure.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
//@Aspect
//@Component
//@Slf4j
//public class LoggingAspect {
//    @Pointcut("within(@org.springframework.stereotype.Repository *)" +
//            " || within(@org.springframework.stereotype.Service *)" +
//            " || within(@org.springframework.web.bind.annotation.RestController *)")
//    public void springBeanPointcut() { }
//
//    @Pointcut("within(org.huynv.projectionstoreprocedure..*)")
//    public void applicationPackagePointcut() {
//        // Method is empty as this is just a Pointcut, the implementations are in the advices.
//    }
//
//    @Before("execution(* org.huynv.projectionstoreprocedure.controller.*.*(..))")
//    public void before(JoinPoint joinPoint) {
//        log.info("Before.............................");
//    }
//
//    @After("execution(* org.huynv.projectionstoreprocedure.controller.*.*(..))")
//    public void after(JoinPoint joinPoint) {
//        log.info("After.............................");
//    }
//
//    @AfterThrowing(pointcut = "applicationPackagePointcut() && springBeanPointcut()", throwing = "e")
//    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
//        log.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
//                joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL");
//    }
//
//    @Around("applicationPackagePointcut() && springBeanPointcut()")
//    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
//        if (log.isInfoEnabled()) {
//            log.info("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
//                    joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
//        }
//        try {
//            Object result = joinPoint.proceed();
//            if (log.isInfoEnabled()) {
//                log.info("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
//                        joinPoint.getSignature().getName(), result);
//            }
//            return result;
//        } catch (IllegalArgumentException e) {
//            log.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
//                    joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
//            throw e;
//        }
//    }
//}
