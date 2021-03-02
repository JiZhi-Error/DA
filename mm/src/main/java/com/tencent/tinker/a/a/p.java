package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;
import com.tencent.tinker.a.a.s;

public final class p extends s.a.AbstractC2212a<p> {
    public int SgA;
    public int Sgy;
    public int Sgz;

    public p(int i2, int i3, int i4, int i5) {
        super(i2);
        this.Sgy = i3;
        this.SgA = i4;
        this.Sgz = i5;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int compareTo(p pVar) {
        if (this.Sgy != pVar.Sgy) {
            return c.mD(this.Sgy, pVar.Sgy);
        }
        if (this.Sgz != pVar.Sgz) {
            return c.mD(this.Sgz, pVar.Sgz);
        }
        return c.mD(this.SgA, pVar.SgA);
    }

    @Override // com.tencent.tinker.a.a.s.a.AbstractC2212a
    public final int hashCode() {
        return e.hash(Integer.valueOf(this.Sgy), Integer.valueOf(this.SgA), Integer.valueOf(this.Sgz));
    }

    @Override // com.tencent.tinker.a.a.s.a.AbstractC2212a
    public final boolean equals(Object obj) {
        if ((obj instanceof p) && compareTo((p) obj) == 0) {
            return true;
        }
        return false;
    }
}
