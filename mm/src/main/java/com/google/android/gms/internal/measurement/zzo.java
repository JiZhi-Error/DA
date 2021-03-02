package com.google.android.gms.internal.measurement;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzo extends Binder implements IInterface {
    private static zzq zzqk = null;

    protected zzo(String str) {
        AppMethodBeat.i(40316);
        attachInterface(this, str);
        AppMethodBeat.o(40316);
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
        boolean z;
        AppMethodBeat.i(40317);
        if (i2 > 16777215) {
            z = super.onTransact(i2, parcel, parcel2, i3);
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
            z = false;
        }
        if (z) {
            AppMethodBeat.o(40317);
            return true;
        }
        boolean dispatchTransaction = dispatchTransaction(i2, parcel, parcel2, i3);
        AppMethodBeat.o(40317);
        return dispatchTransaction;
    }
}
