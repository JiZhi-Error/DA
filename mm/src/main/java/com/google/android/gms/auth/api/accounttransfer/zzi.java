package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzi extends AccountTransferClient.zzd<byte[]> {
    private final /* synthetic */ zzh zzbb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzi(zzh zzh, AccountTransferClient.zze zze) {
        super(zze);
        this.zzbb = zzh;
    }

    @Override // com.google.android.gms.internal.auth.zzv, com.google.android.gms.internal.auth.zzaa
    public final void zzd(byte[] bArr) {
        AppMethodBeat.i(10655);
        this.zzbb.setResult(bArr);
        AppMethodBeat.o(10655);
    }
}
