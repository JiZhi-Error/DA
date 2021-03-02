package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.tencent.luggage.h.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

@SuppressLint({"ViewConstructor"})
public final class ak extends t {
    private ac cwK;
    private String mUrl;

    public ak(Context context, w wVar) {
        super(context, wVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final View MT() {
        AppMethodBeat.i(135241);
        if (this.cwK == null) {
            this.cwK = getContainer().bQT();
            this.cwK.nqU = this;
        }
        View contentView = this.cwK.getContentView();
        AppMethodBeat.o(135241);
        return contentView;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final void adB(String str) {
        AppMethodBeat.i(219450);
        this.mUrl = str;
        this.cwK.dE(str);
        AppMethodBeat.o(219450);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final ac hL(int i2) {
        AppMethodBeat.i(219451);
        if (this.cwK.getComponentId() == i2) {
            ac acVar = this.cwK;
            AppMethodBeat.o(219451);
            return acVar;
        }
        AppMethodBeat.o(219451);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final void loadUrl(String str) {
        AppMethodBeat.i(135242);
        Log.i("MicroMsg.AppBrandSinglePage", "AppBrandPageProfile| loadUrl, appId:%s, url:%s", getAppId(), str);
        if (this.mUrl != null) {
            AppMethodBeat.o(135242);
            return;
        }
        this.mUrl = str;
        this.cwK.dE(str);
        AppMethodBeat.o(135242);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final boolean dw(String str) {
        AppMethodBeat.i(135243);
        boolean equals = l.dM(this.mUrl).equals(l.dM(str));
        AppMethodBeat.o(135243);
        return equals;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final void MU() {
        AppMethodBeat.i(135244);
        super.MU();
        this.cwK.onDestroy();
        AppMethodBeat.o(135244);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final void cleanup() {
        AppMethodBeat.i(135245);
        super.cleanup();
        this.cwK.cleanup();
        AppMethodBeat.o(135245);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final void MV() {
        AppMethodBeat.i(135246);
        super.MV();
        this.cwK.onForeground();
        AppMethodBeat.o(135246);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final void MW() {
        AppMethodBeat.i(135247);
        super.MW();
        this.cwK.onBackground();
        AppMethodBeat.o(135247);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final void a(String str, String str2, int[] iArr) {
        AppMethodBeat.i(135248);
        if (!i(iArr, this.cwK.getComponentId())) {
            AppMethodBeat.o(135248);
            return;
        }
        this.cwK.c(str, str2, 0);
        AppMethodBeat.o(135248);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final ac getCurrentPageView() {
        return this.cwK;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final String getCurrentUrl() {
        return this.mUrl;
    }
}
