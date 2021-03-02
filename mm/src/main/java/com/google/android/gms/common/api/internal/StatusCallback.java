package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
public class StatusCallback extends IStatusCallback.Stub {
    @KeepForSdk
    private final BaseImplementation.ResultHolder<Status> mResultHolder;

    @KeepForSdk
    public StatusCallback(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.mResultHolder = resultHolder;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    @KeepForSdk
    public void onResult(Status status) {
        AppMethodBeat.i(11154);
        this.mResultHolder.setResult(status);
        AppMethodBeat.o(11154);
    }
}
