package com.google.android.gms.common.api.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzbm implements Runnable {
    private final /* synthetic */ zzbl zzkm;

    zzbm(zzbl zzbl) {
        this.zzkm = zzbl;
    }

    public final void run() {
        AppMethodBeat.i(11333);
        this.zzkm.zzkk.zzka.disconnect();
        AppMethodBeat.o(11333);
    }
}
