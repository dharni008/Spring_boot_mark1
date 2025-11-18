package first_project.Spring_boot_mark1.AOP;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingController {

    public static final org.slf4j.Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @Before("execution(* first_project.Spring_boot_mark1.Controllers.*.*(..))")
    public void loggingAspectBefore(JoinPoint joinPoint){
        logger.info("Class : "+joinPoint.getTarget().getClass().getSimpleName());
        logger.info("Method "+joinPoint.getSignature().getName()+" called before execution ");
    }

    @After("execution(* first_project.Spring_boot_mark1.Controllers.*.*(..))")
    public void loggingAspectAfter(JoinPoint jp){
        logger.info("Class : "+jp.getTarget().getClass().getSimpleName());
        logger.info("Method "+jp.getSignature().getName()+" executed ");
    }


    @AfterReturning("execution(* first_project.Spring_boot_mark1.Controllers.*.*(..))")
    public void loggingAspectAfterReturning(JoinPoint jp){
        logger.info("Class : "+jp.getTarget().getClass().getSimpleName());
        logger.info("Method "+jp.getSignature().getName()+" executed Successfully");
    }

}
