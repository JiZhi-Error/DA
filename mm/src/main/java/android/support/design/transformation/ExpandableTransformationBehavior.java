package android.support.design.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {
    private AnimatorSet mA;

    /* access modifiers changed from: protected */
    public abstract AnimatorSet b(View view, View view2, boolean z, boolean z2);

    public ExpandableTransformationBehavior() {
    }

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.design.transformation.ExpandableBehavior
    public boolean a(View view, View view2, boolean z, boolean z2) {
        boolean z3 = this.mA != null;
        if (z3) {
            this.mA.cancel();
        }
        this.mA = b(view, view2, z, z3);
        this.mA.addListener(new AnimatorListenerAdapter() {
            /* class android.support.design.transformation.ExpandableTransformationBehavior.AnonymousClass1 */

            public final void onAnimationEnd(Animator animator) {
                ExpandableTransformationBehavior.this.mA = null;
            }
        });
        this.mA.start();
        if (!z2) {
            this.mA.end();
        }
        return true;
    }
}
