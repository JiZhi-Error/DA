package com.google.android.gms.wearable;

import com.google.android.gms.wearable.WearableListenerService;
import com.google.android.gms.wearable.internal.zzfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzn implements Runnable {
    private final /* synthetic */ WearableListenerService.zzd zzao;
    private final /* synthetic */ zzfo zzaq;

    zzn(WearableListenerService.zzd zzd, zzfo zzfo) {
        this.zzao = zzd;
        this.zzaq = zzfo;
    }

    public final void run() {
        AppMethodBeat.i(101467);
        WearableListenerService.this.onPeerConnected(this.zzaq);
        AppMethodBeat.o(101467);
    }
}
