package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

/* access modifiers changed from: package-private */
public final class zzc<TResult, TContinuationResult> implements zzq<TResult> {
    private final Executor zzafk;
    private final Continuation<TResult, TContinuationResult> zzafl;
    private final zzu<TContinuationResult> zzafm;

    public zzc(Executor executor, Continuation<TResult, TContinuationResult> continuation, zzu<TContinuationResult> zzu) {
        this.zzafk = executor;
        this.zzafl = continuation;
        this.zzafm = zzu;
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void cancel() {
        AppMethodBeat.i(13381);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(13381);
        throw unsupportedOperationException;
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void onComplete(Task<TResult> task) {
        AppMethodBeat.i(13380);
        this.zzafk.execute(new zzd(this, task));
        AppMethodBeat.o(13380);
    }
}
