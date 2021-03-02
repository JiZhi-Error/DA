package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.wearable.ChannelApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzal implements zzc<ChannelApi.ChannelListener> {
    private final /* synthetic */ IntentFilter[] zzbr;

    zzal(IntentFilter[] intentFilterArr) {
        this.zzbr = intentFilterArr;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.wearable.internal.zzhg, com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder, java.lang.Object, com.google.android.gms.common.api.internal.ListenerHolder] */
    @Override // com.google.android.gms.wearable.internal.zzc
    public final /* synthetic */ void zza(zzhg zzhg, BaseImplementation.ResultHolder resultHolder, ChannelApi.ChannelListener channelListener, ListenerHolder<ChannelApi.ChannelListener> listenerHolder) {
        AppMethodBeat.i(100985);
        zzhg.zza(resultHolder, channelListener, listenerHolder, (String) null, this.zzbr);
        AppMethodBeat.o(100985);
    }
}
