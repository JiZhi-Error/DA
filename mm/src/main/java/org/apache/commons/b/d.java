package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d {
    private int KVM;
    private transient a[] Uft;
    private final float Ufu;
    private transient int count;

    static class a {
        a Ufv;
        final int bNi;
        final int key;
        Object value;

        protected a(int i2, int i3, Object obj, a aVar) {
            this.bNi = i2;
            this.key = i3;
            this.value = obj;
            this.Ufv = aVar;
        }
    }

    public d() {
        this((byte) 0);
    }

    private d(byte b2) {
        AppMethodBeat.i(40732);
        this.Ufu = 0.75f;
        this.Uft = new a[20];
        this.KVM = 15;
        AppMethodBeat.o(40732);
    }

    public final Object e(int i2, Object obj) {
        AppMethodBeat.i(40733);
        a[] aVarArr = this.Uft;
        int length = (i2 & Integer.MAX_VALUE) % aVarArr.length;
        for (a aVar = aVarArr[length]; aVar != null; aVar = aVar.Ufv) {
            if (aVar.bNi == i2) {
                Object obj2 = aVar.value;
                aVar.value = obj;
                AppMethodBeat.o(40733);
                return obj2;
            }
        }
        if (this.count >= this.KVM) {
            int length2 = this.Uft.length;
            a[] aVarArr2 = this.Uft;
            int i3 = (length2 * 2) + 1;
            a[] aVarArr3 = new a[i3];
            this.KVM = (int) (((float) i3) * this.Ufu);
            this.Uft = aVarArr3;
            while (true) {
                int i4 = length2 - 1;
                if (length2 <= 0) {
                    break;
                }
                a aVar2 = aVarArr2[i4];
                while (aVar2 != null) {
                    a aVar3 = aVar2.Ufv;
                    int i5 = (aVar2.bNi & Integer.MAX_VALUE) % i3;
                    aVar2.Ufv = aVarArr3[i5];
                    aVarArr3[i5] = aVar2;
                    aVar2 = aVar3;
                }
                length2 = i4;
            }
            aVarArr = this.Uft;
            length = (i2 & Integer.MAX_VALUE) % aVarArr.length;
        }
        aVarArr[length] = new a(i2, i2, obj, aVarArr[length]);
        this.count++;
        AppMethodBeat.o(40733);
        return null;
    }
}
