package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
public class TaskUtil {
    @KeepForSdk
    public static void setResultOrApiException(Status status, TaskCompletionSource<Void> taskCompletionSource) {
        AppMethodBeat.i(11156);
        setResultOrApiException(status, null, taskCompletionSource);
        AppMethodBeat.o(11156);
    }

    @KeepForSdk
    public static <TResult> void setResultOrApiException(Status status, TResult tresult, TaskCompletionSource<TResult> taskCompletionSource) {
        AppMethodBeat.i(11157);
        if (status.isSuccess()) {
            taskCompletionSource.setResult(tresult);
            AppMethodBeat.o(11157);
            return;
        }
        taskCompletionSource.setException(new ApiException(status));
        AppMethodBeat.o(11157);
    }

    @KeepForSdk
    @Deprecated
    public static Task<Void> toVoidTaskThatFailsOnFalse(Task<Boolean> task) {
        AppMethodBeat.i(11158);
        Task<TContinuationResult> continueWith = task.continueWith(new zzcg());
        AppMethodBeat.o(11158);
        return continueWith;
    }
}
