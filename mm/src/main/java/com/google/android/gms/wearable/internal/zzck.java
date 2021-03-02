package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataItem;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class zzck implements PendingResultUtil.ResultConverter {
    static final PendingResultUtil.ResultConverter zzbx = new zzck();

    static {
        AppMethodBeat.i(101139);
        AppMethodBeat.o(101139);
    }

    private zzck() {
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final Object convert(Result result) {
        AppMethodBeat.i(101138);
        DataItem dataItem = ((DataApi.DataItemResult) result).getDataItem();
        AppMethodBeat.o(101138);
        return dataItem;
    }
}
