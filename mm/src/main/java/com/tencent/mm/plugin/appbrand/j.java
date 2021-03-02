package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.u;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\"\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/AppBrandPreRenderColdStartService;", "", "()V", "TAG", "", "start", "", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "callback", "Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "startInternal", "requestId", "", "plugin-appbrand-integration_release"})
public final class j {
    public static final j kAc = new j();

    static {
        AppMethodBeat.i(227892);
        AppMethodBeat.o(227892);
    }

    private j() {
    }

    public static void a(g gVar, f fVar) {
        boolean z;
        String a2;
        AppMethodBeat.i(227891);
        p.h(gVar, "bundle");
        int hashCode = gVar.hashCode();
        long currentTicks = Util.currentTicks();
        Log.i("MicroMsg.AppBrandPreRenderColdStartService", "start with id:" + hashCode + " username:" + gVar.username + " appId:" + gVar.appId + " versionType:" + gVar.iOo + " path:" + gVar.kHw + " scene:" + gVar.scene);
        h.INSTANCE.dN(1519, 0);
        a aVar = new a(hashCode, currentTicks, fVar);
        if (((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_android_appbrand_support_pre_render_start, 1) <= 0) {
            f.a.a(aVar, -8);
            AppMethodBeat.o(227891);
            return;
        }
        try {
            u uVar = u.mTD;
            u.a(gVar);
        } catch (Exception e2) {
            if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
                Exception exc = e2;
                AppMethodBeat.o(227891);
                throw exc;
            }
            f.a.a(aVar, -1);
        }
        u uVar2 = u.mTD;
        LaunchParcel b2 = u.b(gVar);
        String str = gVar.appId;
        if (str == null || str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            a2 = gVar.appId;
        } else {
            a2 = com.tencent.mm.plugin.appbrand.launching.e.h.a(b2);
        }
        String c2 = com.tencent.mm.plugin.appbrand.report.quality.g.c(b2, a2);
        b2.cyz = com.tencent.luggage.sdk.launching.b.PRE_RENDER;
        b2.mYM = Util.nowMilliSecond();
        com.tencent.f.h.RTc.aZ(new am(hashCode, b2, c2, aVar));
        AppMethodBeat.o(227891);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/appbrand/AppBrandPreRenderColdStartService$start$1", "Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "onError", "", "errCode", "", "errMsg", "", "onSuccess", "plugin-appbrand-integration_release"})
    public static final class a implements f {
        final /* synthetic */ int kAd;
        final /* synthetic */ long kAe;
        final /* synthetic */ f kAf;

        a(int i2, long j2, f fVar) {
            this.kAd = i2;
            this.kAe = j2;
            this.kAf = fVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.api.f
        public final void onSuccess() {
            AppMethodBeat.i(227889);
            Log.i("MicroMsg.AppBrandPreRenderColdStartService", "onSuccess, requestId:" + this.kAd + ", cost:" + Util.ticksToNow(this.kAe));
            f fVar = this.kAf;
            if (fVar != null) {
                fVar.onSuccess();
            }
            h.INSTANCE.dN(1519, 1);
            AppMethodBeat.o(227889);
        }

        @Override // com.tencent.mm.plugin.appbrand.api.f
        public final void onError(int i2, String str) {
            AppMethodBeat.i(227890);
            StringBuilder append = new StringBuilder("onError, requestId:").append(this.kAd).append(", errCode:");
            f.b bVar = f.b.kHv;
            Log.e("MicroMsg.AppBrandPreRenderColdStartService", append.append(f.b.vM(i2)).append(", errMsg:").append(str).append(", cost:").append(Util.ticksToNow(this.kAe)).toString());
            f fVar = this.kAf;
            if (fVar != null) {
                fVar.onError(i2, str);
            }
            h hVar = h.INSTANCE;
            as asVar = as.kFm;
            hVar.dN(1519, as.vD(i2));
            AppMethodBeat.o(227890);
        }
    }
}
