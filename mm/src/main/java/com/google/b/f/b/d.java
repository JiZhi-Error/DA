package com.google.b.f.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class d {
    static boolean x(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(12245);
        int min = Math.min(i3, bArr.length);
        for (int max = Math.max(i2, 0); max < min; max++) {
            if (bArr[max] == 1) {
                AppMethodBeat.o(12245);
                return false;
            }
        }
        AppMethodBeat.o(12245);
        return true;
    }

    static boolean a(byte[][] bArr, int i2, int i3, int i4) {
        AppMethodBeat.i(12246);
        int min = Math.min(i4, bArr.length);
        for (int max = Math.max(i3, 0); max < min; max++) {
            if (bArr[max][i2] == 1) {
                AppMethodBeat.o(12246);
                return false;
            }
        }
        AppMethodBeat.o(12246);
        return true;
    }

    static int a(b bVar, boolean z) {
        int i2;
        int i3;
        if (z) {
            i2 = bVar.height;
        } else {
            i2 = bVar.width;
        }
        if (z) {
            i3 = bVar.width;
        } else {
            i3 = bVar.height;
        }
        byte[][] bArr = bVar.cfD;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            byte b2 = -1;
            int i6 = 0;
            for (int i7 = 0; i7 < i3; i7++) {
                byte b3 = z ? bArr[i5][i7] : bArr[i7][i5];
                if (b3 == b2) {
                    i6++;
                } else {
                    if (i6 >= 5) {
                        i4 += (i6 - 5) + 3;
                    }
                    i6 = 1;
                    b2 = b3;
                }
            }
            if (i6 >= 5) {
                i4 += (i6 - 5) + 3;
            }
        }
        return i4;
    }
}
