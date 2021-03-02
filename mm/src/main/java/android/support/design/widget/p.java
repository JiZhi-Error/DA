package android.support.design.widget;

import android.support.v4.view.u;
import android.view.View;

final class p {
    private final View view;
    int wE;
    private int wF;
    int wG;
    int wH;

    public p(View view2) {
        this.view = view2;
    }

    public final void dx() {
        this.wE = this.view.getTop();
        this.wF = this.view.getLeft();
        dy();
    }

    /* access modifiers changed from: package-private */
    public final void dy() {
        u.s(this.view, this.wG - (this.view.getTop() - this.wE));
        u.u(this.view, this.wH - (this.view.getLeft() - this.wF));
    }

    public final boolean G(int i2) {
        if (this.wG == i2) {
            return false;
        }
        this.wG = i2;
        dy();
        return true;
    }
}
