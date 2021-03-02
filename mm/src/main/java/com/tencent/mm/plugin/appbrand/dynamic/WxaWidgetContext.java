package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Parcelable;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;

public interface WxaWidgetContext extends Parcelable {
    WxaPkgWrappingInfo bBO();

    WxaPkgWrappingInfo bBP();

    int bBQ();

    byte[] bBR();

    int bBS();

    DebuggerInfo bBT();

    WidgetSysConfig bBU();

    WidgetRuntimeConfig bBV();

    int bvh();

    String getAppId();

    String getId();
}
