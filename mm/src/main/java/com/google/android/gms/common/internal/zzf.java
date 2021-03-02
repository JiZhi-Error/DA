package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzf implements BaseGmsClient.BaseConnectionCallbacks {
    private final /* synthetic */ GoogleApiClient.ConnectionCallbacks zztd;

    zzf(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zztd = connectionCallbacks;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        AppMethodBeat.i(11896);
        this.zztd.onConnected(bundle);
        AppMethodBeat.o(11896);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i2) {
        AppMethodBeat.i(11897);
        this.zztd.onConnectionSuspended(i2);
        AppMethodBeat.o(11897);
    }
}
