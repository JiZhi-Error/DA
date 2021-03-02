package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wearable.CapabilityClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzag extends UnregisterListenerMethod<zzhg, CapabilityClient.OnCapabilityChangedListener> {
    private final CapabilityClient.OnCapabilityChangedListener zzby;

    private zzag(CapabilityClient.OnCapabilityChangedListener onCapabilityChangedListener, ListenerHolder.ListenerKey<CapabilityClient.OnCapabilityChangedListener> listenerKey) {
        super(listenerKey);
        this.zzby = onCapabilityChangedListener;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient, com.google.android.gms.tasks.TaskCompletionSource] */
    @Override // com.google.android.gms.common.api.internal.UnregisterListenerMethod
    public final /* synthetic */ void unregisterListener(zzhg zzhg, TaskCompletionSource taskCompletionSource) {
        AppMethodBeat.i(100971);
        zzhg.zza(new zzgg(taskCompletionSource), this.zzby);
        AppMethodBeat.o(100971);
    }
}
