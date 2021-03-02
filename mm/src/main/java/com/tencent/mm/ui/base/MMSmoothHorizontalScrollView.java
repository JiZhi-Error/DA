package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMSmoothHorizontalScrollView extends HorizontalScrollView {
    private TranslateAnimation BAc;
    private Interpolator OPZ = new DecelerateInterpolator();
    private View OTc;
    private float mLastMotionX;
    private Rect mRect = new Rect();

    public MMSmoothHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(142152);
        setFadingEdgeLength(0);
        AppMethodBeat.o(142152);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(142153);
        if (getChildCount() > 0) {
            this.OTc = getChildAt(0);
        }
        AppMethodBeat.o(142153);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.i(142154);
        if (this.OTc == null) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(142154);
            return onTouchEvent;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastMotionX = motionEvent.getX();
                break;
            case 1:
            case 3:
                this.mLastMotionX = 0.0f;
                if (this.mRect.isEmpty()) {
                    z = false;
                }
                if (z) {
                    this.BAc = new TranslateAnimation((float) this.OTc.getLeft(), (float) this.mRect.left, 0.0f, 0.0f);
                    this.BAc.setInterpolator(this.OPZ);
                    this.BAc.setDuration((long) Math.abs(this.OTc.getLeft() - this.mRect.left));
                    this.OTc.startAnimation(this.BAc);
                    this.OTc.layout(this.mRect.left, this.mRect.top, this.mRect.right, this.mRect.bottom);
                    this.mRect.setEmpty();
                    break;
                }
                break;
            case 2:
                float x = motionEvent.getX();
                if (this.mLastMotionX == 0.0f) {
                    this.mLastMotionX = x;
                }
                int i2 = ((int) (this.mLastMotionX - x)) / 2;
                scrollBy(i2, 0);
                this.mLastMotionX = x;
                int measuredWidth = this.OTc.getMeasuredWidth() - ((getWidth() - getPaddingLeft()) - getPaddingRight());
                int scrollX = getScrollX();
                if (scrollX == 0 || scrollX == measuredWidth) {
                    z2 = true;
                }
                if (z2) {
                    if (this.mRect.isEmpty()) {
                        this.mRect.set(this.OTc.getLeft(), this.OTc.getTop(), this.OTc.getRight(), this.OTc.getBottom());
                    }
                    this.OTc.layout(this.OTc.getLeft() - i2, this.OTc.getTop(), this.OTc.getRight() - i2, this.OTc.getBottom());
                    break;
                }
                break;
        }
        boolean onTouchEvent2 = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(142154);
        return onTouchEvent2;
    }
}
