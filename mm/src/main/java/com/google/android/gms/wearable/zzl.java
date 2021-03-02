package com.google.android.gms.wearable;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.WearableListenerService;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzl implements Runnable {
    private final /* synthetic */ DataHolder zzan;
    private final /* synthetic */ WearableListenerService.zzd zzao;

    zzl(WearableListenerService.zzd zzd, DataHolder dataHolder) {
        this.zzao = zzd;
        this.zzan = dataHolder;
    }

    public final void run() {
        AppMethodBeat.i(101465);
        DataEventBuffer dataEventBuffer = new DataEventBuffer(this.zzan);
        try {
            WearableListenerService.this.onDataChanged(dataEventBuffer);
        } finally {
            dataEventBuffer.release();
            AppMethodBeat.o(101465);
        }
    }
}
