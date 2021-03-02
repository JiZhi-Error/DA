package com.tencent.mm.particles;

public final class d {
    public final int jIY;
    public final int jIZ;
    public final int jJa;
    public final int jJb;

    public d(int i2, int i3) {
        this(i2, i3, i2, i3);
    }

    private d(int i2, int i3, int i4, int i5) {
        this.jIY = i2;
        this.jIZ = i3;
        this.jJa = i4;
        this.jJb = i5;
    }

    /* access modifiers changed from: protected */
    public final float aA(float f2) {
        return ((float) this.jIY) + (((float) (this.jJa - this.jIY)) * f2);
    }

    /* access modifiers changed from: protected */
    public final float aB(float f2) {
        return ((float) this.jIZ) + (((float) (this.jJb - this.jIZ)) * f2);
    }
}
