package com.google.android.gms.internal.p000authapiphone;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ae.c;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzb  reason: invalid package */
public class zzb extends Binder implements IInterface {
    private static zzd zzc = null;

    protected zzb(String str) {
        AppMethodBeat.i(933);
        attachInterface(this, str);
        AppMethodBeat.o(933);
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
        AppMethodBeat.i(c.CTRL_INDEX);
        if (i2 > 16777215) {
            z = super.onTransact(i2, parcel, parcel2, i3);
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
            z = false;
        }
        if (z) {
            AppMethodBeat.o(c.CTRL_INDEX);
            return true;
        }
        boolean dispatchTransaction = dispatchTransaction(i2, parcel, parcel2, i3);
        AppMethodBeat.o(c.CTRL_INDEX);
        return dispatchTransaction;
    }
}
