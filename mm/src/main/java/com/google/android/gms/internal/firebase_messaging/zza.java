package com.google.android.gms.internal.firebase_messaging;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zza implements IInterface {
    private final IBinder zza;
    private final String zzb;

    protected zza(IBinder iBinder, String str) {
        this.zza = iBinder;
        this.zzb = str;
    }

    public IBinder asBinder() {
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public final Parcel obtainAndWriteInterfaceToken() {
        AppMethodBeat.i(4107);
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzb);
        AppMethodBeat.o(4107);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final void transactOneway(int i2, Parcel parcel) {
        AppMethodBeat.i(4108);
        try {
            this.zza.transact(1, parcel, null, 1);
        } finally {
            parcel.recycle();
            AppMethodBeat.o(4108);
        }
    }
}
