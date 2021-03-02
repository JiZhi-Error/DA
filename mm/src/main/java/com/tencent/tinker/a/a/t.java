package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.s;
import java.util.Arrays;

public final class t extends s.a.AbstractC2212a<t> {
    public static final t Shc = new t(0, i.Sgj);
    public short[] Shd;

    public t(int i2, short[] sArr) {
        super(i2);
        this.Shd = sArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int compareTo(t tVar) {
        return c.a(this.Shd, tVar.Shd);
    }

    @Override // com.tencent.tinker.a.a.s.a.AbstractC2212a
    public final int hashCode() {
        return Arrays.hashCode(this.Shd);
    }

    @Override // com.tencent.tinker.a.a.s.a.AbstractC2212a
    public final boolean equals(Object obj) {
        if ((obj instanceof t) && compareTo((t) obj) == 0) {
            return true;
        }
        return false;
    }
}
