package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
public class ApiExceptionMapper implements StatusExceptionMapper {
    @Override // com.google.android.gms.common.api.internal.StatusExceptionMapper
    public Exception getException(Status status) {
        AppMethodBeat.i(11055);
        ApiException fromStatus = ApiExceptionUtil.fromStatus(status);
        AppMethodBeat.o(11055);
        return fromStatus;
    }
}
