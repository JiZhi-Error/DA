package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zza implements PendingResult.StatusListener {
    private final /* synthetic */ Batch zzch;

    zza(Batch batch) {
        this.zzch = batch;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        AppMethodBeat.i(11501);
        synchronized (Batch.zza(this.zzch)) {
            try {
                if (!this.zzch.isCanceled()) {
                    if (status.isCanceled()) {
                        Batch.zza(this.zzch, true);
                    } else if (!status.isSuccess()) {
                        Batch.zzb(this.zzch, true);
                    }
                    Batch.zzb(this.zzch);
                    if (Batch.zzc(this.zzch) == 0) {
                        if (Batch.zzd(this.zzch)) {
                            Batch.zze(this.zzch);
                        } else {
                            this.zzch.setResult(new BatchResult(Batch.zzf(this.zzch) ? new Status(13) : Status.RESULT_SUCCESS, Batch.zzg(this.zzch)));
                        }
                    }
                    AppMethodBeat.o(11501);
                }
            } finally {
                AppMethodBeat.o(11501);
            }
        }
    }
}
