package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgg implements BaseImplementation.ResultHolder<Status> {
    private final TaskCompletionSource<Boolean> zzes;

    zzgg(TaskCompletionSource<Boolean> taskCompletionSource) {
        this.zzes = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final void setFailedResult(Status status) {
        AppMethodBeat.i(101348);
        this.zzes.setException(new ApiException(status));
        AppMethodBeat.o(101348);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final /* synthetic */ void setResult(Status status) {
        AppMethodBeat.i(101349);
        Status status2 = status;
        int statusCode = status2.getStatusCode();
        if (statusCode == 0) {
            this.zzes.setResult(Boolean.TRUE);
            AppMethodBeat.o(101349);
        } else if (statusCode == 4002) {
            this.zzes.setResult(Boolean.FALSE);
            AppMethodBeat.o(101349);
        } else {
            setFailedResult(status2);
            AppMethodBeat.o(101349);
        }
    }
}
