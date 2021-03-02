package com.tencent.mm.plugin.multitalk.ui.widget.projector.bubble;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends Drawable {
    private float auL;
    private final RectF auM;
    private final Rect auN;
    private boolean auP = false;
    private boolean auQ = true;
    private final Paint mPaint;

    public a(int i2, float f2) {
        AppMethodBeat.i(239504);
        this.auL = f2;
        this.mPaint = new Paint(5);
        this.mPaint.setColor(i2);
        this.auM = new RectF();
        this.auN = new Rect();
        AppMethodBeat.o(239504);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(239505);
        canvas.drawRoundRect(this.auM, this.auL, this.auL, this.mPaint);
        AppMethodBeat.o(239505);
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        AppMethodBeat.i(239506);
        super.onBoundsChange(rect);
        if (rect == null) {
            rect = getBounds();
        }
        this.auM.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.auN.set(rect);
        AppMethodBeat.o(239506);
    }

    public final void getOutline(Outline outline) {
        AppMethodBeat.i(239507);
        outline.setRoundRect(this.auN, this.auL);
        AppMethodBeat.o(239507);
    }

    public final void setAlpha(int i2) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getOpacity() {
        return -3;
    }
}
