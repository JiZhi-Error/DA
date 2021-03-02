package android.support.design.transformation;

import android.content.Context;
import android.support.design.c.b;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.List;

public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {
    private int currentState = 0;

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public abstract boolean a(View view, View view2);

    /* access modifiers changed from: protected */
    public abstract boolean a(View view, View view2, boolean z, boolean z2);

    public ExpandableBehavior() {
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final boolean a(CoordinatorLayout coordinatorLayout, final View view, int i2) {
        final b bVar;
        if (!u.az(view)) {
            List<View> t = coordinatorLayout.t(view);
            int size = t.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    bVar = null;
                    break;
                }
                View view2 = t.get(i3);
                if (a(view, view2)) {
                    bVar = (b) view2;
                    break;
                }
                i3++;
            }
            if (bVar != null && s(bVar.bB())) {
                this.currentState = bVar.bB() ? 1 : 2;
                final int i4 = this.currentState;
                view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    /* class android.support.design.transformation.ExpandableBehavior.AnonymousClass1 */

                    public final boolean onPreDraw() {
                        view.getViewTreeObserver().removeOnPreDrawListener(this);
                        if (ExpandableBehavior.this.currentState == i4) {
                            ExpandableBehavior.this.a((View) bVar, view, bVar.bB(), false);
                        }
                        return false;
                    }
                });
            }
        }
        return false;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public final boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
        b bVar = (b) view2;
        if (!s(bVar.bB())) {
            return false;
        }
        this.currentState = bVar.bB() ? 1 : 2;
        return a((View) bVar, view, bVar.bB(), true);
    }

    private boolean s(boolean z) {
        return z ? this.currentState == 0 || this.currentState == 2 : this.currentState == 1;
    }
}
