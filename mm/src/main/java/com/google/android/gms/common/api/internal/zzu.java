package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzu implements zzbq {
    private final /* synthetic */ zzr zzgc;

    private zzu(zzr zzr) {
        this.zzgc = zzr;
    }

    /* synthetic */ zzu(zzr zzr, zzs zzs) {
        this(zzr);
    }

    @Override // com.google.android.gms.common.api.internal.zzbq
    public final void zzb(int i2, boolean z) {
        AppMethodBeat.i(11471);
        this.zzgc.zzga.lock();
        try {
            if (this.zzgc.zzfz) {
                this.zzgc.zzfz = false;
                zzr.zza(this.zzgc, i2, z);
                return;
            }
            this.zzgc.zzfz = true;
            this.zzgc.zzfr.onConnectionSuspended(i2);
            this.zzgc.zzga.unlock();
            AppMethodBeat.o(11471);
        } finally {
            this.zzgc.zzga.unlock();
            AppMethodBeat.o(11471);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbq
    public final void zzb(Bundle bundle) {
        AppMethodBeat.i(11469);
        this.zzgc.zzga.lock();
        try {
            this.zzgc.zzfy = ConnectionResult.RESULT_SUCCESS;
            zzr.zzb(this.zzgc);
        } finally {
            this.zzgc.zzga.unlock();
            AppMethodBeat.o(11469);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbq
    public final void zzc(ConnectionResult connectionResult) {
        AppMethodBeat.i(11470);
        this.zzgc.zzga.lock();
        try {
            this.zzgc.zzfy = connectionResult;
            zzr.zzb(this.zzgc);
        } finally {
            this.zzgc.zzga.unlock();
            AppMethodBeat.o(11470);
        }
    }
}
