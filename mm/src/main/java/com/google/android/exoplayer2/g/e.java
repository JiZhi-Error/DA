package com.google.android.exoplayer2.g;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.g.f;
import com.google.android.exoplayer2.s;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Map;

public abstract class e extends h {
    private final SparseArray<Map<r, b>> bEt = new SparseArray<>();
    private final SparseBooleanArray bEu = new SparseBooleanArray();
    private a bEv;
    private int bdQ = 0;

    public static final class b {
        public final f.a bEB;
        public final int bEC;
        public final int[] bEe;
    }

    /* access modifiers changed from: protected */
    public abstract f[] a(s[] sVarArr, r[] rVarArr, int[][][] iArr);

    public static final class a {
        private final r bEA;
        private final int[] bEw;
        private final r[] bEx;
        private final int[] bEy;
        private final int[][][] bEz;
        public final int length;

        a(int[] iArr, r[] rVarArr, int[] iArr2, int[][][] iArr3, r rVar) {
            AppMethodBeat.i(92948);
            this.bEw = iArr;
            this.bEx = rVarArr;
            this.bEz = iArr3;
            this.bEy = iArr2;
            this.bEA = rVar;
            this.length = rVarArr.length;
            AppMethodBeat.o(92948);
        }
    }

    @Override // com.google.android.exoplayer2.g.h
    public final i a(s[] sVarArr, r rVar) {
        boolean z;
        int i2;
        boolean z2;
        boolean z3;
        f a2;
        int i3;
        f[] fVarArr;
        int[] iArr;
        int[] iArr2 = new int[(sVarArr.length + 1)];
        q[][] qVarArr = new q[(sVarArr.length + 1)][];
        int[][][] iArr3 = new int[(sVarArr.length + 1)][][];
        for (int i4 = 0; i4 < qVarArr.length; i4++) {
            qVarArr[i4] = new q[rVar.length];
            iArr3[i4] = new int[rVar.length][];
        }
        int[] iArr4 = new int[sVarArr.length];
        for (int i5 = 0; i5 < iArr4.length; i5++) {
            iArr4[i5] = sVarArr[i5].td();
        }
        for (int i6 = 0; i6 < rVar.length; i6++) {
            q qVar = rVar.bxi[i6];
            int length = sVarArr.length;
            int i7 = 0;
            int i8 = 0;
            while (true) {
                if (i8 >= sVarArr.length) {
                    i8 = length;
                    break;
                }
                s sVar = sVarArr[i8];
                for (int i9 = 0; i9 < qVar.length; i9++) {
                    int b2 = sVar.b(qVar.bwD[i9]) & 7;
                    if (b2 > i7) {
                        if (b2 == 4) {
                            break;
                        }
                        i7 = b2;
                        length = i8;
                    }
                }
                i8++;
            }
            if (i8 == sVarArr.length) {
                iArr = new int[qVar.length];
            } else {
                s sVar2 = sVarArr[i8];
                int[] iArr5 = new int[qVar.length];
                for (int i10 = 0; i10 < qVar.length; i10++) {
                    iArr5[i10] = sVar2.b(qVar.bwD[i10]);
                }
                iArr = iArr5;
            }
            int i11 = iArr2[i8];
            qVarArr[i8][i11] = qVar;
            iArr3[i8][i11] = iArr;
            iArr2[i8] = iArr2[i8] + 1;
        }
        r[] rVarArr = new r[sVarArr.length];
        int[] iArr6 = new int[sVarArr.length];
        for (int i12 = 0; i12 < sVarArr.length; i12++) {
            int i13 = iArr2[i12];
            rVarArr[i12] = new r((q[]) Arrays.copyOf(qVarArr[i12], i13));
            iArr3[i12] = (int[][]) Arrays.copyOf(iArr3[i12], i13);
            iArr6[i12] = sVarArr[i12].getTrackType();
        }
        r rVar2 = new r((q[]) Arrays.copyOf(qVarArr[sVarArr.length], iArr2[sVarArr.length]));
        f[] a3 = a(sVarArr, rVarArr, iArr3);
        for (int i14 = 0; i14 < sVarArr.length; i14++) {
            if (this.bEu.get(i14)) {
                a2 = null;
                i3 = i14;
                fVarArr = a3;
            } else {
                r rVar3 = rVarArr[i14];
                Map<r, b> map = this.bEt.get(i14);
                if (map == null || !map.containsKey(rVar3)) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (z3) {
                    b bVar = this.bEt.get(i14).get(rVar3);
                    if (bVar == null) {
                        a2 = null;
                        i3 = i14;
                        fVarArr = a3;
                    } else {
                        a2 = bVar.bEB.a(rVar3.bxi[bVar.bEC], bVar.bEe);
                        i3 = i14;
                        fVarArr = a3;
                    }
                }
            }
            fVarArr[i3] = a2;
        }
        a aVar = new a(iArr6, rVarArr, iArr4, iArr3, rVar2);
        t[] tVarArr = new t[sVarArr.length];
        for (int i15 = 0; i15 < sVarArr.length; i15++) {
            tVarArr[i15] = a3[i15] != null ? t.bdP : null;
        }
        int i16 = this.bdQ;
        if (i16 != 0) {
            int i17 = -1;
            int i18 = -1;
            int i19 = 0;
            while (true) {
                if (i19 >= sVarArr.length) {
                    z = true;
                    break;
                }
                int trackType = sVarArr[i19].getTrackType();
                f fVar = a3[i19];
                if ((trackType == 1 || trackType == 2) && fVar != null) {
                    int[][] iArr7 = iArr3[i19];
                    r rVar4 = rVarArr[i19];
                    if (fVar != null) {
                        int a4 = rVar4.a(fVar.wy());
                        int i20 = 0;
                        while (true) {
                            if (i20 >= fVar.length()) {
                                z2 = true;
                                break;
                            } else if ((iArr7[a4][fVar.eV(i20)] & 32) != 32) {
                                z2 = false;
                                break;
                            } else {
                                i20++;
                            }
                        }
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        if (trackType == 1) {
                            if (i17 != -1) {
                                z = false;
                                break;
                            }
                            i2 = i18;
                            i17 = i19;
                            i19++;
                            i18 = i2;
                        } else if (i18 != -1) {
                            z = false;
                            break;
                        } else {
                            i2 = i19;
                            i19++;
                            i18 = i2;
                        }
                    }
                }
                i2 = i18;
                i19++;
                i18 = i2;
            }
            if (((i17 == -1 || i18 == -1) ? false : true) && z) {
                t tVar = new t(i16);
                tVarArr[i17] = tVar;
                tVarArr[i18] = tVar;
            }
        }
        return new i(rVar, new g(a3), aVar, tVarArr);
    }

    @Override // com.google.android.exoplayer2.g.h
    public final void ah(Object obj) {
        this.bEv = (a) obj;
    }
}
