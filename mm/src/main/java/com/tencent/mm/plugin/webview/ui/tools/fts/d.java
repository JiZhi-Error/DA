package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;

public final class d extends a {
    public d(Context context, View view, View view2, View view3, View view4, View view5, View view6, View view7, View view8) {
        super(context, view, view2, view3, view4, view5, view6, view7, view8);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.a
    public final void gha() {
        AppMethodBeat.i(80764);
        Log.i("MicroMsg.WebSearch.SosAnimatorController", "search to init");
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        if (this.JoU[0][0] - ((float) this.JoK) >= 0.0f) {
            ofFloat.addUpdateListener(this.Jpa);
        } else {
            ofFloat.addUpdateListener(this.Jpb);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat);
        animatorSet.setDuration(300L);
        animatorSet.addListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.fts.d.AnonymousClass1 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(80760);
                d.this.isAnimating = true;
                if (d.this.JoX != null) {
                    d.this.JoX.onAnimationStart();
                }
                AppMethodBeat.o(80760);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(80761);
                d.this.isAnimating = false;
                if (d.this.JoX != null) {
                    d.this.JoX.onAnimationEnd();
                }
                AppMethodBeat.o(80761);
            }

            public final void onAnimationCancel(Animator animator) {
                d.this.isAnimating = false;
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        animatorSet.start();
        AppMethodBeat.o(80764);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.a
    public final void ghb() {
        AppMethodBeat.i(80765);
        Log.i("MicroMsg.WebSearch.SosAnimatorController", "init to search");
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        if (this.JoU[0][0] - ((float) this.JoK) >= 0.0f) {
            ofFloat.addUpdateListener(this.JoY);
        } else {
            ofFloat.addUpdateListener(this.JoZ);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat);
        animatorSet.setDuration(300L);
        animatorSet.addListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.fts.d.AnonymousClass2 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(80762);
                d.this.isAnimating = true;
                if (d.this.JoX != null) {
                    d.this.JoX.onAnimationStart();
                }
                AppMethodBeat.o(80762);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(80763);
                d.this.isAnimating = false;
                if (d.this.JoX != null) {
                    d.this.JoX.onAnimationEnd();
                }
                AppMethodBeat.o(80763);
            }

            public final void onAnimationCancel(Animator animator) {
                d.this.isAnimating = false;
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        animatorSet.start();
        AppMethodBeat.o(80765);
    }
}
