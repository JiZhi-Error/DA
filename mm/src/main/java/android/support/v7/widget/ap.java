package android.support.v7.widget;

/* access modifiers changed from: package-private */
public final class ap {
    int Al = 0;
    int An = 0;
    int Pc = Integer.MIN_VALUE;
    int avh = Integer.MIN_VALUE;
    int avi = 0;
    int avj = 0;
    boolean avk = false;
    boolean mIsRtl = false;

    ap() {
    }

    public final void aA(int i2, int i3) {
        this.avh = i2;
        this.Pc = i3;
        this.avk = true;
        if (this.mIsRtl) {
            if (i3 != Integer.MIN_VALUE) {
                this.Al = i3;
            }
            if (i2 != Integer.MIN_VALUE) {
                this.An = i2;
                return;
            }
            return;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.Al = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.An = i3;
        }
    }

    public final void aB(int i2, int i3) {
        this.avk = false;
        if (i2 != Integer.MIN_VALUE) {
            this.avi = i2;
            this.Al = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.avj = i3;
            this.An = i3;
        }
    }
}
