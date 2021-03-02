package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class CancellationTokenSource {
    private final zza zzafj = new zza();

    public CancellationTokenSource() {
        AppMethodBeat.i(13338);
        AppMethodBeat.o(13338);
    }

    public void cancel() {
        AppMethodBeat.i(13339);
        this.zzafj.cancel();
        AppMethodBeat.o(13339);
    }

    public CancellationToken getToken() {
        return this.zzafj;
    }
}
