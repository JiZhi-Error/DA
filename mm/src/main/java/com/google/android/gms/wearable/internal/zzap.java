package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.ChannelClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class zzap implements PendingResultUtil.ResultConverter {
    static final PendingResultUtil.ResultConverter zzbx = new zzap();

    static {
        AppMethodBeat.i(101008);
        AppMethodBeat.o(101008);
    }

    private zzap() {
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final Object convert(Result result) {
        AppMethodBeat.i(101007);
        ChannelClient.Channel zza = zzao.zza((ChannelApi.OpenChannelResult) result);
        AppMethodBeat.o(101007);
        return zza;
    }
}
