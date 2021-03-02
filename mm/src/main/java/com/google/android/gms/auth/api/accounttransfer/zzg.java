package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;
import com.google.android.gms.internal.auth.zzac;
import com.google.android.gms.internal.auth.zzai;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzg extends AccountTransferClient.zzf {
    private final /* synthetic */ zzai zzaz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzg(AccountTransferClient accountTransferClient, zzai zzai) {
        super(null);
        this.zzaz = zzai;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.auth.api.accounttransfer.AccountTransferClient.zze
    public final void zzd(zzac zzac) {
        AppMethodBeat.i(10653);
        zzac.zzd(this.zzbi, this.zzaz);
        AppMethodBeat.o(10653);
    }
}
