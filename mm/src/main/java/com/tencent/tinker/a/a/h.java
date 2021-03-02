package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;
import com.tencent.tinker.a.a.s;

public final class h extends s.a.AbstractC2212a<h> {
    public int Sgg;
    public int[] Sgh;
    public byte[] Sgi;

    public h(int i2, int i3, int[] iArr, byte[] bArr) {
        super(i2);
        this.Sgg = i3;
        this.Sgh = iArr;
        this.Sgi = bArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int compareTo(h hVar) {
        int i2;
        int i3 = this.Sgg;
        int i4 = hVar.Sgg;
        if (i3 != i4) {
            return i3 - i4;
        }
        int[] iArr = this.Sgh;
        int[] iArr2 = hVar.Sgh;
        int length = iArr.length;
        int length2 = iArr2.length;
        if (length >= length2) {
            if (length <= length2) {
                int i5 = 0;
                while (true) {
                    if (i5 < length) {
                        i2 = c.mD(iArr[i5], iArr2[i5]);
                        if (i2 != 0) {
                            break;
                        }
                        i5++;
                    } else {
                        i2 = 0;
                        break;
                    }
                }
            } else {
                i2 = 1;
            }
        } else {
            i2 = -1;
        }
        if (i2 == 0) {
            return c.p(this.Sgi, hVar.Sgi);
        }
        return i2;
    }

    @Override // com.tencent.tinker.a.a.s.a.AbstractC2212a
    public final int hashCode() {
        return e.hash(Integer.valueOf(this.Sgg), this.Sgh, this.Sgi);
    }

    @Override // com.tencent.tinker.a.a.s.a.AbstractC2212a
    public final boolean equals(Object obj) {
        if ((obj instanceof h) && compareTo((h) obj) == 0) {
            return true;
        }
        return false;
    }
}
