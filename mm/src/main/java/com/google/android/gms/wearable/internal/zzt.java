package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.wearable.CapabilityApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzt implements zzc<CapabilityApi.CapabilityListener> {
    private final /* synthetic */ IntentFilter[] zzbr;

    zzt(IntentFilter[] intentFilterArr) {
        this.zzbr = intentFilterArr;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.wearable.internal.zzhg, com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder, java.lang.Object, com.google.android.gms.common.api.internal.ListenerHolder] */
    @Override // com.google.android.gms.wearable.internal.zzc
    public final /* synthetic */ void zza(zzhg zzhg, BaseImplementation.ResultHolder resultHolder, CapabilityApi.CapabilityListener capabilityListener, ListenerHolder<CapabilityApi.CapabilityListener> listenerHolder) {
        AppMethodBeat.i(101455);
        zzhg.zza(resultHolder, capabilityListener, listenerHolder, this.zzbr);
        AppMethodBeat.o(101455);
    }
}
