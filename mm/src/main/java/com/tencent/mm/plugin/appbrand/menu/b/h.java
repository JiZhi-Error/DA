package com.tencent.mm.plugin.appbrand.menu.b;

import android.content.Context;
import com.tencent.luggage.sdk.b.a.c.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.menu.a.b;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/menu/devtools/SecondaryMenuDelegate_GameForceGc;", "Lcom/tencent/mm/plugin/appbrand/menu/base/BaseSecondaryMenuDelegate;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "()V", "getTitle", "", "context", "Landroid/content/Context;", "pageView", "appId", "performItemClick", "", "shouldShow", "", "plugin-appbrand-integration_release"})
public final class h implements b<ag> {
    public static final h nfX = new h();

    static {
        AppMethodBeat.i(50889);
        AppMethodBeat.o(50889);
    }

    private h() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ boolean a(Context context, ag agVar, String str) {
        AppMethodBeat.i(50886);
        ag agVar2 = agVar;
        p.h(context, "context");
        p.h(agVar2, "pageView");
        p.h(str, "appId");
        m av = agVar2.av(AppBrandSysConfigWC.class);
        p.g(av, "pageView.getConfig(AppBr…dSysConfigWC::class.java)");
        AppBrandSysConfigWC appBrandSysConfigWC = (AppBrandSysConfigWC) av;
        if (appBrandSysConfigWC.leE.kNW == 1 || appBrandSysConfigWC.leE.kNW == 2 || WeChatEnvironment.hasDebugger() || WeChatEnvironment.isMonkeyEnv() || BuildInfo.IS_FLAVOR_RED || com.tencent.mm.plugin.appbrand.p.Un(str).kDe) {
            AppMethodBeat.o(50886);
            return true;
        }
        AppMethodBeat.o(50886);
        return false;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ String b(Context context, ag agVar, String str) {
        AppMethodBeat.i(50887);
        p.h(context, "context");
        p.h(agVar, "pageView");
        p.h(str, "appId");
        AppMethodBeat.o(50887);
        return "Request Force GC";
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ void c(Context context, ag agVar, String str) {
        AppMethodBeat.i(50888);
        ag agVar2 = agVar;
        p.h(context, "context");
        p.h(agVar2, "pageView");
        q runtime = agVar2.getRuntime();
        p.g(runtime, "pageView.runtime");
        c bsE = runtime.bsE();
        p.g(bsE, "service");
        ((com.tencent.mm.plugin.appbrand.m.q) bsE.getJsRuntime().R(com.tencent.mm.plugin.appbrand.m.q.class)).post(new a(bsE));
        AppMethodBeat.o(50888);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ c mpU;

        a(c cVar) {
            this.mpU = cVar;
        }

        public final void run() {
            AppMethodBeat.i(229051);
            c cVar = this.mpU;
            p.g(cVar, "service");
            f Ol = cVar.Ol();
            p.g(Ol, "service.delegate");
            Ol.Oz().Oh().requestV8GarbageCollectionForTest();
            AppMethodBeat.o(229051);
        }
    }
}
