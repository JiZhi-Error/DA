package android.support.design.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/* access modifiers changed from: package-private */
public class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private p wB;
    private int wC = 0;
    private int wD = 0;

    public ViewOffsetBehavior() {
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i2) {
        c(coordinatorLayout, v, i2);
        if (this.wB == null) {
            this.wB = new p(v);
        }
        this.wB.dx();
        if (this.wC != 0) {
            this.wB.G(this.wC);
            this.wC = 0;
        }
        if (this.wD == 0) {
            return true;
        }
        p pVar = this.wB;
        int i3 = this.wD;
        if (pVar.wH != i3) {
            pVar.wH = i3;
            pVar.dy();
        }
        this.wD = 0;
        return true;
    }

    /* access modifiers changed from: protected */
    public void c(CoordinatorLayout coordinatorLayout, V v, int i2) {
        coordinatorLayout.g(v, i2);
    }

    public boolean G(int i2) {
        if (this.wB != null) {
            return this.wB.G(i2);
        }
        this.wC = i2;
        return false;
    }

    public int bT() {
        if (this.wB != null) {
            return this.wB.wG;
        }
        return 0;
    }
}
