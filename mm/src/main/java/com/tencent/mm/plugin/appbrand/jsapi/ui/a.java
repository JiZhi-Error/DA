package com.tencent.mm.plugin.appbrand.jsapi.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.bg;
import com.tencent.mm.plugin.appbrand.page.e;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.ui.ag;
import com.tencent.mm.plugin.appbrand.ui.al;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/JsApiGetMenuButtonBoundingClientRectWC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiGetMenuButtonBoundingClientRect;", "()V", "wechatIMPL", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider;", "provideLayoutPropertiesProvider", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "Companion", "plugin-appbrand-integration_release"})
public final class a extends bg {
    @Deprecated
    public static final C0703a muS = new C0703a((byte) 0);
    private ag muR;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/JsApiGetMenuButtonBoundingClientRectWC$Companion;", "", "()V", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ui.a$a  reason: collision with other inner class name */
    static final class C0703a {
        private C0703a() {
        }

        public /* synthetic */ C0703a(byte b2) {
            this();
        }
    }

    public a() {
        AppMethodBeat.i(175187);
        AppMethodBeat.o(175187);
    }

    static {
        boolean z = false;
        AppMethodBeat.i(180478);
        if (WeChatEnvironment.hasDebugger()) {
            z = true;
        }
        bg.hi(z);
        AppMethodBeat.o(180478);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bg
    public final ag j(s sVar) {
        AppMethodBeat.i(175186);
        p.h(sVar, "service");
        if (this.muR == null) {
            AppBrandRuntime runtime = sVar.getRuntime();
            if (runtime == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.AppBrandRuntimeWC");
                AppMethodBeat.o(175186);
                throw tVar;
            }
            q qVar = (q) runtime;
            e bsn = qVar.bsn();
            Context appContext = qVar.getAppContext();
            p.g(appContext, "rt.appContext");
            this.muR = new b(bsn.c(appContext, com.tencent.mm.plugin.appbrand.widget.actionbar.b.class), qVar, qVar);
        }
        ag agVar = this.muR;
        if (agVar == null) {
            p.btv("wechatIMPL");
        }
        AppMethodBeat.o(175186);
        return agVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/ui/JsApiGetMenuButtonBoundingClientRectWC$provideLayoutPropertiesProvider$2$1", "Lcom/tencent/mm/plugin/appbrand/ui/WxaMenuButtonLayoutPropertiesProvider;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "plugin-appbrand-integration_release"})
    public static final class b extends al {
        final /* synthetic */ Context muT;
        final /* synthetic */ q muU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context, q qVar, AppBrandRuntime appBrandRuntime) {
            super(appBrandRuntime);
            this.muT = context;
            this.muU = qVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.ui.al
        public final Context getContext() {
            return this.muT;
        }
    }
}
