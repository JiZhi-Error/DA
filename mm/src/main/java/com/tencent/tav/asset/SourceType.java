package com.tencent.tav.asset;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface SourceType {
    public static final int Audio = 2;
    public static final int Image = 3;
    public static final int Video = 1;
}
