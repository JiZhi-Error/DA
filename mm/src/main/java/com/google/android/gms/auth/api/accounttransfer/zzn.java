package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.auth.zzv;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzn extends zzv {
    private final /* synthetic */ AccountTransferClient.zzf zzbj;

    zzn(AccountTransferClient.zzf zzf) {
        this.zzbj = zzf;
    }

    @Override // com.google.android.gms.internal.auth.zzv, com.google.android.gms.internal.auth.zzaa
    public final void onFailure(Status status) {
        AppMethodBeat.i(10661);
        this.zzbj.zzd(status);
        AppMethodBeat.o(10661);
    }

    @Override // com.google.android.gms.internal.auth.zzv, com.google.android.gms.internal.auth.zzaa
    public final void zzi() {
        AppMethodBeat.i(10660);
        this.zzbj.setResult(null);
        AppMethodBeat.o(10660);
    }
}
