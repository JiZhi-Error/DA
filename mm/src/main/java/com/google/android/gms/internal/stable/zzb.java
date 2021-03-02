package com.google.android.gms.internal.stable;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzb extends Binder implements IInterface {
    private static zzd zzc = null;

    protected zzb(String str) {
        AppMethodBeat.i(5482);
        attachInterface(this, str);
        AppMethodBeat.o(5482);
    }

    public IBinder asBinder() {
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) {
        return false;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
        AppMethodBeat.i(5484);
        if (routeToSuperOrEnforceInterface(i2, parcel, parcel2, i3)) {
            AppMethodBeat.o(5484);
            return true;
        }
        boolean dispatchTransaction = dispatchTransaction(i2, parcel, parcel2, i3);
        AppMethodBeat.o(5484);
        return dispatchTransaction;
    }

    /* access modifiers changed from: protected */
    public boolean routeToSuperOrEnforceInterface(int i2, Parcel parcel, Parcel parcel2, int i3) {
        AppMethodBeat.i(5483);
        if (i2 > 16777215) {
            boolean onTransact = super.onTransact(i2, parcel, parcel2, i3);
            AppMethodBeat.o(5483);
            return onTransact;
        }
        parcel.enforceInterface(getInterfaceDescriptor());
        AppMethodBeat.o(5483);
        return false;
    }
}
