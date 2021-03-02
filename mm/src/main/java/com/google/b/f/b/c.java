package com.google.b.f.b;

import com.google.b.f.a.a;
import com.google.b.f.a.b;
import com.google.b.f.a.c;
import com.google.b.h;
import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

public final class c {
    private static final int[] cfE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    public static f a(String str, a aVar, Map<com.google.b.c, ?> map) {
        b bVar;
        com.google.b.f.a.c cVar;
        int length;
        int i2;
        com.google.b.b.c cr;
        int i3 = 0;
        AppMethodBeat.i(12314);
        String str2 = KindaConfigCacheStg.SAVE_CHARSET;
        if (map != null && map.containsKey(com.google.b.c.CHARACTER_SET)) {
            str2 = map.get(com.google.b.c.CHARACTER_SET).toString();
        }
        if (!"Shift_JIS".equals(str2) || !cv(str)) {
            int i4 = 0;
            boolean z = false;
            boolean z2 = false;
            while (true) {
                if (i4 < str.length()) {
                    char charAt = str.charAt(i4);
                    if (charAt < '0' || charAt > '9') {
                        if (hl(charAt) == -1) {
                            bVar = b.BYTE;
                            break;
                        }
                        z = true;
                    } else {
                        z2 = true;
                    }
                    i4++;
                } else if (z) {
                    bVar = b.ALPHANUMERIC;
                } else if (z2) {
                    bVar = b.NUMERIC;
                } else {
                    bVar = b.BYTE;
                }
            }
        } else {
            bVar = b.KANJI;
        }
        com.google.b.b.a aVar2 = new com.google.b.b.a();
        if (bVar == b.BYTE && !KindaConfigCacheStg.SAVE_CHARSET.equals(str2) && (cr = com.google.b.b.c.cr(str2)) != null) {
            aVar2.bH(b.ECI.cfd, 4);
            aVar2.bH(cr.cdd[0], 8);
        }
        aVar2.bH(bVar.cfd, 4);
        com.google.b.b.a aVar3 = new com.google.b.b.a();
        switch (bVar) {
            case NUMERIC:
                int length2 = str.length();
                while (i3 < length2) {
                    int charAt2 = str.charAt(i3) - '0';
                    if (i3 + 2 < length2) {
                        aVar3.bH((charAt2 * 100) + ((str.charAt(i3 + 1) - '0') * 10) + (str.charAt(i3 + 2) - '0'), 10);
                        i3 += 3;
                    } else if (i3 + 1 < length2) {
                        aVar3.bH((charAt2 * 10) + (str.charAt(i3 + 1) - '0'), 7);
                        i3 += 2;
                    } else {
                        aVar3.bH(charAt2, 4);
                        i3++;
                    }
                }
                break;
            case ALPHANUMERIC:
                int length3 = str.length();
                while (i3 < length3) {
                    int hl = hl(str.charAt(i3));
                    if (hl == -1) {
                        h hVar = new h();
                        AppMethodBeat.o(12314);
                        throw hVar;
                    } else if (i3 + 1 < length3) {
                        int hl2 = hl(str.charAt(i3 + 1));
                        if (hl2 == -1) {
                            h hVar2 = new h();
                            AppMethodBeat.o(12314);
                            throw hVar2;
                        }
                        aVar3.bH((hl * 45) + hl2, 11);
                        i3 += 2;
                    } else {
                        aVar3.bH(hl, 6);
                        i3++;
                    }
                }
                break;
            case BYTE:
                try {
                    byte[] bytes = str.getBytes(str2);
                    int length4 = bytes.length;
                    while (i3 < length4) {
                        aVar3.bH(bytes[i3], 8);
                        i3++;
                    }
                    break;
                } catch (UnsupportedEncodingException e2) {
                    h hVar3 = new h(e2);
                    AppMethodBeat.o(12314);
                    throw hVar3;
                }
            case KANJI:
                try {
                    byte[] bytes2 = str.getBytes("Shift_JIS");
                    int length5 = bytes2.length;
                    while (i3 < length5) {
                        int i5 = ((bytes2[i3] & 255) << 8) | (bytes2[i3 + 1] & 255);
                        if (i5 >= 33088 && i5 <= 40956) {
                            i2 = i5 - 33088;
                        } else if (i5 < 57408 || i5 > 60351) {
                            i2 = -1;
                        } else {
                            i2 = i5 - 49472;
                        }
                        if (i2 == -1) {
                            h hVar4 = new h("Invalid byte sequence");
                            AppMethodBeat.o(12314);
                            throw hVar4;
                        }
                        aVar3.bH((i2 & 255) + ((i2 >> 8) * 192), 13);
                        i3 += 2;
                    }
                    break;
                } catch (UnsupportedEncodingException e3) {
                    h hVar5 = new h(e3);
                    AppMethodBeat.o(12314);
                    throw hVar5;
                }
                break;
            default:
                h hVar6 = new h("Invalid mode: ".concat(String.valueOf(bVar)));
                AppMethodBeat.o(12314);
                throw hVar6;
        }
        if (map == null || !map.containsKey(com.google.b.c.QR_VERSION)) {
            cVar = a(a(bVar, aVar2, aVar3, a(a(bVar, aVar2, aVar3, com.google.b.f.a.c.hk(1)), aVar)), aVar);
        } else {
            cVar = com.google.b.f.a.c.hk(Integer.parseInt(map.get(com.google.b.c.QR_VERSION).toString()));
            if (!a(a(bVar, aVar2, aVar3, cVar), cVar, aVar)) {
                h hVar7 = new h("Data too big for requested version");
                AppMethodBeat.o(12314);
                throw hVar7;
            }
        }
        com.google.b.b.a aVar4 = new com.google.b.b.a();
        aVar4.a(aVar2);
        if (bVar == b.BYTE) {
            length = aVar3.Ii();
        } else {
            length = str.length();
        }
        int a2 = bVar.a(cVar);
        if (length >= (1 << a2)) {
            h hVar8 = new h(length + " is bigger than " + ((1 << a2) - 1));
            AppMethodBeat.o(12314);
            throw hVar8;
        }
        aVar4.bH(length, a2);
        aVar4.a(aVar3);
        c.b a3 = cVar.a(aVar);
        int IB = cVar.cfx - a3.IB();
        a(IB, aVar4);
        com.google.b.b.a a4 = a(aVar4, cVar.cfx, IB, a3.IA());
        f fVar = new f();
        fVar.cfL = aVar;
        fVar.cfK = bVar;
        fVar.cfM = cVar;
        int i6 = (cVar.cfu * 4) + 17;
        b bVar2 = new b(i6, i6);
        int a5 = a(a4, aVar, cVar, bVar2);
        fVar.cfN = a5;
        e.a(a4, aVar, cVar, a5, bVar2);
        fVar.cfO = bVar2;
        AppMethodBeat.o(12314);
        return fVar;
    }

    private static int hl(int i2) {
        if (i2 < cfE.length) {
            return cfE[i2];
        }
        return -1;
    }

    private static boolean cv(String str) {
        AppMethodBeat.i(12316);
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                AppMethodBeat.o(12316);
                return false;
            }
            for (int i2 = 0; i2 < length; i2 += 2) {
                int i3 = bytes[i2] & 255;
                if ((i3 < 129 || i3 > 159) && (i3 < 224 || i3 > 235)) {
                    AppMethodBeat.o(12316);
                    return false;
                }
            }
            AppMethodBeat.o(12316);
            return true;
        } catch (UnsupportedEncodingException e2) {
            AppMethodBeat.o(12316);
            return false;
        }
    }

    private static int a(com.google.b.b.a aVar, a aVar2, com.google.b.f.a.c cVar, b bVar) {
        int i2;
        AppMethodBeat.i(12317);
        int i3 = Integer.MAX_VALUE;
        int i4 = -1;
        int i5 = 0;
        while (i5 < 8) {
            e.a(aVar, aVar2, cVar, i5, bVar);
            int a2 = d.a(bVar, true) + d.a(bVar, false);
            int i6 = 0;
            byte[][] bArr = bVar.cfD;
            int i7 = bVar.width;
            int i8 = bVar.height;
            for (int i9 = 0; i9 < i8 - 1; i9++) {
                for (int i10 = 0; i10 < i7 - 1; i10++) {
                    byte b2 = bArr[i9][i10];
                    if (b2 == bArr[i9][i10 + 1] && b2 == bArr[i9 + 1][i10] && b2 == bArr[i9 + 1][i10 + 1]) {
                        i6++;
                    }
                }
            }
            int i11 = a2 + (i6 * 3);
            int i12 = 0;
            byte[][] bArr2 = bVar.cfD;
            int i13 = bVar.width;
            int i14 = bVar.height;
            for (int i15 = 0; i15 < i14; i15++) {
                for (int i16 = 0; i16 < i13; i16++) {
                    byte[] bArr3 = bArr2[i15];
                    if (i16 + 6 < i13 && bArr3[i16] == 1 && bArr3[i16 + 1] == 0 && bArr3[i16 + 2] == 1 && bArr3[i16 + 3] == 1 && bArr3[i16 + 4] == 1 && bArr3[i16 + 5] == 0 && bArr3[i16 + 6] == 1 && (d.x(bArr3, i16 - 4, i16) || d.x(bArr3, i16 + 7, i16 + 11))) {
                        i12++;
                    }
                    if (i15 + 6 < i14 && bArr2[i15][i16] == 1 && bArr2[i15 + 1][i16] == 0 && bArr2[i15 + 2][i16] == 1 && bArr2[i15 + 3][i16] == 1 && bArr2[i15 + 4][i16] == 1 && bArr2[i15 + 5][i16] == 0 && bArr2[i15 + 6][i16] == 1 && (d.a(bArr2, i16, i15 - 4, i15) || d.a(bArr2, i16, i15 + 7, i15 + 11))) {
                        i12++;
                    }
                }
            }
            int i17 = i11 + (i12 * 40);
            int i18 = 0;
            byte[][] bArr4 = bVar.cfD;
            int i19 = bVar.width;
            int i20 = bVar.height;
            for (int i21 = 0; i21 < i20; i21++) {
                byte[] bArr5 = bArr4[i21];
                for (int i22 = 0; i22 < i19; i22++) {
                    if (bArr5[i22] == 1) {
                        i18++;
                    }
                }
            }
            int i23 = bVar.height * bVar.width;
            int abs = i17 + (((Math.abs((i18 << 1) - i23) * 10) / i23) * 10);
            if (abs < i3) {
                i2 = i5;
            } else {
                i2 = i4;
                abs = i3;
            }
            i5++;
            i4 = i2;
            i3 = abs;
        }
        AppMethodBeat.o(12317);
        return i4;
    }

    private static com.google.b.f.a.c a(int i2, a aVar) {
        AppMethodBeat.i(12318);
        for (int i3 = 1; i3 <= 40; i3++) {
            com.google.b.f.a.c hk = com.google.b.f.a.c.hk(i3);
            if (a(i2, hk, aVar)) {
                AppMethodBeat.o(12318);
                return hk;
            }
        }
        h hVar = new h("Data too big");
        AppMethodBeat.o(12318);
        throw hVar;
    }

    private static void a(int i2, com.google.b.b.a aVar) {
        AppMethodBeat.i(12320);
        int i3 = i2 << 3;
        if (aVar.size > i3) {
            h hVar = new h("data bits cannot fit in the QR Code" + aVar.size + " > " + i3);
            AppMethodBeat.o(12320);
            throw hVar;
        }
        for (int i4 = 0; i4 < 4 && aVar.size < i3; i4++) {
            aVar.bH(false);
        }
        int i5 = aVar.size & 7;
        if (i5 > 0) {
            while (i5 < 8) {
                aVar.bH(false);
                i5++;
            }
        }
        int Ii = i2 - aVar.Ii();
        for (int i6 = 0; i6 < Ii; i6++) {
            aVar.bH((i6 & 1) == 0 ? 236 : 17, 8);
        }
        if (aVar.size != i3) {
            h hVar2 = new h("Bits size does not equal capacity");
            AppMethodBeat.o(12320);
            throw hVar2;
        }
        AppMethodBeat.o(12320);
    }

    private static com.google.b.b.a a(com.google.b.b.a aVar, int i2, int i3, int i4) {
        AppMethodBeat.i(12321);
        if (aVar.Ii() != i3) {
            h hVar = new h("Number of bits and data bytes does not match");
            AppMethodBeat.o(12321);
            throw hVar;
        }
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        ArrayList<a> arrayList = new ArrayList(i4);
        for (int i8 = 0; i8 < i4; i8++) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            if (i8 >= i4) {
                h hVar2 = new h("Block ID too large");
                AppMethodBeat.o(12321);
                throw hVar2;
            }
            int i9 = i2 % i4;
            int i10 = i4 - i9;
            int i11 = i2 / i4;
            int i12 = i11 + 1;
            int i13 = i3 / i4;
            int i14 = i13 + 1;
            int i15 = i11 - i13;
            int i16 = i12 - i14;
            if (i15 != i16) {
                h hVar3 = new h("EC bytes mismatch");
                AppMethodBeat.o(12321);
                throw hVar3;
            } else if (i4 != i10 + i9) {
                h hVar4 = new h("RS blocks mismatch");
                AppMethodBeat.o(12321);
                throw hVar4;
            } else {
                if (i2 != (i9 * (i14 + i16)) + ((i13 + i15) * i10)) {
                    h hVar5 = new h("Total bytes mismatch");
                    AppMethodBeat.o(12321);
                    throw hVar5;
                }
                if (i8 < i10) {
                    iArr[0] = i13;
                    iArr2[0] = i15;
                } else {
                    iArr[0] = i14;
                    iArr2[0] = i16;
                }
                int i17 = iArr[0];
                byte[] bArr = new byte[i17];
                aVar.a(i5 << 3, bArr, i17);
                byte[] t = t(bArr, iArr2[0]);
                arrayList.add(new a(bArr, t));
                i6 = Math.max(i6, i17);
                i7 = Math.max(i7, t.length);
                i5 += iArr[0];
            }
        }
        if (i3 != i5) {
            h hVar6 = new h("Data bytes does not match offset");
            AppMethodBeat.o(12321);
            throw hVar6;
        }
        com.google.b.b.a aVar2 = new com.google.b.b.a();
        for (int i18 = 0; i18 < i6; i18++) {
            for (a aVar3 : arrayList) {
                byte[] bArr2 = aVar3.cfB;
                if (i18 < bArr2.length) {
                    aVar2.bH(bArr2[i18], 8);
                }
            }
        }
        for (int i19 = 0; i19 < i7; i19++) {
            for (a aVar4 : arrayList) {
                byte[] bArr3 = aVar4.cfC;
                if (i19 < bArr3.length) {
                    aVar2.bH(bArr3[i19], 8);
                }
            }
        }
        if (i2 != aVar2.Ii()) {
            h hVar7 = new h("Interleaving error: " + i2 + " and " + aVar2.Ii() + " differ.");
            AppMethodBeat.o(12321);
            throw hVar7;
        }
        AppMethodBeat.o(12321);
        return aVar2;
    }

    private static byte[] t(byte[] bArr, int i2) {
        AppMethodBeat.i(12322);
        int length = bArr.length;
        int[] iArr = new int[(length + i2)];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        new com.google.b.b.a.c(com.google.b.b.a.a.cdk).e(iArr, i2);
        byte[] bArr2 = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr2[i4] = (byte) iArr[length + i4];
        }
        AppMethodBeat.o(12322);
        return bArr2;
    }

    private static int a(b bVar, com.google.b.b.a aVar, com.google.b.b.a aVar2, com.google.b.f.a.c cVar) {
        AppMethodBeat.i(12315);
        int a2 = aVar.size + bVar.a(cVar) + aVar2.size;
        AppMethodBeat.o(12315);
        return a2;
    }

    private static boolean a(int i2, com.google.b.f.a.c cVar, a aVar) {
        AppMethodBeat.i(12319);
        if (cVar.cfx - cVar.a(aVar).IB() >= (i2 + 7) / 8) {
            AppMethodBeat.o(12319);
            return true;
        }
        AppMethodBeat.o(12319);
        return false;
    }
}
