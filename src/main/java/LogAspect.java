import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by Svitlana on 27.07.2016.
 */
@Aspect
public class LogAspect implements MethodInterceptor {

    @Override
    @Around("executon (* (..)")
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Logger logger = Logger.getLogger("log");
        logger.info("Calculation is beginning" + methodInvocation.getMethod().getName());
        Object result = methodInvocation.proceed();
        logger.info("Calculation is finished" + methodInvocation.getMethod().getName());
        return  result;
    }
}
