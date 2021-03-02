package android.support.design.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.support.design.a.a;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;

public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private int currentState = 2;
    private ViewPropertyAnimator hc;
    private int height = 0;

    public HideBottomViewOnScrollBehavior() {
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i2) {
        this.height = v.getMeasuredHeight();
        return super.a(coordinatorLayout, v, i2);
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final boolean B(int i2) {
        return i2 == 2;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final void a(V v, int i2) {
        if (this.currentState != 1 && i2 > 0) {
            c(v);
        } else if (this.currentState != 2 && i2 < 0) {
            b(v);
        }
    }

    /* access modifiers changed from: protected */
    public void b(V v) {
        if (this.hc != null) {
            this.hc.cancel();
            v.clearAnimation();
        }
        this.currentState = 2;
        a(v, 0, 225, a.gN);
    }

    /* access modifiers changed from: protected */
    public void c(V v) {
        if (this.hc != null) {
            this.hc.cancel();
            v.clearAnimation();
        }
        this.currentState = 1;
        a(v, this.height, 175, a.gM);
    }

    private void a(V v, int i2, long j2, TimeInterpolator timeInterpolator) {
        this.hc = v.animate().translationY((float) i2).setInterpolator(timeInterpolator).setDuration(j2).setListener(new AnimatorListenerAdapter() {
            /* class android.support.design.behavior.HideBottomViewOnScrollBehavior.AnonymousClass1 */

            public final void onAnimationEnd(Animator animator) {
                HideBottomViewOnScrollBehavior.this.hc = null;
            }
        });
    }
}
