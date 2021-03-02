package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.c.c.b;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d implements b.a {
    private final long bdJ;
    private final long bkF;
    private final long[] bkG;
    private final long bkH;
    private final int bkI;
    private final long firstFramePosition;

    d(long j2, long j3, long j4) {
        this(j2, j3, j4, null, 0, 0);
    }

    d(long j2, long j3, long j4, long[] jArr, long j5, int i2) {
        this.firstFramePosition = j2;
        this.bdJ = j3;
        this.bkF = j4;
        this.bkG = jArr;
        this.bkH = j5;
        this.bkI = i2;
    }

    @Override // com.google.android.exoplayer2.c.l
    public final boolean uu() {
        return this.bkG != null;
    }

    @Override // com.google.android.exoplayer2.c.l
    public final long L(long j2) {
        float f2 = 256.0f;
        float f3 = 0.0f;
        AppMethodBeat.i(92048);
        if (!uu()) {
            long j3 = this.firstFramePosition;
            AppMethodBeat.o(92048);
            return j3;
        }
        float f4 = (((float) j2) * 100.0f) / ((float) this.bdJ);
        if (f4 <= 0.0f) {
            f2 = 0.0f;
        } else if (f4 < 100.0f) {
            int i2 = (int) f4;
            if (i2 != 0) {
                f3 = (float) this.bkG[i2 - 1];
            }
            if (i2 < 99) {
                f2 = (float) this.bkG[i2];
            }
            f2 = ((f2 - f3) * (f4 - ((float) i2))) + f3;
        }
        long min = Math.min(this.firstFramePosition + Math.round(((double) f2) * 0.00390625d * ((double) this.bkH)), this.bkF != -1 ? this.bkF - 1 : ((this.firstFramePosition - ((long) this.bkI)) + this.bkH) - 1);
        AppMethodBeat.o(92048);
        return min;
    }

    @Override // com.google.android.exoplayer2.c.c.b.a
    public final long N(long j2) {
        AppMethodBeat.i(92049);
        if (!uu() || j2 < this.firstFramePosition) {
            AppMethodBeat.o(92049);
            return 0;
        }
        double d2 = (256.0d * ((double) (j2 - this.firstFramePosition))) / ((double) this.bkH);
        int a2 = x.a(this.bkG, (long) d2, false) + 1;
        long eb = eb(a2);
        long j3 = a2 == 0 ? 0 : this.bkG[a2 - 1];
        long j4 = a2 == 99 ? 256 : this.bkG[a2];
        long eb2 = (j4 == j3 ? 0 : (long) (((d2 - ((double) j3)) * ((double) (eb(a2 + 1) - eb))) / ((double) (j4 - j3)))) + eb;
        AppMethodBeat.o(92049);
        return eb2;
    }

    @Override // com.google.android.exoplayer2.c.l
    public final long getDurationUs() {
        return this.bdJ;
    }

    private long eb(int i2) {
        return (this.bdJ * ((long) i2)) / 100;
    }
}
