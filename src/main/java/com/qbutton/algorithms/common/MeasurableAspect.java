package com.qbutton.algorithms.common;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * The aspect that will measure time of sorting.
 *
 * @author German Urikh
 * @since version 1.0 on 05.12.15.
 */
@Component
@Aspect
public class MeasurableAspect {
    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(MeasurableAspect.class);

    /**
     * When the annotation {code Measurable} is used, log the time of method's execution.
     * @param joinPoint joinPoint
     * @return proceed on joinPoint
     * @throws Throwable
     */
    @Around(value = "@annotation(com.qbutton.algorithms.common.Measurable)")
    public Object measureTime(final ProceedingJoinPoint joinPoint) throws Throwable {
        final long startMillis = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            final long duration = System.currentTimeMillis() - startMillis;
            LOGGER.warn(String.format("Call to %s took %d ms",
                    joinPoint.getSignature(), duration));
        }
    }
}
