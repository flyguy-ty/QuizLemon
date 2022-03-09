package spring.player;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class PlayerAspect {

    Logger logger = Logger.getLogger(PlayerAspect.class);

    /*Cross cutting concerns?
    Sometimes we have a desired action that is performed *across* methods, across components...
    and, in the interest of reducing boilerplate, we want to have a strategy
    for implementing some functionality across these

    An aspect: eliminates the need for cross cutting concerns
    by applying this functionality for us

    A joinpoint: is a place where an advice can be executed
    An advice is an action taken by an aspect
    A pointcut is an expression used to select a joinpoint


    Aspects introduce some code to all methods that conform to a particular pattern
    (for instance, all methods in a class or package,
    all methods that take a certain parameter,
    all methods with a certain naming patter,
    etc

    for instance: maybe, we want to log every time we have a method
    that contains getAllDigimon (including getAllDigimon, getAllDigimonByPowerLevel, etc


    */

    //    pointcut expression example: get any method that starts with getAllDigimon
//    followed by anything (*)
//    with any return type (*)
//    with any parameters and any number of parameters (..)
//    for more ways to format pointcuts, refer to spring docs or revpro
    @Before("execution(* getPlayer*(..))")
    public void BeforeGettingPlayer(JoinPoint joinPoint){
        logger.info(joinPoint.getSignature());
    }
    /*advice annotations:
    that was before, there's a couple other good once
    @Before: advice executed before joinpoint
    @After: advice executed after joinpoint (regardless of success)
    @Around: before and after combined
    @AfterThrowing: after an exception is thrown
    @AfterReturning: after successfully returning (ie no exception)

    pointcut wildcard:
    * - a traditional wildcard
    .. - any number of arguments/datatypes/parameters
     */





}