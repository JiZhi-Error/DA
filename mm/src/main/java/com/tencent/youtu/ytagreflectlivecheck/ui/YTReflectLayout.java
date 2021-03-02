package com.tencent.youtu.ytagreflectlivecheck.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class YTReflectLayout extends RelativeLayout {
    private static String TAG = "YTReflectLayout";
    private ColorMatrixColorFilter mColorMatrixColorFilter;
    private Paint mPaint = new Paint(1);
    private Rect mRect = new Rect();

    public YTReflectLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(43406);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(Color.argb(200, 0, 0, 0));
        this.mColorMatrixColorFilter = new ColorMatrixColorFilter(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
        setWillNotDraw(false);
        AppMethodBeat.o(43406);
    }

    public void setColorMatrixColorFilter(ColorMatrixColorFilter colorMatrixColorFilter) {
        AppMethodBeat.i(43407);
        this.mColorMatrixColorFilter = colorMatrixColorFilter;
        invalidate();
        AppMethodBeat.o(43407);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(43408);
        super.onDraw(canvas);
        this.mPaint.setColorFilter(this.mColorMatrixColorFilter);
        this.mRect.set(0, 0, getWidth(), getHeight());
        canvas.drawRect(this.mRect, this.mPaint);
        AppMethodBeat.o(43408);
    }
}
