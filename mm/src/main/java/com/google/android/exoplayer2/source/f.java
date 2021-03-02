package com.google.android.exoplayer2.source;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;

public final class f implements o {
    private final o[] bvD;

    public f(o[] oVarArr) {
        this.bvD = oVarArr;
    }

    @Override // com.google.android.exoplayer2.source.o
    public final long vq() {
        AppMethodBeat.i(92640);
        long j2 = Long.MAX_VALUE;
        for (o oVar : this.bvD) {
            long vq = oVar.vq();
            if (vq != Long.MIN_VALUE) {
                j2 = Math.min(j2, vq);
            }
        }
        if (j2 == MAlarmHandler.NEXT_FIRE_INTERVAL) {
            AppMethodBeat.o(92640);
            return Long.MIN_VALUE;
        }
        AppMethodBeat.o(92640);
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.o
    public final long vr() {
        AppMethodBeat.i(92641);
        long j2 = Long.MAX_VALUE;
        for (o oVar : this.bvD) {
            long vr = oVar.vr();
            if (vr != Long.MIN_VALUE) {
                j2 = Math.min(j2, vr);
            }
        }
        if (j2 == MAlarmHandler.NEXT_FIRE_INTERVAL) {
            AppMethodBeat.o(92641);
            return Long.MIN_VALUE;
        }
        AppMethodBeat.o(92641);
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.o
    public final boolean X(long j2) {
        boolean z;
        AppMethodBeat.i(92642);
        boolean z2 = false;
        do {
            long vr = vr();
            if (vr == Long.MIN_VALUE) {
                break;
            }
            o[] oVarArr = this.bvD;
            z = false;
            for (o oVar : oVarArr) {
                if (oVar.vr() == vr) {
                    z |= oVar.X(j2);
                }
            }
            z2 |= z;
        } while (z);
        AppMethodBeat.o(92642);
        return z2;
    }
}
