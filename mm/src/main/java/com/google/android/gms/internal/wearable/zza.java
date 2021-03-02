package com.google.android.gms.internal.wearable;

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
        AppMethodBeat.i(100648);
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzb);
        AppMethodBeat.o(100648);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final void transactAndReadExceptionReturnVoid(int i2, Parcel parcel) {
        AppMethodBeat.i(100649);
        Parcel obtain = Parcel.obtain();
        try {
            this.zza.transact(i2, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
            AppMethodBeat.o(100649);
        }
    }

    /* access modifiers changed from: protected */
    public final void transactOneway(int i2, Parcel parcel) {
        AppMethodBeat.i(100650);
        try {
            this.zza.transact(i2, parcel, null, 1);
        } finally {
            parcel.recycle();
            AppMethodBeat.o(100650);
        }
    }
}
