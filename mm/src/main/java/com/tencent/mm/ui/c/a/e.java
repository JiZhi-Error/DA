package com.tencent.mm.ui.c.a;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.c.a.b;

final class e extends d {
    e(View view) {
        super(view);
    }

    @Override // com.tencent.mm.ui.c.a.b
    public final b a(b.a aVar) {
        AppMethodBeat.i(205199);
        if (((ViewPropertyAnimator) this.OMC.get()) != null) {
            this.OMn = aVar;
        }
        AppMethodBeat.o(205199);
        return this;
    }

    @Override // com.tencent.mm.ui.c.a.b, com.tencent.mm.ui.c.a.d
    public final void start() {
        AppMethodBeat.i(205200);
        System.currentTimeMillis();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f);
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.OMC.get();
        if (this.OMl != null) {
            this.OMj.put(ofFloat, this.OMl);
            this.OMl = null;
        }
        if (this.OMm != null) {
            this.OMk.put(ofFloat, this.OMm);
            this.OMm = null;
        }
        viewPropertyAnimator.setListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.ui.c.a.e.AnonymousClass1 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(205194);
                if (e.this.OMr != null) {
                    e.this.OMr.onAnimationStart(null);
                }
                if (e.this.OMj != null) {
                    Runnable runnable = (Runnable) e.this.OMj.get(ofFloat);
                    if (runnable != null) {
                        runnable.run();
                    }
                    e.this.OMj.remove(ofFloat);
                }
                AppMethodBeat.o(205194);
            }

            public final void onAnimationRepeat(Animator animator) {
                AppMethodBeat.i(205195);
                if (e.this.OMr != null) {
                    e.this.OMr.onAnimationRepeat(null);
                }
                AppMethodBeat.o(205195);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(205196);
                e.this.OMD = false;
                if (e.this.OMr != null) {
                    e.this.OMr.onAnimationEnd(null);
                }
                if (e.this.OMk != null) {
                    Runnable runnable = (Runnable) e.this.OMk.get(ofFloat);
                    if (runnable != null) {
                        runnable.run();
                    }
                    e.this.OMk.remove(ofFloat);
                }
                AppMethodBeat.o(205196);
            }

            public final void onAnimationCancel(Animator animator) {
                AppMethodBeat.i(205197);
                if (e.this.OMr != null) {
                    e.this.OMr.onAnimationCancel(null);
                }
                if (e.this.OMk != null) {
                    e.this.OMk.remove(ofFloat);
                }
                AppMethodBeat.o(205197);
            }
        });
        if (viewPropertyAnimator != null) {
            if (this.OMD) {
                viewPropertyAnimator.withLayer();
            }
            if (this.OMn != null) {
                viewPropertyAnimator.setUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.tencent.mm.ui.c.a.e.AnonymousClass2 */

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.i(205198);
                        e.this.OMn.by(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        AppMethodBeat.o(205198);
                    }
                });
            }
            viewPropertyAnimator.start();
        }
        AppMethodBeat.o(205200);
    }
}
