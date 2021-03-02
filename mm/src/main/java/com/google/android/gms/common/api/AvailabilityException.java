package com.google.android.gms.common.api;

import android.support.v4.e.a;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.zzh;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class AvailabilityException extends Exception {
    private final a<zzh<?>, ConnectionResult> zzcc;

    public AvailabilityException(a<zzh<?>, ConnectionResult> aVar) {
        this.zzcc = aVar;
    }

    public ConnectionResult getConnectionResult(GoogleApi<? extends Api.ApiOptions> googleApi) {
        AppMethodBeat.i(10973);
        zzh<? extends Api.ApiOptions> zzm = googleApi.zzm();
        Preconditions.checkArgument(this.zzcc.get(zzm) != null, "The given API was not part of the availability request.");
        ConnectionResult connectionResult = this.zzcc.get(zzm);
        AppMethodBeat.o(10973);
        return connectionResult;
    }

    public String getMessage() {
        AppMethodBeat.i(10974);
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (zzh<?> zzh : this.zzcc.keySet()) {
            ConnectionResult connectionResult = this.zzcc.get(zzh);
            if (connectionResult.isSuccess()) {
                z = false;
            }
            String zzq = zzh.zzq();
            String valueOf = String.valueOf(connectionResult);
            arrayList.add(new StringBuilder(String.valueOf(zzq).length() + 2 + String.valueOf(valueOf).length()).append(zzq).append(": ").append(valueOf).toString());
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("None of the queried APIs are available. ");
        } else {
            sb.append("Some of the queried APIs are unavailable. ");
        }
        sb.append(TextUtils.join("; ", arrayList));
        String sb2 = sb.toString();
        AppMethodBeat.o(10974);
        return sb2;
    }

    public final a<zzh<?>, ConnectionResult> zzl() {
        return this.zzcc;
    }
}
