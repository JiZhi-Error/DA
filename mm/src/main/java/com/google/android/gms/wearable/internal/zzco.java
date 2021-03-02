package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.wearable.DataItemBuffer;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class zzco implements PendingResultUtil.ResultConverter {
    static final PendingResultUtil.ResultConverter zzbx = new zzco();

    static {
        AppMethodBeat.i(101144);
        AppMethodBeat.o(101144);
    }

    private zzco() {
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final Object convert(Result result) {
        return (DataItemBuffer) result;
    }
}
