package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzci implements Runnable {
    private final /* synthetic */ Result zzmk;
    private final /* synthetic */ zzch zzml;

    zzci(zzch zzch, Result result) {
        this.zzml = zzch;
        this.zzmk = result;
    }

    public final void run() {
        AppMethodBeat.i(11381);
        try {
            BasePendingResult.zzez.set(Boolean.TRUE);
            this.zzml.zzmi.sendMessage(this.zzml.zzmi.obtainMessage(0, this.zzml.zzmd.onSuccess(this.zzmk)));
            BasePendingResult.zzez.set(Boolean.FALSE);
            zzch.zza(this.zzml, this.zzmk);
            GoogleApiClient googleApiClient = (GoogleApiClient) this.zzml.zzfc.get();
            if (googleApiClient != null) {
                googleApiClient.zzb(this.zzml);
            }
            AppMethodBeat.o(11381);
        } catch (RuntimeException e2) {
            this.zzml.zzmi.sendMessage(this.zzml.zzmi.obtainMessage(1, e2));
            BasePendingResult.zzez.set(Boolean.FALSE);
            zzch.zza(this.zzml, this.zzmk);
            GoogleApiClient googleApiClient2 = (GoogleApiClient) this.zzml.zzfc.get();
            if (googleApiClient2 != null) {
                googleApiClient2.zzb(this.zzml);
            }
            AppMethodBeat.o(11381);
        } catch (Throwable th) {
            BasePendingResult.zzez.set(Boolean.FALSE);
            zzch.zza(this.zzml, this.zzmk);
            GoogleApiClient googleApiClient3 = (GoogleApiClient) this.zzml.zzfc.get();
            if (googleApiClient3 != null) {
                googleApiClient3.zzb(this.zzml);
            }
            AppMethodBeat.o(11381);
            throw th;
        }
    }
}
