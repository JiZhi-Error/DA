package com.google.android.gms.internal.ads_identifier;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzc {
    private static final ClassLoader zzd = zzc.class.getClassLoader();

    static {
        AppMethodBeat.i(53040);
        AppMethodBeat.o(53040);
    }

    private zzc() {
    }

    public static void zza(Parcel parcel, boolean z) {
        AppMethodBeat.i(53039);
        parcel.writeInt(1);
        AppMethodBeat.o(53039);
    }

    public static boolean zza(Parcel parcel) {
        AppMethodBeat.i(53038);
        if (parcel.readInt() != 0) {
            AppMethodBeat.o(53038);
            return true;
        }
        AppMethodBeat.o(53038);
        return false;
    }
}
