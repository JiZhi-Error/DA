package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\b\u001a\u00020\t*\u00020\u0005H\u0007R\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigUtils;", "", "()V", "versionType", "", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "getVersionType", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)I", "toLaunchParcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "plugin-appbrand-integration_release"})
public final class i {
    public static final i ldM = new i();

    static {
        AppMethodBeat.i(50334);
        AppMethodBeat.o(50334);
    }

    private i() {
    }

    public static final LaunchParcel e(AppBrandInitConfigWC appBrandInitConfigWC) {
        AppMethodBeat.i(50333);
        p.h(appBrandInitConfigWC, "$this$toLaunchParcel");
        LaunchParcel launchParcel = new LaunchParcel();
        launchParcel.username = appBrandInitConfigWC.username;
        launchParcel.appId = appBrandInitConfigWC.appId;
        launchParcel.version = appBrandInitConfigWC.appVersion;
        p.h(appBrandInitConfigWC, "$this$versionType");
        launchParcel.iOo = appBrandInitConfigWC.eix;
        launchParcel.kHw = appBrandInitConfigWC.kHw;
        launchParcel.mYK = appBrandInitConfigWC.Nz();
        launchParcel.cys = appBrandInitConfigWC.cys;
        LaunchParamsOptional launchParamsOptional = new LaunchParamsOptional();
        launchParamsOptional.cyr = appBrandInitConfigWC.cyr;
        launchParamsOptional.cyq = appBrandInitConfigWC.cyq;
        launchParamsOptional.cyt = appBrandInitConfigWC.cyt;
        launchParcel.mYL = launchParamsOptional;
        launchParcel.ldR = appBrandInitConfigWC.ldR;
        launchParcel.ldQ = appBrandInitConfigWC.ldQ;
        launchParcel.kHI = appBrandInitConfigWC.kHI;
        AppMethodBeat.o(50333);
        return launchParcel;
    }
}
