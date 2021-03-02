package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;
import com.google.android.gms.internal.auth.zzac;
import com.google.android.gms.internal.auth.zzy;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzj extends AccountTransferClient.zze<DeviceMetaData> {
    private final /* synthetic */ zzy zzbc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzj(AccountTransferClient accountTransferClient, zzy zzy) {
        super(null);
        this.zzbc = zzy;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.auth.api.accounttransfer.AccountTransferClient.zze
    public final void zzd(zzac zzac) {
        AppMethodBeat.i(10656);
        zzac.zzd(new zzk(this, this), this.zzbc);
        AppMethodBeat.o(10656);
    }
}
