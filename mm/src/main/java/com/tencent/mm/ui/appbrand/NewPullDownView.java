package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class NewPullDownView extends View {
    private float FSi = 0.0f;
    private boolean FSo = false;
    private float ONi = (20.0f * getResources().getDisplayMetrics().density);
    private float ONj = ((14.0f * getResources().getDisplayMetrics().density) - (getResources().getDisplayMetrics().density * 4.0f));
    private Paint ONk = new Paint(1);
    private Paint ONl;

    public NewPullDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(33826);
        this.ONk.setStyle(Paint.Style.FILL);
        this.ONk.setColor(-4408132);
        this.ONl = new Paint(1);
        this.ONl.setStyle(Paint.Style.STROKE);
        this.ONl.setColor(0);
        this.ONl.setStrokeWidth(getResources().getDisplayMetrics().density * 4.0f);
        this.ONl.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        AppMethodBeat.o(33826);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(33827);
        super.onDraw(canvas);
        float measuredWidth = (float) (getMeasuredWidth() / 2);
        float measuredHeight = (float) (getMeasuredHeight() / 2);
        canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), null, 31);
        canvas.drawCircle(measuredWidth, measuredHeight, (this.FSi * this.ONi) / 2.0f, this.ONk);
        if (this.FSi >= 0.4f) {
            canvas.drawCircle(measuredWidth, measuredHeight, (((this.FSi - 0.4f) / 0.6f) * this.ONj) / 2.0f, this.ONl);
        }
        canvas.restore();
        AppMethodBeat.o(33827);
    }

    public void setVerticalScrollPercent(float f2) {
        AppMethodBeat.i(33828);
        Log.i("MicroMsg.PullDownView", "[setVerticalScrollPercent] percent:%s", Float.valueOf(f2));
        if (this.FSo) {
            f2 = 1.0f - f2;
        }
        this.FSi = Math.max(0.0f, Math.min(f2, 1.0f));
        postInvalidate();
        AppMethodBeat.o(33828);
    }
}
