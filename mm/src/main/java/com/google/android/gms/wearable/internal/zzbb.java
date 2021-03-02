package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Channel;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzbb extends zzn<Channel.GetInputStreamResult> {
    private final /* synthetic */ zzay zzcm;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbb(zzay zzay, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zzcm = zzay;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.i(101047);
        zzbg zzbg = new zzbg(status, null);
        AppMethodBeat.o(101047);
        return zzbg;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzhg zzhg) {
        AppMethodBeat.i(101046);
        String str = this.zzcm.zzce;
        zzbr zzbr = new zzbr();
        ((zzep) zzhg.getService()).zza(new zzgs(this, zzbr), zzbr, str);
        AppMethodBeat.o(101046);
    }
}
