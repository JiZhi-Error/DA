package android.support.v4.view;

import android.view.ViewGroup;

public final class o {
    private final ViewGroup Qa;
    public int Qb;

    public o(ViewGroup viewGroup) {
        this.Qa = viewGroup;
    }

    public final void aP(int i2) {
        this.Qb = i2;
    }

    public final int getNestedScrollAxes() {
        return this.Qb;
    }

    public final void fC() {
        this.Qb = 0;
    }
}
