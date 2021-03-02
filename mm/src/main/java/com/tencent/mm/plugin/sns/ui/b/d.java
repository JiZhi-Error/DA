package com.tencent.mm.plugin.sns.ui.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d extends a {
    public d(Activity activity, View view, final boolean z) {
        super(activity, view, z);
        AppMethodBeat.i(99899);
        this.yTl = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.yTl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.sns.ui.b.d.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(99896);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (z) {
                    d.this.view.setAlpha(1.0f - (0.2f * floatValue));
                } else {
                    d.this.view.setAlpha(1.0f - floatValue);
                }
                if (floatValue != 0.0f) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.view.getLayoutParams();
                    layoutParams.leftMargin = (int) (((float) d.this.ETJ) * floatValue);
                    layoutParams.topMargin = (int) (((float) d.this.ETK) * floatValue);
                    ViewGroup viewGroup = (ViewGroup) d.this.view.getParent();
                    if (z) {
                        layoutParams.rightMargin = (int) ((((float) viewGroup.getWidth()) - (((float) d.this.targetWidth) - (((float) d.this.ETO) * floatValue))) - ((float) layoutParams.leftMargin));
                        layoutParams.bottomMargin = (int) ((((float) viewGroup.getHeight()) - (((float) d.this.targetHeight) - (((float) d.this.ETN) * floatValue))) - ((float) layoutParams.topMargin));
                    } else {
                        layoutParams.rightMargin = (int) (((((float) viewGroup.getWidth()) * floatValue) - (((float) d.this.ETL) * floatValue)) - ((float) layoutParams.leftMargin));
                        layoutParams.bottomMargin = (int) (((((float) viewGroup.getHeight()) * floatValue) - (((float) d.this.ETM) * floatValue)) - ((float) layoutParams.topMargin));
                    }
                    d.this.view.setLayoutParams(layoutParams);
                }
                if (d.this.ETI != null) {
                    d.this.ETI.bX(floatValue);
                }
                AppMethodBeat.o(99896);
            }
        });
        this.yTl.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.sns.ui.b.d.AnonymousClass2 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(99897);
                if (d.this.ETI != null) {
                    d.this.ETI.onAnimationStart();
                }
                d.this.view.setVisibility(0);
                AppMethodBeat.o(99897);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(99898);
                if (d.this.ETI != null) {
                    d.this.ETI.onAnimationEnd();
                }
                d.this.view.setVisibility(8);
                AppMethodBeat.o(99898);
            }
        });
        if (z) {
            this.yTl.setDuration(300L);
            AppMethodBeat.o(99899);
            return;
        }
        this.yTl.setDuration(400L);
        AppMethodBeat.o(99899);
    }
}
