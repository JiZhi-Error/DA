package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.s;

public final class r extends s.a.AbstractC2212a<r> {
    public String value;

    public r(int i2, String str) {
        super(i2);
        this.value = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int compareTo(r rVar) {
        return this.value.compareTo(rVar.value);
    }

    @Override // com.tencent.tinker.a.a.s.a.AbstractC2212a
    public final int hashCode() {
        return this.value.hashCode();
    }

    @Override // com.tencent.tinker.a.a.s.a.AbstractC2212a
    public final boolean equals(Object obj) {
        if ((obj instanceof r) && compareTo((r) obj) == 0) {
            return true;
        }
        return false;
    }
}
