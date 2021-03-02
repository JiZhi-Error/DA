package com.tencent.luggage.game.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.sdk.platformtools.Log;

@SuppressLint({"ViewConstructor"})
public final class e extends t {
    private ac cwK;
    private String mURL;

    public e(Context context, w wVar) {
        super(context, wVar);
        AppMethodBeat.i(130628);
        Log.i("MicroMsg.WAGamePage", "hy: WAGamePage on create");
        AppMethodBeat.o(130628);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final void loadUrl(String str) {
        AppMethodBeat.i(130630);
        this.mURL = str;
        this.cwK.dE(str);
        AppMethodBeat.o(130630);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final boolean dw(String str) {
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final void a(String str, String str2, int[] iArr) {
        AppMethodBeat.i(130631);
        this.cwK.c(str, str2, 0);
        AppMethodBeat.o(130631);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final ac getCurrentPageView() {
        return this.cwK;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final String getCurrentUrl() {
        return this.mURL;
    }

    public final void setCurrentUrl(String str) {
        this.mURL = str;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final ac hL(int i2) {
        AppMethodBeat.i(222887);
        if (this.cwK.getComponentId() == i2) {
            ac acVar = this.cwK;
            AppMethodBeat.o(222887);
            return acVar;
        }
        AppMethodBeat.o(222887);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final void cleanup() {
        AppMethodBeat.i(130632);
        super.cleanup();
        this.cwK.cleanup();
        AppMethodBeat.o(130632);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final void MU() {
        AppMethodBeat.i(130633);
        super.MU();
        this.cwK.onDestroy();
        AppMethodBeat.o(130633);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final void MV() {
        AppMethodBeat.i(130634);
        super.MV();
        setEnableGesture(false);
        this.cwK.onForeground();
        AppMethodBeat.o(130634);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final void MW() {
        AppMethodBeat.i(130635);
        super.MW();
        this.cwK.onBackground();
        AppMethodBeat.o(130635);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.t
    public final View MT() {
        AppMethodBeat.i(130629);
        ac bQT = getContainer().bQT();
        this.cwK = bQT;
        View contentView = bQT.getContentView();
        AppMethodBeat.o(130629);
        return contentView;
    }
}
