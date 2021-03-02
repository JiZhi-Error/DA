package com.tencent.mm.ui.c.a;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

class d extends b {
    protected final WeakReference<ViewPropertyAnimator> OMC;
    protected boolean OMD;
    Animator.AnimatorListener OMr;
    Interpolator mInterpolator;

    d(View view) {
        AppMethodBeat.i(205184);
        this.OMC = new WeakReference<>(view.animate());
        AppMethodBeat.o(205184);
    }

    @Override // com.tencent.mm.ui.c.a.b
    public final b gKg() {
        AppMethodBeat.i(205185);
        ViewPropertyAnimator viewPropertyAnimator = this.OMC.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setDuration(250);
        }
        AppMethodBeat.o(205185);
        return this;
    }

    @Override // com.tencent.mm.ui.c.a.b
    public final b c(Interpolator interpolator) {
        AppMethodBeat.i(205186);
        ViewPropertyAnimator viewPropertyAnimator = this.OMC.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setInterpolator(interpolator);
            this.mInterpolator = interpolator;
        }
        AppMethodBeat.o(205186);
        return this;
    }

    @Override // com.tencent.mm.ui.c.a.b
    public void start() {
        long j2;
        AppMethodBeat.i(205187);
        System.currentTimeMillis();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f);
        ViewPropertyAnimator viewPropertyAnimator = this.OMC.get();
        if (this.OMl != null) {
            this.OMj.put(ofFloat, this.OMl);
            this.OMl = null;
        }
        if (this.OMm != null) {
            this.OMk.put(ofFloat, this.OMm);
            this.OMm = null;
        }
        viewPropertyAnimator.setListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.ui.c.a.d.AnonymousClass1 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(205179);
                if (d.this.OMr != null) {
                    d.this.OMr.onAnimationStart(null);
                }
                if (d.this.OMj != null) {
                    Runnable runnable = (Runnable) d.this.OMj.get(ofFloat);
                    if (runnable != null) {
                        runnable.run();
                    }
                    d.this.OMj.remove(ofFloat);
                }
                AppMethodBeat.o(205179);
            }

            public final void onAnimationRepeat(Animator animator) {
                AppMethodBeat.i(205180);
                if (d.this.OMr != null) {
                    d.this.OMr.onAnimationRepeat(null);
                }
                AppMethodBeat.o(205180);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(205181);
                d.this.OMD = false;
                d.this.mInterpolator = null;
                if (d.this.OMr != null) {
                    d.this.OMr.onAnimationEnd(null);
                }
                if (d.this.OMk != null) {
                    Runnable runnable = (Runnable) d.this.OMk.get(ofFloat);
                    if (runnable != null) {
                        runnable.run();
                    }
                    d.this.OMk.remove(ofFloat);
                }
                AppMethodBeat.o(205181);
            }

            public final void onAnimationCancel(Animator animator) {
                AppMethodBeat.i(205182);
                if (d.this.OMr != null) {
                    d.this.OMr.onAnimationCancel(null);
                }
                d.this.mInterpolator = null;
                if (d.this.OMk != null) {
                    d.this.OMk.remove(ofFloat);
                }
                AppMethodBeat.o(205182);
            }
        });
        if (viewPropertyAnimator != null) {
            if (this.OMD) {
                viewPropertyAnimator.withLayer();
            }
            if (this.OMn != null) {
                ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
                ViewPropertyAnimator viewPropertyAnimator2 = this.OMC.get();
                if (viewPropertyAnimator2 != null) {
                    j2 = viewPropertyAnimator2.getDuration();
                } else {
                    j2 = -1;
                }
                ofFloat2.setDuration(j2);
                if (this.mInterpolator != null) {
                    ofFloat2.setInterpolator(this.mInterpolator);
                }
                ofFloat2.setStartDelay(viewPropertyAnimator.getStartDelay());
                ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.tencent.mm.ui.c.a.d.AnonymousClass2 */

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.i(205183);
                        d.this.OMn.by(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        AppMethodBeat.o(205183);
                    }
                });
                ofFloat2.start();
            }
            viewPropertyAnimator.start();
        }
        AppMethodBeat.o(205187);
    }

    @Override // com.tencent.mm.ui.c.a.b
    public final b cn(float f2) {
        AppMethodBeat.i(205188);
        ViewPropertyAnimator viewPropertyAnimator = this.OMC.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationX(f2);
        }
        AppMethodBeat.o(205188);
        return this;
    }

    @Override // com.tencent.mm.ui.c.a.b
    public final b co(float f2) {
        AppMethodBeat.i(205189);
        ViewPropertyAnimator viewPropertyAnimator = this.OMC.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationY(f2);
        }
        AppMethodBeat.o(205189);
        return this;
    }

    @Override // com.tencent.mm.ui.c.a.b
    public final b cp(float f2) {
        AppMethodBeat.i(205190);
        ViewPropertyAnimator viewPropertyAnimator = this.OMC.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleX(f2);
        }
        AppMethodBeat.o(205190);
        return this;
    }

    @Override // com.tencent.mm.ui.c.a.b
    public final b cq(float f2) {
        AppMethodBeat.i(205191);
        ViewPropertyAnimator viewPropertyAnimator = this.OMC.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleY(f2);
        }
        AppMethodBeat.o(205191);
        return this;
    }

    @Override // com.tencent.mm.ui.c.a.b
    public final b aJ(Runnable runnable) {
        AppMethodBeat.i(205192);
        ViewPropertyAnimator viewPropertyAnimator = this.OMC.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.withEndAction(runnable);
        }
        AppMethodBeat.o(205192);
        return this;
    }

    @Override // com.tencent.mm.ui.c.a.b
    public final b aK(Runnable runnable) {
        AppMethodBeat.i(205193);
        ViewPropertyAnimator viewPropertyAnimator = this.OMC.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.withStartAction(runnable);
        }
        AppMethodBeat.o(205193);
        return this;
    }
}
