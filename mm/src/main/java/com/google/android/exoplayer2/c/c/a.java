package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.c.c.b;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.TimeUtil;

/* access modifiers changed from: package-private */
public final class a implements b.a {
    private final long bdJ;
    private final int bitrate;
    private final long firstFramePosition;

    public a(long j2, int i2, long j3) {
        AppMethodBeat.i(92034);
        this.firstFramePosition = j2;
        this.bitrate = i2;
        this.bdJ = j3 == -1 ? -9223372036854775807L : N(j3);
        AppMethodBeat.o(92034);
    }

    @Override // com.google.android.exoplayer2.c.l
    public final boolean uu() {
        return this.bdJ != -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.c.l
    public final long L(long j2) {
        AppMethodBeat.i(92035);
        if (this.bdJ == -9223372036854775807L) {
            AppMethodBeat.o(92035);
            return 0;
        }
        long l = x.l(j2, this.bdJ);
        long j3 = ((l * ((long) this.bitrate)) / 8000000) + this.firstFramePosition;
        AppMethodBeat.o(92035);
        return j3;
    }

    @Override // com.google.android.exoplayer2.c.c.b.a
    public final long N(long j2) {
        AppMethodBeat.i(92036);
        long max = ((Math.max(0L, j2 - this.firstFramePosition) * TimeUtil.SECOND_TO_US) * 8) / ((long) this.bitrate);
        AppMethodBeat.o(92036);
        return max;
    }

    @Override // com.google.android.exoplayer2.c.l
    public final long getDurationUs() {
        return this.bdJ;
    }
}
