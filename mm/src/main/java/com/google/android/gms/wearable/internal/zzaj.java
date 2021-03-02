package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.ChannelApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzaj implements ChannelApi {
    @Override // com.google.android.gms.wearable.ChannelApi
    public final PendingResult<Status> addListener(GoogleApiClient googleApiClient, ChannelApi.ChannelListener channelListener) {
        AppMethodBeat.i(100981);
        Preconditions.checkNotNull(googleApiClient, "client is null");
        Preconditions.checkNotNull(channelListener, "listener is null");
        PendingResult<Status> zza = zzb.zza(googleApiClient, new zzal(new IntentFilter[]{zzgj.zzc("com.google.android.gms.wearable.CHANNEL_EVENT")}), channelListener);
        AppMethodBeat.o(100981);
        return zza;
    }

    @Override // com.google.android.gms.wearable.ChannelApi
    public final PendingResult<ChannelApi.OpenChannelResult> openChannel(GoogleApiClient googleApiClient, String str, String str2) {
        AppMethodBeat.i(100980);
        Preconditions.checkNotNull(googleApiClient, "client is null");
        Preconditions.checkNotNull(str, "nodeId is null");
        Preconditions.checkNotNull(str2, "path is null");
        BaseImplementation.ApiMethodImpl enqueue = googleApiClient.enqueue(new zzak(this, googleApiClient, str, str2));
        AppMethodBeat.o(100980);
        return enqueue;
    }

    @Override // com.google.android.gms.wearable.ChannelApi
    public final PendingResult<Status> removeListener(GoogleApiClient googleApiClient, ChannelApi.ChannelListener channelListener) {
        AppMethodBeat.i(100982);
        Preconditions.checkNotNull(googleApiClient, "client is null");
        Preconditions.checkNotNull(channelListener, "listener is null");
        BaseImplementation.ApiMethodImpl enqueue = googleApiClient.enqueue(new zzan(googleApiClient, channelListener, null));
        AppMethodBeat.o(100982);
        return enqueue;
    }
}
