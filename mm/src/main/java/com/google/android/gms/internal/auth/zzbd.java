package com.google.android.gms.internal.auth;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzbd extends zzd implements zzbc {
    zzbd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
    }

    @Override // com.google.android.gms.internal.auth.zzbc
    public final void zzd(zzba zzba) {
        AppMethodBeat.i(88389);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, zzba);
        transactAndReadExceptionReturnVoid(4, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(88389);
    }

    @Override // com.google.android.gms.internal.auth.zzbc
    public final void zzd(zzba zzba, CredentialRequest credentialRequest) {
        AppMethodBeat.i(88386);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, zzba);
        zzf.zzd(obtainAndWriteInterfaceToken, credentialRequest);
        transactAndReadExceptionReturnVoid(1, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(88386);
    }

    @Override // com.google.android.gms.internal.auth.zzbc
    public final void zzd(zzba zzba, zzay zzay) {
        AppMethodBeat.i(88388);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, zzba);
        zzf.zzd(obtainAndWriteInterfaceToken, zzay);
        transactAndReadExceptionReturnVoid(3, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(88388);
    }

    @Override // com.google.android.gms.internal.auth.zzbc
    public final void zzd(zzba zzba, zzbe zzbe) {
        AppMethodBeat.i(88387);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, zzba);
        zzf.zzd(obtainAndWriteInterfaceToken, zzbe);
        transactAndReadExceptionReturnVoid(2, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(88387);
    }
}
