package com.google.android.gms.internal.gcm;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzd implements IInterface {
    private final IBinder zzd;
    private final String zze;

    protected zzd(IBinder iBinder, String str) {
        this.zzd = iBinder;
        this.zze = str;
    }

    public IBinder asBinder() {
        return this.zzd;
    }

    /* access modifiers changed from: protected */
    public final Parcel obtainAndWriteInterfaceToken() {
        AppMethodBeat.i(2572);
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zze);
        AppMethodBeat.o(2572);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final void transactAndReadExceptionReturnVoid(int i2, Parcel parcel) {
        AppMethodBeat.i(2573);
        Parcel obtain = Parcel.obtain();
        try {
            this.zzd.transact(2, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
            AppMethodBeat.o(2573);
        }
    }

    /* access modifiers changed from: protected */
    public final void transactOneway(int i2, Parcel parcel) {
        AppMethodBeat.i(2574);
        try {
            this.zzd.transact(1, parcel, null, 1);
        } finally {
            parcel.recycle();
            AppMethodBeat.o(2574);
        }
    }
}
