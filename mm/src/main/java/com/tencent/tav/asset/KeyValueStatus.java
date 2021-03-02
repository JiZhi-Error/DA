package com.tencent.tav.asset;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface KeyValueStatus {
    public static final int AVKeyValueStatusCancelled = 5;
    public static final int AVKeyValueStatusFailed = 4;
    public static final int AVKeyValueStatusLoaded = 3;
    public static final int AVKeyValueStatusLoading = 2;
    public static final int AVKeyValueStatusUnknown = 1;
}
