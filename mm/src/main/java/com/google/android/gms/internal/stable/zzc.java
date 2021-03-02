package com.google.android.gms.internal.stable;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzc {
    private static final ClassLoader zzd = zzc.class.getClassLoader();

    static {
        AppMethodBeat.i(5491);
        AppMethodBeat.o(5491);
    }

    private zzc() {
    }

    public static <T extends Parcelable> T zza(Parcel parcel, Parcelable.Creator<T> creator) {
        AppMethodBeat.i(5487);
        if (parcel.readInt() == 0) {
            AppMethodBeat.o(5487);
            return null;
        }
        T createFromParcel = creator.createFromParcel(parcel);
        AppMethodBeat.o(5487);
        return createFromParcel;
    }

    public static void zza(Parcel parcel, IInterface iInterface) {
        AppMethodBeat.i(5490);
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
            AppMethodBeat.o(5490);
            return;
        }
        parcel.writeStrongBinder(iInterface.asBinder());
        AppMethodBeat.o(5490);
    }

    public static void zza(Parcel parcel, Parcelable parcelable) {
        AppMethodBeat.i(5488);
        if (parcelable == null) {
            parcel.writeInt(0);
            AppMethodBeat.o(5488);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
        AppMethodBeat.o(5488);
    }

    public static void zza(Parcel parcel, boolean z) {
        AppMethodBeat.i(5486);
        parcel.writeInt(z ? 1 : 0);
        AppMethodBeat.o(5486);
    }

    public static boolean zza(Parcel parcel) {
        AppMethodBeat.i(5485);
        if (parcel.readInt() != 0) {
            AppMethodBeat.o(5485);
            return true;
        }
        AppMethodBeat.o(5485);
        return false;
    }

    public static void zzb(Parcel parcel, Parcelable parcelable) {
        AppMethodBeat.i(5489);
        if (parcelable == null) {
            parcel.writeInt(0);
            AppMethodBeat.o(5489);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 1);
        AppMethodBeat.o(5489);
    }
}
