package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.b.a;
import android.support.v4.view.ac;
import android.support.v4.view.d;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;

abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
    final Rect se = new Rect();
    final Rect sf = new Rect();
    int sg = 0;
    int sh;

    /* access modifiers changed from: package-private */
    public abstract View e(List<View> list);

    public HeaderScrollingViewBehavior() {
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean a(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4, int i5) {
        View e2;
        int i6 = view.getLayoutParams().height;
        if ((i6 != -1 && i6 != -2) || (e2 = e(coordinatorLayout.t(view))) == null) {
            return false;
        }
        if (u.aq(e2) && !u.aq(view)) {
            u.e(view, true);
            if (u.aq(view)) {
                view.requestLayout();
                return true;
            }
        }
        int size = View.MeasureSpec.getSize(i4);
        if (size == 0) {
            size = coordinatorLayout.getHeight();
        }
        coordinatorLayout.a(view, i2, i3, View.MeasureSpec.makeMeasureSpec(i(e2) + (size - e2.getMeasuredHeight()), i6 == -1 ? 1073741824 : Integer.MIN_VALUE), i5);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.support.design.widget.ViewOffsetBehavior
    public final void c(CoordinatorLayout coordinatorLayout, View view, int i2) {
        View e2 = e(coordinatorLayout.t(view));
        if (e2 != null) {
            CoordinatorLayout.d dVar = (CoordinatorLayout.d) view.getLayoutParams();
            Rect rect = this.se;
            rect.set(coordinatorLayout.getPaddingLeft() + dVar.leftMargin, e2.getBottom() + dVar.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - dVar.rightMargin, ((coordinatorLayout.getHeight() + e2.getBottom()) - coordinatorLayout.getPaddingBottom()) - dVar.bottomMargin);
            ac lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && u.aq(coordinatorLayout) && !u.aq(view)) {
                rect.left += lastWindowInsets.getSystemWindowInsetLeft();
                rect.right -= lastWindowInsets.getSystemWindowInsetRight();
            }
            Rect rect2 = this.sf;
            int i3 = dVar.gravity;
            if (i3 == 0) {
                i3 = 8388659;
            }
            d.apply(i3, view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i2);
            int w = w(e2);
            view.layout(rect2.left, rect2.top - w, rect2.right, rect2.bottom - w);
            this.sg = rect2.top - e2.getBottom();
            return;
        }
        super.c(coordinatorLayout, view, i2);
        this.sg = 0;
    }

    /* access modifiers changed from: package-private */
    public float h(View view) {
        return 1.0f;
    }

    /* access modifiers changed from: package-private */
    public final int w(View view) {
        if (this.sh == 0) {
            return 0;
        }
        return a.clamp((int) (h(view) * ((float) this.sh)), 0, this.sh);
    }

    /* access modifiers changed from: package-private */
    public int i(View view) {
        return view.getMeasuredHeight();
    }
}
