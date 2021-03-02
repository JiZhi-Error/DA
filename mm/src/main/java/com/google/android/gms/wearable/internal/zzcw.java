package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wearable.DataClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzcw extends UnregisterListenerMethod<zzhg, DataClient.OnDataChangedListener> {
    private final DataClient.OnDataChangedListener zzdk;

    private zzcw(DataClient.OnDataChangedListener onDataChangedListener, ListenerHolder.ListenerKey<DataClient.OnDataChangedListener> listenerKey) {
        super(listenerKey);
        this.zzdk = onDataChangedListener;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient, com.google.android.gms.tasks.TaskCompletionSource] */
    @Override // com.google.android.gms.common.api.internal.UnregisterListenerMethod
    public final /* synthetic */ void unregisterListener(zzhg zzhg, TaskCompletionSource taskCompletionSource) {
        AppMethodBeat.i(101157);
        zzhg.zza(new zzgg(taskCompletionSource), this.zzdk);
        AppMethodBeat.o(101157);
    }
}
