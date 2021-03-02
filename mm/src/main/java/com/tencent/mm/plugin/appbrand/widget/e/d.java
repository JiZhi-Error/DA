package com.tencent.mm.plugin.appbrand.widget.e;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d extends FrameLayout {
    public static final int oyG = Color.parseColor("#000000");
    public static final int oyv = Color.parseColor("#000000");
    public static final int oyw = Color.parseColor("#000000");
    private float anchorX = 0.0f;
    private float anchorY = 0.0f;
    private TextView oyF;
    private int oyH;
    private int oyI;
    private int oyJ;
    private int oyK;
    public int x = 0;
    public int y = 0;

    static {
        AppMethodBeat.i(146596);
        AppMethodBeat.o(146596);
    }

    public d(Context context) {
        super(context);
        AppMethodBeat.i(146587);
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.oyF = new TextView(context);
        this.oyF.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.oyF);
        AppMethodBeat.o(146587);
    }

    public final void reset() {
        AppMethodBeat.i(182824);
        setText("");
        setTextSize(12);
        setTextColor(oyv);
        setTextPadding(0);
        setGravity("center");
        int i2 = oyw;
        A(0, 0, i2, i2);
        AppMethodBeat.o(182824);
    }

    public final void A(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(146588);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) i2);
        gradientDrawable.setStroke(i3, i4);
        gradientDrawable.setColor(i5);
        this.oyF.setBackgroundDrawable(gradientDrawable);
        AppMethodBeat.o(146588);
    }

    public final void setText(String str) {
        AppMethodBeat.i(146589);
        this.oyF.setText(str);
        AppMethodBeat.o(146589);
    }

    public final void setTextSize(int i2) {
        AppMethodBeat.i(146590);
        this.oyF.setTextSize((float) i2);
        AppMethodBeat.o(146590);
    }

    public final void setTextColor(int i2) {
        AppMethodBeat.i(146591);
        this.oyF.setTextColor(i2);
        AppMethodBeat.o(146591);
    }

    public final void setTextPadding(int i2) {
        AppMethodBeat.i(146592);
        this.oyF.setPadding(i2, i2, i2, i2);
        AppMethodBeat.o(146592);
    }

    public final void setGravity(String str) {
        AppMethodBeat.i(146593);
        this.oyF.setGravity(17);
        AppMethodBeat.o(146593);
    }

    public final void setX(int i2) {
        this.x = i2;
    }

    public final void setY(int i2) {
        this.y = i2;
    }

    public final float getAnchorX() {
        return this.anchorX;
    }

    public final float getAnchorY() {
        return this.anchorY;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(146594);
        super.onMeasure(i2, i3);
        this.oyH = getMeasuredWidth();
        this.oyI = getMeasuredHeight();
        if ((-this.oyH) < this.x && this.x < 0) {
            this.oyJ = this.oyH;
            this.anchorX = ((float) Math.abs(this.x)) / (((float) this.oyH) * 1.0f);
        } else if (this.x >= 0) {
            this.oyJ = this.oyH + Math.abs(this.x);
            this.anchorX = 0.0f;
        } else {
            this.oyJ = Math.abs(this.x);
            this.anchorX = 1.0f;
        }
        if ((-this.oyI) < this.y && this.y < 0) {
            this.oyK = this.oyI;
            this.anchorY = ((float) Math.abs(this.y)) / (((float) this.oyI) * 1.0f);
        } else if (this.y >= 0) {
            this.oyK = this.oyI + Math.abs(this.y);
            this.anchorY = 0.0f;
        } else {
            this.oyK = Math.abs(this.y);
            this.anchorY = 1.0f;
        }
        setMeasuredDimension(this.oyJ, this.oyK);
        AppMethodBeat.o(146594);
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(146595);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getChildAt(0).getLayoutParams();
        if (this.x >= 0 && this.y >= 0) {
            layoutParams.gravity = 85;
        } else if (this.x >= 0 && this.y <= 0) {
            layoutParams.gravity = 53;
        } else if (this.x <= 0 && this.y >= 0) {
            layoutParams.gravity = 83;
        } else if (this.x <= 0 && this.y <= 0) {
            layoutParams.gravity = 51;
        }
        super.onLayout(z, i2, i3, i4, i5);
        AppMethodBeat.o(146595);
    }

    public final void eN(int i2, int i3) {
        AppMethodBeat.i(217261);
        if (i2 < 0 || i3 < 0) {
            AppMethodBeat.o(217261);
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.oyF.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i3;
        this.oyF.setLayoutParams(layoutParams);
        invalidate();
        AppMethodBeat.o(217261);
    }
}
