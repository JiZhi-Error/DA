package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class j {
    private int JjV;
    ValueAnimator animator;
    View view;

    public j(View view2) {
        this.view = view2;
    }

    /* access modifiers changed from: package-private */
    public final void c(int i2, final Runnable runnable) {
        AppMethodBeat.i(131496);
        if (this.view == null) {
            AppMethodBeat.o(131496);
        } else if (!isRunning() || this.JjV != i2) {
            this.JjV = i2;
            if (!(this.view.getBackground() instanceof ColorDrawable) || ((ColorDrawable) this.view.getBackground()).getColor() != i2) {
                AnonymousClass1 r2 = new AnimatorListenerAdapter() {
                    /* class com.tencent.mm.plugin.appbrand.widget.dialog.j.AnonymousClass1 */

                    public final void onAnimationCancel(Animator animator) {
                        j.this.animator = null;
                    }

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(131494);
                        if (runnable != null) {
                            runnable.run();
                        }
                        j.this.animator = null;
                        AppMethodBeat.o(131494);
                    }
                };
                if (this.animator == null || !this.animator.isStarted() || !this.animator.isRunning() || this.JjV != i2) {
                    if (this.animator != null) {
                        this.animator.cancel();
                    }
                    this.animator = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.view.getBackground() instanceof ColorDrawable ? ((ColorDrawable) this.view.getBackground()).getColor() : 0), Integer.valueOf(this.JjV));
                    this.animator.addListener(r2);
                    this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        /* class com.tencent.mm.plugin.appbrand.widget.dialog.j.AnonymousClass2 */

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            AppMethodBeat.i(131495);
                            if (j.this.view != null) {
                                j.this.view.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                            }
                            AppMethodBeat.o(131495);
                        }
                    });
                    this.animator.start();
                    AppMethodBeat.o(131496);
                    return;
                }
                this.animator.addListener(r2);
                AppMethodBeat.o(131496);
                return;
            }
            if (runnable != null) {
                runnable.run();
            }
            if (this.animator != null) {
                this.animator.cancel();
            }
            AppMethodBeat.o(131496);
        } else {
            AppMethodBeat.o(131496);
        }
    }

    /* access modifiers changed from: package-private */
    public final void cancel() {
        AppMethodBeat.i(131497);
        if (this.animator != null) {
            this.animator.cancel();
        }
        AppMethodBeat.o(131497);
    }

    /* access modifiers changed from: package-private */
    public final boolean isRunning() {
        AppMethodBeat.i(131498);
        if (this.animator == null || !this.animator.isRunning()) {
            AppMethodBeat.o(131498);
            return false;
        }
        AppMethodBeat.o(131498);
        return true;
    }
}
