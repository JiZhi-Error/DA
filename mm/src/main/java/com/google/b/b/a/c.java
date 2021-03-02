package com.google.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class c {
    private final a cdu;
    private final List<b> cdw = new ArrayList();

    public c(a aVar) {
        AppMethodBeat.i(12229);
        this.cdu = aVar;
        this.cdw.add(new b(aVar, new int[]{1}));
        AppMethodBeat.o(12229);
    }

    private b hg(int i2) {
        b bVar;
        AppMethodBeat.i(12230);
        if (i2 >= this.cdw.size()) {
            int size = this.cdw.size();
            b bVar2 = this.cdw.get(this.cdw.size() - 1);
            while (size <= i2) {
                b bVar3 = new b(this.cdu, new int[]{1, this.cdu.cdo[(size - 1) + this.cdu.cdt]});
                if (!bVar2.cdu.equals(bVar3.cdu)) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
                    AppMethodBeat.o(12230);
                    throw illegalArgumentException;
                }
                if (bVar2.isZero() || bVar3.isZero()) {
                    bVar = bVar2.cdu.cdq;
                } else {
                    int[] iArr = bVar2.cdv;
                    int length = iArr.length;
                    int[] iArr2 = bVar3.cdv;
                    int length2 = iArr2.length;
                    int[] iArr3 = new int[((length + length2) - 1)];
                    for (int i3 = 0; i3 < length; i3++) {
                        int i4 = iArr[i3];
                        for (int i5 = 0; i5 < length2; i5++) {
                            iArr3[i3 + i5] = a.bJ(iArr3[i3 + i5], bVar2.cdu.bK(i4, iArr2[i5]));
                        }
                    }
                    bVar = new b(bVar2.cdu, iArr3);
                }
                this.cdw.add(bVar);
                size++;
                bVar2 = bVar;
            }
        }
        b bVar4 = this.cdw.get(i2);
        AppMethodBeat.o(12230);
        return bVar4;
    }

    public final void e(int[] iArr, int i2) {
        AppMethodBeat.i(12231);
        if (i2 == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No error correction bytes");
            AppMethodBeat.o(12231);
            throw illegalArgumentException;
        }
        int length = iArr.length - i2;
        if (length <= 0) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("No data bytes provided");
            AppMethodBeat.o(12231);
            throw illegalArgumentException2;
        }
        b hg = hg(i2);
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        int[] iArr3 = new b(this.cdu, iArr2).bL(i2, 1).b(hg)[1].cdv;
        int length2 = i2 - iArr3.length;
        for (int i3 = 0; i3 < length2; i3++) {
            iArr[length + i3] = 0;
        }
        System.arraycopy(iArr3, 0, iArr, length + length2, iArr3.length);
        AppMethodBeat.o(12231);
    }
}
