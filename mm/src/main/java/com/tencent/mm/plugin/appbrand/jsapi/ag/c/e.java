package com.tencent.mm.plugin.appbrand.jsapi.ag.c;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.backgroundrunning.j;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Set;

public class e extends j {
    public boolean mJN = true;
    public o mJO;
    public Set<o> mJP = new HashSet();

    public e() {
        AppMethodBeat.i(215853);
        AppMethodBeat.o(215853);
    }

    @Override // com.tencent.mm.plugin.appbrand.backgroundrunning.j
    public final boolean bzd() {
        AppMethodBeat.i(215854);
        if (this.mJO == null || this.mJP.isEmpty()) {
            AppMethodBeat.o(215854);
            return false;
        }
        AppMethodBeat.o(215854);
        return true;
    }

    public final boolean a(o oVar, int i2) {
        boolean z;
        AppMethodBeat.i(215855);
        if (bzd() && i2 != 3) {
            if (oVar instanceof com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o) {
                z = this.mJO == oVar;
            } else if (oVar instanceof a) {
                z = this.mJP.contains(oVar);
            }
            Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "shouldInterceptEnterBackground, result:%s, isVOIPing:%s, type:%s", Boolean.valueOf(z), Boolean.valueOf(bzd()), Integer.valueOf(i2));
            AppMethodBeat.o(215855);
            return z;
        }
        z = false;
        Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "shouldInterceptEnterBackground, result:%s, isVOIPing:%s, type:%s", Boolean.valueOf(z), Boolean.valueOf(bzd()), Integer.valueOf(i2));
        AppMethodBeat.o(215855);
        return z;
    }

    public final synchronized void bCO() {
        AppMethodBeat.i(215856);
        if (this.mJO != null) {
            Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "stopVOIP, LivePusher:%s", this.mJO.PH());
            this.mJO.PG();
        }
        for (o oVar : this.mJP) {
            if (oVar != null) {
                Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "stopVOIP, LivePlayer:%s", oVar.PH());
                oVar.PG();
            }
        }
        AppMethodBeat.o(215856);
    }

    public static void a(AppBrandRuntime appBrandRuntime, o oVar) {
        AppMethodBeat.i(215857);
        Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "onPushBegin, runtime:%s, LivePusher:%s", appBrandRuntime.mAppId, oVar.PH());
        b(appBrandRuntime, 1);
        AppMethodBeat.o(215857);
    }

    public static void b(AppBrandRuntime appBrandRuntime, int i2) {
        AppMethodBeat.i(215858);
        a aVar = new a();
        aVar.mJH.appId = appBrandRuntime.mAppId;
        aVar.mJH.beL = 4;
        aVar.mJH.dDe = i2;
        EventCenter.instance.publish(aVar);
        AppMethodBeat.o(215858);
    }

    public final void c(AppBrandRuntime appBrandRuntime, boolean z) {
        AppMethodBeat.i(215859);
        Log.i("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "enableMic, enable:%s", Boolean.valueOf(z));
        boolean z2 = this.mJN;
        this.mJN = z;
        if (z2 != z) {
            b(appBrandRuntime, 1);
        }
        AppMethodBeat.o(215859);
    }
}
