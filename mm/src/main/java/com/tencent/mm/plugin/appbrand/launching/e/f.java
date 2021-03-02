package com.tencent.mm.plugin.appbrand.launching.e;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public interface f {
    public static final f mZp = (g.aAe().azG().aBb() ? new h() : new b());

    boolean a(Context context, LaunchParcel launchParcel);

    boolean a(Context context, String str, String str2, String str3, int i2, int i3, AppBrandStatObject appBrandStatObject, AppBrandLaunchReferrer appBrandLaunchReferrer, LaunchParamsOptional launchParamsOptional);
}
