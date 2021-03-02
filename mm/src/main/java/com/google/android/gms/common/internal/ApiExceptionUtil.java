package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ApiExceptionUtil {
    public static ApiException fromConnectionResult(ConnectionResult connectionResult) {
        AppMethodBeat.i(11791);
        ApiException fromStatus = fromStatus(new Status(connectionResult.getErrorCode(), connectionResult.getErrorMessage(), connectionResult.getResolution()));
        AppMethodBeat.o(11791);
        return fromStatus;
    }

    public static ApiException fromStatus(Status status) {
        AppMethodBeat.i(11790);
        if (status.hasResolution()) {
            ResolvableApiException resolvableApiException = new ResolvableApiException(status);
            AppMethodBeat.o(11790);
            return resolvableApiException;
        }
        ApiException apiException = new ApiException(status);
        AppMethodBeat.o(11790);
        return apiException;
    }
}
