package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;
import com.google.android.gms.internal.auth.zzac;
import com.google.android.gms.internal.auth.zzae;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzm extends AccountTransferClient.zzf {
    private final /* synthetic */ zzae zzbf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzm(AccountTransferClient accountTransferClient, zzae zzae) {
        super(null);
        this.zzbf = zzae;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.auth.api.accounttransfer.AccountTransferClient.zze
    public final void zzd(zzac zzac) {
        AppMethodBeat.i(10659);
        zzac.zzd(this.zzbi, this.zzbf);
        AppMethodBeat.o(10659);
    }
}
