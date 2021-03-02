package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

/* access modifiers changed from: package-private */
public final class zzjm {
    private long startTime;
    private final Clock zzro;

    public zzjm(Clock clock) {
        AppMethodBeat.i(1919);
        Preconditions.checkNotNull(clock);
        this.zzro = clock;
        AppMethodBeat.o(1919);
    }

    public final void clear() {
        this.startTime = 0;
    }

    public final void start() {
        AppMethodBeat.i(1920);
        this.startTime = this.zzro.elapsedRealtime();
        AppMethodBeat.o(1920);
    }

    public final boolean zzj(long j2) {
        AppMethodBeat.i(1921);
        if (this.startTime == 0) {
            AppMethodBeat.o(1921);
            return true;
        } else if (this.zzro.elapsedRealtime() - this.startTime >= Util.MILLSECONDS_OF_HOUR) {
            AppMethodBeat.o(1921);
            return true;
        } else {
            AppMethodBeat.o(1921);
            return false;
        }
    }
}
