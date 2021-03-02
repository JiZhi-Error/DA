package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u0015R\u001c\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\u00020\f*\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/FakeNativeRuntimeAutoReLaunchLogic;", "Lcom/tencent/mm/plugin/appbrand/IRuntimeAutoReLaunchLogicInterceptor;", "initialConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)V", "appId", "", "kotlin.jvm.PlatformType", "getAppId", "()Ljava/lang/String;", "mCurrentConfig", "mLastAcceptableEnterScene", "", "scene", "getScene", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)I", "onConfigUpdated", "", "newConfig", "shouldReLaunchOnConfigWillUpdate", "", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;)Ljava/lang/Boolean;", "Companion", "plugin-appbrand-integration_release"})
public final class ae implements aj {
    @Deprecated
    public static final a kER = new a((byte) 0);
    private AppBrandInitConfigWC kEP;
    private int kEQ;

    static {
        AppMethodBeat.i(175104);
        AppMethodBeat.o(175104);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/FakeNativeRuntimeAutoReLaunchLogic$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public ae(AppBrandInitConfigWC appBrandInitConfigWC) {
        p.h(appBrandInitConfigWC, "initialConfig");
        AppMethodBeat.i(175103);
        this.kEP = appBrandInitConfigWC;
        this.kEQ = appBrandInitConfigWC.Nz().scene;
        AppMethodBeat.o(175103);
    }

    @Override // com.tencent.mm.plugin.appbrand.aj
    public final Boolean b(AppBrandInitConfigWC appBrandInitConfigWC) {
        AppMethodBeat.i(175101);
        p.h(appBrandInitConfigWC, "newConfig");
        if (!this.kEP.ldN) {
            AppMethodBeat.o(175101);
            return null;
        }
        try {
            if (1038 == appBrandInitConfigWC.Nz().scene) {
                Log.i("MicroMsg.AppBrandRuntimeWC.FakeNativeRuntimeAutoReLaunchLogic", "shouldRelaunch return false. appId[" + this.kEP.appId + "], reason=1038 back from other MiniProgram");
                return Boolean.FALSE;
            }
            String str = appBrandInitConfigWC.kHw;
            if (!(str == null || str.length() == 0)) {
                Log.i("MicroMsg.AppBrandRuntimeWC.FakeNativeRuntimeAutoReLaunchLogic", "shouldRelaunch return true appId[" + this.kEP.appId + "] enterPath[" + appBrandInitConfigWC.kHw + ']');
                Boolean bool = Boolean.TRUE;
                c(appBrandInitConfigWC);
                AppMethodBeat.o(175101);
                return bool;
            }
            Boolean valueOf = Boolean.valueOf(this.kEQ != appBrandInitConfigWC.Nz().scene);
            Log.i("MicroMsg.AppBrandRuntimeWC.FakeNativeRuntimeAutoReLaunchLogic", "shouldRelaunch return " + valueOf.booleanValue() + " appId[" + this.kEP.appId + "] mLastAcceptableScene[" + this.kEQ + "] newScene[" + appBrandInitConfigWC.Nz().scene + ']');
            c(appBrandInitConfigWC);
            AppMethodBeat.o(175101);
            return valueOf;
        } finally {
            c(appBrandInitConfigWC);
            AppMethodBeat.o(175101);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.aj
    public final void c(AppBrandInitConfigWC appBrandInitConfigWC) {
        AppMethodBeat.i(175102);
        p.h(appBrandInitConfigWC, "newConfig");
        this.kEP = appBrandInitConfigWC;
        if (1038 != appBrandInitConfigWC.Nz().scene) {
            this.kEQ = appBrandInitConfigWC.Nz().scene;
        }
        AppMethodBeat.o(175102);
    }
}
