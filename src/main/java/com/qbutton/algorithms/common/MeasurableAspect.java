package com.qbutton.algorithms.common;

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
    @Around(value = "@annotation(com.qbutton.algorithms.common.Measurable)")
    public Object measureTime(final ProceedingJoinPoint joinPoint) throws Throwable {
        final long startMillis = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            final long duration = System.currentTimeMillis() - startMillis;
            System.out.println("Call to " + joinPoint.getSignature() + " took " + duration + " ms");
        }
    }
}
