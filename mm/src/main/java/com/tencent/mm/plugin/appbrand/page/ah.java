package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J/\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPreloadedWidgetProvider;", "Lcom/tencent/mm/plugin/appbrand/page/IAppBrandPreloadedWidgetProvider;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "getPreloadedWidget", "WIDGET", "Landroid/view/View;", "clazz", "Ljava/lang/Class;", "ctx", "Landroid/content/Context;", "(Ljava/lang/Class;Landroid/content/Context;)Landroid/view/View;", "plugin-appbrand-integration_release"})
public final class ah implements ba {
    private final q kGW;

    public ah(q qVar) {
        p.h(qVar, "runtime");
        AppMethodBeat.i(229242);
        this.kGW = qVar;
        AppMethodBeat.o(229242);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ba
    public final <WIDGET extends View> WIDGET a(Class<WIDGET> cls, Context context) {
        AppMethodBeat.i(229241);
        p.h(cls, "clazz");
        p.h(context, "ctx");
        e bsn = this.kGW.bsn();
        Context appContext = this.kGW.getAppContext();
        p.g(appContext, "runtime.appContext");
        WIDGET widget = (WIDGET) bsn.a(cls, appContext);
        AppMethodBeat.o(229241);
        return widget;
    }
}
