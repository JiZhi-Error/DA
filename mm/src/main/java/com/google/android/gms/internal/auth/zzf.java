package com.google.android.gms.internal.auth;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzf {
    private static final ClassLoader zzg = zzf.class.getClassLoader();

    static {
        AppMethodBeat.i(10783);
        AppMethodBeat.o(10783);
    }

    private zzf() {
    }

    public static <T extends Parcelable> T zzd(Parcel parcel, Parcelable.Creator<T> creator) {
        AppMethodBeat.i(10780);
        if (parcel.readInt() == 0) {
            AppMethodBeat.o(10780);
            return null;
        }
        T createFromParcel = creator.createFromParcel(parcel);
        AppMethodBeat.o(10780);
        return createFromParcel;
    }

    public static void zzd(Parcel parcel, IInterface iInterface) {
        AppMethodBeat.i(10782);
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
            AppMethodBeat.o(10782);
            return;
        }
        parcel.writeStrongBinder(iInterface.asBinder());
        AppMethodBeat.o(10782);
    }

    public static void zzd(Parcel parcel, Parcelable parcelable) {
        AppMethodBeat.i(10781);
        if (parcelable == null) {
            parcel.writeInt(0);
            AppMethodBeat.o(10781);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
        AppMethodBeat.o(10781);
    }

    public static void zzd(Parcel parcel, boolean z) {
        AppMethodBeat.i(10779);
        parcel.writeInt(z ? 1 : 0);
        AppMethodBeat.o(10779);
    }

    public static boolean zzd(Parcel parcel) {
        AppMethodBeat.i(10778);
        if (parcel.readInt() != 0) {
            AppMethodBeat.o(10778);
            return true;
        }
        AppMethodBeat.o(10778);
        return false;
    }
}
