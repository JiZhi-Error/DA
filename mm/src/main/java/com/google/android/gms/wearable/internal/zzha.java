package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.wearable.ChannelApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzha extends zzgm<ChannelApi.OpenChannelResult> {
    public zzha(BaseImplementation.ResultHolder<ChannelApi.OpenChannelResult> resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzek
    public final void zza(zzfq zzfq) {
        AppMethodBeat.i(101372);
        zza(new zzam(zzgd.zzb(zzfq.statusCode), zzfq.zzck));
        AppMethodBeat.o(101372);
    }
}
