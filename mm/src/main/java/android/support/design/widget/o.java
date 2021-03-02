package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

public final class o {
    final ArrayList<a> tO = new ArrayList<>();
    a tP = null;
    ValueAnimator tQ = null;
    private final Animator.AnimatorListener tR = new AnimatorListenerAdapter() {
        /* class android.support.design.widget.o.AnonymousClass1 */

        public final void onAnimationEnd(Animator animator) {
            if (o.this.tQ == animator) {
                o.this.tQ = null;
            }
        }
    };

    public final void a(int[] iArr, ValueAnimator valueAnimator) {
        a aVar = new a(iArr, valueAnimator);
        valueAnimator.addListener(this.tR);
        this.tO.add(aVar);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        final ValueAnimator animator;
        final int[] tT;

        a(int[] iArr, ValueAnimator valueAnimator) {
            this.tT = iArr;
            this.animator = valueAnimator;
        }
    }
}
