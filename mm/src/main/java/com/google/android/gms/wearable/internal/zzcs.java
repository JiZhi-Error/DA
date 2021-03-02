package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.wearable.DataApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class zzcs implements PendingResultUtil.ResultConverter {
    static final PendingResultUtil.ResultConverter zzbx = new zzcs();

    static {
        AppMethodBeat.i(101152);
        AppMethodBeat.o(101152);
    }

    private zzcs() {
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final Object convert(Result result) {
        AppMethodBeat.i(101151);
        zzcu zzcu = new zzcu((DataApi.GetFdForAssetResult) result);
        AppMethodBeat.o(101151);
        return zzcu;
    }
}
