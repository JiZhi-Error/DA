package com.tencent.tav.asset;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface MediaType {
    public static final int AVMediaTypeAudio = 2;
    public static final int AVMediaTypeVideo = 1;
}
