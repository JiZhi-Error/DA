package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzk implements PendingResultUtil.StatusConverter {
    zzk() {
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.StatusConverter
    public final ApiException convert(Status status) {
        AppMethodBeat.i(11899);
        ApiException fromStatus = ApiExceptionUtil.fromStatus(status);
        AppMethodBeat.o(11899);
        return fromStatus;
    }
}
