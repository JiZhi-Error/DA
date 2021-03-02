package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public class LineLinearLayout extends LinearLayout {
    private int QCd;
    private Paint mPaint;
    private Rect mRect;

    public LineLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LineLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(143337);
        setWillNotDraw(false);
        this.mRect = new Rect();
        this.mPaint = new Paint();
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(-571543826);
        this.mPaint.setStrokeWidth((float) Math.round(a.getDensity(getContext()) * 0.5f));
        this.QCd = a.fromDPToPix(context, 44);
        AppMethodBeat.o(143337);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(143338);
        int measuredHeight = getMeasuredHeight();
        Paint paint = this.mPaint;
        for (int i2 = 1; this.QCd * i2 < measuredHeight; i2++) {
            canvas.drawLine(0.0f, (float) (this.QCd * i2), (float) getMeasuredWidth(), (float) (this.QCd * i2), paint);
        }
        super.onDraw(canvas);
        AppMethodBeat.o(143338);
    }
}
