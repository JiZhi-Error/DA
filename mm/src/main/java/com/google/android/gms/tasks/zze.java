package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

/* access modifiers changed from: package-private */
public final class zze<TResult, TContinuationResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TContinuationResult>, zzq<TResult> {
    private final Executor zzafk;
    private final Continuation<TResult, Task<TContinuationResult>> zzafl;
    private final zzu<TContinuationResult> zzafm;

    public zze(Executor executor, Continuation<TResult, Task<TContinuationResult>> continuation, zzu<TContinuationResult> zzu) {
        this.zzafk = executor;
        this.zzafl = continuation;
        this.zzafm = zzu;
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void cancel() {
        AppMethodBeat.i(13387);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(13387);
        throw unsupportedOperationException;
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void onCanceled() {
        AppMethodBeat.i(13386);
        this.zzafm.zzdp();
        AppMethodBeat.o(13386);
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void onComplete(Task<TResult> task) {
        AppMethodBeat.i(13383);
        this.zzafk.execute(new zzf(this, task));
        AppMethodBeat.o(13383);
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        AppMethodBeat.i(13385);
        this.zzafm.setException(exc);
        AppMethodBeat.o(13385);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(TContinuationResult tcontinuationresult) {
        AppMethodBeat.i(13384);
        this.zzafm.setResult(tcontinuationresult);
        AppMethodBeat.o(13384);
    }
}
