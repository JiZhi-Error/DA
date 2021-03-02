package com.tencent.mm.plugin.emoji.ui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ScaleRelativeLayout extends RelativeLayout {
    public float aXt;
    private float aXu;
    private float rnA;
    private boolean rnB;
    private ValueAnimator rnC;
    private float rnv;
    private float rnw;
    private float rnx;
    private float rny;
    public float rnz;

    public ScaleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScaleRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.aXt = 3.0f;
        this.aXu = 0.5f;
        this.rnv = 1.0f;
        this.rnw = 1.0f;
        this.rnx = 0.0f;
        this.rny = 0.0f;
        this.rnz = 6.0f;
        this.rnA = 0.3f;
        this.rnB = false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(109435);
        if (motionEvent.getPointerCount() > 1) {
            AppMethodBeat.o(109435);
            return true;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(109435);
        return onInterceptTouchEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(109436);
        if (!this.rnB && motionEvent.getPointerCount() == 2) {
            this.rnB = true;
            this.rnx = (float) Math.hypot((double) (motionEvent.getX(0) - motionEvent.getX(1)), (double) (motionEvent.getY(0) - motionEvent.getY(1)));
            this.rnw = this.rnv;
        }
        switch (motionEvent.getActionMasked()) {
            case 1:
                float f2 = this.rnv;
                float f3 = this.rnv;
                if (this.rnv < this.aXu) {
                    f3 = this.aXu;
                } else if (this.rnv > this.aXt) {
                    f3 = this.aXt;
                }
                if (this.rnC != null) {
                    this.rnC.cancel();
                }
                this.rnC = ValueAnimator.ofFloat(f2, f3);
                this.rnC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.tencent.mm.plugin.emoji.ui.widget.ScaleRelativeLayout.AnonymousClass1 */

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.i(109434);
                        ScaleRelativeLayout.this.rnv = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        for (int i2 = 0; i2 < ScaleRelativeLayout.this.getChildCount(); i2++) {
                            View childAt = ScaleRelativeLayout.this.getChildAt(i2);
                            childAt.setScaleX(ScaleRelativeLayout.this.rnv);
                            childAt.setScaleY(ScaleRelativeLayout.this.rnv);
                        }
                        AppMethodBeat.o(109434);
                    }
                });
                this.rnC.start();
                break;
            case 2:
                if (motionEvent.getPointerCount() == 2) {
                    float hypot = (float) Math.hypot((double) (motionEvent.getX(0) - motionEvent.getX(1)), (double) (motionEvent.getY(0) - motionEvent.getY(1)));
                    float f4 = (this.rnw * hypot) / this.rnx;
                    if (f4 > this.rnz) {
                        f4 = this.rnz;
                        this.rny = this.rnx * f4;
                    } else if (f4 < this.rnA) {
                        f4 = this.rnA;
                        this.rny = this.rnx * f4;
                    } else {
                        this.rny = hypot;
                    }
                    this.rnv = f4;
                    if (this.rnC != null) {
                        this.rnC.cancel();
                        break;
                    }
                }
                break;
            case 6:
                if (motionEvent.getPointerCount() == 2) {
                    this.rnx = this.rny;
                    this.rnw = this.rnv;
                    this.rnB = false;
                    break;
                }
                break;
        }
        if (this.rnx <= 0.0f) {
            this.rnx = 0.1f;
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            childAt.setScaleX(this.rnv);
            childAt.setScaleY(this.rnv);
        }
        AppMethodBeat.o(109436);
        return true;
    }
}
