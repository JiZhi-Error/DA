package com.tencent.mm.plugin.appbrand.page.c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.c.c;
import com.tencent.mm.sdk.system.AndroidContextUtil;

@TargetApi(21)
public class a extends b {
    private int hIX = 0;

    protected a(ac acVar) {
        super(acVar);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.c.c, com.tencent.mm.plugin.appbrand.page.c.b
    public void Nj() {
        AppMethodBeat.i(135309);
        bSF();
        AppMethodBeat.o(135309);
    }

    private void bSF() {
        AppMethodBeat.i(135310);
        this.nvY.set(c.b.SHOWN);
        if (this.cxn.getContext() instanceof Activity) {
            Window window = ((Activity) this.cxn.getContext()).getWindow();
            if (window == null) {
                AppMethodBeat.o(135310);
                return;
            }
            View decorView = window.getDecorView();
            window.clearFlags(1024);
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & -5);
        }
        AppMethodBeat.o(135310);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.c.c, com.tencent.mm.plugin.appbrand.page.c.b
    public void Nk() {
        AppMethodBeat.i(135311);
        this.nvY.set(c.b.HIDDEN);
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(this.cxn.getContext());
        if (castActivityOrNull != null && !castActivityOrNull.isFinishing() && !castActivityOrNull.isDestroyed()) {
            Window window = castActivityOrNull.getWindow();
            if (window == null) {
                AppMethodBeat.o(135311);
                return;
            }
            window.addFlags(1024);
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 4 | 256);
        }
        AppMethodBeat.o(135311);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.c.c, com.tencent.mm.plugin.appbrand.page.c.b
    public void MV() {
        AppMethodBeat.i(135312);
        super.MV();
        switch ((c.b) this.nvY.get()) {
            case SHOWN:
                bSF();
                AppMethodBeat.o(135312);
                return;
            case HIDDEN:
                Nk();
                AppMethodBeat.o(135312);
                return;
            default:
                AppMethodBeat.o(135312);
                return;
        }
    }

    public void u(boolean z, int i2) {
        AppMethodBeat.i(219489);
        boolean z2 = i2 != this.hIX;
        this.hIX = i2;
        if (2 == i2) {
            Activity activity = this.cxn.getActivity();
            if (activity == null || Build.VERSION.SDK_INT < 24 || !activity.isInMultiWindowMode() || activity.getRequestedOrientation() != 1) {
                if (!z) {
                    Nk();
                }
                AppMethodBeat.o(219489);
                return;
            }
            AppMethodBeat.o(219489);
            return;
        }
        if ((z2 || this.nvY.get() == c.b.SHOWN) && !z) {
            Nj();
        }
        AppMethodBeat.o(219489);
    }
}
