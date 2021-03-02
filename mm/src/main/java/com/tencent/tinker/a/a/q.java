package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;
import com.tencent.tinker.a.a.s;

public final class q extends s.a.AbstractC2212a<q> {
    public int SgB;
    public int SgC;
    public int SgD;

    public q(int i2, int i3, int i4, int i5) {
        super(i2);
        this.SgB = i3;
        this.SgC = i4;
        this.SgD = i5;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int compareTo(q qVar) {
        int mD = c.mD(this.SgB, qVar.SgB);
        if (mD != 0) {
            return mD;
        }
        int mD2 = c.mD(this.SgC, qVar.SgC);
        return mD2 == 0 ? c.mE(this.SgD, qVar.SgD) : mD2;
    }

    @Override // com.tencent.tinker.a.a.s.a.AbstractC2212a
    public final int hashCode() {
        return e.hash(Integer.valueOf(this.SgB), Integer.valueOf(this.SgC), Integer.valueOf(this.SgD));
    }

    @Override // com.tencent.tinker.a.a.s.a.AbstractC2212a
    public final boolean equals(Object obj) {
        if ((obj instanceof q) && compareTo((q) obj) == 0) {
            return true;
        }
        return false;
    }
}
