package com.google.b.a.a;

import com.google.b.b.a;
import com.google.b.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public final class c {
    private static final int[] cck = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    public static a w(byte[] bArr, int i2, int i3) {
        boolean z;
        int i4;
        int t;
        a aVar;
        int i5;
        a a2;
        int i6;
        int i7;
        int i8;
        AppMethodBeat.i(12260);
        d dVar = new d(bArr);
        Collection<f> singletonList = Collections.singletonList(f.ccs);
        int i9 = 0;
        while (i9 < dVar.ccp.length) {
            byte b2 = i9 + 1 < dVar.ccp.length ? dVar.ccp[i9 + 1] : 0;
            switch (dVar.ccp[i9]) {
                case 13:
                    if (b2 == 10) {
                        i7 = 2;
                        break;
                    } else {
                        i7 = 0;
                        break;
                    }
                case 44:
                    if (b2 == 32) {
                        i7 = 4;
                        break;
                    } else {
                        i7 = 0;
                        break;
                    }
                case 46:
                    if (b2 == 32) {
                        i7 = 3;
                        break;
                    } else {
                        i7 = 0;
                        break;
                    }
                case 58:
                    if (b2 == 32) {
                        i7 = 5;
                        break;
                    } else {
                        i7 = 0;
                        break;
                    }
                default:
                    i7 = 0;
                    break;
            }
            if (i7 > 0) {
                singletonList = d.a(singletonList, i9, i7);
                i8 = i9 + 1;
            } else {
                LinkedList linkedList = new LinkedList();
                for (f fVar : singletonList) {
                    dVar.a(fVar, i9, linkedList);
                }
                singletonList = d.b(linkedList);
                i8 = i9;
            }
            i9 = i8 + 1;
        }
        a J = ((f) Collections.min(singletonList, new Comparator<f>() {
            /* class com.google.b.a.a.d.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(f fVar, f fVar2) {
                return fVar.ccv - fVar2.ccv;
            }
        })).J(dVar.ccp);
        int i10 = ((J.size * i2) / 100) + 11;
        int i11 = J.size + i10;
        if (i3 != 0) {
            boolean z2 = i3 < 0;
            i4 = Math.abs(i3);
            if (i4 > (z2 ? 4 : 32)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i3)));
                AppMethodBeat.o(12260);
                throw illegalArgumentException;
            }
            t = t(i4, z2);
            i5 = cck[i4];
            int i12 = t - (t % i5);
            a a3 = a(J, i5);
            if (a3.size + i10 > i12) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Data to large for user specified layer");
                AppMethodBeat.o(12260);
                throw illegalArgumentException2;
            } else if (!z2 || a3.size <= (i5 << 6)) {
                aVar = a3;
                z = z2;
            } else {
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Data to large for user specified layer");
                AppMethodBeat.o(12260);
                throw illegalArgumentException3;
            }
        } else {
            int i13 = 0;
            a aVar2 = null;
            int i14 = 0;
            while (i14 <= 32) {
                z = i14 <= 3;
                if (z) {
                    i4 = i14 + 1;
                } else {
                    i4 = i14;
                }
                t = t(i4, z);
                if (i11 <= t) {
                    if (i13 != cck[i4]) {
                        i13 = cck[i4];
                        aVar2 = a(J, i13);
                    }
                    int i15 = t - (t % i13);
                    if ((!z || aVar2.size <= (i13 << 6)) && aVar2.size + i10 <= i15) {
                        aVar = aVar2;
                        i5 = i13;
                    }
                }
                i14++;
            }
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("Data too large for an Aztec code");
            AppMethodBeat.o(12260);
            throw illegalArgumentException4;
        }
        a a4 = a(aVar, t, i5);
        int i16 = aVar.size / i5;
        a aVar3 = new a();
        if (z) {
            aVar3.bH(i4 - 1, 2);
            aVar3.bH(i16 - 1, 6);
            a2 = a(aVar3, 28, 4);
        } else {
            aVar3.bH(i4 - 1, 5);
            aVar3.bH(i16 - 1, 11);
            a2 = a(aVar3, 40, 4);
        }
        int i17 = (i4 << 2) + (z ? 11 : 14);
        int[] iArr = new int[i17];
        if (z) {
            for (int i18 = 0; i18 < iArr.length; i18++) {
                iArr[i18] = i18;
            }
            i6 = i17;
        } else {
            i6 = i17 + 1 + ((((i17 / 2) - 1) / 15) * 2);
            int i19 = i17 / 2;
            int i20 = i6 / 2;
            for (int i21 = 0; i21 < i19; i21++) {
                int i22 = (i21 / 15) + i21;
                iArr[(i19 - i21) - 1] = (i20 - i22) - 1;
                iArr[i19 + i21] = i22 + i20 + 1;
            }
        }
        b bVar = new b(i6);
        int i23 = 0;
        int i24 = 0;
        while (i23 < i4) {
            int i25 = ((i4 - i23) << 2) + (z ? 9 : 12);
            for (int i26 = 0; i26 < i25; i26++) {
                int i27 = i26 << 1;
                for (int i28 = 0; i28 < 2; i28++) {
                    if (a4.get(i24 + i27 + i28)) {
                        bVar.set(iArr[(i23 << 1) + i28], iArr[(i23 << 1) + i26]);
                    }
                    if (a4.get((i25 << 1) + i24 + i27 + i28)) {
                        bVar.set(iArr[(i23 << 1) + i26], iArr[((i17 - 1) - (i23 << 1)) - i28]);
                    }
                    if (a4.get((i25 << 2) + i24 + i27 + i28)) {
                        bVar.set(iArr[((i17 - 1) - (i23 << 1)) - i28], iArr[((i17 - 1) - (i23 << 1)) - i26]);
                    }
                    if (a4.get((i25 * 6) + i24 + i27 + i28)) {
                        bVar.set(iArr[((i17 - 1) - (i23 << 1)) - i26], iArr[(i23 << 1) + i28]);
                    }
                }
            }
            i23++;
            i24 += i25 << 3;
        }
        a(bVar, z, i6, a2);
        if (z) {
            a(bVar, i6 / 2, 5);
        } else {
            a(bVar, i6 / 2, 7);
            int i29 = 0;
            int i30 = 0;
            while (i29 < (i17 / 2) - 1) {
                for (int i31 = (i6 / 2) & 1; i31 < i6; i31 += 2) {
                    bVar.set((i6 / 2) - i30, i31);
                    bVar.set((i6 / 2) + i30, i31);
                    bVar.set(i31, (i6 / 2) - i30);
                    bVar.set(i31, (i6 / 2) + i30);
                }
                i29 += 15;
                i30 += 16;
            }
        }
        a aVar4 = new a();
        aVar4.cce = z;
        aVar4.size = i6;
        aVar4.ccf = i4;
        aVar4.ccg = i16;
        aVar4.cch = bVar;
        AppMethodBeat.o(12260);
        return aVar4;
    }

    private static void a(b bVar, int i2, int i3) {
        AppMethodBeat.i(12261);
        for (int i4 = 0; i4 < i3; i4 += 2) {
            for (int i5 = i2 - i4; i5 <= i2 + i4; i5++) {
                bVar.set(i5, i2 - i4);
                bVar.set(i5, i2 + i4);
                bVar.set(i2 - i4, i5);
                bVar.set(i2 + i4, i5);
            }
        }
        bVar.set(i2 - i3, i2 - i3);
        bVar.set((i2 - i3) + 1, i2 - i3);
        bVar.set(i2 - i3, (i2 - i3) + 1);
        bVar.set(i2 + i3, i2 - i3);
        bVar.set(i2 + i3, (i2 - i3) + 1);
        bVar.set(i2 + i3, (i2 + i3) - 1);
        AppMethodBeat.o(12261);
    }

    private static void a(b bVar, boolean z, int i2, a aVar) {
        int i3 = 0;
        AppMethodBeat.i(12262);
        int i4 = i2 / 2;
        if (z) {
            while (i3 < 7) {
                int i5 = (i4 - 3) + i3;
                if (aVar.get(i3)) {
                    bVar.set(i5, i4 - 5);
                }
                if (aVar.get(i3 + 7)) {
                    bVar.set(i4 + 5, i5);
                }
                if (aVar.get(20 - i3)) {
                    bVar.set(i5, i4 + 5);
                }
                if (aVar.get(27 - i3)) {
                    bVar.set(i4 - 5, i5);
                }
                i3++;
            }
            AppMethodBeat.o(12262);
            return;
        }
        while (i3 < 10) {
            int i6 = (i4 - 5) + i3 + (i3 / 5);
            if (aVar.get(i3)) {
                bVar.set(i6, i4 - 7);
            }
            if (aVar.get(i3 + 10)) {
                bVar.set(i4 + 7, i6);
            }
            if (aVar.get(29 - i3)) {
                bVar.set(i6, i4 + 7);
            }
            if (aVar.get(39 - i3)) {
                bVar.set(i4 - 7, i6);
            }
            i3++;
        }
        AppMethodBeat.o(12262);
    }

    private static int[] b(a aVar, int i2, int i3) {
        AppMethodBeat.i(12264);
        int[] iArr = new int[i3];
        int i4 = aVar.size / i2;
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = 0;
            for (int i7 = 0; i7 < i2; i7++) {
                i6 |= aVar.get((i5 * i2) + i7) ? 1 << ((i2 - i7) - 1) : 0;
            }
            iArr[i5] = i6;
        }
        AppMethodBeat.o(12264);
        return iArr;
    }

    private static a a(a aVar, int i2) {
        int i3;
        AppMethodBeat.i(12265);
        a aVar2 = new a();
        int i4 = aVar.size;
        int i5 = (1 << i2) - 2;
        int i6 = 0;
        while (i6 < i4) {
            int i7 = 0;
            for (int i8 = 0; i8 < i2; i8++) {
                if (i6 + i8 >= i4 || aVar.get(i6 + i8)) {
                    i7 |= 1 << ((i2 - 1) - i8);
                }
            }
            if ((i7 & i5) == i5) {
                aVar2.bH(i7 & i5, i2);
                i3 = i6 - 1;
            } else if ((i7 & i5) == 0) {
                aVar2.bH(i7 | 1, i2);
                i3 = i6 - 1;
            } else {
                aVar2.bH(i7, i2);
                i3 = i6;
            }
            i6 = i3 + i2;
        }
        AppMethodBeat.o(12265);
        return aVar2;
    }

    private static int t(int i2, boolean z) {
        return ((z ? 88 : 112) + (i2 << 4)) * i2;
    }

    private static a a(a aVar, int i2, int i3) {
        com.google.b.b.a.a aVar2;
        AppMethodBeat.i(12263);
        int i4 = aVar.size / i3;
        switch (i3) {
            case 4:
                aVar2 = com.google.b.b.a.a.cdj;
                break;
            case 5:
            case 7:
            case 9:
            case 11:
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(i3)));
                AppMethodBeat.o(12263);
                throw illegalArgumentException;
            case 6:
                aVar2 = com.google.b.b.a.a.cdi;
                break;
            case 8:
                aVar2 = com.google.b.b.a.a.cdm;
                break;
            case 10:
                aVar2 = com.google.b.b.a.a.cdh;
                break;
            case 12:
                aVar2 = com.google.b.b.a.a.cdg;
                break;
        }
        com.google.b.b.a.c cVar = new com.google.b.b.a.c(aVar2);
        int i5 = i2 / i3;
        int[] b2 = b(aVar, i3, i5);
        cVar.e(b2, i5 - i4);
        a aVar3 = new a();
        aVar3.bH(0, i2 % i3);
        for (int i6 : b2) {
            aVar3.bH(i6, i3);
        }
        AppMethodBeat.o(12263);
        return aVar3;
    }
}
