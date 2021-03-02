package com.tencent.mm.appbrand.commonjni;

import android.support.annotation.Keep;

@Keep
public class AppBrandCommonBindingJniParams {
    @Keep
    public float gcFactor = 0.1f;
    @Keep
    public long jsContext;
    @Keep
    public long jsEngine;
    @Keep
    public long uvLoop;
    @Keep
    public String wasmCachePath;
}
