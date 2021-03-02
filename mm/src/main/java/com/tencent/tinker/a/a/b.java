package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.s;
import java.util.Arrays;

public final class b extends s.a.AbstractC2212a<b> {
    public int[] Sfy;

    public b(int i2, int[] iArr) {
        super(i2);
        this.Sfy = iArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int compareTo(b bVar) {
        int length = this.Sfy.length;
        int length2 = bVar.Sfy.length;
        if (length != length2) {
            return c.mD(length, length2);
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (this.Sfy[i2] != bVar.Sfy[i2]) {
                return c.mD(this.Sfy[i2], bVar.Sfy[i2]);
            }
        }
        return 0;
    }

    @Override // com.tencent.tinker.a.a.s.a.AbstractC2212a
    public final int hashCode() {
        return Arrays.hashCode(this.Sfy);
    }

    @Override // com.tencent.tinker.a.a.s.a.AbstractC2212a
    public final boolean equals(Object obj) {
        if ((obj instanceof b) && compareTo((b) obj) == 0) {
            return true;
        }
        return false;
    }
}
