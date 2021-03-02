package com.tencent.mm.plugin.scanner.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class ScanRectDecorView extends FrameLayout {
    private RectView CVp;
    private Rect CVq;
    private int CVr;
    private int CVs;
    private ImageView tgP;
    private ValueAnimator tgS;

    public ScanRectDecorView(Context context) {
        super(context);
        AppMethodBeat.i(91114);
        init();
        AppMethodBeat.o(91114);
    }

    public ScanRectDecorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(91115);
        init();
        AppMethodBeat.o(91115);
    }

    public ScanRectDecorView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(91116);
        init();
        AppMethodBeat.o(91116);
    }

    private void init() {
        AppMethodBeat.i(91117);
        this.CVr = getContext().getResources().getDimensionPixelSize(R.dimen.ahx);
        this.CVs = getContext().getResources().getDimensionPixelSize(R.dimen.ahw);
        this.CVp = new RectView(getContext());
        addView(this.CVp, new FrameLayout.LayoutParams(-1, -1));
        eSj();
        setWillNotDraw(false);
        this.tgP = new ImageView(getContext());
        addView(this.tgP, new FrameLayout.LayoutParams(this.CVr, -2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.tgP.getLayoutParams();
        layoutParams.gravity = 1;
        this.tgP.setLayoutParams(layoutParams);
        this.tgP.setBackgroundResource(R.drawable.cky);
        this.tgP.setVisibility(8);
        this.tgS = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(2600L);
        this.tgS.setInterpolator(new AccelerateDecelerateInterpolator());
        this.tgS.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.scanner.view.ScanRectDecorView.AnonymousClass1 */

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(91111);
                ScanRectDecorView.this.tgP.setVisibility(8);
                AppMethodBeat.o(91111);
            }

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(91112);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ScanRectDecorView.this.tgP.getLayoutParams();
                layoutParams.topMargin = ScanRectDecorView.this.CVp.getRect().top;
                ScanRectDecorView.this.tgP.setLayoutParams(layoutParams);
                ScanRectDecorView.this.tgP.setVisibility(0);
                AppMethodBeat.o(91112);
            }
        });
        this.tgS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.scanner.view.ScanRectDecorView.AnonymousClass2 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(91113);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ScanRectDecorView.this.tgP.getLayoutParams();
                layoutParams.topMargin = ((int) (floatValue * ((float) (ScanRectDecorView.this.CVs - ScanRectDecorView.this.tgP.getHeight())))) + ScanRectDecorView.this.CVp.getRect().top;
                ScanRectDecorView.this.tgP.setLayoutParams(layoutParams);
                AppMethodBeat.o(91113);
            }
        });
        this.tgS.setRepeatMode(1);
        this.tgS.setRepeatCount(-1);
        AppMethodBeat.o(91117);
    }

    public final void ij(int i2, int i3) {
        AppMethodBeat.i(91118);
        this.CVr = i2;
        this.CVs = i3;
        eSj();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.tgP.getLayoutParams();
        layoutParams.width = i2;
        this.tgP.setLayoutParams(layoutParams);
        AppMethodBeat.o(91118);
    }

    private void eSj() {
        AppMethodBeat.i(91119);
        Point point = new Point();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getSize(point);
        int i2 = (point.x / 2) - (this.CVr / 2);
        int i3 = (point.y / 2) - (this.CVs / 2);
        this.CVq = new Rect(i2, i3, this.CVr + i2, this.CVs + i3);
        this.CVp.setRect(this.CVq);
        AppMethodBeat.o(91119);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(91120);
        super.onDetachedFromWindow();
        if (this.tgS != null) {
            this.tgS.cancel();
        }
        AppMethodBeat.o(91120);
    }

    public Rect getDecorRect() {
        return this.CVq;
    }

    public void setDecorRect(Rect rect) {
        AppMethodBeat.i(91121);
        if (rect != null) {
            this.CVr = rect.width();
            this.CVs = rect.height();
            this.CVq = new Rect(rect);
        }
        this.CVp.setRect(this.CVq);
        this.CVp.postInvalidate();
        AppMethodBeat.o(91121);
    }

    public final void cWi() {
        AppMethodBeat.i(91122);
        if (!this.tgS.isStarted()) {
            this.tgP.setVisibility(0);
            this.tgS.start();
        }
        AppMethodBeat.o(91122);
    }

    public final void cWj() {
        AppMethodBeat.i(91123);
        this.tgS.cancel();
        this.tgP.setVisibility(8);
        AppMethodBeat.o(91123);
    }
}
