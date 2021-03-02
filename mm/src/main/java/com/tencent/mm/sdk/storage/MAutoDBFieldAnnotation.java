package com.tencent.mm.sdk.storage;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MAutoDBFieldAnnotation {
    String defValue();

    int primaryKey() default 0;
}
