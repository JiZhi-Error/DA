package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.s;
import java.util.Arrays;

public final class c extends s.a.AbstractC2212a<c> {
    public int[] Sfz;

    public c(int i2, int[] iArr) {
        super(i2);
        this.Sfz = iArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int compareTo(c cVar) {
        int length = this.Sfz.length;
        int length2 = cVar.Sfz.length;
        if (length != length2) {
            return com.tencent.tinker.a.a.b.c.mD(length, length2);
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (this.Sfz[i2] != cVar.Sfz[i2]) {
                return com.tencent.tinker.a.a.b.c.mD(this.Sfz[i2], cVar.Sfz[i2]);
            }
        }
        return 0;
    }

    @Override // com.tencent.tinker.a.a.s.a.AbstractC2212a
    public final int hashCode() {
        return Arrays.hashCode(this.Sfz);
    }

    @Override // com.tencent.tinker.a.a.s.a.AbstractC2212a
    public final boolean equals(Object obj) {
        if ((obj instanceof c) && compareTo((c) obj) == 0) {
            return true;
        }
        return false;
    }
}
