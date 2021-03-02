package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

/* access modifiers changed from: package-private */
public final class zzo<TResult, TContinuationResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TContinuationResult>, zzq<TResult> {
    private final Executor zzafk;
    private final zzu<TContinuationResult> zzafm;
    private final SuccessContinuation<TResult, TContinuationResult> zzafy;

    public zzo(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation, zzu<TContinuationResult> zzu) {
        this.zzafk = executor;
        this.zzafy = successContinuation;
        this.zzafm = zzu;
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void cancel() {
        AppMethodBeat.i(13402);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(13402);
        throw unsupportedOperationException;
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void onCanceled() {
        AppMethodBeat.i(13405);
        this.zzafm.zzdp();
        AppMethodBeat.o(13405);
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void onComplete(Task<TResult> task) {
        AppMethodBeat.i(13401);
        this.zzafk.execute(new zzp(this, task));
        AppMethodBeat.o(13401);
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        AppMethodBeat.i(13404);
        this.zzafm.setException(exc);
        AppMethodBeat.o(13404);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(TContinuationResult tcontinuationresult) {
        AppMethodBeat.i(13403);
        this.zzafm.setResult(tcontinuationresult);
        AppMethodBeat.o(13403);
    }
}
