package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.ChannelClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.Nullable;

final class zzau extends UnregisterListenerMethod<zzhg, ChannelClient.ChannelCallback> {
    @Nullable
    private final String zzce;
    private final ChannelApi.ChannelListener zzcf;

    zzau(ChannelApi.ChannelListener channelListener, @Nullable String str, ListenerHolder.ListenerKey<ChannelClient.ChannelCallback> listenerKey) {
        super(listenerKey);
        this.zzcf = channelListener;
        this.zzce = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient, com.google.android.gms.tasks.TaskCompletionSource] */
    @Override // com.google.android.gms.common.api.internal.UnregisterListenerMethod
    public final /* synthetic */ void unregisterListener(zzhg zzhg, TaskCompletionSource taskCompletionSource) {
        AppMethodBeat.i(101020);
        zzhg.zza(new zzgg(taskCompletionSource), this.zzcf, this.zzce);
        AppMethodBeat.o(101020);
    }
}
