package first_project.Spring_boot_mark1.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAnalysis {

    public static final Logger logger = LoggerFactory.getLogger(PerformanceAnalysis.class);

    @Around("execution(* first_project.Spring_boot_mark1.Controllers.EnrollmentController.*(..))")
    public Object TimeTaken(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object object = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        logger.info("Method "+proceedingJoinPoint.getSignature().getName()+" executed in : "+(end - start)+" ms");
        return object;
    }
}
