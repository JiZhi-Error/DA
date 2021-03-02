package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.TransformedResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

@KeepForSdk
public final class OptionalPendingResultImpl<R extends Result> extends OptionalPendingResult<R> {
    private final BasePendingResult<R> zzlo;

    public OptionalPendingResultImpl(PendingResult<R> pendingResult) {
        AppMethodBeat.i(11142);
        this.zzlo = (BasePendingResult) pendingResult;
        AppMethodBeat.o(11142);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void addStatusListener(PendingResult.StatusListener statusListener) {
        AppMethodBeat.i(11151);
        this.zzlo.addStatusListener(statusListener);
        AppMethodBeat.o(11151);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final R await() {
        AppMethodBeat.i(11145);
        R await = this.zzlo.await();
        AppMethodBeat.o(11145);
        return await;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final R await(long j2, TimeUnit timeUnit) {
        AppMethodBeat.i(11146);
        R await = this.zzlo.await(j2, timeUnit);
        AppMethodBeat.o(11146);
        return await;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void cancel() {
        AppMethodBeat.i(11147);
        this.zzlo.cancel();
        AppMethodBeat.o(11147);
    }

    @Override // com.google.android.gms.common.api.OptionalPendingResult
    public final R get() {
        AppMethodBeat.i(11144);
        if (isDone()) {
            R await = await(0, TimeUnit.MILLISECONDS);
            AppMethodBeat.o(11144);
            return await;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Result is not available. Check that isDone() returns true before calling get().");
        AppMethodBeat.o(11144);
        throw illegalStateException;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final boolean isCanceled() {
        AppMethodBeat.i(11148);
        boolean isCanceled = this.zzlo.isCanceled();
        AppMethodBeat.o(11148);
        return isCanceled;
    }

    @Override // com.google.android.gms.common.api.OptionalPendingResult
    public final boolean isDone() {
        AppMethodBeat.i(11143);
        boolean isReady = this.zzlo.isReady();
        AppMethodBeat.o(11143);
        return isReady;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(ResultCallback<? super R> resultCallback) {
        AppMethodBeat.i(11149);
        this.zzlo.setResultCallback(resultCallback);
        AppMethodBeat.o(11149);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(ResultCallback<? super R> resultCallback, long j2, TimeUnit timeUnit) {
        AppMethodBeat.i(11150);
        this.zzlo.setResultCallback(resultCallback, j2, timeUnit);
        AppMethodBeat.o(11150);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        AppMethodBeat.i(11152);
        TransformedResult<S> then = this.zzlo.then(resultTransform);
        AppMethodBeat.o(11152);
        return then;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final Integer zzo() {
        AppMethodBeat.i(11153);
        Integer zzo = this.zzlo.zzo();
        AppMethodBeat.o(11153);
        return zzo;
    }
}
