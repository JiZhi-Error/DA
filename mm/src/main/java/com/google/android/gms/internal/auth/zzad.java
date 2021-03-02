package com.google.android.gms.internal.auth;

import android.os.IBinder;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzad extends zzd implements zzac {
    zzad(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferService");
    }

    @Override // com.google.android.gms.internal.auth.zzac
    public final void zzd(zzaa zzaa, zzae zzae) {
        AppMethodBeat.i(10743);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, zzaa);
        zzf.zzd(obtainAndWriteInterfaceToken, zzae);
        transactAndReadExceptionReturnVoid(9, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(10743);
    }

    @Override // com.google.android.gms.internal.auth.zzac
    public final void zzd(zzaa zzaa, zzag zzag) {
        AppMethodBeat.i(10740);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, zzaa);
        zzf.zzd(obtainAndWriteInterfaceToken, zzag);
        transactAndReadExceptionReturnVoid(6, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(10740);
    }

    @Override // com.google.android.gms.internal.auth.zzac
    public final void zzd(zzaa zzaa, zzai zzai) {
        AppMethodBeat.i(10739);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, zzaa);
        zzf.zzd(obtainAndWriteInterfaceToken, zzai);
        transactAndReadExceptionReturnVoid(5, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(10739);
    }

    @Override // com.google.android.gms.internal.auth.zzac
    public final void zzd(zzaa zzaa, zzak zzak) {
        AppMethodBeat.i(10742);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, zzaa);
        zzf.zzd(obtainAndWriteInterfaceToken, zzak);
        transactAndReadExceptionReturnVoid(8, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(10742);
    }

    @Override // com.google.android.gms.internal.auth.zzac
    public final void zzd(zzaa zzaa, zzy zzy) {
        AppMethodBeat.i(10741);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, zzaa);
        zzf.zzd(obtainAndWriteInterfaceToken, zzy);
        transactAndReadExceptionReturnVoid(7, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(10741);
    }
}
