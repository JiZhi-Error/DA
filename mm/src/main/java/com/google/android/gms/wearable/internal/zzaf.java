package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzaf extends RegisterListenerMethod<zzhg, CapabilityClient.OnCapabilityChangedListener> {
    private final IntentFilter[] zzba;
    private final CapabilityClient.OnCapabilityChangedListener zzby;
    private final ListenerHolder<CapabilityApi.CapabilityListener> zzbz;

    private zzaf(CapabilityClient.OnCapabilityChangedListener onCapabilityChangedListener, IntentFilter[] intentFilterArr, ListenerHolder<CapabilityClient.OnCapabilityChangedListener> listenerHolder) {
        super(listenerHolder);
        this.zzby = onCapabilityChangedListener;
        this.zzba = intentFilterArr;
        this.zzbz = listenerHolder;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient, com.google.android.gms.tasks.TaskCompletionSource] */
    @Override // com.google.android.gms.common.api.internal.RegisterListenerMethod
    public final /* synthetic */ void registerListener(zzhg zzhg, TaskCompletionSource taskCompletionSource) {
        AppMethodBeat.i(100970);
        zzhg.zza(new zzgh(taskCompletionSource), this.zzby, this.zzbz, this.zzba);
        AppMethodBeat.o(100970);
    }
}
