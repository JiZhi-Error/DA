package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.ChannelApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.Nullable;

final class zzan extends zzn<Status> {
    private final String zzce;
    private ChannelApi.ChannelListener zzcf;

    zzan(GoogleApiClient googleApiClient, ChannelApi.ChannelListener channelListener, @Nullable String str) {
        super(googleApiClient);
        AppMethodBeat.i(100987);
        this.zzcf = (ChannelApi.ChannelListener) Preconditions.checkNotNull(channelListener);
        this.zzce = str;
        AppMethodBeat.o(100987);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        this.zzcf = null;
        return status;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzhg zzhg) {
        AppMethodBeat.i(100988);
        zzhg.zza(this, this.zzcf, this.zzce);
        this.zzcf = null;
        AppMethodBeat.o(100988);
    }
}
