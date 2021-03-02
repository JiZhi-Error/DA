package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.wearable.CapabilityApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzho implements ListenerHolder.Notifier<CapabilityApi.CapabilityListener> {
    private final /* synthetic */ zzah zzfr;

    zzho(zzah zzah) {
        this.zzfr = zzah;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(CapabilityApi.CapabilityListener capabilityListener) {
        AppMethodBeat.i(101417);
        capabilityListener.onCapabilityChanged(this.zzfr);
        AppMethodBeat.o(101417);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }
}
