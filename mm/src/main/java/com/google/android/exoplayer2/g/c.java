package com.google.android.exoplayer2.g;

import android.graphics.Point;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.f;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.s;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.source.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class c extends e {
    private static final int[] bEg = new int[0];
    private final f.a bEh;
    private final AtomicReference<b> bEi;

    public static final class b {
        public final String bEj;
        public final String bEk;
        public final int bEl;
        public final int bEm;
        public final int bEn;
        public final boolean bEo;
        public final boolean bEp;
        public final boolean bEq;
        public final boolean bEr;
        public final boolean bEs;
        public final int viewportHeight;
        public final int viewportWidth;

        public b() {
            this((byte) 0);
        }

        private b(byte b2) {
            this.bEj = null;
            this.bEk = null;
            this.bEq = false;
            this.bEr = true;
            this.bEl = Integer.MAX_VALUE;
            this.bEm = Integer.MAX_VALUE;
            this.bEn = Integer.MAX_VALUE;
            this.bEo = true;
            this.bEs = true;
            this.viewportWidth = Integer.MAX_VALUE;
            this.viewportHeight = Integer.MAX_VALUE;
            this.bEp = true;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(92931);
            if (this == obj) {
                AppMethodBeat.o(92931);
                return true;
            } else if (obj == null || getClass() != obj.getClass()) {
                AppMethodBeat.o(92931);
                return false;
            } else {
                b bVar = (b) obj;
                if (this.bEq == bVar.bEq && this.bEr == bVar.bEr && this.bEl == bVar.bEl && this.bEm == bVar.bEm && this.bEo == bVar.bEo && this.bEs == bVar.bEs && this.bEp == bVar.bEp && this.viewportWidth == bVar.viewportWidth && this.viewportHeight == bVar.viewportHeight && this.bEn == bVar.bEn && TextUtils.equals(this.bEj, bVar.bEj) && TextUtils.equals(this.bEk, bVar.bEk)) {
                    AppMethodBeat.o(92931);
                    return true;
                }
                AppMethodBeat.o(92931);
                return false;
            }
        }

        public final int hashCode() {
            int i2;
            int i3;
            int i4;
            int i5 = 1;
            AppMethodBeat.i(92932);
            int hashCode = ((this.bEq ? 1 : 0) + (((this.bEj.hashCode() * 31) + this.bEk.hashCode()) * 31)) * 31;
            if (this.bEr) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            int i6 = (((((((i2 + hashCode) * 31) + this.bEl) * 31) + this.bEm) * 31) + this.bEn) * 31;
            if (this.bEo) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            int i7 = (i3 + i6) * 31;
            if (this.bEs) {
                i4 = 1;
            } else {
                i4 = 0;
            }
            int i8 = (i4 + i7) * 31;
            if (!this.bEp) {
                i5 = 0;
            }
            int i9 = ((((i8 + i5) * 31) + this.viewportWidth) * 31) + this.viewportHeight;
            AppMethodBeat.o(92932);
            return i9;
        }
    }

    public c() {
        this(null);
    }

    public c(f.a aVar) {
        AppMethodBeat.i(92933);
        this.bEh = aVar;
        this.bEi = new AtomicReference<>(new b());
        AppMethodBeat.o(92933);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.g.e
    public final f[] a(s[] sVarArr, r[] rVarArr, int[][][] iArr) {
        boolean z;
        boolean z2;
        String str;
        int[] y;
        int i2;
        AppMethodBeat.i(92934);
        int length = sVarArr.length;
        f[] fVarArr = new f[length];
        b bVar = this.bEi.get();
        boolean z3 = false;
        boolean z4 = false;
        int i3 = 0;
        while (i3 < length) {
            if (2 == sVarArr[i3].getTrackType()) {
                if (!z4) {
                    s sVar = sVarArr[i3];
                    r rVar = rVarArr[i3];
                    int[][] iArr2 = iArr[i3];
                    f.a aVar = this.bEh;
                    f fVar = null;
                    if (aVar != null) {
                        int i4 = bVar.bEr ? 24 : 16;
                        boolean z5 = bVar.bEq && (sVar.td() & i4) != 0;
                        int i5 = 0;
                        while (true) {
                            if (i5 >= rVar.length) {
                                fVar = null;
                                break;
                            }
                            q qVar = rVar.bxi[i5];
                            int[] iArr3 = iArr2[i5];
                            int i6 = bVar.bEl;
                            int i7 = bVar.bEm;
                            int i8 = bVar.bEn;
                            int i9 = bVar.viewportWidth;
                            int i10 = bVar.viewportHeight;
                            boolean z6 = bVar.bEp;
                            if (qVar.length < 2) {
                                y = bEg;
                            } else {
                                List<Integer> a2 = a(qVar, i9, i10, z6);
                                if (a2.size() < 2) {
                                    y = bEg;
                                } else {
                                    String str2 = null;
                                    if (!z5) {
                                        HashSet hashSet = new HashSet();
                                        int i11 = 0;
                                        int i12 = 0;
                                        while (i12 < a2.size()) {
                                            String str3 = qVar.bwD[a2.get(i12).intValue()].bdq;
                                            if (!hashSet.add(str3) || (i2 = a(qVar, iArr3, i4, str3, i6, i7, i8, a2)) <= i11) {
                                                str3 = str2;
                                                i2 = i11;
                                            }
                                            i12++;
                                            str2 = str3;
                                            i11 = i2;
                                        }
                                        str = str2;
                                    } else {
                                        str = null;
                                    }
                                    b(qVar, iArr3, i4, str, i6, i7, i8, a2);
                                    y = a2.size() < 2 ? bEg : x.y(a2);
                                }
                            }
                            if (y.length > 0) {
                                fVar = aVar.a(qVar, y);
                                break;
                            }
                            i5++;
                        }
                    }
                    if (fVar == null) {
                        fVar = a(rVar, iArr2, bVar);
                    }
                    fVarArr[i3] = fVar;
                    z4 = fVarArr[i3] != null;
                }
                if (rVarArr[i3].length > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = z2 | z3;
            } else {
                z = z3;
            }
            i3++;
            z3 = z;
        }
        boolean z7 = false;
        boolean z8 = false;
        for (int i13 = 0; i13 < length; i13++) {
            switch (sVarArr[i13].getTrackType()) {
                case 1:
                    if (!z7) {
                        fVarArr[i13] = a(rVarArr[i13], iArr[i13], bVar, z3 ? null : this.bEh);
                        z7 = fVarArr[i13] != null;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    break;
                case 3:
                    if (!z8) {
                        fVarArr[i13] = b(rVarArr[i13], iArr[i13], bVar);
                        z8 = fVarArr[i13] != null;
                        break;
                    } else {
                        break;
                    }
                default:
                    fVarArr[i13] = c(rVarArr[i13], iArr[i13], bVar);
                    break;
            }
        }
        AppMethodBeat.o(92934);
        return fVarArr;
    }

    private static int a(q qVar, int[] iArr, int i2, String str, int i3, int i4, int i5, List<Integer> list) {
        AppMethodBeat.i(92935);
        int i6 = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            int intValue = list.get(i7).intValue();
            if (a(qVar.bwD[intValue], str, iArr[intValue], i2, i3, i4, i5)) {
                i6++;
            } else {
                i6 = i6;
            }
        }
        AppMethodBeat.o(92935);
        return i6;
    }

    private static void b(q qVar, int[] iArr, int i2, String str, int i3, int i4, int i5, List<Integer> list) {
        AppMethodBeat.i(92936);
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = list.get(size).intValue();
            if (!a(qVar.bwD[intValue], str, iArr[intValue], i2, i3, i4, i5)) {
                list.remove(size);
            }
        }
        AppMethodBeat.o(92936);
    }

    private static boolean a(Format format, String str, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(92937);
        if (!q(i2, false) || (i2 & i3) == 0 || ((str != null && !x.j(format.bdq, str)) || ((format.width != -1 && format.width > i4) || ((format.height != -1 && format.height > i5) || (format.bitrate != -1 && format.bitrate > i6))))) {
            AppMethodBeat.o(92937);
            return false;
        }
        AppMethodBeat.o(92937);
        return true;
    }

    private static f a(r rVar, int[][] iArr, b bVar) {
        int bg;
        AppMethodBeat.i(92938);
        q qVar = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = -1;
        int i5 = -1;
        for (int i6 = 0; i6 < rVar.length; i6++) {
            q qVar2 = rVar.bxi[i6];
            List<Integer> a2 = a(qVar2, bVar.viewportWidth, bVar.viewportHeight, bVar.bEp);
            int[] iArr2 = iArr[i6];
            for (int i7 = 0; i7 < qVar2.length; i7++) {
                if (q(iArr2[i7], bVar.bEs)) {
                    Format format = qVar2.bwD[i7];
                    boolean z = a2.contains(Integer.valueOf(i7)) && (format.width == -1 || format.width <= bVar.bEl) && ((format.height == -1 || format.height <= bVar.bEm) && (format.bitrate == -1 || format.bitrate <= bVar.bEn));
                    if (z || bVar.bEo) {
                        int i8 = z ? 2 : 1;
                        boolean q = q(iArr2[i7], false);
                        if (q) {
                            i8 += 1000;
                        }
                        boolean z2 = i8 > i3;
                        if (i8 == i3) {
                            if (format.tv() != i5) {
                                bg = bg(format.tv(), i5);
                            } else {
                                bg = bg(format.bitrate, i4);
                            }
                            if (!q || !z) {
                                z2 = bg < 0;
                            } else {
                                z2 = bg > 0;
                            }
                        }
                        if (z2) {
                            i4 = format.bitrate;
                            i5 = format.tv();
                            i3 = i8;
                            i2 = i7;
                            qVar = qVar2;
                        }
                    }
                }
            }
        }
        if (qVar == null) {
            AppMethodBeat.o(92938);
            return null;
        }
        d dVar = new d(qVar, i2);
        AppMethodBeat.o(92938);
        return dVar;
    }

    private static int bg(int i2, int i3) {
        if (i2 == -1) {
            return i3 == -1 ? 0 : -1;
        }
        if (i3 == -1) {
            return 1;
        }
        return i2 - i3;
    }

    private static f a(r rVar, int[][] iArr, b bVar, f.a aVar) {
        int[] iArr2;
        int i2;
        int i3;
        AppMethodBeat.i(92939);
        int i4 = -1;
        int i5 = -1;
        int i6 = 0;
        for (int i7 = 0; i7 < rVar.length; i7++) {
            q qVar = rVar.bxi[i7];
            int[] iArr3 = iArr[i7];
            for (int i8 = 0; i8 < qVar.length; i8++) {
                if (q(iArr3[i8], bVar.bEs)) {
                    Format format = qVar.bwD[i8];
                    int i9 = iArr3[i8];
                    String str = bVar.bEj;
                    boolean z = (format.bdD & 1) != 0;
                    if (a(format, str)) {
                        if (z) {
                            i3 = 4;
                        } else {
                            i3 = 3;
                        }
                    } else if (z) {
                        i3 = 2;
                    } else {
                        i3 = 1;
                    }
                    if (q(i9, false)) {
                        i3 += 1000;
                    }
                    if (i3 > i6) {
                        i6 = i3;
                        i5 = i8;
                        i4 = i7;
                    }
                }
            }
        }
        if (i4 == -1) {
            AppMethodBeat.o(92939);
            return null;
        }
        q qVar2 = rVar.bxi[i4];
        if (aVar != null) {
            int[] iArr4 = iArr[i4];
            boolean z2 = bVar.bEq;
            int i10 = 0;
            a aVar2 = null;
            HashSet hashSet = new HashSet();
            int i11 = 0;
            while (i11 < qVar2.length) {
                Format format2 = qVar2.bwD[i11];
                a aVar3 = new a(format2.channelCount, format2.sampleRate, z2 ? null : format2.bdq);
                if (!hashSet.add(aVar3) || (i2 = a(qVar2, iArr4, aVar3)) <= i10) {
                    aVar3 = aVar2;
                    i2 = i10;
                }
                i11++;
                aVar2 = aVar3;
                i10 = i2;
            }
            if (i10 > 1) {
                int[] iArr5 = new int[i10];
                int i12 = 0;
                for (int i13 = 0; i13 < qVar2.length; i13++) {
                    if (a(qVar2.bwD[i13], iArr4[i13], aVar2)) {
                        iArr5[i12] = i13;
                        i12++;
                    }
                }
                iArr2 = iArr5;
            } else {
                iArr2 = bEg;
            }
            if (iArr2.length > 0) {
                f a2 = aVar.a(qVar2, iArr2);
                AppMethodBeat.o(92939);
                return a2;
            }
        }
        d dVar = new d(qVar2, i5);
        AppMethodBeat.o(92939);
        return dVar;
    }

    private static int a(q qVar, int[] iArr, a aVar) {
        int i2 = 0;
        AppMethodBeat.i(92940);
        for (int i3 = 0; i3 < qVar.length; i3++) {
            if (a(qVar.bwD[i3], iArr[i3], aVar)) {
                i2++;
            } else {
                i2 = i2;
            }
        }
        AppMethodBeat.o(92940);
        return i2;
    }

    private static boolean a(Format format, int i2, a aVar) {
        AppMethodBeat.i(92941);
        if (!q(i2, false) || format.channelCount != aVar.channelCount || format.sampleRate != aVar.sampleRate || (aVar.mimeType != null && !TextUtils.equals(aVar.mimeType, format.bdq))) {
            AppMethodBeat.o(92941);
            return false;
        }
        AppMethodBeat.o(92941);
        return true;
    }

    private static f b(r rVar, int[][] iArr, b bVar) {
        int i2;
        AppMethodBeat.i(92942);
        q qVar = null;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < rVar.length; i5++) {
            q qVar2 = rVar.bxi[i5];
            int[] iArr2 = iArr[i5];
            for (int i6 = 0; i6 < qVar2.length; i6++) {
                if (q(iArr2[i6], bVar.bEs)) {
                    Format format = qVar2.bwD[i6];
                    boolean z = (format.bdD & 1) != 0;
                    boolean z2 = (format.bdD & 2) != 0;
                    if (a(format, bVar.bEk)) {
                        if (z) {
                            i2 = 6;
                        } else if (!z2) {
                            i2 = 5;
                        } else {
                            i2 = 4;
                        }
                    } else if (z) {
                        i2 = 3;
                    } else if (z2) {
                        if (a(format, bVar.bEj)) {
                            i2 = 2;
                        } else {
                            i2 = 1;
                        }
                    }
                    if (q(iArr2[i6], false)) {
                        i2 += 1000;
                    }
                    if (i2 > i4) {
                        i4 = i2;
                        i3 = i6;
                        qVar = qVar2;
                    }
                }
            }
        }
        if (qVar == null) {
            AppMethodBeat.o(92942);
            return null;
        }
        d dVar = new d(qVar, i3);
        AppMethodBeat.o(92942);
        return dVar;
    }

    private static f c(r rVar, int[][] iArr, b bVar) {
        int i2;
        AppMethodBeat.i(92943);
        int i3 = 0;
        int i4 = 0;
        q qVar = null;
        for (int i5 = 0; i5 < rVar.length; i5++) {
            q qVar2 = rVar.bxi[i5];
            int[] iArr2 = iArr[i5];
            int i6 = 0;
            while (i6 < qVar2.length) {
                if (q(iArr2[i6], bVar.bEs)) {
                    i2 = (qVar2.bwD[i6].bdD & 1) != 0 ? 2 : 1;
                    if (q(iArr2[i6], false)) {
                        i2 += 1000;
                    }
                    if (i2 > i3) {
                        i4 = i6;
                        qVar = qVar2;
                        i6++;
                        i3 = i2;
                    }
                }
                i2 = i3;
                i6++;
                i3 = i2;
            }
        }
        if (qVar == null) {
            AppMethodBeat.o(92943);
            return null;
        }
        d dVar = new d(qVar, i4);
        AppMethodBeat.o(92943);
        return dVar;
    }

    private static boolean q(int i2, boolean z) {
        int i3 = i2 & 7;
        return i3 == 4 || (z && i3 == 3);
    }

    private static boolean a(Format format, String str) {
        AppMethodBeat.i(92944);
        if (str == null || !TextUtils.equals(str, x.bF(format.language))) {
            AppMethodBeat.o(92944);
            return false;
        }
        AppMethodBeat.o(92944);
        return true;
    }

    private static List<Integer> a(q qVar, int i2, int i3, boolean z) {
        int i4;
        int i5 = 0;
        AppMethodBeat.i(92945);
        ArrayList arrayList = new ArrayList(qVar.length);
        for (int i6 = 0; i6 < qVar.length; i6++) {
            arrayList.add(Integer.valueOf(i6));
        }
        if (i2 == Integer.MAX_VALUE || i3 == Integer.MAX_VALUE) {
            AppMethodBeat.o(92945);
            return arrayList;
        }
        int i7 = Integer.MAX_VALUE;
        while (i5 < qVar.length) {
            Format format = qVar.bwD[i5];
            if (format.width > 0 && format.height > 0) {
                Point a2 = a(z, i2, i3, format.width, format.height);
                i4 = format.width * format.height;
                if (format.width >= ((int) (((float) a2.x) * 0.98f)) && format.height >= ((int) (((float) a2.y) * 0.98f)) && i4 < i7) {
                    i5++;
                    i7 = i4;
                }
            }
            i4 = i7;
            i5++;
            i7 = i4;
        }
        if (i7 != Integer.MAX_VALUE) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                int tv = qVar.bwD[((Integer) arrayList.get(size)).intValue()].tv();
                if (tv == -1 || tv > i7) {
                    arrayList.remove(size);
                }
            }
        }
        AppMethodBeat.o(92945);
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Point a(boolean r5, int r6, int r7, int r8, int r9) {
        /*
            r0 = 1
            r1 = 0
            r4 = 92946(0x16b12, float:1.30245E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            if (r5 == 0) goto L_0x003b
            if (r8 <= r9) goto L_0x0028
            r2 = r0
        L_0x000d:
            if (r6 <= r7) goto L_0x002a
        L_0x000f:
            if (r2 == r0) goto L_0x003b
            r1 = r6
            r2 = r7
        L_0x0013:
            int r0 = r8 * r1
            int r3 = r9 * r2
            if (r0 < r3) goto L_0x002c
            android.graphics.Point r0 = new android.graphics.Point
            int r1 = r2 * r9
            int r1 = com.google.android.exoplayer2.i.x.bi(r1, r8)
            r0.<init>(r2, r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x0027:
            return r0
        L_0x0028:
            r2 = r1
            goto L_0x000d
        L_0x002a:
            r0 = r1
            goto L_0x000f
        L_0x002c:
            android.graphics.Point r0 = new android.graphics.Point
            int r2 = r1 * r8
            int r2 = com.google.android.exoplayer2.i.x.bi(r2, r9)
            r0.<init>(r2, r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0027
        L_0x003b:
            r1 = r7
            r2 = r6
            goto L_0x0013
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.g.c.a(boolean, int, int, int, int):android.graphics.Point");
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        public final int channelCount;
        public final String mimeType;
        public final int sampleRate;

        public a(int i2, int i3, String str) {
            this.channelCount = i2;
            this.sampleRate = i3;
            this.mimeType = str;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(92929);
            if (this == obj) {
                AppMethodBeat.o(92929);
                return true;
            } else if (obj == null || getClass() != obj.getClass()) {
                AppMethodBeat.o(92929);
                return false;
            } else {
                a aVar = (a) obj;
                if (this.channelCount == aVar.channelCount && this.sampleRate == aVar.sampleRate && TextUtils.equals(this.mimeType, aVar.mimeType)) {
                    AppMethodBeat.o(92929);
                    return true;
                }
                AppMethodBeat.o(92929);
                return false;
            }
        }

        public final int hashCode() {
            AppMethodBeat.i(92930);
            int hashCode = (this.mimeType != null ? this.mimeType.hashCode() : 0) + (((this.channelCount * 31) + this.sampleRate) * 31);
            AppMethodBeat.o(92930);
            return hashCode;
        }
    }
}
