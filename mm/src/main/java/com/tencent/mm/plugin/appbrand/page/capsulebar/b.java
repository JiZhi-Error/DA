package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i;
import com.tencent.mm.sdk.system.AndroidContextUtil;

/* access modifiers changed from: package-private */
public final class b extends j implements a {
    private final AppBrandRuntime kGM;
    private final i.a nuX;
    private Drawable nuY;
    private CharSequence nuZ;
    private int nva;

    public b(AppBrandRuntime appBrandRuntime, i.a aVar) {
        this.kGM = appBrandRuntime;
        this.nuX = aVar;
    }

    private boolean bSv() {
        AppMethodBeat.i(219466);
        if (this.kGM == null || this.kGM.isDestroyed() || this.kGM.SO || this.kGM.kAx == null) {
            AppMethodBeat.o(219466);
            return true;
        }
        AppMethodBeat.o(219466);
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.f
    public final Context getContext() {
        AppMethodBeat.i(219467);
        try {
            Context context = this.kGM.brh().getCurrentPage().getCurrentPageView().bRi().getContext();
            AppMethodBeat.o(219467);
            return context;
        } catch (NullPointerException e2) {
            Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(this.kGM.mContext);
            AppMethodBeat.o(219467);
            return castActivityOrNull;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.f
    public final void P(Runnable runnable) {
        AppMethodBeat.i(219468);
        this.kGM.i(runnable, 0);
        AppMethodBeat.o(219468);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.f
    public final void y(Drawable drawable) {
        AppMethodBeat.i(219469);
        this.nuY = drawable;
        if (bSv()) {
            AppMethodBeat.o(219469);
            return;
        }
        this.nuX.setLogo(drawable);
        AppMethodBeat.o(219469);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.f
    public final void E(CharSequence charSequence) {
        AppMethodBeat.i(219470);
        this.nuZ = charSequence;
        if (bSv()) {
            AppMethodBeat.o(219470);
            return;
        }
        this.nuX.setDescription(charSequence);
        AppMethodBeat.o(219470);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.f
    public final void yS(int i2) {
        AppMethodBeat.i(219471);
        this.nva = i2;
        if (bSv()) {
            AppMethodBeat.o(219471);
            return;
        }
        this.nuX.setStatus(i2);
        AppMethodBeat.o(219471);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.a
    public final i.a a(a.b bVar) {
        AppMethodBeat.i(219472);
        int i2 = bVar.nuU;
        int i3 = bVar.nuV;
        i.a bSB = super.bSB();
        bSB.setLogo(i3);
        bSB.yT(i2);
        bSB.setStatus(bVar.ordinal());
        AppMethodBeat.o(219472);
        return bSB;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.a
    public final int bSu() {
        return this.nva;
    }
}
