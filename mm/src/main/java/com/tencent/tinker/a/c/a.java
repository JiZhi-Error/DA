package com.tencent.tinker.a.c;

public final class a implements Cloneable {
    private static final boolean[] Sht = new boolean[0];
    private static final int[] bYn = new int[0];
    private int[] Pi;
    private boolean[] Shu;
    private int mSize;

    public a() {
        this((byte) 0);
    }

    private a(byte b2) {
        this.Pi = new int[10];
        this.Shu = new boolean[10];
        this.mSize = 0;
    }

    private static int av(int i2) {
        if (i2 <= 4) {
            return 8;
        }
        return (i2 >> 1) + i2;
    }

    /* access modifiers changed from: private */
    /* renamed from: hoZ */
    public a clone() {
        try {
            a aVar = (a) super.clone();
            try {
                aVar.Pi = (int[]) this.Pi.clone();
                aVar.Shu = (boolean[]) this.Shu.clone();
                return aVar;
            } catch (CloneNotSupportedException e2) {
                return aVar;
            }
        } catch (CloneNotSupportedException e3) {
            return null;
        }
    }

    public final void asd(int i2) {
        int b2 = b(this.Pi, this.mSize, i2);
        if (b2 >= 0) {
            this.Shu[b2] = true;
            return;
        }
        int i3 = b2 ^ -1;
        int[] iArr = this.Pi;
        int i4 = this.mSize;
        if (i4 > iArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i4);
        }
        if (i4 + 1 <= iArr.length) {
            System.arraycopy(iArr, i3, iArr, i3 + 1, i4 - i3);
            iArr[i3] = i2;
        } else {
            int[] iArr2 = new int[av(i4)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            iArr2[i3] = i2;
            System.arraycopy(iArr, i3, iArr2, i3 + 1, iArr.length - i3);
            iArr = iArr2;
        }
        this.Pi = iArr;
        boolean[] zArr = this.Shu;
        int i5 = this.mSize;
        if (i5 > zArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + zArr.length + " currentSize: " + i5);
        }
        if (i5 + 1 <= zArr.length) {
            System.arraycopy(zArr, i3, zArr, i3 + 1, i5 - i3);
            zArr[i3] = true;
        } else {
            boolean[] zArr2 = new boolean[av(i5)];
            System.arraycopy(zArr, 0, zArr2, 0, i3);
            zArr2[i3] = true;
            System.arraycopy(zArr, i3, zArr2, i3 + 1, zArr.length - i3);
            zArr = zArr2;
        }
        this.Shu = zArr;
        this.mSize++;
    }

    private static int b(int[] iArr, int i2, int i3) {
        int i4 = i2 - 1;
        int i5 = 0;
        while (i5 <= i4) {
            int i6 = (i5 + i4) >>> 1;
            int i7 = iArr[i6];
            if (i7 < i3) {
                i5 = i6 + 1;
            } else if (i7 <= i3) {
                return i6;
            } else {
                i4 = i6 - 1;
            }
        }
        return i5 ^ -1;
    }

    public final boolean hM(int i2) {
        return b(this.Pi, this.mSize, i2) >= 0;
    }

    public final String toString() {
        if (this.mSize <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.mSize; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(this.Pi[i2]);
            sb.append('=');
            sb.append(this.Shu[i2]);
        }
        sb.append('}');
        return sb.toString();
    }
}
