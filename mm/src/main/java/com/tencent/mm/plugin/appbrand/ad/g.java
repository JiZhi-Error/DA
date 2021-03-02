package com.tencent.mm.plugin.appbrand.ad;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.luggage.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.appbrand.page.ao;
import com.tencent.mm.plugin.appbrand.s;
import java.util.Map;

public final class g extends j implements h {
    private s kGT;
    public ao kGU;
    public f kGV;

    public g(s sVar) {
        AppMethodBeat.i(134653);
        this.kGT = sVar;
        AppMethodBeat.o(134653);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final <T extends b> T M(Class<T> cls) {
        AppMethodBeat.i(134654);
        T t = (T) this.kGT.M(cls);
        AppMethodBeat.o(134654);
        return t;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.h
    public final View getContentView() {
        AppMethodBeat.i(134655);
        if (this.kGV != null) {
            ViewGroup contentContainer = this.kGV.getContentContainer();
            AppMethodBeat.o(134655);
            return contentContainer;
        }
        if (this.kGT.getRuntime() != null) {
            this.kGV = this.kGT.getRuntime().getRuntimeAdViewContainer();
            if (this.kGV != null) {
                ViewGroup contentContainer2 = this.kGV.getContentContainer();
                AppMethodBeat.o(134655);
                return contentContainer2;
            }
        }
        AppMethodBeat.o(134655);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.h
    private ao getCustomViewContainer() {
        AppMethodBeat.i(134656);
        if (this.kGU != null) {
            ao aoVar = this.kGU;
            AppMethodBeat.o(134656);
            return aoVar;
        } else if (getContentView() instanceof ViewGroup) {
            this.kGU = new ao((ViewGroup) getContentView());
            ao aoVar2 = this.kGU;
            AppMethodBeat.o(134656);
            return aoVar2;
        } else {
            AppMethodBeat.o(134656);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.h
    public final h.a gA(boolean z) {
        AppMethodBeat.i(219297);
        if (!z) {
            ao customViewContainer = getCustomViewContainer();
            AppMethodBeat.o(219297);
            return customViewContainer;
        } else if (this.kGT.getRuntime().kAT != null) {
            com.tencent.mm.plugin.appbrand.page.j jVar = this.kGT.getRuntime().kAT;
            AppMethodBeat.o(219297);
            return jVar;
        } else {
            AppMethodBeat.o(219297);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.h
    public final boolean btO() {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final int getComponentId() {
        AppMethodBeat.i(134657);
        int hashCode = hashCode();
        AppMethodBeat.o(134657);
        return hashCode;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final String getAppId() {
        AppMethodBeat.i(134658);
        String appId = this.kGT.getAppId();
        AppMethodBeat.o(134658);
        return appId;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final Context getContext() {
        AppMethodBeat.i(134659);
        Context context = this.kGT.getContext();
        AppMethodBeat.o(134659);
        return context;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final boolean bsV() {
        return this.kGT.kEa;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final void P(Runnable runnable) {
        AppMethodBeat.i(134661);
        this.kGT.P(runnable);
        AppMethodBeat.o(134661);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final void i(Runnable runnable, long j2) {
        AppMethodBeat.i(219298);
        this.kGT.i(runnable, j2);
        AppMethodBeat.o(219298);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final void i(int i2, String str) {
        AppMethodBeat.i(134662);
        this.kGT.i(i2, str);
        AppMethodBeat.o(134662);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final void co(String str, String str2) {
        AppMethodBeat.i(134663);
        this.kGT.c(str, str2, 0);
        AppMethodBeat.o(134663);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final void a(bc bcVar) {
        AppMethodBeat.i(134664);
        this.kGT.a(bcVar);
        AppMethodBeat.o(134664);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final void a(bc bcVar, o oVar) {
        AppMethodBeat.i(219299);
        this.kGT.a(bcVar, oVar);
        AppMethodBeat.o(219299);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final void a(bc bcVar, int[] iArr) {
        AppMethodBeat.i(134665);
        this.kGT.a(bcVar);
        AppMethodBeat.o(134665);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final void b(String str, String str2, int[] iArr) {
        AppMethodBeat.i(134666);
        this.kGT.c(str, str2, 0);
        AppMethodBeat.o(134666);
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
    public final i Oo() {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final i getJsRuntime() {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final com.tencent.mm.plugin.appbrand.a.b getAppState() {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final Map<String, p> Op() {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final boolean isRunning() {
        AppMethodBeat.i(134660);
        if (this.kGT.getRuntime() == null || this.kGT.getRuntime().isDestroyed()) {
            AppMethodBeat.o(134660);
            return false;
        }
        AppMethodBeat.o(134660);
        return true;
    }
}
