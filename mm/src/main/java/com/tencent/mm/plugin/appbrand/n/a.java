package com.tencent.mm.plugin.appbrand.n;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ao;
import com.tencent.mm.plugin.appbrand.page.j;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public final class a extends LinearLayout implements h {
    private static volatile int mOp;
    private ac cwK;
    public ao kGU;
    public LinearLayout mOo;
    public Runnable mOq = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.n.a.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(219311);
            Log.i("MicroMsg.AppBrandKeyBoardComponentView", "clear all views runnable");
            if (a.this.kGU != null) {
                a.this.kGU.clear();
            }
            if (a.this.mOo != null) {
                a.this.mOo.removeAllViews();
            }
            AppMethodBeat.o(219311);
        }
    };

    public a(Context context, ac acVar) {
        super(context);
        AppMethodBeat.i(219312);
        this.cwK = acVar;
        this.mOo = this;
        AppMethodBeat.o(219312);
    }

    public final AppBrandRuntime getRuntime() {
        AppMethodBeat.i(219313);
        AppBrandRuntime runtime = this.cwK.getRuntime();
        AppMethodBeat.o(219313);
        return runtime;
    }

    public final void setRootContainerViewId(int i2) {
        mOp = i2;
    }

    public final int getRootContainerViewId() {
        return mOp;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.h
    public final View getContentView() {
        return this.mOo;
    }

    public final FrameLayout getPageArea() {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.h
    public final boolean btO() {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.h
    public final ao getCustomViewContainer() {
        AppMethodBeat.i(219314);
        if (this.kGU != null) {
            Log.d("MicroMsg.AppBrandKeyBoardComponentView", "getCustomViewContainer, existed ViewContainer");
            ao aoVar = this.kGU;
            AppMethodBeat.o(219314);
            return aoVar;
        } else if (getContentView() instanceof ViewGroup) {
            this.kGU = new ao((ViewGroup) getContentView());
            Log.d("MicroMsg.AppBrandKeyBoardComponentView", "getCustomViewContainer, create customViewContainer");
            ao aoVar2 = this.kGU;
            AppMethodBeat.o(219314);
            return aoVar2;
        } else {
            AppMethodBeat.o(219314);
            return null;
        }
    }

    public final h.a getGlobalCustomViewContainer() {
        AppMethodBeat.i(219315);
        if (getRuntime().kAT != null) {
            j jVar = getRuntime().kAT;
            AppMethodBeat.o(219315);
            return jVar;
        }
        AppMethodBeat.o(219315);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.h
    public final h.a gA(boolean z) {
        AppMethodBeat.i(219316);
        if (z) {
            h.a globalCustomViewContainer = getGlobalCustomViewContainer();
            AppMethodBeat.o(219316);
            return globalCustomViewContainer;
        }
        ao customViewContainer = getCustomViewContainer();
        AppMethodBeat.o(219316);
        return customViewContainer;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final void b(String str, String str2, int[] iArr) {
        AppMethodBeat.i(219317);
        Log.d("MicroMsg.AppBrandKeyBoardComponentView", "publish String event, String data, int[] dst");
        this.cwK.c(str, str2, 0);
        AppMethodBeat.o(219317);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final void a(bc bcVar, int[] iArr) {
        AppMethodBeat.i(219318);
        Log.d("MicroMsg.AppBrandKeyBoardComponentView", "publish JsApiEvent event, int[] dst");
        this.cwK.a(bcVar);
        AppMethodBeat.o(219318);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final void i(int i2, String str) {
        AppMethodBeat.i(219319);
        this.cwK.i(i2, str);
        AppMethodBeat.o(219319);
    }

    public final void setInterceptor(f.b bVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final int getComponentId() {
        AppMethodBeat.i(219320);
        int hashCode = hashCode();
        AppMethodBeat.o(219320);
        return hashCode;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final String getAppId() {
        AppMethodBeat.i(219321);
        String appId = this.cwK.getAppId();
        AppMethodBeat.o(219321);
        return appId;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final boolean isRunning() {
        AppMethodBeat.i(219322);
        if (getRuntime() == null || getRuntime().isDestroyed()) {
            AppMethodBeat.o(219322);
            return false;
        }
        AppMethodBeat.o(219322);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final boolean bsV() {
        AppMethodBeat.i(219323);
        boolean bsV = this.cwK.bsV();
        AppMethodBeat.o(219323);
        return bsV;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final void co(String str, String str2) {
        AppMethodBeat.i(219324);
        this.cwK.c(str, str2, 0);
        AppMethodBeat.o(219324);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final void a(bc bcVar) {
        AppMethodBeat.i(219325);
        this.cwK.a(bcVar);
        AppMethodBeat.o(219325);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final void a(bc bcVar, o oVar) {
        AppMethodBeat.i(219326);
        this.cwK.a(bcVar, oVar);
        AppMethodBeat.o(219326);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final i Oo() {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final i getJsRuntime() {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final b getAppState() {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final Map<String, p> Op() {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final <T extends m> T av(Class<T> cls) {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final <T extends n> T aw(Class<T> cls) {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final boolean a(n nVar) {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final Handler getAsyncHandler() {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final q getFileSystem() {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final com.tencent.mm.plugin.appbrand.widget.dialog.m getDialogContainer() {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final void P(Runnable runnable) {
        AppMethodBeat.i(219327);
        this.cwK.P(runnable);
        AppMethodBeat.o(219327);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final void i(Runnable runnable, long j2) {
        AppMethodBeat.i(219328);
        this.cwK.i(runnable, j2);
        AppMethodBeat.o(219328);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final <T extends com.tencent.luggage.a.b> T M(Class<T> cls) {
        AppMethodBeat.i(219329);
        T t = (T) this.cwK.M(cls);
        AppMethodBeat.o(219329);
        return t;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i
    public final void a(i.c cVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i
    public final void b(i.c cVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i
    public final void a(i.b bVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i
    public final void b(i.b bVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i
    public final void a(i.d dVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i
    public final void b(i.d dVar) {
    }
}
