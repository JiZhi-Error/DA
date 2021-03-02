package com.google.android.gms.internal.firebase_messaging;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzg extends zza implements zze {
    zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.iid.IMessengerCompat");
    }

    @Override // com.google.android.gms.internal.firebase_messaging.zze
    public final void send(Message message) {
        AppMethodBeat.i(4113);
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, message);
        transactOneway(1, obtainAndWriteInterfaceToken);
        AppMethodBeat.o(4113);
    }
}
