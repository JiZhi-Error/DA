package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.fts.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends a {
    public c(Context context, View view, View view2, View view3, View view4, View view5, View view6, View view7, View view8) {
        super(context, view, view2, view3, view4, view5, view6, view7, view8);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.a
    public final void gha() {
        AppMethodBeat.i(80758);
        Log.i("MicroMsg.WebSearch.SosAnimatorController", "searchToInit");
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        if (this.JoU[0][0] - ((float) this.JoK) >= 0.0f) {
            ofFloat.addUpdateListener(this.Jpa);
        } else {
            ofFloat.addUpdateListener(this.Jpb);
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.JoT, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.setDuration(300L);
        animatorSet.addListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.fts.c.AnonymousClass1 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(80752);
                c.this.isAnimating = true;
                if (c.this.JoX != null) {
                    c.this.JoX.onAnimationStart();
                }
                AppMethodBeat.o(80752);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(80753);
                c.this.isAnimating = false;
                if (c.this.JoX != null) {
                    c.this.JoX.onAnimationEnd();
                }
                AppMethodBeat.o(80753);
            }

            public final void onAnimationCancel(Animator animator) {
                c.this.isAnimating = false;
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        animatorSet.start();
        AppMethodBeat.o(80758);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.a
    public final void ghb() {
        AppMethodBeat.i(80759);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        if (this.JoU[0][0] - ((float) this.JoK) >= 0.0f) {
            ofFloat.addUpdateListener(this.JoY);
        } else {
            ofFloat.addUpdateListener(this.JoZ);
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.JoT, "alpha", 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.setDuration(300L);
        animatorSet.addListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.fts.c.AnonymousClass2 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(80754);
                c.this.isAnimating = true;
                if (c.this.JoX != null) {
                    c.this.JoX.onAnimationStart();
                }
                AppMethodBeat.o(80754);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(80755);
                c.this.isAnimating = false;
                if (c.this.JoX != null) {
                    c.this.JoX.onAnimationEnd();
                }
                AppMethodBeat.o(80755);
            }

            public final void onAnimationCancel(Animator animator) {
                c.this.isAnimating = false;
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        animatorSet.start();
        AppMethodBeat.o(80759);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.a
    public final void b(a.b bVar) {
        AppMethodBeat.i(80757);
        if (bVar != this.JoW) {
            switch (bVar) {
                case Init:
                    gha();
                    AppMethodBeat.o(80757);
                    return;
                case Search:
                    ghb();
                    break;
            }
        }
        AppMethodBeat.o(80757);
    }
}
