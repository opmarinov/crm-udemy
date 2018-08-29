package com.udemy;

import java.util.Objects;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {

  private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

  @Pointcut("execution(* com.udemy.controllers.*.*(..))")
  public void forControllers() {
  }

  @Pointcut("execution(* com.udemy.entity.*.*(..))")
  public void forEntities() {
  }

  @Pointcut("execution(* com.udemy.repositories.*.*(..))")
  public void forRepositories() {
  }

  @Before("forControllers() || forEntities() || forRepositories()")
  public void logActivities(JoinPoint jp) {

    logger.info("Method called: [ " + jp.getSignature().getName() + " ]");

    Objects[] args;

    for (Object arg : jp.getArgs()) {
      logger.info("With arguments: [ " + arg + " ]");
    }
  }

  @AfterReturning(
      pointcut = "forControllers()",
      returning = "res"
  )
  public void returnActivities(JoinPoint jp, Object res) {
    logger.info("Result from method ==> " + jp.getSignature().getName() + " is [ " + res + " ]");
  }

}
