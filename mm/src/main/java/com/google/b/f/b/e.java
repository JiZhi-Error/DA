package com.google.b.f.b;

import com.google.b.b.a;
import com.google.b.f.a.c;
import com.google.b.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k.g;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.smtt.sdk.TbsListener;

/* access modifiers changed from: package-private */
public final class e {
    private static final int[][] cfG = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    private static final int[][] cfH = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    private static final int[][] cfI = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, g.CTRL_INDEX, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, TbsListener.ErrorCode.NEEDDOWNLOAD_3, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, r.CTRL_INDEX, TbsListener.ErrorCode.STARTDOWNLOAD_3}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, TbsListener.ErrorCode.NEEDDOWNLOAD_3, TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE}};
    private static final int[][] cfJ = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    private static int bP(int i2, int i3) {
        AppMethodBeat.i(12250);
        if (i3 == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("0 polynomial");
            AppMethodBeat.o(12250);
            throw illegalArgumentException;
        }
        int numberOfLeadingZeros = 32 - Integer.numberOfLeadingZeros(i3);
        int i4 = i2 << (numberOfLeadingZeros - 1);
        while (32 - Integer.numberOfLeadingZeros(i4) >= numberOfLeadingZeros) {
            i4 ^= i3 << ((32 - Integer.numberOfLeadingZeros(i4)) - numberOfLeadingZeros);
        }
        AppMethodBeat.o(12250);
        return i4;
    }

    private static boolean hm(int i2) {
        return i2 == -1;
    }

    private static void a(int i2, int i3, b bVar) {
        AppMethodBeat.i(12251);
        for (int i4 = 0; i4 < 8; i4++) {
            if (!hm(bVar.bO(i2 + i4, i3))) {
                h hVar = new h();
                AppMethodBeat.o(12251);
                throw hVar;
            }
            bVar.set(i2 + i4, i3, 0);
        }
        AppMethodBeat.o(12251);
    }

    private static void b(int i2, int i3, b bVar) {
        AppMethodBeat.i(12252);
        for (int i4 = 0; i4 < 7; i4++) {
            if (!hm(bVar.bO(i2, i3 + i4))) {
                h hVar = new h();
                AppMethodBeat.o(12252);
                throw hVar;
            }
            bVar.set(i2, i3 + i4, 0);
        }
        AppMethodBeat.o(12252);
    }

    private static void c(int i2, int i3, b bVar) {
        AppMethodBeat.i(12253);
        for (int i4 = 0; i4 < 7; i4++) {
            for (int i5 = 0; i5 < 7; i5++) {
                bVar.set(i2 + i5, i3 + i4, cfG[i4][i5]);
            }
        }
        AppMethodBeat.o(12253);
    }

    static void a(a aVar, com.google.b.f.a.a aVar2, c cVar, int i2, b bVar) {
        boolean z;
        AppMethodBeat.i(12247);
        for (int i3 = 0; i3 < bVar.height; i3++) {
            for (int i4 = 0; i4 < bVar.width; i4++) {
                bVar.cfD[i3][i4] = -1;
            }
        }
        int length = cfG[0].length;
        c(0, 0, bVar);
        c(bVar.width - length, 0, bVar);
        c(0, bVar.width - length, bVar);
        a(0, 7, bVar);
        a(bVar.width - 8, 7, bVar);
        a(0, bVar.width - 8, bVar);
        b(7, 0, bVar);
        b((bVar.height - 7) - 1, 0, bVar);
        b(7, bVar.height - 7, bVar);
        if (bVar.bO(8, bVar.height - 8) == 0) {
            h hVar = new h();
            AppMethodBeat.o(12247);
            throw hVar;
        }
        bVar.set(8, bVar.height - 8, 1);
        if (cVar.cfu >= 2) {
            int i5 = cVar.cfu - 1;
            int[] iArr = cfI[i5];
            int length2 = cfI[i5].length;
            for (int i6 = 0; i6 < length2; i6++) {
                for (int i7 = 0; i7 < length2; i7++) {
                    int i8 = iArr[i6];
                    int i9 = iArr[i7];
                    if (!(i9 == -1 || i8 == -1 || !hm(bVar.bO(i9, i8)))) {
                        int i10 = i9 - 2;
                        int i11 = i8 - 2;
                        for (int i12 = 0; i12 < 5; i12++) {
                            for (int i13 = 0; i13 < 5; i13++) {
                                bVar.set(i10 + i13, i11 + i12, cfH[i12][i13]);
                            }
                        }
                    }
                }
            }
        }
        for (int i14 = 8; i14 < bVar.width - 8; i14++) {
            int i15 = (i14 + 1) % 2;
            if (hm(bVar.bO(i14, 6))) {
                bVar.set(i14, 6, i15);
            }
            if (hm(bVar.bO(6, i14))) {
                bVar.set(6, i14, i15);
            }
        }
        a aVar3 = new a();
        if (i2 < 0 || i2 >= 8) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            h hVar2 = new h("Invalid mask pattern");
            AppMethodBeat.o(12247);
            throw hVar2;
        }
        int i16 = (aVar2.cfd << 3) | i2;
        aVar3.bH(i16, 5);
        aVar3.bH(bP(i16, 1335), 10);
        a aVar4 = new a();
        aVar4.bH(21522, 15);
        if (aVar3.size != aVar4.size) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Sizes don't match");
            AppMethodBeat.o(12247);
            throw illegalArgumentException;
        }
        for (int i17 = 0; i17 < aVar3.ccy.length; i17++) {
            int[] iArr2 = aVar3.ccy;
            iArr2[i17] = iArr2[i17] ^ aVar4.ccy[i17];
        }
        if (aVar3.size != 15) {
            h hVar3 = new h("should not happen but we got: " + aVar3.size);
            AppMethodBeat.o(12247);
            throw hVar3;
        }
        for (int i18 = 0; i18 < aVar3.size; i18++) {
            boolean z2 = aVar3.get((aVar3.size - 1) - i18);
            bVar.set(cfJ[i18][0], cfJ[i18][1], z2);
            if (i18 < 8) {
                bVar.set((bVar.width - i18) - 1, 8, z2);
            } else {
                bVar.set(8, (bVar.height - 7) + (i18 - 8), z2);
            }
        }
        a(cVar, bVar);
        a(aVar, i2, bVar);
        AppMethodBeat.o(12247);
    }

    private static void a(c cVar, b bVar) {
        AppMethodBeat.i(12248);
        if (cVar.cfu < 7) {
            AppMethodBeat.o(12248);
            return;
        }
        a aVar = new a();
        aVar.bH(cVar.cfu, 6);
        aVar.bH(bP(cVar.cfu, 7973), 12);
        if (aVar.size != 18) {
            h hVar = new h("should not happen but we got: " + aVar.size);
            AppMethodBeat.o(12248);
            throw hVar;
        }
        int i2 = 17;
        for (int i3 = 0; i3 < 6; i3++) {
            for (int i4 = 0; i4 < 3; i4++) {
                boolean z = aVar.get(i2);
                i2--;
                bVar.set(i3, (bVar.height - 11) + i4, z);
                bVar.set((bVar.height - 11) + i4, i3, z);
            }
        }
        AppMethodBeat.o(12248);
    }

    private static void a(a aVar, int i2, b bVar) {
        int i3;
        int i4;
        boolean z;
        int i5;
        boolean z2;
        AppMethodBeat.i(12249);
        int i6 = bVar.width - 1;
        int i7 = bVar.height - 1;
        int i8 = -1;
        int i9 = 0;
        while (i6 > 0) {
            if (i6 == 6) {
                i4 = i7;
                i3 = i6 - 1;
            } else {
                i4 = i7;
                i3 = i6;
            }
            while (i4 >= 0 && i4 < bVar.height) {
                int i10 = 0;
                while (i10 < 2) {
                    int i11 = i3 - i10;
                    if (hm(bVar.bO(i11, i4))) {
                        if (i9 < aVar.size) {
                            z = aVar.get(i9);
                            i9++;
                        } else {
                            z = false;
                        }
                        if (i2 != -1) {
                            switch (i2) {
                                case 0:
                                    i5 = (i4 + i11) & 1;
                                    break;
                                case 1:
                                    i5 = i4 & 1;
                                    break;
                                case 2:
                                    i5 = i11 % 3;
                                    break;
                                case 3:
                                    i5 = (i4 + i11) % 3;
                                    break;
                                case 4:
                                    i5 = ((i4 / 2) + (i11 / 3)) & 1;
                                    break;
                                case 5:
                                    int i12 = i4 * i11;
                                    i5 = (i12 % 3) + (i12 & 1);
                                    break;
                                case 6:
                                    int i13 = i4 * i11;
                                    i5 = ((i13 % 3) + (i13 & 1)) & 1;
                                    break;
                                case 7:
                                    i5 = (((i4 * i11) % 3) + ((i4 + i11) & 1)) & 1;
                                    break;
                                default:
                                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid mask pattern: ".concat(String.valueOf(i2)));
                                    AppMethodBeat.o(12249);
                                    throw illegalArgumentException;
                            }
                            if (i5 == 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                z = !z;
                            }
                        }
                        bVar.set(i11, i4, z);
                    }
                    i10++;
                    i9 = i9;
                }
                i4 += i8;
            }
            int i14 = -i8;
            i7 = i4 + i14;
            i6 = i3 - 2;
            i8 = i14;
        }
        if (i9 != aVar.size) {
            h hVar = new h("Not all bits consumed: " + i9 + '/' + aVar.size);
            AppMethodBeat.o(12249);
            throw hVar;
        }
        AppMethodBeat.o(12249);
    }
}
