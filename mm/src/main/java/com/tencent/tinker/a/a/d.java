package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;
import com.tencent.tinker.a.a.s;

public final class d extends s.a.AbstractC2212a<d> {
    public int SfA;
    public int[][] SfB;
    public int[][] SfC;
    public int[][] SfD;

    public d(int i2, int i3, int[][] iArr, int[][] iArr2, int[][] iArr3) {
        super(i2);
        this.SfA = i3;
        this.SfB = iArr;
        this.SfC = iArr2;
        this.SfD = iArr3;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int compareTo(d dVar) {
        if (this.SfA != dVar.SfA) {
            return c.mD(this.SfA, dVar.SfA);
        }
        int length = this.SfB.length;
        int length2 = this.SfC.length;
        int length3 = this.SfD.length;
        int length4 = dVar.SfB.length;
        int length5 = dVar.SfC.length;
        int length6 = dVar.SfD.length;
        if (length != length4) {
            return c.mE(length, length4);
        }
        if (length2 != length5) {
            return c.mE(length2, length5);
        }
        if (length3 != length6) {
            return c.mE(length3, length6);
        }
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = this.SfB[i2][0];
            int i4 = this.SfB[i2][1];
            int i5 = dVar.SfB[i2][0];
            int i6 = dVar.SfB[i2][1];
            if (i3 != i5) {
                return c.mD(i3, i5);
            }
            if (i4 != i6) {
                return c.mE(i4, i6);
            }
        }
        for (int i7 = 0; i7 < length2; i7++) {
            int i8 = this.SfC[i7][0];
            int i9 = this.SfC[i7][1];
            int i10 = dVar.SfC[i7][0];
            int i11 = dVar.SfC[i7][1];
            if (i8 != i10) {
                return c.mD(i8, i10);
            }
            if (i9 != i11) {
                return c.mE(i9, i11);
            }
        }
        for (int i12 = 0; i12 < length3; i12++) {
            int i13 = this.SfD[i12][0];
            int i14 = this.SfD[i12][1];
            int i15 = dVar.SfD[i12][0];
            int i16 = dVar.SfD[i12][1];
            if (i13 != i15) {
                return c.mD(i13, i15);
            }
            if (i14 != i16) {
                return c.mE(i14, i16);
            }
        }
        return 0;
    }

    @Override // com.tencent.tinker.a.a.s.a.AbstractC2212a
    public final int hashCode() {
        return e.hash(Integer.valueOf(this.SfA), this.SfB, this.SfC, this.SfD);
    }

    @Override // com.tencent.tinker.a.a.s.a.AbstractC2212a
    public final boolean equals(Object obj) {
        if ((obj instanceof d) && compareTo((d) obj) == 0) {
            return true;
        }
        return false;
    }
}
