package com.tencent.tinker.a.c;

public final class b implements Cloneable {
    private static final int[] bYn = new int[0];
    public int[] Pi;
    public int[] Shv;
    public int mSize;

    public b() {
        this(10);
    }

    public b(int i2) {
        if (i2 == 0) {
            this.Pi = bYn;
            this.Shv = bYn;
        } else {
            this.Pi = new int[i2];
            this.Shv = new int[this.Pi.length];
        }
        this.mSize = 0;
    }

    private static int av(int i2) {
        if (i2 <= 4) {
            return 8;
        }
        return (i2 >> 1) + i2;
    }

    /* access modifiers changed from: private */
    /* renamed from: hpa */
    public b clone() {
        try {
            b bVar = (b) super.clone();
            try {
                bVar.Pi = (int[]) this.Pi.clone();
                bVar.Shv = (int[]) this.Shv.clone();
                return bVar;
            } catch (CloneNotSupportedException e2) {
                return bVar;
            }
        } catch (CloneNotSupportedException e3) {
            return null;
        }
    }

    public final int get(int i2) {
        return ase(i2);
    }

    public final int ase(int i2) {
        int b2 = b(this.Pi, this.mSize, i2);
        if (b2 < 0) {
            return 0;
        }
        return this.Shv[b2];
    }

    public final void put(int i2, int i3) {
        int b2 = b(this.Pi, this.mSize, i2);
        if (b2 >= 0) {
            this.Shv[b2] = i3;
            return;
        }
        int i4 = b2 ^ -1;
        this.Pi = b(this.Pi, this.mSize, i4, i2);
        this.Shv = b(this.Shv, this.mSize, i4, i3);
        this.mSize++;
    }

    public final int size() {
        return this.mSize;
    }

    public final int keyAt(int i2) {
        return this.Pi[i2];
    }

    public final int indexOfKey(int i2) {
        return b(this.Pi, this.mSize, i2);
    }

    public final void append(int i2, int i3) {
        if (this.mSize == 0 || i2 > this.Pi[this.mSize - 1]) {
            this.Pi = h(this.Pi, this.mSize, i2);
            this.Shv = h(this.Shv, this.mSize, i3);
            this.mSize++;
            return;
        }
        put(i2, i3);
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

    private static int[] h(int[] iArr, int i2, int i3) {
        if (i2 > iArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i2);
        }
        if (i2 + 1 > iArr.length) {
            int[] iArr2 = new int[av(i2)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            iArr = iArr2;
        }
        iArr[i2] = i3;
        return iArr;
    }

    private static int[] b(int[] iArr, int i2, int i3, int i4) {
        if (i2 > iArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i2);
        } else if (i2 + 1 <= iArr.length) {
            System.arraycopy(iArr, i3, iArr, i3 + 1, i2 - i3);
            iArr[i3] = i4;
            return iArr;
        } else {
            int[] iArr2 = new int[av(i2)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            iArr2[i3] = i4;
            System.arraycopy(iArr, i3, iArr2, i3 + 1, iArr.length - i3);
            return iArr2;
        }
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
            sb.append(this.Shv[i2]);
        }
        sb.append('}');
        return sb.toString();
    }
}
