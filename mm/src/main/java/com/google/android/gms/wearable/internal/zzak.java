package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.ChannelApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzak extends zzn<ChannelApi.OpenChannelResult> {
    private final /* synthetic */ String zzcb;
    private final /* synthetic */ String zzcc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzak(zzaj zzaj, GoogleApiClient googleApiClient, String str, String str2) {
        super(googleApiClient);
        this.zzcb = str;
        this.zzcc = str2;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.i(100984);
        zzam zzam = new zzam(status, null);
        AppMethodBeat.o(100984);
        return zzam;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzhg zzhg) {
        AppMethodBeat.i(100983);
        ((zzep) zzhg.getService()).zza(new zzha(this), this.zzcb, this.zzcc);
        AppMethodBeat.o(100983);
    }
}
