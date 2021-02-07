package com.mus.securedwebapplicationdemo.annotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marker Configuration annotation indicating that the annotated class is part of the security implementation.
 * */

@Target({ ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Configuration
public @interface SecurityConfiguration {

}
