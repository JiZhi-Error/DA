package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.wearable.DataApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class zzcr implements PendingResultUtil.ResultConverter {
    static final PendingResultUtil.ResultConverter zzbx = new zzcr();

    static {
        AppMethodBeat.i(101150);
        AppMethodBeat.o(101150);
    }

    private zzcr() {
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final Object convert(Result result) {
        AppMethodBeat.i(101149);
        zzcu zzcu = new zzcu((DataApi.GetFdForAssetResult) result);
        AppMethodBeat.o(101149);
        return zzcu;
    }
}
