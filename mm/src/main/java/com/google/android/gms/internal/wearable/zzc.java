package com.google.android.gms.internal.wearable;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzc {
    private static final ClassLoader zzd = zzc.class.getClassLoader();

    static {
        AppMethodBeat.i(100656);
        AppMethodBeat.o(100656);
    }

    private zzc() {
    }

    public static <T extends Parcelable> T zza(Parcel parcel, Parcelable.Creator<T> creator) {
        AppMethodBeat.i(100653);
        if (parcel.readInt() == 0) {
            AppMethodBeat.o(100653);
            return null;
        }
        T createFromParcel = creator.createFromParcel(parcel);
        AppMethodBeat.o(100653);
        return createFromParcel;
    }

    public static void zza(Parcel parcel, IInterface iInterface) {
        AppMethodBeat.i(100655);
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
            AppMethodBeat.o(100655);
            return;
        }
        parcel.writeStrongBinder(iInterface.asBinder());
        AppMethodBeat.o(100655);
    }

    public static void zza(Parcel parcel, Parcelable parcelable) {
        AppMethodBeat.i(100654);
        if (parcelable == null) {
            parcel.writeInt(0);
            AppMethodBeat.o(100654);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
        AppMethodBeat.o(100654);
    }
}
