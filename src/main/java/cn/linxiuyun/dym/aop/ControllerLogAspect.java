package cn.linxiuyun.dym.aop;

import cn.linxiuyun.dym.base.BaseResponse;
import cn.linxiuyun.dym.conf.ReturnCode;
import cn.linxiuyun.dym.util.ReflectUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Modifier;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Aspect
@Component
public class ControllerLogAspect {

    private final  static Logger logger = LoggerFactory.getLogger(ControllerLogAspect.class);

    @Around("@annotation(org.springframework.web.bind.annotation.GetMapping)||@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public Object aroundService(ProceedingJoinPoint pjp) {
        long start = System.currentTimeMillis();
        MethodSignature methodSignature = (MethodSignature)pjp.getSignature();
        String methodName = methodSignature.getName();
        String targetClassName = pjp.getTarget().getClass().getName();
        Object[] args = pjp.getArgs();
        Set<Object> requestParam = ReflectUtil.getParamSet(args);
        Object response = null;
        try{
            response = pjp.proceed();
        }catch (Throwable t){
            logger.error("Exception:",t);
            response = new BaseResponse(ReturnCode.EXCEPTION);
        }finally {
            logger.info("<|>"+targetClassName+"<|>"+methodName+"<|>param:"+requestParam+"<|>result:"+response+"<|>executeTime:"+Long.toString(System.currentTimeMillis()-start)+"<|><|><|>");

        }

        return response;
    }
}
