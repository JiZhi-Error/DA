package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.wearable.ChannelApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzhn implements ListenerHolder.Notifier<ChannelApi.ChannelListener> {
    private final /* synthetic */ zzaw zzav;

    zzhn(zzaw zzaw) {
        this.zzav = zzaw;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(ChannelApi.ChannelListener channelListener) {
        AppMethodBeat.i(101416);
        this.zzav.zza(channelListener);
        AppMethodBeat.o(101416);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }
}
