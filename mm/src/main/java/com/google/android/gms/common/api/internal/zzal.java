package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class zzal implements BaseGmsClient.ConnectionProgressReportCallbacks {
    private final Api<?> mApi;
    private final boolean zzfo;
    private final WeakReference<zzaj> zzhw;

    public zzal(zzaj zzaj, Api<?> api, boolean z) {
        AppMethodBeat.i(11242);
        this.zzhw = new WeakReference<>(zzaj);
        this.mApi = api;
        this.zzfo = z;
        AppMethodBeat.o(11242);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
    public final void onReportServiceBinding(ConnectionResult connectionResult) {
        boolean z = false;
        AppMethodBeat.i(11243);
        zzaj zzaj = this.zzhw.get();
        if (zzaj == null) {
            AppMethodBeat.o(11243);
            return;
        }
        if (Looper.myLooper() == zzaj.zzd(zzaj).zzfq.getLooper()) {
            z = true;
        }
        Preconditions.checkState(z, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
        zzaj.zzc(zzaj).lock();
        try {
            if (zzaj.zza(zzaj, 0)) {
                if (!connectionResult.isSuccess()) {
                    zzaj.zza(zzaj, connectionResult, this.mApi, this.zzfo);
                }
                if (zzaj.zzk(zzaj)) {
                    zzaj.zzj(zzaj);
                }
                zzaj.zzc(zzaj).unlock();
                AppMethodBeat.o(11243);
            }
        } finally {
            zzaj.zzc(zzaj).unlock();
            AppMethodBeat.o(11243);
        }
    }
}
