package com.google.b.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

public final class a {
    private final b[] ceC;
    int ceD;
    private final int height;
    private final int width;

    a(int i2, int i3) {
        AppMethodBeat.i(12294);
        this.ceC = new b[i2];
        int length = this.ceC.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.ceC[i4] = new b(((i3 + 4) * 17) + 1);
        }
        this.width = i3 * 17;
        this.height = i2;
        this.ceD = -1;
        AppMethodBeat.o(12294);
    }

    /* access modifiers changed from: package-private */
    public final b Iy() {
        return this.ceC[this.ceD];
    }

    public final byte[][] bN(int i2, int i3) {
        byte[][] bArr = (byte[][]) Array.newInstance(Byte.TYPE, this.height * i3, this.width * i2);
        int i4 = this.height * i3;
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (i4 - i5) - 1;
            b bVar = this.ceC[i5 / i3];
            byte[] bArr2 = new byte[(bVar.ceE.length * i2)];
            for (int i7 = 0; i7 < bArr2.length; i7++) {
                bArr2[i7] = bVar.ceE[i7 / i2];
            }
            bArr[i6] = bArr2;
        }
        return bArr;
    }
}
