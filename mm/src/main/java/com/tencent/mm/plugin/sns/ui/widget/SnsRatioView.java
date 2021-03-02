package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SnsRatioView extends View {
    public int FfJ;
    public int FfK;
    public int FfL;
    public int FfM = 70;
    public int FfN = 10;
    public int FfO = 0;
    private Path FfP = new Path();
    private Path FfQ = new Path();
    public Paint FfR = new Paint();
    public Paint FfS = new Paint();
    public float[] FfT = new float[8];

    public SnsRatioView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(100559);
        AppMethodBeat.o(100559);
    }

    public final void iZ(int i2, int i3) {
        AppMethodBeat.i(100560);
        this.FfR.setColor(i2);
        this.FfS.setColor(i3);
        invalidate();
        AppMethodBeat.o(100560);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(100561);
        int width = getWidth();
        int height = getHeight();
        int tan = (int) (((double) height) / Math.tan(Math.toRadians((double) this.FfM)));
        int max = Math.max((int) ((((float) ((((width - tan) - this.FfN) - (this.FfL * 2)) * this.FfJ)) * 1.0f) / 100.0f), this.FfO);
        this.FfP.reset();
        this.FfP.moveTo(0.0f, 0.0f);
        this.FfP.lineTo((float) (max + tan), 0.0f);
        this.FfP.lineTo((float) max, (float) height);
        this.FfP.lineTo(0.0f, (float) height);
        this.FfP.close();
        this.FfQ.reset();
        this.FfQ.moveTo((float) (tan + max + this.FfN), 0.0f);
        this.FfQ.lineTo((float) width, 0.0f);
        this.FfQ.lineTo((float) width, (float) height);
        this.FfQ.lineTo((float) (this.FfN + max), (float) height);
        this.FfQ.close();
        Path path = new Path();
        path.addRoundRect(new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()), this.FfT, Path.Direction.CW);
        canvas.clipPath(path);
        canvas.drawPath(this.FfP, this.FfR);
        canvas.drawPath(this.FfQ, this.FfS);
        AppMethodBeat.o(100561);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(100562);
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            invalidate();
        }
        AppMethodBeat.o(100562);
    }
}
