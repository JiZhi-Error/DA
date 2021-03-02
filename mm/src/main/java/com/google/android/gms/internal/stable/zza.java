package com.google.android.gms.internal.stable;

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
    public Parcel obtainAndWriteInterfaceToken() {
        AppMethodBeat.i(5478);
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzb);
        AppMethodBeat.o(5478);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public Parcel transactAndReadException(int i2, Parcel parcel) {
        AppMethodBeat.i(5479);
        Parcel obtain = Parcel.obtain();
        try {
            this.zza.transact(i2, parcel, obtain, 0);
            obtain.readException();
            parcel.recycle();
            AppMethodBeat.o(5479);
            return obtain;
        } catch (RuntimeException e2) {
            obtain.recycle();
            AppMethodBeat.o(5479);
            throw e2;
        } catch (Throwable th) {
            parcel.recycle();
            AppMethodBeat.o(5479);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void transactAndReadExceptionReturnVoid(int i2, Parcel parcel) {
        AppMethodBeat.i(5480);
        Parcel obtain = Parcel.obtain();
        try {
            this.zza.transact(i2, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
            AppMethodBeat.o(5480);
        }
    }

    /* access modifiers changed from: protected */
    public void transactOneway(int i2, Parcel parcel) {
        AppMethodBeat.i(5481);
        try {
            this.zza.transact(i2, parcel, null, 1);
        } finally {
            parcel.recycle();
            AppMethodBeat.o(5481);
        }
    }
}
