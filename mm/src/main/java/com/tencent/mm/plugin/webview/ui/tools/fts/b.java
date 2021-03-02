package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.fts.a;

public final class b extends a {
    public b(Context context, View view, View view2, View view3, View view4, View view5, View view6, View view7, View view8) {
        super(context, view, view2, view3, view4, view5, view6, view7, view8);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.a
    public final void b(a.b bVar) {
        AppMethodBeat.i(80747);
        a(bVar, true);
        AppMethodBeat.o(80747);
    }

    public final void a(a.b bVar, boolean z) {
        AppMethodBeat.i(80748);
        if (bVar == this.JoW) {
            AppMethodBeat.o(80748);
            return;
        }
        switch (bVar) {
            case Init:
                gha();
                AppMethodBeat.o(80748);
                return;
            case Search:
                if (!z) {
                    ghc();
                    break;
                } else {
                    ghb();
                    AppMethodBeat.o(80748);
                    return;
                }
        }
        AppMethodBeat.o(80748);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.a
    public final void gha() {
        AppMethodBeat.i(80749);
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
            /* class com.tencent.mm.plugin.webview.ui.tools.fts.b.AnonymousClass1 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(80741);
                b.this.isAnimating = true;
                if (b.this.JoX != null) {
                    b.this.JoX.onAnimationStart();
                }
                AppMethodBeat.o(80741);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(80742);
                b.this.isAnimating = false;
                if (b.this.JoX != null) {
                    b.this.JoX.onAnimationEnd();
                }
                AppMethodBeat.o(80742);
            }

            public final void onAnimationCancel(Animator animator) {
                b.this.isAnimating = false;
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        animatorSet.start();
        AppMethodBeat.o(80749);
    }

    private void ghc() {
        AppMethodBeat.i(80750);
        this.JoN.setPadding(this.JoM, 0, 0, 0);
        int i2 = this.zSm;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.JoN.getLayoutParams();
        layoutParams.leftMargin = this.zSm - i2;
        layoutParams.rightMargin = this.zSm - i2;
        layoutParams.width = (i2 * 2) + ((int) this.JoU[2][0]);
        this.JoN.setLayoutParams(layoutParams);
        this.JoN.post(new Runnable() {
            /* class com.tencent.mm.plugin.webview.ui.tools.fts.b.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(80743);
                b.this.JoN.setY(b.this.JoU[0][1]);
                b.this.JoN.setX(b.this.JoU[1][1]);
                AppMethodBeat.o(80743);
            }
        });
        AppMethodBeat.o(80750);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.a
    public final void ghb() {
        AppMethodBeat.i(80751);
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
            /* class com.tencent.mm.plugin.webview.ui.tools.fts.b.AnonymousClass3 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(80744);
                b.this.isAnimating = true;
                if (b.this.JoX != null) {
                    b.this.JoX.onAnimationStart();
                }
                AppMethodBeat.o(80744);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(80745);
                b.this.isAnimating = false;
                if (b.this.JoX != null) {
                    b.this.JoX.onAnimationEnd();
                }
                AppMethodBeat.o(80745);
            }

            public final void onAnimationCancel(Animator animator) {
                b.this.isAnimating = false;
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        animatorSet.start();
        AppMethodBeat.o(80751);
    }
}
