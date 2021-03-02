package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzbe extends zzn<Status> {
    private final /* synthetic */ zzay zzcm;
    private final /* synthetic */ Uri zzco;
    private final /* synthetic */ long zzcq;
    private final /* synthetic */ long zzcr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbe(zzay zzay, GoogleApiClient googleApiClient, Uri uri, long j2, long j3) {
        super(googleApiClient);
        this.zzcm = zzay;
        this.zzco = uri;
        this.zzcq = j2;
        this.zzcr = j3;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzhg zzhg) {
        AppMethodBeat.i(101051);
        zzhg.zza(this, this.zzcm.zzce, this.zzco, this.zzcq, this.zzcr);
        AppMethodBeat.o(101051);
    }
}
