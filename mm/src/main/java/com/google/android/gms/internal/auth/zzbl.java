package com.google.android.gms.internal.auth;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzbl extends zzd implements zzbk {
    zzbl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.internal.IAuthService");
    }

    @Override // com.google.android.gms.internal.auth.zzbk
    public final void zzd(zzbi zzbi, ProxyRequest proxyRequest) {
        AppMethodBeat.i(10765);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, zzbi);
        zzf.zzd(obtainAndWriteInterfaceToken, proxyRequest);
        transactAndReadExceptionReturnVoid(1, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(10765);
    }
}
