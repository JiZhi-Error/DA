package com.tencent.mm.compatible.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b<E> {
    static final Object OT = new Object();
    boolean OU;
    long[] OV;
    Object[] OW;
    int mSize;

    static {
        AppMethodBeat.i(157478);
        AppMethodBeat.o(157478);
    }

    public final void put(long j2, E e2) {
        AppMethodBeat.i(157477);
        int b2 = b(this.OV, this.mSize, j2);
        if (b2 >= 0) {
            this.OW[b2] = e2;
            AppMethodBeat.o(157477);
            return;
        }
        int i2 = b2 ^ -1;
        if (i2 >= this.mSize || this.OW[i2] != OT) {
            if (this.OU && this.mSize >= this.OV.length) {
                int i3 = this.mSize;
                long[] jArr = this.OV;
                Object[] objArr = this.OW;
                int i4 = 0;
                for (int i5 = 0; i5 < i3; i5++) {
                    Object obj = objArr[i5];
                    if (obj != OT) {
                        if (i5 != i4) {
                            jArr[i4] = jArr[i5];
                            objArr[i4] = obj;
                        }
                        i4++;
                    }
                }
                this.OU = false;
                this.mSize = i4;
                i2 = b(this.OV, this.mSize, j2) ^ -1;
            }
            if (this.mSize >= this.OV.length) {
                int idealIntArraySize = a.idealIntArraySize(this.mSize + 1);
                long[] jArr2 = new long[idealIntArraySize];
                Object[] objArr2 = new Object[idealIntArraySize];
                System.arraycopy(this.OV, 0, jArr2, 0, this.OV.length);
                System.arraycopy(this.OW, 0, objArr2, 0, this.OW.length);
                this.OV = jArr2;
                this.OW = objArr2;
            }
            if (this.mSize - i2 != 0) {
                long[] jArr3 = this.OV;
                System.arraycopy(jArr3, i2, jArr3, i2 + 1, this.mSize - i2);
                Object[] objArr3 = this.OW;
                System.arraycopy(objArr3, i2, objArr3, i2 + 1, this.mSize - i2);
            }
            this.OV[i2] = j2;
            this.OW[i2] = e2;
            this.mSize++;
            AppMethodBeat.o(157477);
            return;
        }
        this.OV[i2] = j2;
        this.OW[i2] = e2;
        AppMethodBeat.o(157477);
    }

    static int b(long[] jArr, int i2, long j2) {
        int i3 = i2 + 0;
        int i4 = -1;
        while (i3 - i4 > 1) {
            int i5 = (i3 + i4) / 2;
            if (jArr[i5] < j2) {
                i4 = i5;
            } else {
                i3 = i5;
            }
        }
        if (i3 == i2 + 0) {
            return (i2 + 0) ^ -1;
        }
        return jArr[i3] != j2 ? i3 ^ -1 : i3;
    }
}
