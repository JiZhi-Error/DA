package com.tencent.mm.plugin.appbrand.platform.window;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ak;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.appbrand.utils.a;
import com.tencent.mm.plugin.appbrand.utils.ac;
import com.tencent.mm.plugin.appbrand.utils.q;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.m;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/platform/window/WxaOrientationGetter;", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter;", "orientationHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;)V", "curOrientation", "Lcom/tencent/mm/plugin/appbrand/utils/Orientation;", "getCurOrientation", "()Lcom/tencent/mm/plugin/appbrand/utils/Orientation;", "name", "", "getName", "()Ljava/lang/String;", "wxaOrientation2Orientation", "wxaOrientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "Companion", "luggage-wxa-app_release"})
public final class h implements q {
    public static final a nEx = new a((byte) 0);
    private final e nEw;

    static {
        AppMethodBeat.i(219773);
        AppMethodBeat.o(219773);
    }

    public h(e eVar) {
        p.h(eVar, "orientationHandler");
        AppMethodBeat.i(219772);
        this.nEw = eVar;
        AppMethodBeat.o(219772);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/platform/window/WxaOrientationGetter$Companion;", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter$IFactory;", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter;", "componentView", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentView;", "luggage-wxa-app_release"})
    public static final class a implements q.a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.utils.q.a
        public final q a(com.tencent.mm.plugin.appbrand.jsapi.h hVar) {
            ak bri;
            c windowAndroid;
            e orientationHandler;
            AppMethodBeat.i(219769);
            if (hVar instanceof k) {
                AppBrandRuntime runtime = ((k) hVar).getRuntime();
                if (runtime == null || (bri = runtime.bri()) == null || (windowAndroid = bri.getWindowAndroid()) == null || (orientationHandler = windowAndroid.getOrientationHandler()) == null) {
                    a.C0812a aVar = com.tencent.mm.plugin.appbrand.utils.a.ogC;
                    com.tencent.mm.plugin.appbrand.utils.a b2 = a.C0812a.b(hVar);
                    Log.w("MicroMsg.AppBrand.WxaOrientationGetter", "create, something null, use AndroidOrientationGetter as fallback");
                    com.tencent.mm.plugin.appbrand.utils.a aVar2 = b2;
                    AppMethodBeat.o(219769);
                    return aVar2;
                }
                h hVar2 = new h(orientationHandler);
                AppMethodBeat.o(219769);
                return hVar2;
            }
            Log.w("MicroMsg.AppBrand.WxaOrientationGetter", "create, componentView is not AppBrandComponentWithExtra, use AndroidOrientationGetter as fallback");
            a.C0812a aVar3 = com.tencent.mm.plugin.appbrand.utils.a.ogC;
            com.tencent.mm.plugin.appbrand.utils.a b3 = a.C0812a.b(hVar);
            AppMethodBeat.o(219769);
            return b3;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.utils.q
    public final String getName() {
        return "WxaOrientationGetter";
    }

    @Override // com.tencent.mm.plugin.appbrand.utils.q
    public final ac bTN() {
        AppMethodBeat.i(219771);
        e.b btm = this.nEw.btm();
        p.g(btm, "orientationHandler.currentOrientation");
        switch (i.$EnumSwitchMapping$0[btm.ordinal()]) {
            case 1:
                ac acVar = ac.PORTRAIT;
                AppMethodBeat.o(219771);
                return acVar;
            case 2:
            case 3:
            case 4:
            case 5:
                ac acVar2 = ac.LANDSCAPE;
                AppMethodBeat.o(219771);
                return acVar2;
            case 6:
                ac acVar3 = ac.UNSPECIFIED;
                AppMethodBeat.o(219771);
                return acVar3;
            default:
                m mVar = new m();
                AppMethodBeat.o(219771);
                throw mVar;
        }
    }
}
