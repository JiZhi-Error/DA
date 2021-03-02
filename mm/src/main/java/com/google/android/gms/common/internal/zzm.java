package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzm implements PendingResultUtil.ResultConverter<R, T> {
    private final /* synthetic */ Response zzus;

    zzm(Response response) {
        this.zzus = response;
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ Object convert(Result result) {
        AppMethodBeat.i(11901);
        this.zzus.setResult(result);
        Response response = this.zzus;
        AppMethodBeat.o(11901);
        return response;
    }
}
