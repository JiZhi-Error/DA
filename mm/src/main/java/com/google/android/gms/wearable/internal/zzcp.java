package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.wearable.DataApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class zzcp implements PendingResultUtil.ResultConverter {
    static final PendingResultUtil.ResultConverter zzbx = new zzcp();

    static {
        AppMethodBeat.i(101146);
        AppMethodBeat.o(101146);
    }

    private zzcp() {
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final Object convert(Result result) {
        AppMethodBeat.i(101145);
        Integer valueOf = Integer.valueOf(((DataApi.DeleteDataItemsResult) result).getNumDeleted());
        AppMethodBeat.o(101145);
        return valueOf;
    }
}
