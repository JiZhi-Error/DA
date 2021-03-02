package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.internal.auth.zzd;
import com.google.android.gms.internal.auth.zzf;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzw extends zzd implements zzv {
    zzw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzv
    public final void zzd(zzt zzt, GoogleSignInOptions googleSignInOptions) {
        AppMethodBeat.i(88351);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, zzt);
        zzf.zzd(obtainAndWriteInterfaceToken, googleSignInOptions);
        transactAndReadExceptionReturnVoid(101, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(88351);
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzv
    public final void zze(zzt zzt, GoogleSignInOptions googleSignInOptions) {
        AppMethodBeat.i(88352);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, zzt);
        zzf.zzd(obtainAndWriteInterfaceToken, googleSignInOptions);
        transactAndReadExceptionReturnVoid(102, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(88352);
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzv
    public final void zzf(zzt zzt, GoogleSignInOptions googleSignInOptions) {
        AppMethodBeat.i(88353);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, zzt);
        zzf.zzd(obtainAndWriteInterfaceToken, googleSignInOptions);
        transactAndReadExceptionReturnVoid(103, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(88353);
    }
}
