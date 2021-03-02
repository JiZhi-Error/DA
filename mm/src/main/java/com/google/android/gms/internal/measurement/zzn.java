package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzn implements IInterface {
    private final IBinder zzqi;
    private final String zzqj;

    protected zzn(IBinder iBinder, String str) {
        this.zzqi = iBinder;
        this.zzqj = str;
    }

    public IBinder asBinder() {
        return this.zzqi;
    }

    /* access modifiers changed from: protected */
    public final Parcel obtainAndWriteInterfaceToken() {
        AppMethodBeat.i(40312);
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzqj);
        AppMethodBeat.o(40312);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final Parcel transactAndReadException(int i2, Parcel parcel) {
        AppMethodBeat.i(40313);
        Parcel obtain = Parcel.obtain();
        try {
            this.zzqi.transact(i2, parcel, obtain, 0);
            obtain.readException();
            parcel.recycle();
            AppMethodBeat.o(40313);
            return obtain;
        } catch (RuntimeException e2) {
            obtain.recycle();
            AppMethodBeat.o(40313);
            throw e2;
        } catch (Throwable th) {
            parcel.recycle();
            AppMethodBeat.o(40313);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public final void transactAndReadExceptionReturnVoid(int i2, Parcel parcel) {
        AppMethodBeat.i(40314);
        Parcel obtain = Parcel.obtain();
        try {
            this.zzqi.transact(i2, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
            AppMethodBeat.o(40314);
        }
    }

    /* access modifiers changed from: protected */
    public final void transactOneway(int i2, Parcel parcel) {
        AppMethodBeat.i(40315);
        try {
            this.zzqi.transact(1, parcel, null, 1);
        } finally {
            parcel.recycle();
            AppMethodBeat.o(40315);
        }
    }
}
