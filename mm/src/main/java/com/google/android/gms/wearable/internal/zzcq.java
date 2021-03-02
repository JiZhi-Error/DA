package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.wearable.DataApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class zzcq implements PendingResultUtil.ResultConverter {
    static final PendingResultUtil.ResultConverter zzbx = new zzcq();

    static {
        AppMethodBeat.i(101148);
        AppMethodBeat.o(101148);
    }

    private zzcq() {
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final Object convert(Result result) {
        AppMethodBeat.i(101147);
        Integer valueOf = Integer.valueOf(((DataApi.DeleteDataItemsResult) result).getNumDeleted());
        AppMethodBeat.o(101147);
        return valueOf;
    }
}
