package com.google.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.TPOptionalID;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public final class d {
    static final String[] ccl = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};
    static final int[][] ccm = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};
    private static final int[][] ccn;
    static final int[][] cco;
    final byte[] ccp;

    static {
        AppMethodBeat.i(12328);
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, 5, 256);
        ccn = iArr;
        iArr[0][32] = 1;
        for (int i2 = 65; i2 <= 90; i2++) {
            ccn[0][i2] = (i2 - 65) + 2;
        }
        ccn[1][32] = 1;
        for (int i3 = 97; i3 <= 122; i3++) {
            ccn[1][i3] = (i3 - 97) + 2;
        }
        ccn[2][32] = 1;
        for (int i4 = 48; i4 <= 57; i4++) {
            ccn[2][i4] = (i4 - 48) + 2;
        }
        ccn[2][44] = 12;
        ccn[2][46] = 13;
        int[] iArr2 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH};
        for (int i5 = 0; i5 < 28; i5++) {
            ccn[3][iArr2[i5]] = i5;
        }
        int[] iArr3 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i6 = 0; i6 < 31; i6++) {
            if (iArr3[i6] > 0) {
                ccn[4][iArr3[i6]] = i6;
            }
        }
        int[][] iArr4 = (int[][]) Array.newInstance(Integer.TYPE, 6, 6);
        cco = iArr4;
        for (int[] iArr5 : iArr4) {
            Arrays.fill(iArr5, -1);
        }
        cco[0][4] = 0;
        cco[1][4] = 0;
        cco[1][0] = 28;
        cco[3][4] = 0;
        cco[2][4] = 0;
        cco[2][0] = 15;
        AppMethodBeat.o(12328);
    }

    public d(byte[] bArr) {
        this.ccp = bArr;
    }

    /* access modifiers changed from: package-private */
    public final void a(f fVar, int i2, Collection<f> collection) {
        boolean z;
        f fVar2;
        AppMethodBeat.i(12325);
        char c2 = (char) (this.ccp[i2] & 255);
        if (ccn[fVar.mode][c2] > 0) {
            z = true;
        } else {
            z = false;
        }
        f fVar3 = null;
        int i3 = 0;
        while (i3 <= 4) {
            int i4 = ccn[i3][c2];
            if (i4 > 0) {
                if (fVar3 == null) {
                    fVar2 = fVar.he(i2);
                } else {
                    fVar2 = fVar3;
                }
                if (!z || i3 == fVar.mode || i3 == 2) {
                    collection.add(fVar2.bD(i3, i4));
                }
                if (!z && cco[fVar.mode][i3] >= 0) {
                    collection.add(fVar2.bE(i3, i4));
                }
            } else {
                fVar2 = fVar3;
            }
            i3++;
            fVar3 = fVar2;
        }
        if (fVar.ccu > 0 || ccn[fVar.mode][c2] == 0) {
            collection.add(fVar.hd(i2));
        }
        AppMethodBeat.o(12325);
    }

    static Collection<f> a(Iterable<f> iterable, int i2, int i3) {
        AppMethodBeat.i(12326);
        LinkedList linkedList = new LinkedList();
        for (f fVar : iterable) {
            f he = fVar.he(i2);
            linkedList.add(he.bD(4, i3));
            if (fVar.mode != 4) {
                linkedList.add(he.bE(4, i3));
            }
            if (i3 == 3 || i3 == 4) {
                linkedList.add(he.bD(2, 16 - i3).bD(2, 1));
            }
            if (fVar.ccu > 0) {
                linkedList.add(fVar.hd(i2).hd(i2 + 1));
            }
        }
        Collection<f> b2 = b(linkedList);
        AppMethodBeat.o(12326);
        return b2;
    }

    static Collection<f> b(Iterable<f> iterable) {
        boolean z;
        AppMethodBeat.i(12327);
        LinkedList linkedList = new LinkedList();
        for (f fVar : iterable) {
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                f fVar2 = (f) it.next();
                if (fVar2.a(fVar)) {
                    z = false;
                    break;
                } else if (fVar.a(fVar2)) {
                    it.remove();
                }
            }
            if (z) {
                linkedList.add(fVar);
            }
        }
        AppMethodBeat.o(12327);
        return linkedList;
    }
}
