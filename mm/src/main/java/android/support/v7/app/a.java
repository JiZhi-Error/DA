package android.support.v7.app;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.d.a.d;

public final class a implements DrawerLayout.c {
    private final AbstractC0041a WS;
    private d WT;
    private boolean WU;
    boolean WV;
    private final int WW;
    private final int WX;

    /* renamed from: android.support.v7.app.a$a  reason: collision with other inner class name */
    public interface AbstractC0041a {
        void bh(int i2);
    }

    @Override // android.support.v4.widget.DrawerLayout.c
    public final void F(float f2) {
        if (this.WU) {
            N(Math.min(1.0f, Math.max(0.0f, f2)));
        } else {
            N(0.0f);
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.c
    public final void fW() {
        N(1.0f);
        if (this.WV) {
            bh(this.WX);
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.c
    public final void fX() {
        N(0.0f);
        if (this.WV) {
            bh(this.WW);
        }
    }

    private void bh(int i2) {
        this.WS.bh(i2);
    }

    private void N(float f2) {
        if (f2 == 1.0f) {
            this.WT.Z(true);
        } else if (f2 == 0.0f) {
            this.WT.Z(false);
        }
        this.WT.setProgress(f2);
    }
}
