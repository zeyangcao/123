package com.sky.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AutoFillAspect {

@Pointcut ("execution(* com.sky.mapper.*.*(..)) && @annotation(com.sky.annotation.AutoFill)")
     public  void autoFillPointCut(){}

    @Before("autoFillPointCut()")
    public void autoFill(JoinPoint joinPoint){
    //在Around环绕通知中，获取连接点信息只能使用ProceedingJoinPoint类型
    log.info("开始进行公共字段自动填充");
    }

}
