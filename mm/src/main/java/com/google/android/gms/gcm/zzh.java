package com.google.android.gms.gcm;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.gcm.zzd;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzh extends zzd implements zzg {
    zzh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gcm.INetworkTaskCallback");
    }

    @Override // com.google.android.gms.gcm.zzg
    public final void zzf(int i2) {
        AppMethodBeat.i(3706);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeInt(i2);
        transactAndReadExceptionReturnVoid(2, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(3706);
    }
}
