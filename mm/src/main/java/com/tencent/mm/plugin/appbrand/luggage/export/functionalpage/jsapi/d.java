package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005*$\b\u0002\u0010\u0007\"\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¨\u0006\b"}, hxF = {"runInMMActivity", "", "context", "Landroid/content/Context;", "block", "Lkotlin/Function1;", "Lcom/tencent/mm/ui/MMActivity;", "ProxyFunction", "plugin-appbrand-integration_release"})
public final class d {
    public static final void b(Context context, b<? super MMActivity, x> bVar) {
        AppMethodBeat.i(228895);
        p.h(bVar, "block");
        int hashCode = bVar.hashCode();
        a aVar = a.nbk;
        a.bOJ().put(bVar.hashCode(), bVar);
        if (MMApplicationContext.isAppBrandProcess()) {
            if (context == null) {
                context = MMApplicationContext.getContext();
            }
            a.b(context, new ProxyRequest(hashCode), null);
            AppMethodBeat.o(228895);
            return;
        }
        if (context == null) {
            context = MMApplicationContext.getContext();
        }
        a.a(context, new ProxyRequest(hashCode), (AppBrandProxyUIProcessTask.b) null);
        AppMethodBeat.o(228895);
    }
}
