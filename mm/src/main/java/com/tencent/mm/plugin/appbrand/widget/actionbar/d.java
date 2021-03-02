package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.u;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.statusbar.b;

public class d extends b {
    private boolean noY = true;
    private int olS = 0;
    private boolean omm = false;
    private int omn;
    private boolean omo = false;
    private Integer omp = null;

    public d(Context context) {
        super(context);
    }

    final class a extends ColorDrawable {
        a() {
            super(0);
        }

        public final void setColor(int i2) {
            AppMethodBeat.i(135444);
            super.setColor(i2);
            cai();
            AppMethodBeat.o(135444);
        }

        public final void setAlpha(int i2) {
            AppMethodBeat.i(135445);
            super.setAlpha(i2);
            cai();
            AppMethodBeat.o(135445);
        }

        private void cai() {
            AppMethodBeat.i(135446);
            d.this.setStatusBarColor(getColor());
            AppMethodBeat.o(135446);
        }
    }

    public void onViewAdded(View view) {
        AppMethodBeat.i(135447);
        super.onViewAdded(view);
        if (!(view instanceof e)) {
            IllegalAccessError illegalAccessError = new IllegalAccessError("Cant add non ActionBar instance here");
            AppMethodBeat.o(135447);
            throw illegalAccessError;
        }
        view.setBackground(new a());
        AppMethodBeat.o(135447);
    }

    private e getActionBar() {
        AppMethodBeat.i(219625);
        if (getChildCount() <= 0) {
            AppMethodBeat.o(219625);
            return null;
        }
        e eVar = (e) getChildAt(0);
        AppMethodBeat.o(219625);
        return eVar;
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean canAnimate() {
        return false;
    }

    @Override // com.tencent.mm.ui.statusbar.b
    public void dispatchSystemUiVisibilityChanged(int i2) {
        AppMethodBeat.i(135449);
        super.dispatchSystemUiVisibilityChanged(i2);
        if (this.noY && u.aD(this) && Qoi && (getWindowSystemUiVisibility() & 4) == 0) {
            Log.d("Luggage.WXA.AppBrandActionBarContainer", "dispatchSystemUiVisibilityChanged resetStatusBarForegroundStyle, hash[%d]", Integer.valueOf(hashCode()));
            cah();
        }
        AppMethodBeat.o(135449);
    }

    public void setStatusBarForegroundStyle(boolean z) {
        AppMethodBeat.i(135450);
        if (getActionBar() == null) {
            AppMethodBeat.o(135450);
            return;
        }
        S(getActionBar().getBackgroundColor(), z);
        AppMethodBeat.o(135450);
    }

    @Override // com.tencent.mm.ui.statusbar.b
    public void setStatusBarColor(int i2) {
        AppMethodBeat.i(135451);
        S(i2, this.omm);
        AppMethodBeat.o(135451);
    }

    @Override // com.tencent.mm.ui.statusbar.b
    public final void S(int i2, boolean z) {
        AppMethodBeat.i(135452);
        this.olS = i2;
        this.omm = z;
        if (!this.noY) {
            if (!this.omo) {
                super.l(i2, z, false);
            }
            AppMethodBeat.o(135452);
            return;
        }
        super.l(i2, z, true);
        AppMethodBeat.o(135452);
    }

    public final void cah() {
        AppMethodBeat.i(135453);
        Log.d("Luggage.WXA.AppBrandActionBarContainer", "resetStatusBarForegroundStyle hash[%d] color[%d] foregroundDark[%b] mActuallyVisible[%b] mDeferStatusBarHeightChange[%b]", Integer.valueOf(hashCode()), Integer.valueOf(this.olS), Boolean.valueOf(this.omm), Boolean.valueOf(this.noY), Boolean.valueOf(this.omo));
        S(this.olS, this.omm);
        AppMethodBeat.o(135453);
    }

    public void setActuallyVisible(boolean z) {
        AppMethodBeat.i(135454);
        boolean z2 = z != this.noY;
        this.noY = z;
        if (z2 && z) {
            cah();
            setDeferStatusBarHeightChange(false);
            setWillNotDraw(false);
        }
        if (z2 && !z) {
            setDeferStatusBarHeightChange(true);
        }
        AppMethodBeat.o(135454);
    }

    public void setDeferStatusBarHeightChange(boolean z) {
        AppMethodBeat.i(135455);
        boolean z2 = z != this.omo;
        this.omo = z;
        if (z2 && !z) {
            super.yf(this.omn);
        }
        AppMethodBeat.o(135455);
    }

    @Override // com.tencent.mm.ui.statusbar.b, com.tencent.mm.ui.statusbar.c.a
    public final void yf(int i2) {
        AppMethodBeat.i(135456);
        Log.i("Luggage.WXA.AppBrandActionBarContainer", "onStatusBarHeightChange: newHeight = ".concat(String.valueOf(i2)));
        if (this.omp != null) {
            int intValue = this.omp.intValue();
            this.omn = intValue;
            super.yf(intValue);
            AppMethodBeat.o(135456);
            return;
        }
        this.omn = i2;
        if (this.omo) {
            AppMethodBeat.o(135456);
            return;
        }
        super.yf(i2);
        AppMethodBeat.o(135456);
    }

    public void setForceTopInsetsHeight(int i2) {
        AppMethodBeat.i(135457);
        this.omp = Integer.valueOf(i2);
        AppMethodBeat.o(135457);
    }

    public final void aG(Context context) {
        AppMethodBeat.i(135458);
        if (getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) getContext()).setBaseContext(context);
        }
        if (this.omp != null) {
            yf(0);
        }
        AppMethodBeat.o(135458);
    }
}
