package com.mus.securedwebapplicationdemo.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;


/**
 * Marker component annotation indicating that the annotated class is part of the security implementation.
 * */


@Target({ ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface SecurityService {

}
