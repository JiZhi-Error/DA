package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;
import com.google.android.gms.internal.auth.zzac;
import com.google.android.gms.internal.auth.zzag;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzh extends AccountTransferClient.zze<byte[]> {
    private final /* synthetic */ zzag zzba;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzh(AccountTransferClient accountTransferClient, zzag zzag) {
        super(null);
        this.zzba = zzag;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.auth.api.accounttransfer.AccountTransferClient.zze
    public final void zzd(zzac zzac) {
        AppMethodBeat.i(10654);
        zzac.zzd(new zzi(this, this), this.zzba);
        AppMethodBeat.o(10654);
    }
}
