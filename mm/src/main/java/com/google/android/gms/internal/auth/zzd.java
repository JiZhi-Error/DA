package com.google.android.gms.internal.auth;

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
        AppMethodBeat.i(10773);
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zze);
        AppMethodBeat.o(10773);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final Parcel transactAndReadException(int i2, Parcel parcel) {
        AppMethodBeat.i(10774);
        Parcel obtain = Parcel.obtain();
        try {
            this.zzd.transact(i2, parcel, obtain, 0);
            obtain.readException();
            parcel.recycle();
            AppMethodBeat.o(10774);
            return obtain;
        } catch (RuntimeException e2) {
            obtain.recycle();
            AppMethodBeat.o(10774);
            throw e2;
        } catch (Throwable th) {
            parcel.recycle();
            AppMethodBeat.o(10774);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public final void transactAndReadExceptionReturnVoid(int i2, Parcel parcel) {
        AppMethodBeat.i(10775);
        Parcel obtain = Parcel.obtain();
        try {
            this.zzd.transact(i2, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
            AppMethodBeat.o(10775);
        }
    }
}
