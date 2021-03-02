package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;
import com.tencent.tinker.a.a.s;

public final class a extends s.a.AbstractC2212a<a> {
    public byte Sfw;
    public k Sfx;

    public a(int i2, byte b2, k kVar) {
        super(i2);
        this.Sfw = b2;
        this.Sfx = kVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int compareTo(a aVar) {
        int b2 = this.Sfx.compareTo(aVar.Sfx);
        return b2 != 0 ? b2 : c.a(this.Sfw, aVar.Sfw);
    }

    @Override // com.tencent.tinker.a.a.s.a.AbstractC2212a
    public final int hashCode() {
        return e.hash(Byte.valueOf(this.Sfw), this.Sfx);
    }

    @Override // com.tencent.tinker.a.a.s.a.AbstractC2212a
    public final boolean equals(Object obj) {
        if ((obj instanceof a) && compareTo((a) obj) == 0) {
            return true;
        }
        return false;
    }
}
