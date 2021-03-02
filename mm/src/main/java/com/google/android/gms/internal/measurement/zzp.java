package com.google.android.gms.internal.measurement;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class zzp {
    private static final ClassLoader zzql = zzp.class.getClassLoader();

    static {
        AppMethodBeat.i(40324);
        AppMethodBeat.o(40324);
    }

    private zzp() {
    }

    public static <T extends Parcelable> T zza(Parcel parcel, Parcelable.Creator<T> creator) {
        AppMethodBeat.i(40320);
        if (parcel.readInt() == 0) {
            AppMethodBeat.o(40320);
            return null;
        }
        T createFromParcel = creator.createFromParcel(parcel);
        AppMethodBeat.o(40320);
        return createFromParcel;
    }

    public static void zza(Parcel parcel, IInterface iInterface) {
        AppMethodBeat.i(40322);
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
            AppMethodBeat.o(40322);
            return;
        }
        parcel.writeStrongBinder(iInterface.asBinder());
        AppMethodBeat.o(40322);
    }

    public static void zza(Parcel parcel, Parcelable parcelable) {
        AppMethodBeat.i(40321);
        if (parcelable == null) {
            parcel.writeInt(0);
            AppMethodBeat.o(40321);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
        AppMethodBeat.o(40321);
    }

    public static void zza(Parcel parcel, boolean z) {
        AppMethodBeat.i(40319);
        parcel.writeInt(z ? 1 : 0);
        AppMethodBeat.o(40319);
    }

    public static boolean zza(Parcel parcel) {
        AppMethodBeat.i(40318);
        if (parcel.readInt() != 0) {
            AppMethodBeat.o(40318);
            return true;
        }
        AppMethodBeat.o(40318);
        return false;
    }

    public static HashMap zzb(Parcel parcel) {
        AppMethodBeat.i(40323);
        HashMap readHashMap = parcel.readHashMap(zzql);
        AppMethodBeat.o(40323);
        return readHashMap;
    }
}
