package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.webkit.URLUtil;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.widget.tabbar.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J&\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nH\u0002R.\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/widget/tabbar/IconLoaderManager;", "", "()V", "iconLoaderMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/widget/tabbar/IconLoader;", "Lkotlin/collections/HashMap;", "getIconLoaderInner", "iconPath", "", "errorHandler", "Lcom/tencent/mm/plugin/appbrand/widget/tabbar/IconLoadErrorHandler;", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "getSpecificLoader", FirebaseAnalytics.b.INDEX, "isPackageIcon", "", "luggage-wxa-app_release"})
public final class f {
    final HashMap<Integer, d> oFi = new HashMap<>();

    public f() {
        AppMethodBeat.i(135628);
        AppMethodBeat.o(135628);
    }

    public final d a(String str, c cVar, s sVar, int i2) {
        AppMethodBeat.i(135625);
        p.h(str, "iconPath");
        p.h(cVar, "errorHandler");
        p.h(sVar, "service");
        d a2 = a(str, cVar, sVar);
        a2.setIndex(i2);
        a2.a(new a(this));
        d dVar = this.oFi.get(Integer.valueOf(i2));
        if (dVar != null) {
            dVar.cancel();
        }
        this.oFi.put(Integer.valueOf(i2), a2);
        AppMethodBeat.o(135625);
        return a2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "destroy"})
    static final class a implements d.a {
        final /* synthetic */ f oFj;

        a(f fVar) {
            this.oFj = fVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.tabbar.d.a
        public final void destroy(int i2) {
            AppMethodBeat.i(135624);
            if (i2 >= 0) {
                this.oFj.oFi.put(Integer.valueOf(i2), null);
            }
            AppMethodBeat.o(135624);
        }
    }

    private static d a(String str, c cVar, s sVar) {
        AppMethodBeat.i(135626);
        if (true == (URLUtil.isHttpsUrl(str) || URLUtil.isHttpUrl(str))) {
            g gVar = new g(str, cVar, sVar);
            AppMethodBeat.o(135626);
            return gVar;
        } else if (true == n.J(str, "wxfile://", false)) {
            i iVar = new i(str, cVar, sVar);
            AppMethodBeat.o(135626);
            return iVar;
        } else if (true == agl(str)) {
            h hVar = new h(str, cVar, sVar);
            AppMethodBeat.o(135626);
            return hVar;
        } else {
            b bVar = new b(str, cVar);
            AppMethodBeat.o(135626);
            return bVar;
        }
    }

    private static boolean agl(String str) {
        AppMethodBeat.i(135627);
        if (n.nm(str, ".png") || n.nm(str, ".jpg") || n.nm(str, ".bmp") || n.nm(str, ".gif")) {
            AppMethodBeat.o(135627);
            return true;
        }
        AppMethodBeat.o(135627);
        return false;
    }
}
