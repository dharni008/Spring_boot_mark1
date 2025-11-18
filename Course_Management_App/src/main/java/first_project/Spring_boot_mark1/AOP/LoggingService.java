package first_project.Spring_boot_mark1.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingService {

    public static final Logger logger = LoggerFactory.getLogger(LoggingService.class);

    @AfterThrowing("execution(* first_project.Spring_boot_mark1.Service.*.*(..))")
    public void loggingAspectAfterThrowingError(JoinPoint joinPoint){
        logger.info("Class : "+joinPoint.getTarget().getClass().getSimpleName());
        logger.info("Method "+joinPoint.getSignature().getName()+" AfterThrowing execution ");
    }

    @Around("execution(* first_project.Spring_boot_mark1.Service.*.*(..)) && args(Id)")
    public Object ValidatingAspect(ProceedingJoinPoint pjp,Long Id) throws Throwable {
        if(Id<0){
            logger.info("object Id with negative value: "+Id);
        Id = -1 *(Id);
            logger.info("object Id converted to: "+Id);
        }
        Object object =  pjp.proceed(new Object[]{Id});
        logger.info(" Value Given in "+pjp.getSignature().getName());
        return object;
    }
}
