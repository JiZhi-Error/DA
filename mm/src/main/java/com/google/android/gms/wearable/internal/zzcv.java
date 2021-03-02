package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzcv extends RegisterListenerMethod<zzhg, DataClient.OnDataChangedListener> {
    private final IntentFilter[] zzba;
    private final ListenerHolder<DataApi.DataListener> zzbz;
    private final DataClient.OnDataChangedListener zzdk;

    private zzcv(DataClient.OnDataChangedListener onDataChangedListener, IntentFilter[] intentFilterArr, ListenerHolder<DataClient.OnDataChangedListener> listenerHolder) {
        super(listenerHolder);
        this.zzdk = onDataChangedListener;
        this.zzba = intentFilterArr;
        this.zzbz = listenerHolder;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient, com.google.android.gms.tasks.TaskCompletionSource] */
    @Override // com.google.android.gms.common.api.internal.RegisterListenerMethod
    public final /* synthetic */ void registerListener(zzhg zzhg, TaskCompletionSource taskCompletionSource) {
        AppMethodBeat.i(101156);
        zzhg.zza(new zzgh(taskCompletionSource), this.zzdk, this.zzbz, this.zzba);
        AppMethodBeat.o(101156);
    }
}
