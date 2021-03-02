package com.google.android.gms.internal.p000authapiphone;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ae.b;
import com.tencent.mm.plugin.appbrand.jsapi.ae.d;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzc  reason: invalid package */
public class zzc {
    private static final ClassLoader zzd = zzc.class.getClassLoader();

    static {
        AppMethodBeat.i(937);
        AppMethodBeat.o(937);
    }

    private zzc() {
    }

    public static <T extends Parcelable> T zza(Parcel parcel, Parcelable.Creator<T> creator) {
        AppMethodBeat.i(b.CTRL_INDEX);
        if (parcel.readInt() == 0) {
            AppMethodBeat.o(b.CTRL_INDEX);
            return null;
        }
        T createFromParcel = creator.createFromParcel(parcel);
        AppMethodBeat.o(b.CTRL_INDEX);
        return createFromParcel;
    }

    public static void zza(Parcel parcel, IInterface iInterface) {
        AppMethodBeat.i(d.CTRL_INDEX);
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
            AppMethodBeat.o(d.CTRL_INDEX);
            return;
        }
        parcel.writeStrongBinder(iInterface.asBinder());
        AppMethodBeat.o(d.CTRL_INDEX);
    }
}
