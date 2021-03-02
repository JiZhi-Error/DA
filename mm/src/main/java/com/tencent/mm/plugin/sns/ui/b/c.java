package com.tencent.mm.plugin.sns.ui.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c extends a {
    public c(Activity activity, View view, final boolean z) {
        super(activity, view, z);
        AppMethodBeat.i(99895);
        this.yTl = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.yTl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.sns.ui.b.c.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(99892);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                c.this.view.setAlpha(1.0f - floatValue);
                if (floatValue != 1.0f) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c.this.view.getLayoutParams();
                    layoutParams.leftMargin = (int) (((float) c.this.ETJ) * floatValue);
                    layoutParams.topMargin = (int) (((float) c.this.ETK) * floatValue);
                    ViewGroup viewGroup = (ViewGroup) c.this.view.getParent();
                    if (z) {
                        layoutParams.rightMargin = (int) ((((float) viewGroup.getWidth()) - (((float) c.this.targetWidth) - (((float) c.this.ETO) * floatValue))) - ((float) layoutParams.leftMargin));
                        layoutParams.bottomMargin = (int) ((((float) viewGroup.getHeight()) - (((float) c.this.targetHeight) - (((float) c.this.ETN) * floatValue))) - ((float) layoutParams.topMargin));
                    } else {
                        layoutParams.rightMargin = (int) (((((float) viewGroup.getWidth()) * floatValue) - (((float) c.this.ETL) * floatValue)) - ((float) layoutParams.leftMargin));
                        layoutParams.bottomMargin = (int) (((((float) viewGroup.getHeight()) * floatValue) - (((float) c.this.ETM) * floatValue)) - ((float) layoutParams.topMargin));
                    }
                    c.this.view.setLayoutParams(layoutParams);
                }
                if (c.this.ETI != null) {
                    c.this.ETI.bX(floatValue);
                }
                AppMethodBeat.o(99892);
            }
        });
        this.yTl.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.sns.ui.b.c.AnonymousClass2 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(99893);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c.this.view.getLayoutParams();
                layoutParams.leftMargin = c.this.ETJ;
                layoutParams.topMargin = c.this.ETK;
                ViewGroup viewGroup = (ViewGroup) c.this.view.getParent();
                if (z) {
                    layoutParams.rightMargin = (viewGroup.getWidth() - (c.this.targetWidth - c.this.ETO)) - layoutParams.leftMargin;
                    layoutParams.bottomMargin = (viewGroup.getHeight() - (c.this.targetHeight - c.this.ETN)) - layoutParams.topMargin;
                } else {
                    layoutParams.rightMargin = (viewGroup.getWidth() - c.this.ETL) - layoutParams.leftMargin;
                    layoutParams.bottomMargin = (viewGroup.getHeight() - c.this.ETM) - layoutParams.topMargin;
                }
                c.this.view.setLayoutParams(layoutParams);
                c.this.view.setVisibility(0);
                if (c.this.ETI != null) {
                    c.this.ETI.onAnimationStart();
                }
                AppMethodBeat.o(99893);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(99894);
                if (c.this.ETI != null) {
                    c.this.ETI.onAnimationEnd();
                }
                if (!z) {
                    c.this.view.setVisibility(8);
                }
                AppMethodBeat.o(99894);
            }
        });
        this.yTl.setDuration(400L);
        AppMethodBeat.o(99895);
    }
}
