package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import com.tencent.luggage.sdk.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0015\u001a\u00020\rH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0012\u0010\u000f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandCenterInsideWindowLayoutManagerWc;", "Lcom/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager;", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "ctx", "Landroid/content/Context;", "activityOrientationHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "base", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;)V", "isBlacklisting", "", "Ljava/lang/Boolean;", "mayDisableInHuaWeiDevices", "checkIsBlackListing", "blackList", "", "getStatusBar", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid$WindowStatusBar;", "shouldInLargeScreenCompatMode", "plugin-appbrand-integration_release"})
public final class d extends a<AppBrandInitConfigWC> {
    private final c nEu;
    private Boolean nSn;
    private Boolean nSo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(AppBrandRuntime appBrandRuntime, Context context, e eVar, c cVar) {
        super(appBrandRuntime, context, eVar);
        p.h(appBrandRuntime, "rt");
        p.h(context, "ctx");
        p.h(eVar, "activityOrientationHandler");
        p.h(cVar, "base");
        AppMethodBeat.i(229455);
        this.nEu = cVar;
        AppMethodBeat.o(229455);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.g
    public final c.C0789c getStatusBar() {
        AppMethodBeat.i(229454);
        c.C0789c statusBar = this.nEu.getStatusBar();
        AppMethodBeat.o(229454);
        return statusBar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        if (((com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC) r0).NA() != false) goto L_0x0028;
     */
    @Override // com.tencent.luggage.sdk.d.a, com.tencent.mm.plugin.appbrand.platform.window.g
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean OD() {
        /*
        // Method dump skipped, instructions count: 289
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.ui.d.OD():boolean");
    }
}
