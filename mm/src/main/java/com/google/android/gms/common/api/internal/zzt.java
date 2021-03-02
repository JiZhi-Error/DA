package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzt implements zzbq {
    private final /* synthetic */ zzr zzgc;

    private zzt(zzr zzr) {
        this.zzgc = zzr;
    }

    /* synthetic */ zzt(zzr zzr, zzs zzs) {
        this(zzr);
    }

    @Override // com.google.android.gms.common.api.internal.zzbq
    public final void zzb(int i2, boolean z) {
        AppMethodBeat.i(11468);
        this.zzgc.zzga.lock();
        try {
            if ((this.zzgc.zzfz) || this.zzgc.zzfy == null || !this.zzgc.zzfy.isSuccess()) {
                this.zzgc.zzfz = false;
                zzr.zza(this.zzgc, i2, z);
                return;
            }
            this.zzgc.zzfz = true;
            this.zzgc.zzfs.onConnectionSuspended(i2);
            this.zzgc.zzga.unlock();
            AppMethodBeat.o(11468);
        } finally {
            this.zzgc.zzga.unlock();
            AppMethodBeat.o(11468);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbq
    public final void zzb(Bundle bundle) {
        AppMethodBeat.i(11466);
        this.zzgc.zzga.lock();
        try {
            zzr.zza(this.zzgc, bundle);
            this.zzgc.zzfx = ConnectionResult.RESULT_SUCCESS;
            zzr.zzb(this.zzgc);
        } finally {
            this.zzgc.zzga.unlock();
            AppMethodBeat.o(11466);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbq
    public final void zzc(ConnectionResult connectionResult) {
        AppMethodBeat.i(11467);
        this.zzgc.zzga.lock();
        try {
            this.zzgc.zzfx = connectionResult;
            zzr.zzb(this.zzgc);
        } finally {
            this.zzgc.zzga.unlock();
            AppMethodBeat.o(11467);
        }
    }
}
