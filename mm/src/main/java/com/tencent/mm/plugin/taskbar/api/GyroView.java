package com.tencent.mm.plugin.taskbar.api;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class GyroView extends View {
    private float FSi = 0.0f;
    private float FSj = 0.0f;
    private float FSk = (100.0f * getResources().getDisplayMetrics().density);
    private float FSl = (40.0f * getResources().getDisplayMetrics().density);
    private float FSm = (10.0f * getResources().getDisplayMetrics().density);
    private float FSn = (6.0f * getResources().getDisplayMetrics().density);
    private boolean FSo = false;
    private float auO = (20.0f * getResources().getDisplayMetrics().density);
    private Paint mPaint = new Paint(1);

    public GyroView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(197270);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(-9934744);
        AppMethodBeat.o(197270);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(197271);
        super.onDraw(canvas);
        float measuredWidth = ((float) getMeasuredWidth()) / 2.0f;
        float measuredHeight = ((float) getMeasuredHeight()) / 2.0f;
        if (this.FSj > 0.0f) {
            canvas.drawCircle(measuredWidth, measuredHeight, (this.FSm / 2.0f) - ((this.FSj * (this.FSm - this.FSn)) / 2.0f), this.mPaint);
            canvas.drawCircle(measuredWidth - (this.FSj * this.auO), measuredHeight, this.FSn / 2.0f, this.mPaint);
            canvas.drawCircle(measuredWidth + (this.FSj * this.auO), measuredHeight, this.FSn / 2.0f, this.mPaint);
            AppMethodBeat.o(197271);
            return;
        }
        canvas.drawCircle(measuredWidth, measuredHeight, (this.FSi * this.FSm) / 2.0f, this.mPaint);
        AppMethodBeat.o(197271);
    }

    public void setVerticalScroll(float f2) {
        AppMethodBeat.i(197272);
        float f3 = (f2 - this.FSl) / (this.FSk - this.FSl);
        if (this.FSo) {
            f3 = 1.0f - f3;
        }
        this.FSj = Math.max(0.0f, Math.min(f3, 1.0f));
        float f4 = f2 / this.FSl;
        if (this.FSo) {
            f4 = 1.0f - f4;
        }
        this.FSi = Math.max(0.0f, Math.min(f4, 1.0f));
        postInvalidate();
        AppMethodBeat.o(197272);
    }

    public final void c(float f2, int i2) {
        AppMethodBeat.i(197273);
        float f3 = (f2 - this.FSl) / (((float) i2) - this.FSl);
        if (this.FSo) {
            f3 = 1.0f - f3;
        }
        this.FSj = Math.max(0.0f, Math.min(f3, 1.0f));
        float f4 = f2 / this.FSl;
        if (this.FSo) {
            f4 = 1.0f - f4;
        }
        this.FSi = Math.max(0.0f, Math.min(f4, 1.0f));
        Log.d("MicroMsg.GyroView", "alvinluo GyroView setVerticalScroll y: %f, limit: %d, percent: %f, paddingPercent: %f", Float.valueOf(f2), Integer.valueOf(i2), Float.valueOf(this.FSi), Float.valueOf(this.FSj));
        postInvalidate();
        AppMethodBeat.o(197273);
    }
}
