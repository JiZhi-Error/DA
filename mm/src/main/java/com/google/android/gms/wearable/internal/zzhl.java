package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataEventBuffer;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzhl implements ListenerHolder.Notifier<DataApi.DataListener> {
    private final /* synthetic */ DataHolder zzan;

    zzhl(DataHolder dataHolder) {
        this.zzan = dataHolder;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(DataApi.DataListener dataListener) {
        AppMethodBeat.i(101414);
        try {
            dataListener.onDataChanged(new DataEventBuffer(this.zzan));
        } finally {
            this.zzan.close();
            AppMethodBeat.o(101414);
        }
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
        AppMethodBeat.i(101413);
        this.zzan.close();
        AppMethodBeat.o(101413);
    }
}
