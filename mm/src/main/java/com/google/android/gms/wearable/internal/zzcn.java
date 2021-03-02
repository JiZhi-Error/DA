package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.wearable.DataItemBuffer;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class zzcn implements PendingResultUtil.ResultConverter {
    static final PendingResultUtil.ResultConverter zzbx = new zzcn();

    static {
        AppMethodBeat.i(101143);
        AppMethodBeat.o(101143);
    }

    private zzcn() {
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final Object convert(Result result) {
        return (DataItemBuffer) result;
    }
}
