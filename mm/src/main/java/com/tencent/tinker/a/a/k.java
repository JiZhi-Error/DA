package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.s;
import java.util.Arrays;

public final class k extends s.a.AbstractC2212a<k> {
    public byte[] data;

    public k(int i2, byte[] bArr) {
        super(i2);
        this.data = bArr;
    }

    /* renamed from: b */
    public final int compareTo(k kVar) {
        return c.p(this.data, kVar.data);
    }

    @Override // com.tencent.tinker.a.a.s.a.AbstractC2212a
    public final int hashCode() {
        return Arrays.hashCode(this.data);
    }

    @Override // com.tencent.tinker.a.a.s.a.AbstractC2212a
    public final boolean equals(Object obj) {
        if ((obj instanceof k) && compareTo((k) obj) == 0) {
            return true;
        }
        return false;
    }
}
