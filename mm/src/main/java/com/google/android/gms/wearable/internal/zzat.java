package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.ChannelClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.Nullable;

final class zzat extends RegisterListenerMethod<zzhg, ChannelClient.ChannelCallback> {
    private final IntentFilter[] zzba;
    @Nullable
    private final String zzce;
    private final ChannelApi.ChannelListener zzcf;
    private final ListenerHolder<ChannelApi.ChannelListener> zzci;

    zzat(ChannelApi.ChannelListener channelListener, @Nullable String str, IntentFilter[] intentFilterArr, ListenerHolder<ChannelClient.ChannelCallback> listenerHolder, ListenerHolder<ChannelApi.ChannelListener> listenerHolder2) {
        super(listenerHolder);
        this.zzcf = channelListener;
        this.zzba = intentFilterArr;
        this.zzce = str;
        this.zzci = listenerHolder2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient, com.google.android.gms.tasks.TaskCompletionSource] */
    @Override // com.google.android.gms.common.api.internal.RegisterListenerMethod
    public final /* synthetic */ void registerListener(zzhg zzhg, TaskCompletionSource taskCompletionSource) {
        AppMethodBeat.i(101019);
        zzhg.zza(new zzgh(taskCompletionSource), this.zzcf, this.zzci, this.zzce, this.zzba);
        AppMethodBeat.o(101019);
    }
}
