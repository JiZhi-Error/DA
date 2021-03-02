package com.tencent.luggage.game.page.a;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.c.c;
import com.tencent.mm.plugin.appbrand.ui.y;
import com.tencent.mm.sdk.system.AndroidContextUtil;

/* access modifiers changed from: package-private */
public final class a implements c {
    private final ac cxn;
    private c.b cxo = null;

    public a(ac acVar) {
        this.cxn = acVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.c.c
    public final void Nj() {
        Window window;
        AppMethodBeat.i(130676);
        this.cxo = c.b.SHOWN;
        bT(false);
        if (Build.VERSION.SDK_INT >= 21 && (this.cxn.getContext() instanceof Activity) && (window = ((Activity) this.cxn.getContext()).getWindow()) != null) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
        AppMethodBeat.o(130676);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.c.c
    public final void Nk() {
        AppMethodBeat.i(130677);
        this.cxo = c.b.HIDDEN;
        bT(true);
        AppMethodBeat.o(130677);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.c.c
    public final void MV() {
        AppMethodBeat.i(130678);
        if (this.cxo == null) {
            this.cxo = this.cxn.getRuntime().getAppConfig().lbP.lcd ? c.b.SHOWN : c.b.HIDDEN;
        }
        switch (this.cxo) {
            case SHOWN:
                Nj();
                AppMethodBeat.o(130678);
                return;
            case HIDDEN:
                Nk();
                AppMethodBeat.o(130678);
                return;
            default:
                AppMethodBeat.o(130678);
                return;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.page.c.c
    public final c.b Nl() {
        return this.cxo;
    }

    private void bT(boolean z) {
        AppMethodBeat.i(130679);
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(this.cxn.getContext());
        if (castActivityOrNull == null) {
            AppMethodBeat.o(130679);
            return;
        }
        Window window = castActivityOrNull.getWindow();
        if (z) {
            y.a(window, true, true);
            AppMethodBeat.o(130679);
            return;
        }
        y.a(window, false, false);
        AppMethodBeat.o(130679);
    }
}
