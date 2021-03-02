package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class MMProcessBar extends View {
    private Animation FN = new RotateAnimation(0.0f, 360.0f);
    private float QDe = 0.0f;

    public MMProcessBar(Context context) {
        super(context);
        AppMethodBeat.i(205404);
        AppMethodBeat.o(205404);
    }

    public MMProcessBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(164211);
        AppMethodBeat.o(164211);
    }

    public MMProcessBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(164212);
        AppMethodBeat.o(164212);
    }

    public void setVisibility(int i2) {
        AppMethodBeat.i(164213);
        super.setVisibility(i2);
        if (i2 == 0) {
            gYP();
            AppMethodBeat.o(164213);
            return;
        }
        gYO();
        AppMethodBeat.o(164213);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(164214);
        super.onDetachedFromWindow();
        gYO();
        AppMethodBeat.o(164214);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(164215);
        super.onAttachedToWindow();
        gYP();
        AppMethodBeat.o(164215);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(164216);
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            gYO();
            this.FN = new RotateAnimation(0.0f, 72000.0f, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
            this.FN.setRepeatMode(-1);
            this.FN.setRepeatCount(-1);
            this.FN.setDuration(70000);
            this.FN.setInterpolator(new LinearInterpolator());
            if (getVisibility() == 0) {
                gYP();
            }
        }
        AppMethodBeat.o(164216);
    }

    public final void setBackground$255f295(int i2) {
        AppMethodBeat.i(205405);
        try {
            Drawable drawable = getResources().getDrawable(R.raw.finder_live_icon_location_loading);
            drawable.setColorFilter(MMApplicationContext.getContext().getResources().getColor(R.color.BW_70), PorterDuff.Mode.SRC_ATOP);
            if (i2 != 0) {
                a.a(drawable, ColorStateList.valueOf(i2));
            }
            setBackground(drawable);
            AppMethodBeat.o(205405);
        } catch (Exception e2) {
            AppMethodBeat.o(205405);
        }
    }

    public final void gYO() {
        AppMethodBeat.i(164217);
        if (this.FN != null) {
            this.FN.cancel();
        }
        clearAnimation();
        AppMethodBeat.o(164217);
    }

    public final void gYP() {
        AppMethodBeat.i(164218);
        if (getVisibility() == 0) {
            startAnimation(this.FN);
            AppMethodBeat.o(164218);
            return;
        }
        Log.w("MicroMsg.MMProcessBar", "[startRotate] startRotate fail. this view Visibility=%s", Integer.valueOf(getVisibility()));
        AppMethodBeat.o(164218);
    }

    public final boolean gYQ() {
        AppMethodBeat.i(205406);
        if (this.FN == null || this.FN.hasEnded() || !this.FN.hasStarted()) {
            AppMethodBeat.o(205406);
            return false;
        }
        AppMethodBeat.o(205406);
        return true;
    }

    public final void rotate(float f2) {
        AppMethodBeat.i(164219);
        if (this.FN != null && !this.FN.hasEnded()) {
            this.FN.cancel();
        }
        this.QDe += f2;
        setRotation(this.QDe * 360.0f);
        AppMethodBeat.o(164219);
    }

    public void setDuration(long j2) {
        AppMethodBeat.i(164220);
        this.FN.setDuration(j2);
        AppMethodBeat.o(164220);
    }

    public void setInterpolator(Interpolator interpolator) {
        AppMethodBeat.i(164221);
        this.FN.setInterpolator(interpolator);
        AppMethodBeat.o(164221);
    }
}
