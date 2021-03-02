package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PendingResultUtil {
    private static final StatusConverter zzun = new zzk();

    public interface ResultConverter<R extends Result, T> {
        T convert(R r);
    }

    public interface StatusConverter {
        ApiException convert(Status status);
    }

    static {
        AppMethodBeat.i(11850);
        AppMethodBeat.o(11850);
    }

    public static <R extends Result, T extends Response<R>> Task<T> toResponseTask(PendingResult<R> pendingResult, T t) {
        AppMethodBeat.i(11848);
        Task<T> task = toTask(pendingResult, new zzm(t));
        AppMethodBeat.o(11848);
        return task;
    }

    public static <R extends Result, T> Task<T> toTask(PendingResult<R> pendingResult, ResultConverter<R, T> resultConverter) {
        AppMethodBeat.i(11847);
        Task<T> task = toTask(pendingResult, resultConverter, zzun);
        AppMethodBeat.o(11847);
        return task;
    }

    public static <R extends Result, T> Task<T> toTask(PendingResult<R> pendingResult, ResultConverter<R, T> resultConverter, StatusConverter statusConverter) {
        AppMethodBeat.i(11846);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        pendingResult.addStatusListener(new zzl(pendingResult, taskCompletionSource, resultConverter, statusConverter));
        Task<T> task = taskCompletionSource.getTask();
        AppMethodBeat.o(11846);
        return task;
    }

    public static <R extends Result> Task<Void> toVoidTask(PendingResult<R> pendingResult) {
        AppMethodBeat.i(11849);
        Task<Void> task = toTask(pendingResult, new zzn());
        AppMethodBeat.o(11849);
        return task;
    }
}
