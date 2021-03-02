package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class y {
    private WeakReference<View> Rd;
    Runnable Re = null;
    Runnable Rf = null;
    int Rg = -1;

    y(View view) {
        this.Rd = new WeakReference<>(view);
    }

    static class a implements z {
        y Rk;
        boolean Rl;

        a(y yVar) {
            this.Rk = yVar;
        }

        @Override // android.support.v4.view.z
        public final void aI(View view) {
            z zVar;
            this.Rl = false;
            if (this.Rk.Rg >= 0) {
                view.setLayerType(2, null);
            }
            if (this.Rk.Re != null) {
                Runnable runnable = this.Rk.Re;
                this.Rk.Re = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            if (tag instanceof z) {
                zVar = (z) tag;
            } else {
                zVar = null;
            }
            if (zVar != null) {
                zVar.aI(view);
            }
        }

        @Override // android.support.v4.view.z
        public final void aJ(View view) {
            z zVar;
            if (this.Rk.Rg >= 0) {
                view.setLayerType(this.Rk.Rg, null);
                this.Rk.Rg = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.Rl) {
                if (this.Rk.Rf != null) {
                    Runnable runnable = this.Rk.Rf;
                    this.Rk.Rf = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                if (tag instanceof z) {
                    zVar = (z) tag;
                } else {
                    zVar = null;
                }
                if (zVar != null) {
                    zVar.aJ(view);
                }
                this.Rl = true;
            }
        }

        @Override // android.support.v4.view.z
        public final void aK(View view) {
            z zVar;
            Object tag = view.getTag(2113929216);
            if (tag instanceof z) {
                zVar = (z) tag;
            } else {
                zVar = null;
            }
            if (zVar != null) {
                zVar.aK(view);
            }
        }
    }

    public final y j(long j2) {
        View view = this.Rd.get();
        if (view != null) {
            view.animate().setDuration(j2);
        }
        return this;
    }

    public final y y(float f2) {
        View view = this.Rd.get();
        if (view != null) {
            view.animate().alpha(f2);
        }
        return this;
    }

    public final y z(float f2) {
        View view = this.Rd.get();
        if (view != null) {
            view.animate().translationY(f2);
        }
        return this;
    }

    public final long getDuration() {
        View view = this.Rd.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0;
    }

    public final y a(Interpolator interpolator) {
        View view = this.Rd.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public final y k(long j2) {
        View view = this.Rd.get();
        if (view != null) {
            view.animate().setStartDelay(j2);
        }
        return this;
    }

    public final y A(float f2) {
        View view = this.Rd.get();
        if (view != null) {
            view.animate().scaleX(f2);
        }
        return this;
    }

    public final y B(float f2) {
        View view = this.Rd.get();
        if (view != null) {
            view.animate().scaleY(f2);
        }
        return this;
    }

    public final void cancel() {
        View view = this.Rd.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void start() {
        View view = this.Rd.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public final y a(z zVar) {
        View view = this.Rd.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                a(view, zVar);
            } else {
                view.setTag(2113929216, zVar);
                a(view, new a(this));
            }
        }
        return this;
    }

    private void a(final View view, final z zVar) {
        if (zVar != null) {
            view.animate().setListener(new AnimatorListenerAdapter() {
                /* class android.support.v4.view.y.AnonymousClass1 */

                public final void onAnimationCancel(Animator animator) {
                    zVar.aK(view);
                }

                public final void onAnimationEnd(Animator animator) {
                    zVar.aJ(view);
                }

                public final void onAnimationStart(Animator animator) {
                    zVar.aI(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    public final y a(final ab abVar) {
        final View view = this.Rd.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            AnonymousClass2 r1 = null;
            if (abVar != null) {
                r1 = new ValueAnimator.AnimatorUpdateListener() {
                    /* class android.support.v4.view.y.AnonymousClass2 */

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        abVar.fH();
                    }
                };
            }
            view.animate().setUpdateListener(r1);
        }
        return this;
    }
}
