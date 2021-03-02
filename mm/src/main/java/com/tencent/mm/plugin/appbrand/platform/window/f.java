package com.tencent.mm.plugin.appbrand.platform.window;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0001H\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0012H\u0016J\b\u0010\"\u001a\u00020\u0012H\u0016J\b\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u0018\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020.H\u0016J\u0018\u0010/\u001a\u00020%2\u0006\u00100\u001a\u0002012\u0006\u0010*\u001a\u00020+H\u0016J\b\u00102\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u00063"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplProxy;", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "base", "windowViewImplScope", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplScope;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplScope;)V", "getBase", "()Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "getWindowViewImplScope", "()Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplScope;", "compareTo", "", FacebookRequestErrorClassification.KEY_OTHER, "createFullscreenHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler;", "provider", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;", "forceLightMode", "", "getContext", "Landroid/content/Context;", "getNavigationBar", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid$WindowNavigationBar;", "getOrientationHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "getSafeAreaInsets", "Landroid/graphics/Rect;", "getScale", "", "getStatusBar", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid$WindowStatusBar;", "getVDisplayMetrics", "Landroid/util/DisplayMetrics;", "isInMultiWindowMode", "isLargeScreenWindow", "runInStandaloneTask", "setSoftOrientation", "", "name", "", "setWindowBackgroundColor", "backgroundColor", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "setWindowDescription", "description", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid$WindowDescription;", "setWindowLayoutParams", NativeProtocol.WEB_DIALOG_PARAMS, "Lcom/tencent/mm/plugin/appbrand/platform/window/WxaWindowLayoutParams;", "shouldInLargeScreenCompatMode", "luggage-wxa-app_release"})
public final class f implements c {
    public final c nEu;
    public final g nEv;

    public f(c cVar, g gVar) {
        p.h(cVar, "base");
        p.h(gVar, "windowViewImplScope");
        AppMethodBeat.i(219768);
        this.nEu = cVar;
        this.nEv = gVar;
        AppMethodBeat.o(219768);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(c cVar) {
        AppMethodBeat.i(219766);
        c cVar2 = cVar;
        p.h(cVar2, FacebookRequestErrorClassification.KEY_OTHER);
        if (!(cVar2 instanceof f)) {
            AppMethodBeat.o(219766);
            return -1;
        } else if (!p.j(((f) cVar2).nEv, this.nEv)) {
            AppMethodBeat.o(219766);
            return -1;
        } else {
            int compareTo = this.nEu.compareTo(((f) cVar2).nEu);
            AppMethodBeat.o(219766);
            return compareTo;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.c
    public final Context getContext() {
        AppMethodBeat.i(219751);
        Context context = this.nEu.getContext();
        p.g(context, "base.context");
        AppMethodBeat.o(219751);
        return context;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.c
    public final boolean bsc() {
        AppMethodBeat.i(219752);
        boolean bsc = this.nEu.bsc();
        AppMethodBeat.o(219752);
        return bsc;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.c, com.tencent.mm.plugin.appbrand.platform.window.g
    public final DisplayMetrics getVDisplayMetrics() {
        AppMethodBeat.i(219753);
        DisplayMetrics vDisplayMetrics = this.nEv.getVDisplayMetrics();
        p.g(vDisplayMetrics, "windowViewImplScope.vDisplayMetrics");
        AppMethodBeat.o(219753);
        return vDisplayMetrics;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.c
    public final boolean bsj() {
        AppMethodBeat.i(219754);
        boolean bsj = this.nEu.bsj();
        AppMethodBeat.o(219754);
        return bsj;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.c
    public final boolean isInMultiWindowMode() {
        AppMethodBeat.i(219755);
        boolean isInMultiWindowMode = this.nEu.isInMultiWindowMode();
        AppMethodBeat.o(219755);
        return isInMultiWindowMode;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.c, com.tencent.mm.plugin.appbrand.platform.window.g
    public final e getOrientationHandler() {
        AppMethodBeat.i(219756);
        e orientationHandler = this.nEv.getOrientationHandler();
        if (orientationHandler != null) {
            AppMethodBeat.o(219756);
            return orientationHandler;
        }
        e orientationHandler2 = this.nEu.getOrientationHandler();
        p.g(orientationHandler2, "base.orientationHandler");
        AppMethodBeat.o(219756);
        return orientationHandler2;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.c, com.tencent.mm.plugin.appbrand.platform.window.g
    public final d a(d.b bVar) {
        AppMethodBeat.i(219757);
        d a2 = this.nEv.a(bVar);
        if (a2 != null) {
            AppMethodBeat.o(219757);
            return a2;
        }
        d a3 = this.nEu.a(bVar);
        p.g(a3, "base.createFullscreenHandler(provider)");
        AppMethodBeat.o(219757);
        return a3;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.g
    public final float getScale() {
        AppMethodBeat.i(219758);
        float scale = this.nEv.getScale();
        AppMethodBeat.o(219758);
        return scale;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.c, com.tencent.mm.plugin.appbrand.platform.window.g
    public final void setSoftOrientation(String str) {
        AppMethodBeat.i(219759);
        p.h(str, "name");
        this.nEv.setSoftOrientation(str);
        AppMethodBeat.o(219759);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.c, com.tencent.mm.plugin.appbrand.platform.window.g
    public final boolean OD() {
        AppMethodBeat.i(219760);
        boolean OD = this.nEv.OD();
        AppMethodBeat.o(219760);
        return OD;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.g
    public final c.C0789c getStatusBar() {
        AppMethodBeat.i(219761);
        c.C0789c statusBar = this.nEv.getStatusBar();
        AppMethodBeat.o(219761);
        return statusBar;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.c
    public final Rect getSafeAreaInsets() {
        AppMethodBeat.i(219762);
        Rect safeAreaInsets = this.nEu.getSafeAreaInsets();
        AppMethodBeat.o(219762);
        return safeAreaInsets;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.c
    public final void setWindowDescription(c.a aVar) {
        AppMethodBeat.i(219763);
        p.h(aVar, "description");
        this.nEu.setWindowDescription(aVar);
        AppMethodBeat.o(219763);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.c
    public final void a(WxaWindowLayoutParams wxaWindowLayoutParams, AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(219764);
        p.h(wxaWindowLayoutParams, NativeProtocol.WEB_DIALOG_PARAMS);
        p.h(appBrandRuntime, "runtime");
        this.nEu.a(wxaWindowLayoutParams, appBrandRuntime);
        AppMethodBeat.o(219764);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.c
    public final void a(int i2, AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(219765);
        p.h(appBrandRuntime, "runtime");
        this.nEu.a(i2, appBrandRuntime);
        AppMethodBeat.o(219765);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.g
    public final boolean OG() {
        AppMethodBeat.i(219767);
        boolean OG = this.nEv.OG();
        AppMethodBeat.o(219767);
        return OG;
    }
}
