package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzas implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private final /* synthetic */ zzaj zzhv;

    private zzas(zzaj zzaj) {
        this.zzhv = zzaj;
    }

    /* synthetic */ zzas(zzaj zzaj, zzak zzak) {
        this(zzaj);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        AppMethodBeat.i(11251);
        zzaj.zzf(this.zzhv).signIn(new zzaq(this.zzhv));
        AppMethodBeat.o(11251);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        AppMethodBeat.i(11252);
        zzaj.zzc(this.zzhv).lock();
        try {
            if (zzaj.zzb(this.zzhv, connectionResult)) {
                zzaj.zzi(this.zzhv);
                zzaj.zzj(this.zzhv);
            } else {
                zzaj.zza(this.zzhv, connectionResult);
            }
        } finally {
            zzaj.zzc(this.zzhv).unlock();
            AppMethodBeat.o(11252);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnectionSuspended(int i2) {
    }
}
