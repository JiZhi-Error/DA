package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class d {

    public static final class a {
        public final int[] bhG;
        public final int bmW;
        public final long[] bmX;
        public final int[] bmY;
        public final long[] offsets;

        /* synthetic */ a(long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2, byte b2) {
            this(jArr, iArr, i2, jArr2, iArr2);
        }

        private a(long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2) {
            this.offsets = jArr;
            this.bhG = iArr;
            this.bmW = i2;
            this.bmX = jArr2;
            this.bmY = iArr2;
        }
    }

    public static a a(int i2, long[] jArr, int[] iArr, long j2) {
        AppMethodBeat.i(92074);
        int i3 = 8192 / i2;
        int length = iArr.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            i4++;
            i5 = x.bi(iArr[i4], i3) + i5;
        }
        long[] jArr2 = new long[i5];
        int[] iArr2 = new int[i5];
        int i6 = 0;
        long[] jArr3 = new long[i5];
        int[] iArr3 = new int[i5];
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < iArr.length; i9++) {
            int i10 = iArr[i9];
            long j3 = jArr[i9];
            while (i10 > 0) {
                int min = Math.min(i3, i10);
                jArr2[i8] = j3;
                iArr2[i8] = i2 * min;
                i6 = Math.max(i6, iArr2[i8]);
                jArr3[i8] = ((long) i7) * j2;
                iArr3[i8] = 1;
                j3 += (long) iArr2[i8];
                i7 += min;
                i10 -= min;
                i8++;
            }
        }
        a aVar = new a(jArr2, iArr2, i6, jArr3, iArr3, (byte) 0);
        AppMethodBeat.o(92074);
        return aVar;
    }
}
