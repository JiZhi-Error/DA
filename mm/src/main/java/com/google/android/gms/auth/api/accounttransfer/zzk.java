package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzk extends AccountTransferClient.zzd<DeviceMetaData> {
    private final /* synthetic */ zzj zzbd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzk(zzj zzj, AccountTransferClient.zze zze) {
        super(zze);
        this.zzbd = zzj;
    }

    @Override // com.google.android.gms.internal.auth.zzv, com.google.android.gms.internal.auth.zzaa
    public final void zzd(DeviceMetaData deviceMetaData) {
        AppMethodBeat.i(10657);
        this.zzbd.setResult(deviceMetaData);
        AppMethodBeat.o(10657);
    }
}
