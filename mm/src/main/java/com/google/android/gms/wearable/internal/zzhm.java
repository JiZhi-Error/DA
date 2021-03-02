package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.wearable.MessageApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzhm implements ListenerHolder.Notifier<MessageApi.MessageListener> {
    private final /* synthetic */ zzfe zzap;

    zzhm(zzfe zzfe) {
        this.zzap = zzfe;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(MessageApi.MessageListener messageListener) {
        AppMethodBeat.i(101415);
        messageListener.onMessageReceived(this.zzap);
        AppMethodBeat.o(101415);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }
}
