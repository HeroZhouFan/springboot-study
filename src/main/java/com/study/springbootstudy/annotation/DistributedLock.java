package com.study.springbootstudy.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @program: openroad-platform
 * @description: redis锁注解
 * @author: Mr.Zhou
 * @create: 2022-01-09 15:33
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
@Inherited
public @interface DistributedLock {

    String prefix() default "lock";

    String lockKey();

    /**
     * 锁超时时间。
     */
    long leaseTime() default 120L;

    /**
     * 时间单位。默认为秒。
     */
    TimeUnit timeUnit() default TimeUnit.SECONDS;
}
