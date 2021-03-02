package android.support.design.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.design.a.b;
import android.support.design.a.i;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;

public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {
    private final i mO = new i(75);
    private final i mP = new i(0);

    public FabTransformationScrimBehavior() {
    }

    public FabTransformationScrimBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.support.design.transformation.ExpandableBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public final boolean a(View view, View view2) {
        return view2 instanceof FloatingActionButton;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final boolean a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return super.a(coordinatorLayout, view, motionEvent);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.design.transformation.ExpandableTransformationBehavior
    public final AnimatorSet b(View view, final View view2, final boolean z, boolean z2) {
        ObjectAnimator ofFloat;
        ArrayList arrayList = new ArrayList();
        new ArrayList();
        i iVar = z ? this.mO : this.mP;
        if (z) {
            if (!z2) {
                view2.setAlpha(0.0f);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, View.ALPHA, 1.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, View.ALPHA, 0.0f);
        }
        iVar.a((Animator) ofFloat);
        arrayList.add(ofFloat);
        AnimatorSet animatorSet = new AnimatorSet();
        b.a(animatorSet, arrayList);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            /* class android.support.design.transformation.FabTransformationScrimBehavior.AnonymousClass1 */

            public final void onAnimationStart(Animator animator) {
                if (z) {
                    view2.setVisibility(0);
                }
            }

            public final void onAnimationEnd(Animator animator) {
                if (!z) {
                    view2.setVisibility(4);
                }
            }
        });
        return animatorSet;
    }
}
