package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;
import com.google.android.gms.internal.auth.zzac;
import com.google.android.gms.internal.auth.zzak;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzl extends AccountTransferClient.zzf {
    private final /* synthetic */ zzak zzbe;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzl(AccountTransferClient accountTransferClient, zzak zzak) {
        super(null);
        this.zzbe = zzak;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.auth.api.accounttransfer.AccountTransferClient.zze
    public final void zzd(zzac zzac) {
        AppMethodBeat.i(10658);
        zzac.zzd(this.zzbi, this.zzbe);
        AppMethodBeat.o(10658);
    }
}
