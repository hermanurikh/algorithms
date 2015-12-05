package com.qbutton.algorithms.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation to show that we want to log time.
 *
 * @author German Urikh
 * @since version 1.0 on 05.12.15.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Measurable {

}
