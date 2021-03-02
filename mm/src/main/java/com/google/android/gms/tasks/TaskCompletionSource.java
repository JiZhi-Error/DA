package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TaskCompletionSource<TResult> {
    private final zzu<TResult> zzafh = new zzu<>();

    public TaskCompletionSource() {
        AppMethodBeat.i(13340);
        AppMethodBeat.o(13340);
    }

    public TaskCompletionSource(CancellationToken cancellationToken) {
        AppMethodBeat.i(13341);
        cancellationToken.onCanceledRequested(new zzs(this));
        AppMethodBeat.o(13341);
    }

    public Task<TResult> getTask() {
        return this.zzafh;
    }

    public void setException(Exception exc) {
        AppMethodBeat.i(13344);
        this.zzafh.setException(exc);
        AppMethodBeat.o(13344);
    }

    public void setResult(TResult tresult) {
        AppMethodBeat.i(13342);
        this.zzafh.setResult(tresult);
        AppMethodBeat.o(13342);
    }

    public boolean trySetException(Exception exc) {
        AppMethodBeat.i(13345);
        boolean trySetException = this.zzafh.trySetException(exc);
        AppMethodBeat.o(13345);
        return trySetException;
    }

    public boolean trySetResult(TResult tresult) {
        AppMethodBeat.i(13343);
        boolean trySetResult = this.zzafh.trySetResult(tresult);
        AppMethodBeat.o(13343);
        return trySetResult;
    }
}
