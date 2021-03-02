package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.service.CommonApiImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzb extends zzd {
    zzb(CommonApiImpl commonApiImpl, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(CommonClient commonClient) {
        AppMethodBeat.i(11892);
        ((ICommonService) commonClient.getService()).clearDefaultAccount(new CommonApiImpl.zza(this));
        AppMethodBeat.o(11892);
    }
}
