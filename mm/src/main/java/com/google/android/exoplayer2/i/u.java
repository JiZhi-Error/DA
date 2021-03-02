package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.tav.coremedia.TimeUtil;

public final class u {
    private long bHF;
    public volatile long bHG = -9223372036854775807L;
    public long bqk;

    public u(long j2) {
        AppMethodBeat.i(93205);
        an(j2);
        AppMethodBeat.o(93205);
    }

    public final synchronized void an(long j2) {
        AppMethodBeat.i(93206);
        a.checkState(this.bHG == -9223372036854775807L);
        this.bqk = j2;
        AppMethodBeat.o(93206);
    }

    public final long xs() {
        if (this.bqk == MAlarmHandler.NEXT_FIRE_INTERVAL) {
            return 0;
        }
        if (this.bHG != -9223372036854775807L) {
            return this.bHF;
        }
        return -9223372036854775807L;
    }

    public final long ao(long j2) {
        long j3;
        AppMethodBeat.i(93207);
        if (j2 == -9223372036854775807L) {
            AppMethodBeat.o(93207);
            return -9223372036854775807L;
        }
        if (this.bHG != -9223372036854775807L) {
            long ar = ar(this.bHG);
            long j4 = (4294967296L + ar) / 8589934592L;
            j3 = ((j4 - 1) * 8589934592L) + j2;
            long j5 = (j4 * 8589934592L) + j2;
            if (Math.abs(j3 - ar) >= Math.abs(j5 - ar)) {
                j3 = j5;
            }
        } else {
            j3 = j2;
        }
        long ap = ap(aq(j3));
        AppMethodBeat.o(93207);
        return ap;
    }

    public final long ap(long j2) {
        AppMethodBeat.i(93208);
        if (j2 == -9223372036854775807L) {
            AppMethodBeat.o(93208);
            return -9223372036854775807L;
        }
        if (this.bHG != -9223372036854775807L) {
            this.bHG = j2;
        } else {
            if (this.bqk != MAlarmHandler.NEXT_FIRE_INTERVAL) {
                this.bHF = this.bqk - j2;
            }
            synchronized (this) {
                try {
                    this.bHG = j2;
                    notifyAll();
                } catch (Throwable th) {
                    AppMethodBeat.o(93208);
                    throw th;
                }
            }
        }
        long j3 = this.bHF + j2;
        AppMethodBeat.o(93208);
        return j3;
    }

    public final synchronized void xt() {
        AppMethodBeat.i(93209);
        while (this.bHG == -9223372036854775807L) {
            wait();
        }
        AppMethodBeat.o(93209);
    }

    public static long aq(long j2) {
        return (TimeUtil.SECOND_TO_US * j2) / 90000;
    }

    public static long ar(long j2) {
        return (90000 * j2) / TimeUtil.SECOND_TO_US;
    }
}
