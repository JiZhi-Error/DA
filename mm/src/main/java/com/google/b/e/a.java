package com.google.b.e;

import com.google.b.b.b;
import com.google.b.c;
import com.google.b.e.a.d;
import com.google.b.e.a.e;
import com.google.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

public final class a implements g {
    @Override // com.google.b.g
    public final b a(String str, com.google.b.a aVar, int i2, int i3, Map<c, ?> map) {
        int i4;
        boolean z;
        boolean z2;
        byte[][] bArr;
        int i5;
        AppMethodBeat.i(12300);
        if (aVar != com.google.b.a.PDF_417) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can only encode PDF_417, but got ".concat(String.valueOf(aVar)));
            AppMethodBeat.o(12300);
            throw illegalArgumentException;
        }
        e eVar = new e();
        int i6 = 2;
        if (map != null) {
            if (map.containsKey(c.PDF417_COMPACT)) {
                eVar.cce = Boolean.valueOf(map.get(c.PDF417_COMPACT).toString()).booleanValue();
            }
            if (map.containsKey(c.PDF417_COMPACTION)) {
                eVar.ceQ = com.google.b.e.a.c.valueOf(map.get(c.PDF417_COMPACTION).toString());
            }
            if (map.containsKey(c.PDF417_DIMENSIONS)) {
                d dVar = (d) map.get(c.PDF417_DIMENSIONS);
                int i7 = dVar.ceM;
                int i8 = dVar.ceL;
                int i9 = dVar.maxRows;
                int i10 = dVar.ceN;
                eVar.ceM = i7;
                eVar.ceL = i8;
                eVar.maxRows = i9;
                eVar.ceN = i10;
            }
            if (map.containsKey(c.MARGIN)) {
                i4 = Integer.parseInt(map.get(c.MARGIN).toString());
            } else {
                i4 = 30;
            }
            if (map.containsKey(c.ERROR_CORRECTION)) {
                i5 = Integer.parseInt(map.get(c.ERROR_CORRECTION).toString());
            } else {
                i5 = 2;
            }
            if (map.containsKey(c.CHARACTER_SET)) {
                eVar.ceR = Charset.forName(map.get(c.CHARACTER_SET).toString());
            }
            i6 = i5;
        } else {
            i4 = 30;
        }
        eVar.m(str, i6);
        byte[][] bN = eVar.ceP.bN(1, 4);
        boolean z3 = i3 > i2;
        if (bN[0].length < bN.length) {
            z = true;
        } else {
            z = false;
        }
        if (z3 ^ z) {
            bN = b(bN);
            z2 = true;
        } else {
            z2 = false;
        }
        int length = i2 / bN[0].length;
        int length2 = i3 / bN.length;
        if (length < length2) {
            length2 = length;
        }
        if (length2 > 1) {
            byte[][] bN2 = eVar.ceP.bN(length2, length2 << 2);
            if (z2) {
                bArr = b(bN2);
            } else {
                bArr = bN2;
            }
            b a2 = a(bArr, i4);
            AppMethodBeat.o(12300);
            return a2;
        }
        b a3 = a(bN, i4);
        AppMethodBeat.o(12300);
        return a3;
    }

    private static b a(byte[][] bArr, int i2) {
        AppMethodBeat.i(12301);
        b bVar = new b(bArr[0].length + (i2 * 2), bArr.length + (i2 * 2));
        bVar.clear();
        int i3 = (bVar.height - i2) - 1;
        int i4 = 0;
        while (i4 < bArr.length) {
            for (int i5 = 0; i5 < bArr[0].length; i5++) {
                if (bArr[i4][i5] == 1) {
                    bVar.set(i5 + i2, i3);
                }
            }
            i4++;
            i3--;
        }
        AppMethodBeat.o(12301);
        return bVar;
    }

    private static byte[][] b(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance(Byte.TYPE, bArr[0].length, bArr.length);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int length = (bArr.length - i2) - 1;
            for (int i3 = 0; i3 < bArr[0].length; i3++) {
                bArr2[i3][length] = bArr[i2][i3];
            }
        }
        return bArr2;
    }
}
