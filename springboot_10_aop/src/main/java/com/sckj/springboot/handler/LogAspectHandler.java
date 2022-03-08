package com.sckj.springboot.handler;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LogAspectHandler {

    /**
     * 定义一个切面，拦截com.sckj.springboot.controller包和子包下的所有方法
     */
    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    /**
     * 定义切面拦截Controller
     */
    @Pointcut("execution(* com.sckj.springboot.controller..*.*(..))")
    public void pointcut(){}


    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("====DoBefore方法进入了===");
        // 获取签名
        Signature signature=joinPoint.getSignature();
        //获取切入的包名
        String declaringTypeName=signature.getDeclaringTypeName();
        //获取即将执行的方法
        String funcName=signature.getName();

        logger.info("即将执行的方法为{},属于{}",funcName,declaringTypeName);
        ServletRequestAttributes attributes = (ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //获取请求的URL地址
        String url=request.getRequestURL().toString();
        //获取的请求的IP
        String ip=request.getRemoteAddr();
        logger.info("用户请求的URL为{},IP地址为{}",url,ip);
    }


    /**
     * 在上面定义的切面方法之后执行该方法
     * @param joinPoint jointPoint
     */
    @After("pointcut()")
    public void doAfter(JoinPoint joinPoint){
        logger.info("====doAfter方法进入了====");
        Signature signature = joinPoint.getSignature();
        String method = signature.getName();
        logger.info("方法{}已经执行完", method);
    }

    @AfterReturning(pointcut = "pointcut()",returning = "result")
    public void doAfterReturning(JoinPoint joinPoint,Object result){
        Signature signature=joinPoint.getSignature();
        String classMethod=signature.getName();
        logger.info("方法{}执行完毕，返回参数为：{}", classMethod, result);
        // 实际项目中可以根据业务做具体的返回值增强
        logger.info("对返回参数进行业务上的增强：{}", result + "增强版");
    }

    /**
     * 在上面定义的切面方法执行抛异常时，执行该方法
     * @param joinPoint jointPoint
     * @param ex ex
     */
    @AfterThrowing(pointcut = "pointcut()",throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint,Throwable ex){
        Signature signature=joinPoint.getSignature();
        String method=signature.getName();
        //打印日志
        logger.info("执行方法{},出错,异常为{}",method,ex.getMessage());
    }


}
