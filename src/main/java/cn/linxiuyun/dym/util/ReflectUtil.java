package cn.linxiuyun.dym.util;

        import javax.servlet.http.HttpServletRequest;
        import java.util.LinkedHashSet;
        import java.util.Set;

public class ReflectUtil {

    public static Set<Object> getParamSet(Object[] args){
        Set<Object> requestParam = new LinkedHashSet<>();
        HttpServletRequest request = null;
        if(args.length>0){
            for(Object arg:args){
                if(arg instanceof HttpServletRequest){
                    request = (HttpServletRequest) arg;
                }
            }

            if(request!=null){
                requestParam.add(request.getParameterMap());
            }else {
                for(Object arg:args){
                    if(!(arg instanceof HttpServletRequest)){
                        requestParam.add(arg);
                    }
                }
            }
        }
        return requestParam;
    }
}
