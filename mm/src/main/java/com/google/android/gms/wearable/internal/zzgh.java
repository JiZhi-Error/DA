package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgh implements BaseImplementation.ResultHolder<Status> {
    private final TaskCompletionSource<Void> zzes;

    zzgh(TaskCompletionSource<Void> taskCompletionSource) {
        this.zzes = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final void setFailedResult(Status status) {
        AppMethodBeat.i(101350);
        this.zzes.setException(new ApiException(status));
        AppMethodBeat.o(101350);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final /* synthetic */ void setResult(Status status) {
        AppMethodBeat.i(101351);
        Status status2 = status;
        int statusCode = status2.getStatusCode();
        if (statusCode == 0 || statusCode == 4001) {
            this.zzes.setResult(null);
            AppMethodBeat.o(101351);
            return;
        }
        setFailedResult(status2);
        AppMethodBeat.o(101351);
    }
}
