package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SnsUnScaleTextView extends TextView {
    public SnsUnScaleTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public SnsUnScaleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(99501);
        try {
            super.onMeasure(i2, i3);
            AppMethodBeat.o(99501);
        } catch (Throwable th) {
            AppMethodBeat.o(99501);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(99502);
        try {
            super.onDraw(canvas);
            AppMethodBeat.o(99502);
        } catch (Throwable th) {
            AppMethodBeat.o(99502);
        }
    }

    public int getBaseline() {
        AppMethodBeat.i(99503);
        try {
            int baseline = super.getBaseline();
            AppMethodBeat.o(99503);
            return baseline;
        } catch (Throwable th) {
            AppMethodBeat.o(99503);
            return -1;
        }
    }

    public boolean onPreDraw() {
        AppMethodBeat.i(99504);
        try {
            boolean onPreDraw = super.onPreDraw();
            AppMethodBeat.o(99504);
            return onPreDraw;
        } catch (Throwable th) {
            AppMethodBeat.o(99504);
            return true;
        }
    }
}
