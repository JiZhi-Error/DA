package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.wearable.MessageApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class zzfa implements PendingResultUtil.ResultConverter {
    static final PendingResultUtil.ResultConverter zzbx = new zzfa();

    static {
        AppMethodBeat.i(101290);
        AppMethodBeat.o(101290);
    }

    private zzfa() {
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final Object convert(Result result) {
        AppMethodBeat.i(101289);
        Integer valueOf = Integer.valueOf(((MessageApi.SendMessageResult) result).getRequestId());
        AppMethodBeat.o(101289);
        return valueOf;
    }
}
