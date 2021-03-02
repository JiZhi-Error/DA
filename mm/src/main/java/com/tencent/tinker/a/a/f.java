package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;
import com.tencent.tinker.a.a.s;

public final class f extends s.a.AbstractC2212a<f> {
    public int SfJ;
    public int SfM;
    public int SfN;
    public int SfO;
    public int SfP;
    public int SfQ;
    public int SfR;
    public int SfS;

    public f(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        super(i2);
        this.SfM = i3;
        this.SfJ = i4;
        this.SfN = i5;
        this.SfO = i6;
        this.SfP = i7;
        this.SfQ = i8;
        this.SfR = i9;
        this.SfS = i10;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int compareTo(f fVar) {
        int mD = c.mD(this.SfM, fVar.SfM);
        if (mD != 0) {
            return mD;
        }
        int mE = c.mE(this.SfJ, fVar.SfJ);
        if (mE != 0) {
            return mE;
        }
        int mD2 = c.mD(this.SfN, fVar.SfN);
        if (mD2 != 0) {
            return mD2;
        }
        int mE2 = c.mE(this.SfO, fVar.SfO);
        if (mE2 != 0) {
            return mE2;
        }
        int mD3 = c.mD(this.SfP, fVar.SfP);
        if (mD3 != 0) {
            return mD3;
        }
        int mE3 = c.mE(this.SfQ, fVar.SfQ);
        if (mE3 != 0) {
            return mE3;
        }
        int mE4 = c.mE(this.SfR, fVar.SfR);
        return mE4 == 0 ? c.mE(this.SfS, fVar.SfS) : mE4;
    }

    @Override // com.tencent.tinker.a.a.s.a.AbstractC2212a
    public final int hashCode() {
        return e.hash(Integer.valueOf(this.SfM), Integer.valueOf(this.SfJ), Integer.valueOf(this.SfN), Integer.valueOf(this.SfO), Integer.valueOf(this.SfP), Integer.valueOf(this.SfQ), Integer.valueOf(this.SfR), Integer.valueOf(this.SfS));
    }

    @Override // com.tencent.tinker.a.a.s.a.AbstractC2212a
    public final boolean equals(Object obj) {
        if ((obj instanceof f) && compareTo((f) obj) == 0) {
            return true;
        }
        return false;
    }
}
