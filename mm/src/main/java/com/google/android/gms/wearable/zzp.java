package com.google.android.gms.wearable;

import com.google.android.gms.wearable.WearableListenerService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class zzp implements Runnable {
    private final /* synthetic */ WearableListenerService.zzd zzao;
    private final /* synthetic */ List zzar;

    zzp(WearableListenerService.zzd zzd, List list) {
        this.zzao = zzd;
        this.zzar = list;
    }

    public final void run() {
        AppMethodBeat.i(101469);
        WearableListenerService.this.onConnectedNodes(this.zzar);
        AppMethodBeat.o(101469);
    }
}
