package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class m {
    public final int[] bhG;
    public final int bmW;
    public final int[] bmY;
    public final long[] boQ;
    public final long[] offsets;
    public final int sampleCount;

    public m(long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(92132);
        a.checkArgument(iArr.length == jArr2.length);
        if (jArr.length == jArr2.length) {
            z = true;
        } else {
            z = false;
        }
        a.checkArgument(z);
        a.checkArgument(iArr2.length != jArr2.length ? false : z2);
        this.offsets = jArr;
        this.bhG = iArr;
        this.bmW = i2;
        this.boQ = jArr2;
        this.bmY = iArr2;
        this.sampleCount = jArr.length;
        AppMethodBeat.o(92132);
    }

    public final int P(long j2) {
        AppMethodBeat.i(92133);
        for (int a2 = x.a(this.boQ, j2, false); a2 >= 0; a2--) {
            if ((this.bmY[a2] & 1) != 0) {
                AppMethodBeat.o(92133);
                return a2;
            }
        }
        AppMethodBeat.o(92133);
        return -1;
    }

    public final int Q(long j2) {
        AppMethodBeat.i(92134);
        for (int a2 = x.a(this.boQ, j2, true, false); a2 < this.boQ.length; a2++) {
            if ((this.bmY[a2] & 1) != 0) {
                AppMethodBeat.o(92134);
                return a2;
            }
        }
        AppMethodBeat.o(92134);
        return -1;
    }
}
