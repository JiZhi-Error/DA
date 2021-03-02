package com.tencent.tinker.a.b.a;

public final class h extends a {
    public short[] Shs;

    public h(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("initSize < 0");
        }
        this.Shs = new short[i2];
    }

    public final void c(short s) {
        int i2 = this.apk;
        if (this.Shs.length - i2 <= 0) {
            short[] sArr = new short[(this.Shs.length + (this.Shs.length >> 1))];
            System.arraycopy(this.Shs, 0, sArr, 0, i2);
            this.Shs = sArr;
        }
        this.Shs[this.apk] = s;
        hoY();
    }

    public final void b(short s, short s2) {
        c(s);
        c(s2);
    }

    public final void a(short s, short s2, short s3) {
        c(s);
        c(s2);
        c(s3);
    }

    public final void writeInt(int i2) {
        c((short) i2);
        c((short) (i2 >> 16));
    }
}
