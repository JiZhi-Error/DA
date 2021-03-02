package com.google.android.gms.internal.ads_identifier;

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
        AppMethodBeat.i(53034);
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzb);
        AppMethodBeat.o(53034);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final Parcel transactAndReadException(int i2, Parcel parcel) {
        AppMethodBeat.i(53035);
        Parcel obtain = Parcel.obtain();
        try {
            this.zza.transact(i2, parcel, obtain, 0);
            obtain.readException();
            parcel.recycle();
            AppMethodBeat.o(53035);
            return obtain;
        } catch (RuntimeException e2) {
            obtain.recycle();
            AppMethodBeat.o(53035);
            throw e2;
        } catch (Throwable th) {
            parcel.recycle();
            AppMethodBeat.o(53035);
            throw th;
        }
    }
}
