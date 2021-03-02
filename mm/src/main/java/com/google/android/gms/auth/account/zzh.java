package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.auth.zzd;
import com.google.android.gms.internal.auth.zzf;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzh extends zzd implements zzf {
    zzh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.account.IWorkAccountService");
    }

    @Override // com.google.android.gms.auth.account.zzf
    public final void zzd(zzd zzd, Account account) {
        AppMethodBeat.i(10631);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, zzd);
        zzf.zzd(obtainAndWriteInterfaceToken, account);
        transactAndReadExceptionReturnVoid(3, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(10631);
    }

    @Override // com.google.android.gms.auth.account.zzf
    public final void zzd(zzd zzd, String str) {
        AppMethodBeat.i(10630);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, zzd);
        obtainAndWriteInterfaceToken.writeString(str);
        transactAndReadExceptionReturnVoid(2, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(10630);
    }

    @Override // com.google.android.gms.auth.account.zzf
    public final void zze(boolean z) {
        AppMethodBeat.i(10629);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, z);
        transactAndReadExceptionReturnVoid(1, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(10629);
    }
}
