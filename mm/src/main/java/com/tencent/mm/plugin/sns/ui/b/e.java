package com.tencent.mm.plugin.sns.ui.b;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Outline;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public final class e extends a {
    private boolean DsW;
    private float ETS;
    private AnimatorSet ETT;
    private ViewOutlineProvider ETU = new ViewOutlineProvider() {
        /* class com.tencent.mm.plugin.sns.ui.b.e.AnonymousClass4 */

        public final void getOutline(View view, Outline outline) {
            AppMethodBeat.i(203875);
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), e.this.auL);
            AppMethodBeat.o(203875);
        }
    };
    float auL;

    public e(Activity activity, View view, Bundle bundle, boolean z) {
        super(activity, view, false);
        AppMethodBeat.i(203876);
        aG(bundle);
        this.ETS = (float) a.fromDPToPix(this.ETH, 8);
        this.auL = this.ETS;
        this.DsW = z;
        final View view2 = this.view;
        view2.setClipToOutline(true);
        view2.setOutlineProvider(this.ETU);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, "rotation", (float) (this.DsW ? -90 : 90), 0.0f);
        ofFloat2.setDuration(400L);
        float f2 = 1.0f;
        float f3 = 1.0f;
        if (!(this.targetWidth == 0 || this.targetHeight == 0)) {
            f2 = (((float) this.ETM) * 1.0f) / ((float) this.targetWidth);
            f3 = (((float) this.ETL) * 1.0f) / ((float) this.targetHeight);
        }
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view2, "scaleX", f2, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view2, "scaleY", f3, 1.0f);
        ofFloat3.setDuration(400L);
        ofFloat4.setDuration(400L);
        float f4 = ((float) this.ETJ) + (((float) this.ETL) / 2.0f);
        float f5 = ((float) this.ETK) + (((float) this.ETM) / 2.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view2, "translationX", f4 - (((float) this.targetWidth) / 2.0f), 0.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(view2, "translationY", f5 - (((float) this.targetHeight) / 2.0f), 0.0f);
        ofFloat5.setDuration(400L);
        ofFloat6.setDuration(400L);
        ValueAnimator ofFloat7 = ValueAnimator.ofFloat(this.ETS, 0.0f);
        ofFloat7.setDuration(200L);
        ofFloat7.setStartDelay(300);
        ofFloat7.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.sns.ui.b.e.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(203871);
                e.this.auL = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                view2.invalidateOutline();
                AppMethodBeat.o(203871);
            }
        });
        final ValueAnimator ofFloat8 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat8.setDuration(200L);
        ofFloat8.setStartDelay(300);
        ofFloat8.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.sns.ui.b.e.AnonymousClass2 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(203872);
                if (e.this.ETI != null) {
                    e.this.ETI.bX(((Float) ofFloat8.getAnimatedValue()).floatValue());
                }
                AppMethodBeat.o(203872);
            }
        });
        this.ETT = new AnimatorSet();
        this.ETT.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6, ofFloat7, ofFloat8);
        this.ETT.addListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.plugin.sns.ui.b.e.AnonymousClass3 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(203873);
                if (e.this.ETI != null) {
                    e.this.ETI.onAnimationStart();
                }
                AppMethodBeat.o(203873);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(203874);
                if (e.this.ETI != null) {
                    e.this.ETI.onAnimationEnd();
                }
                AppMethodBeat.o(203874);
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        AppMethodBeat.o(203876);
    }

    @Override // com.tencent.mm.plugin.sns.ui.b.a
    public final void fkj() {
        AppMethodBeat.i(203877);
        if (this.ETT != null && !this.ETT.isStarted()) {
            this.ETT.setStartDelay(0);
            this.ETT.start();
        }
        AppMethodBeat.o(203877);
    }
}
