package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.u;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView;
import com.tencent.mm.plugin.appbrand.page.capsulebar.e;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.d;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;

@SuppressLint({"ViewConstructor"})
public final class bp extends FrameLayout implements b.d {
    private ac cwK;
    d nqL;
    private b nqM;
    boolean nuo = false;

    public bp(Context context, ac acVar) {
        super(context);
        AppMethodBeat.i(147502);
        this.cwK = acVar;
        b.d pageConfig = this.cwK.getPageConfig();
        if (pageConfig == null) {
            AppMethodBeat.o(147502);
            return;
        }
        if (pageConfig.bzL()) {
            this.nqL = new d(getContext());
            this.nqL.setActuallyVisible(false);
            this.nqM = (com.tencent.mm.plugin.appbrand.widget.actionbar.b) this.cwK.npk.d(getContext(), com.tencent.mm.plugin.appbrand.widget.actionbar.b.class);
            this.nqM.setFullscreenMode(false);
            this.nqM.gz(true);
            try {
                e eVar = this.cwK.getRuntime().kAx;
                AppBrandCapsuleBarPlaceHolderView capsuleView = this.nqM.getCapsuleView();
                if (capsuleView != null) {
                    com.tencent.mm.plugin.appbrand.page.capsulebar.d dVar = eVar.nvi;
                    if (dVar == null) {
                        p.btv("capsuleBarView");
                    }
                    View capsuleContentAreaView = dVar.getCapsuleContentAreaView();
                    p.g(capsuleContentAreaView, "this.capsuleBarView.capsuleContentAreaView");
                    capsuleView.setFixedWidth(capsuleContentAreaView.getMeasuredWidth());
                }
            } catch (NullPointerException e2) {
            }
            bSo();
            this.nqL.addView(this.nqM);
            addView(this.nqL, -1, -2);
        }
        setBackgroundColor(g.cu(pageConfig.lco, -1));
        AppMethodBeat.o(147502);
    }

    /* access modifiers changed from: package-private */
    public final void bSo() {
        AppMethodBeat.i(147503);
        if (this.nqM == null) {
            AppMethodBeat.o(147503);
            return;
        }
        if (!TextUtils.isEmpty(this.cwK.bRi().getMainTitle())) {
            this.nqM.setMainTitle(this.cwK.bRi().getMainTitle());
        } else {
            this.nqM.setMainTitle(getContext().getString(R.string.hr));
        }
        this.nqM.setNavHidden(this.cwK.bRi().cae());
        AppMethodBeat.o(147503);
    }

    public final void setBackgroundColor(int i2) {
        boolean z = true;
        AppMethodBeat.i(147504);
        if (i2 == 0) {
            setWillNotDraw(true);
            AppMethodBeat.o(147504);
            return;
        }
        int i3 = -16777216 | i2;
        setWillNotDraw(false);
        super.setBackgroundColor(i3);
        if (this.nqM != null) {
            this.nqM.setBackgroundAlpha(1.0d);
            this.nqM.setBackgroundColor(i3);
            if (ar.aln(i3)) {
                z = false;
            }
            this.nqM.setForegroundStyle(z);
        }
        AppMethodBeat.o(147504);
    }

    private void bSp() {
        AppMethodBeat.i(147505);
        if (this.nqM != null) {
            if (getVisibility() != 0 || !u.aD(this)) {
                this.nqM.setLoadingIconVisibility(false);
                this.nqL.setActuallyVisible(false);
            } else {
                this.nqM.setLoadingIconVisibility(true);
                this.nqL.setActuallyVisible(true);
                AppMethodBeat.o(147505);
                return;
            }
        }
        AppMethodBeat.o(147505);
    }

    public final void setVisibility(int i2) {
        AppMethodBeat.i(147506);
        super.setVisibility(i2);
        bSp();
        AppMethodBeat.o(147506);
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        AppMethodBeat.i(147507);
        super.onAttachedToWindow();
        bSp();
        AppMethodBeat.o(147507);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(147508);
        super.onDetachedFromWindow();
        bSp();
        AppMethodBeat.o(147508);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.b.d
    public final void io(boolean z) {
        this.nuo = z;
    }
}
