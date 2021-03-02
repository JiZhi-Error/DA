package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataItem;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class zzcl implements PendingResultUtil.ResultConverter {
    static final PendingResultUtil.ResultConverter zzbx = new zzcl();

    static {
        AppMethodBeat.i(101141);
        AppMethodBeat.o(101141);
    }

    private zzcl() {
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final Object convert(Result result) {
        AppMethodBeat.i(101140);
        DataItem dataItem = ((DataApi.DataItemResult) result).getDataItem();
        AppMethodBeat.o(101140);
        return dataItem;
    }
}
