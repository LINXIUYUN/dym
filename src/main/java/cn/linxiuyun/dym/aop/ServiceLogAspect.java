package cn.linxiuyun.dym.aop;

import cn.linxiuyun.dym.util.ReflectUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;
import java.util.Set;

@Aspect
@Component
public class ServiceLogAspect {

    private final  static Logger logger = LoggerFactory.getLogger(ServiceLogAspect.class);

    @Around("execution(* cn.linxiuyun.dym.service..*.*(..))")
    public Object aroundRequest(ProceedingJoinPoint pjp){
        long start = System.currentTimeMillis();
        MethodSignature methodSignature = (MethodSignature)pjp.getSignature();
        String methodName = methodSignature.getName();
        String targetClassName = pjp.getTarget().getClass().getName();
        int modifier = methodSignature.getMethod().getModifiers();

        Object[] args = pjp.getArgs();
        Set<Object> paramSet = ReflectUtil.getParamSet(args);
        Object response = null;

        try{
            response = pjp.proceed();
        }catch (Throwable t){
            throw  new RuntimeException(t);
        }finally {
            if(Modifier.isPublic(modifier)){
                logger.info("<|>"+targetClassName+"<|>"+methodName+"<|>param:"+paramSet+"<|>result:"+response+"<|>executeTime:"+Long.toString(System.currentTimeMillis()-start)+"<|><|><|>");
            }
        }

        return response;
    }
}
