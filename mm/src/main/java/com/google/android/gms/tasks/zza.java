package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zza extends CancellationToken {
    private final zzu<Void> zzafh = new zzu<>();

    zza() {
        AppMethodBeat.i(13375);
        AppMethodBeat.o(13375);
    }

    public final void cancel() {
        AppMethodBeat.i(13378);
        this.zzafh.trySetResult(null);
        AppMethodBeat.o(13378);
    }

    @Override // com.google.android.gms.tasks.CancellationToken
    public final boolean isCancellationRequested() {
        AppMethodBeat.i(13376);
        boolean isComplete = this.zzafh.isComplete();
        AppMethodBeat.o(13376);
        return isComplete;
    }

    @Override // com.google.android.gms.tasks.CancellationToken
    public final CancellationToken onCanceledRequested(OnTokenCanceledListener onTokenCanceledListener) {
        AppMethodBeat.i(13377);
        this.zzafh.addOnSuccessListener(new zzb(this, onTokenCanceledListener));
        AppMethodBeat.o(13377);
        return this;
    }
}
