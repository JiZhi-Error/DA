package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzcb extends zzn<DataApi.DeleteDataItemsResult> {
    private final /* synthetic */ Uri zzco;
    private final /* synthetic */ int zzdc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcb(zzbw zzbw, GoogleApiClient googleApiClient, Uri uri, int i2) {
        super(googleApiClient);
        this.zzco = uri;
        this.zzdc = i2;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.i(101113);
        zzch zzch = new zzch(status, 0);
        AppMethodBeat.o(101113);
        return zzch;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzhg zzhg) {
        AppMethodBeat.i(101112);
        ((zzep) zzhg.getService()).zzb(new zzgp(this), this.zzco, this.zzdc);
        AppMethodBeat.o(101112);
    }
}
