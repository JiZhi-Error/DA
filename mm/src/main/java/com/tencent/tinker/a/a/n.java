package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;
import com.tencent.tinker.a.a.s;

public final class n extends s.a.AbstractC2212a<n> {
    public int SfM;
    public int Sgy;
    public int Sgz;

    public n(int i2, int i3, int i4, int i5) {
        super(i2);
        this.Sgy = i3;
        this.SfM = i4;
        this.Sgz = i5;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int compareTo(n nVar) {
        if (this.Sgy != nVar.Sgy) {
            return c.mD(this.Sgy, nVar.Sgy);
        }
        if (this.Sgz != nVar.Sgz) {
            return c.mD(this.Sgz, nVar.Sgz);
        }
        return c.mD(this.SfM, nVar.SfM);
    }

    @Override // com.tencent.tinker.a.a.s.a.AbstractC2212a
    public final int hashCode() {
        return e.hash(Integer.valueOf(this.Sgy), Integer.valueOf(this.SfM), Integer.valueOf(this.Sgz));
    }

    @Override // com.tencent.tinker.a.a.s.a.AbstractC2212a
    public final boolean equals(Object obj) {
        if ((obj instanceof n) && compareTo((n) obj) == 0) {
            return true;
        }
        return false;
    }
}
