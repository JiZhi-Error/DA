package com.tencent.liteav.renderer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXCFocusIndicatorView extends View {
    private static final int FOCUS_AREA_STROKE = 1;
    private int mFocusAreaStroke = 2;
    private Runnable mHideRunnable = new Runnable() {
        /* class com.tencent.liteav.renderer.TXCFocusIndicatorView.AnonymousClass1 */

        public void run() {
            AppMethodBeat.i(16750);
            TXCFocusIndicatorView.this.setVisibility(8);
            AppMethodBeat.o(16750);
        }
    };
    private Paint mPaint;
    private ScaleAnimation mScaleAnimation;
    private int mSize = 0;

    public TXCFocusIndicatorView(Context context) {
        super(context);
        AppMethodBeat.i(16938);
        init(null, 0);
        AppMethodBeat.o(16938);
    }

    public TXCFocusIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(16939);
        init(attributeSet, 0);
        AppMethodBeat.o(16939);
    }

    public TXCFocusIndicatorView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(16940);
        init(attributeSet, i2);
        AppMethodBeat.o(16940);
    }

    private void init(AttributeSet attributeSet, int i2) {
        AppMethodBeat.i(16941);
        this.mPaint = new Paint();
        this.mFocusAreaStroke = (int) ((getContext().getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        this.mScaleAnimation = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.mScaleAnimation.setDuration(200);
        AppMethodBeat.o(16941);
    }

    public void show(int i2, int i3, int i4) {
        AppMethodBeat.i(16942);
        removeCallbacks(this.mHideRunnable);
        this.mScaleAnimation.cancel();
        this.mSize = i4;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.setMargins(i2, i3, 0, 0);
        layoutParams.width = this.mSize;
        layoutParams.height = this.mSize;
        setVisibility(0);
        requestLayout();
        this.mScaleAnimation.reset();
        startAnimation(this.mScaleAnimation);
        postDelayed(this.mHideRunnable, 1000);
        AppMethodBeat.o(16942);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(16943);
        canvas.save();
        int i2 = this.mFocusAreaStroke / 2;
        Rect rect = new Rect(i2, i2, this.mSize - i2, this.mSize - i2);
        this.mPaint.setColor(-1);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth((float) (i2 * 2));
        canvas.drawRect(rect, this.mPaint);
        canvas.restore();
        super.onDraw(canvas);
        AppMethodBeat.o(16943);
    }
}
