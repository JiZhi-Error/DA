package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ScrollAlwaysTextView extends TextView {
    public ScrollAlwaysTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public ScrollAlwaysTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        AppMethodBeat.i(141484);
        if (z) {
            super.onFocusChanged(z, i2, rect);
        }
        AppMethodBeat.o(141484);
    }

    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(141485);
        if (z) {
            super.onWindowFocusChanged(z);
        }
        AppMethodBeat.o(141485);
    }

    public boolean isFocused() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(141486);
        try {
            super.onMeasure(i2, i3);
            AppMethodBeat.o(141486);
        } catch (Throwable th) {
            AppMethodBeat.o(141486);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(141487);
        try {
            super.onDraw(canvas);
            AppMethodBeat.o(141487);
        } catch (Throwable th) {
            AppMethodBeat.o(141487);
        }
    }

    public int getBaseline() {
        AppMethodBeat.i(141488);
        try {
            int baseline = super.getBaseline();
            AppMethodBeat.o(141488);
            return baseline;
        } catch (Throwable th) {
            AppMethodBeat.o(141488);
            return -1;
        }
    }

    public boolean onPreDraw() {
        AppMethodBeat.i(141489);
        try {
            boolean onPreDraw = super.onPreDraw();
            AppMethodBeat.o(141489);
            return onPreDraw;
        } catch (Throwable th) {
            AppMethodBeat.o(141489);
            return true;
        }
    }
}
