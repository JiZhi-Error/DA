package com.tencent.mm.plugin.appbrand;

import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0017\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/PreRenderAutoRelaunchLogicInterceptor;", "Lcom/tencent/mm/plugin/appbrand/IRuntimeAutoReLaunchLogicInterceptor;", "updatedConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "onConfigUpdated", "", "newConfig", "shouldReLaunchOnConfigWillUpdate", "", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)Ljava/lang/Boolean;", "Companion", "plugin-appbrand-integration_release"})
public final class ar implements aj {
    @Deprecated
    public static final a kFl = new a((byte) 0);
    private AppBrandInitConfigWC kFj;
    private final q kFk;

    static {
        AppMethodBeat.i(227933);
        AppMethodBeat.o(227933);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/PreRenderAutoRelaunchLogicInterceptor$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public ar(AppBrandInitConfigWC appBrandInitConfigWC, q qVar) {
        p.h(appBrandInitConfigWC, "updatedConfig");
        p.h(qVar, "rt");
        AppMethodBeat.i(227932);
        this.kFj = appBrandInitConfigWC;
        this.kFk = qVar;
        AppMethodBeat.o(227932);
    }

    @Override // com.tencent.mm.plugin.appbrand.aj
    public final Boolean b(AppBrandInitConfigWC appBrandInitConfigWC) {
        AppMethodBeat.i(227930);
        p.h(appBrandInitConfigWC, "newConfig");
        ag bsz = this.kFk.bsz();
        String bRl = bsz != null ? bsz.bRl() : null;
        String str = appBrandInitConfigWC.kHw;
        int i2 = this.kFj.Nz().scene;
        int i3 = appBrandInitConfigWC.Nz().scene;
        if (this.kFj.cyz != b.PRE_RENDER || this.kFj.cyz == appBrandInitConfigWC.cyz || !p.j(bRl, str) || i2 != i3) {
            AppMethodBeat.o(227930);
            return null;
        }
        Log.i("MicroMsg.AppBrand.PreRenderAutoRelaunchLogicInterceptor", "shouldReLaunchOnConfigWillUpdate returns false, appId:" + this.kFk.getAppId() + ", currentOriginRouteUrl:" + bRl + ", newRouteUrl:" + str + ", oldScene:" + i2 + ", newScene:" + i3);
        Boolean bool = Boolean.FALSE;
        AppMethodBeat.o(227930);
        return bool;
    }

    @Override // com.tencent.mm.plugin.appbrand.aj
    public final void c(AppBrandInitConfigWC appBrandInitConfigWC) {
        AppMethodBeat.i(227931);
        p.h(appBrandInitConfigWC, "newConfig");
        this.kFj = appBrandInitConfigWC;
        AppMethodBeat.o(227931);
    }
}
