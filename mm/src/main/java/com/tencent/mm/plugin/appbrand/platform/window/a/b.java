package com.tencent.mm.plugin.appbrand.platform.window.a;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.platform.window.a;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;

final class b extends a {
    private int nEA = -1;
    private WindowManager.LayoutParams nEB;
    private final d.c nEy;
    private int nEz;

    b(final o oVar, d.b bVar) {
        super(oVar, bVar);
        AppMethodBeat.i(219575);
        this.nEy = new d.c() {
            /* class com.tencent.mm.plugin.appbrand.platform.window.a.b.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.platform.window.d.c
            public final void a(e.b bVar) {
                AppMethodBeat.i(219574);
                oVar.bTY().a(bVar, null);
                AppMethodBeat.o(219574);
            }
        };
        AppMethodBeat.o(219575);
    }

    private Activity getActivity() {
        AppMethodBeat.i(219576);
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(((o) this.kEb).mContext);
        AppMethodBeat.o(219576);
        return castActivityOrNull;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.d
    public final void vH(int i2) {
        AppMethodBeat.i(219577);
        this.nEi = true;
        switch (i2) {
            case -90:
                this.nEy.a(e.b.yZ(8));
                AppMethodBeat.o(219577);
                return;
            case 0:
                this.nEy.a(e.b.yZ(1));
                AppMethodBeat.o(219577);
                return;
            case 90:
                this.nEy.a(e.b.yZ(0));
                AppMethodBeat.o(219577);
                return;
            default:
                this.nEy.a(e.b.yZ(9));
                AppMethodBeat.o(219577);
                return;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a, com.tencent.mm.plugin.appbrand.platform.window.d
    public final void N(View view, int i2) {
        AppMethodBeat.i(219578);
        super.N(view, i2);
        Activity activity = getActivity();
        if (activity != null) {
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            if (this.nEh == null) {
                this.nEz = viewGroup.getSystemUiVisibility();
            }
            if (com.tencent.mm.compatible.util.d.oE(19)) {
                viewGroup.setSystemUiVisibility(2);
            } else {
                viewGroup.setSystemUiVisibility(4102);
            }
            if (this.nEh == null) {
                this.nEB = new WindowManager.LayoutParams();
                this.nEB.copyFrom(activity.getWindow().getAttributes());
            }
            activity.getWindow().addFlags(1024);
            if (Build.VERSION.SDK_INT >= 28) {
                activity.getWindow().getAttributes().layoutInDisplayCutoutMode = 2;
            }
            if (this.nEh == null) {
                this.nEA = activity.getRequestedOrientation();
            }
            vH(i2);
        } else {
            Log.e("Luggage.ActivityWindowFullscreenImpl", "enterFullscreen, get NULL activity");
            if (this.nEh == null) {
                this.nEA = -1;
                this.nEB = null;
                this.nEz = 0;
            }
        }
        bTL();
        this.nEh = null;
        AppMethodBeat.o(219578);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.a, com.tencent.mm.plugin.appbrand.platform.window.d
    public final boolean btC() {
        AppMethodBeat.i(219579);
        boolean z = this.nEi;
        if (super.btC()) {
            Activity activity = getActivity();
            if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                Log.e("Luggage.ActivityWindowFullscreenImpl", "exitFullscreen activity(%s) destroyed", activity);
            } else {
                ((ViewGroup) activity.getWindow().getDecorView()).setSystemUiVisibility(this.nEz);
                activity.getWindow().clearFlags(1024);
                if (this.nEB != null) {
                    activity.getWindow().setAttributes(this.nEB);
                }
                this.nEy.a(e.b.yZ(this.nEA));
                this.nEA = -1;
            }
            bTM();
            AppMethodBeat.o(219579);
            return true;
        } else if (z) {
            this.nEi = false;
            bTM();
            AppMethodBeat.o(219579);
            return true;
        } else {
            AppMethodBeat.o(219579);
            return false;
        }
    }
}
