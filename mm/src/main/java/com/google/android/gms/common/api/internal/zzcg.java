package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzcg implements Continuation<Boolean, Void> {
    zzcg() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.tasks.Task] */
    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Void then(Task<Boolean> task) {
        AppMethodBeat.i(11368);
        if (!task.getResult().booleanValue()) {
            ApiException apiException = new ApiException(new Status(13, "listener already unregistered"));
            AppMethodBeat.o(11368);
            throw apiException;
        }
        AppMethodBeat.o(11368);
        return null;
    }
}
